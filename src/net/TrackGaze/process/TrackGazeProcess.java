package src.net.TrackGaze.process;

import net.boxes.BoxList;
import src.net.TrackGaze.log.LogEntry;
import src.net.TrackGaze.log.TrackGazeSeverity;

public class TrackGazeProcess {

    /**
     * A queue of log entries ready to be processed.
     */
    private static final BoxList<LogEntry> entries = new BoxList<>();

    /**
     * Putting together all the wanted information. Once done it adds it to the log entry queue.
     * @param severity The severity level of the log.
     * @param message The log message.
     */
    public static void entry(TrackGazeSeverity severity, String message) {
        // TODO | Stop is system is shutting down
        // TODO | Create entry into entries list
    }

    /**
     * Triggers a loop that goes through the log entries queue and sends them out to be processed. Pauses for a
     * short time if the list is empty.
     */
    public static void run() {
        // TODO | Loop through the entries and process() them (pause for X ms if empty)
    }
    /**
     * Processes the given log entry. Formatting it, ready for output.
     * @param entry The log entry to be processed.
     */
    private static void process(LogEntry entry) {
        // TODO | Process given entries
    }

    /**
     * A formatted tunnel method to direct to all the output locations.
     * @param message The processed log message.
     */
    private static void output(String message) {
        // TODO | Output to targets
    }

    /**
     * Output the processed message log to the console.
     * @param message The processed log message.
     */
    private static void outConsole(String message) {
        // TODO | Output to console
    }
    /**
     * Output the processed log message to the log file.
     * @param message The processed log message.
     */
    private static void outFile(String message) {
        // TODO | Output to file if applicable
        //          - Don't cache the file, directly append to existing
    }
    /**
     * Output the processed log message to the custom output locations.
     * @param message The processed log message.
     */
    private static void outCustom(String message) {
        // TODO | Output data to custom location using registry list and TrackGazeCustom
    }
}
