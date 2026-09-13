package src.net.TrackGaze.process;

import net.aSysSync.ASysThread;
import net.aSysSync.ASysUtil;
import src.net.TrackGaze.TrackGaze;
import src.net.TrackGaze.log.LogEntry;
import src.net.TrackGaze.log.LogGroup;
import src.net.TrackGaze.log.TrackGazeSeverity;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class TrackGazeProcess {

    /**
     * A queue of log entries ready to be processed.
     */
    private static final ArrayList<LogEntry> entries = new ArrayList<>();

    /**
     * The async loop that processes entries in the queue;
     */
    private static ASysThread entryLoop;

    private static File file = new File(TrackGaze.config.getFilePath() + "latestLog.txt");

    /**
     * Putting together all the wanted information. Once done it adds it to the log entry queue.
     * @param severity The severity level of the log.
     * @param message The log message.
     */
    public static void entry(TrackGazeSeverity severity, LogGroup group, String name, String message) {
        if (!TrackGaze.isRunning()) return;

        switch (severity) {
            case DEBUG -> { if (!TrackGaze.config.showDebug()) return; }
            case INFO -> { if (!TrackGaze.config.showInfo()) return; }
            case WARNING -> { if (!TrackGaze.config.showWarning()) return; }
            case ERROR -> { if (!TrackGaze.config.showError()) return; }
        }

        entries.add(new LogEntry(LocalDateTime.now(), severity, group, name, message));
    }

    /**
     * Triggers a loop that goes through the log entries queue and sends them out to be processed. Pauses for a
     * short time if the list is empty.
     */
    public static void run() {
        entryLoop = new ASysThread("entryLoop");
        entryLoop.loop("entryLoop", () -> {
            while (!entries.isEmpty()) {
                output(process(entries.removeFirst()));
            }
            if (!TrackGaze.isRunning()) entryLoop.stop();
            if (entries.isEmpty()) ASysUtil.threadSleep(100);
        });
    }
    /**
     * Processes the given log entry. Formatting it, ready for output.
     * @param entry The log entry to be processed.
     */
    private static String process(LogEntry entry) {
        StringBuilder output = new StringBuilder();

        output.append("[").append(entry.severity()).append("]");

        // DateTime configs
        if (TrackGaze.config.showTime()) {
            output.append("[");

            LocalDateTime dateTime = entry.time();

            if (TrackGaze.config.showDay())
                output.append(dateTime.format(DateTimeFormatter.ofPattern("yyyy/MM/dd"))).append("-");


            output.append(dateTime.format(DateTimeFormatter.ofPattern("HH:mm:ss")));

            output.append("]");
        }

        // Group configs
        if (TrackGaze.config.showGroup()) {
            output.append("[");

            if (TrackGaze.config.showPath()) output.append(entry.group().groupPath)
                    .append(entry.group().groupPath.isEmpty() ? "" : ".");

            output.append(entry.group().name);

            if (TrackGaze.config.showIndent()) output.append("-").append(entry.group().indent);

            output.append("]");
        }

        // Name config
        if (TrackGaze.config.showName()) output.append("[").append(entry.name()).append("]");

        output.append(" ").append(entry.message());

        return new String(output);
    }

    /**
     * A formatted tunnel method to direct to all the output locations.
     * @param message The processed log message.
     */
    private static void output(String message) {
        outConsole(message);
        outFile(message);
        outCustom(message);
    }

    /**
     * Output the processed message log to the console.
     * @param message The processed log message.
     */
    private static void outConsole(String message) {
        System.out.println(message);
    }
    /**
     * Output the processed log message to the log file.
     * @param message The processed log message.
     */
    private static void outFile(String message) {
        if (!TrackGaze.config.outputToFile()) return;

        message += "\n";

        if (!file.getPath().equals(TrackGaze.config.getFilePath())) {
            file = new File(TrackGaze.config.getFilePath() + "latestLog.txt");

            file.getParentFile().mkdirs();
        }

        try (FileOutputStream fos = new FileOutputStream(file, true)) {
            fos.write(message.getBytes());
        } catch (IOException e) {
            throw new RuntimeException("Failed to output log to file.", e);
        }
    }
    /**
     * Output the processed log message to the custom output locations.
     * @param message The processed log message.
     */
    private static void outCustom(String message) {
        for (TrackGazeCustom customOutput : TrackGaze.getOutputRegistry().toArray(new TrackGazeCustom[0])) {
            customOutput.output(message);
        }
    }

    public static boolean isEmpty() {
        return entries.isEmpty();
    }
}
