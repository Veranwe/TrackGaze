package src.net.TrackGaze;

import net.boxes.BoxList;
import src.net.TrackGaze.config.TrackGazeConfig;
import src.net.TrackGaze.log.Log;
import src.net.TrackGaze.log.LogGroup;
import src.net.TrackGaze.process.TrackGazeCustom;
import src.net.TrackGaze.process.TrackGazeProcess;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.zip.GZIPOutputStream;

public class TrackGaze {

    /**
     * The path to the configurations of the logging system.
     */
    public static final TrackGazeConfig config = new TrackGazeConfig();
    /**
     * The output registry for custom outputs.
     */
    private static final BoxList<TrackGazeCustom> outputRegistry = new BoxList<>();

    public static final LogGroup rootGroup = new LogGroup(null, "root");

    /**
     * Letting the system know if it is in running mode.
     * Used when shutting down.
     */
    private static boolean running = false;

    /**
     * Setting up and initializing all the needed data in the logging system. Once ready it announces it in the logs.
     */
    public static void start() {
        TrackGazeProcess.run();

        running = true;

        Log.info(rootGroup, "StartupNotification", "TrackGaze logger running.");
    }

    /**
     * Shutting down the system safely, allowing the logs to finish processing. Once done it saves the active log
     * file and compresses it down. Renaming it for future needs.
     */
    public static void stop() {
        Log.info(rootGroup, "ShutdownNotification", "TrackGaze logger shutting down.");

        running = false;

        compressFile();
    }

    /**
     * Compresses the latest log file into a gzip file.
     */
    private static void compressFile() {
        String compressedName = "LOG-" + LocalDateTime.now().format(
                DateTimeFormatter.ofPattern("yyyy/MM/dd-HH:mm:ss'XXX")) + ".txt.zip";

        try (
            FileInputStream inputStream = new FileInputStream(config.getFilePath() + "latestLog.txt");
            FileOutputStream outputStream = new FileOutputStream(config.getFilePath() + compressedName);
            GZIPOutputStream gzipOutputStream = new GZIPOutputStream(outputStream);
        ) {
            byte[] buffer = new byte[4096];
            int len;

            while ((len = inputStream.read(buffer)) != -1) {
                gzipOutputStream.write(buffer, 0, len);
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to compress logs file.", e);
        }

    }

    /**
     * Registers and saves custom output locations.
     */
    public static void registerOutput(TrackGazeCustom customOutput) { outputRegistry.add(customOutput); }
    /**
     * A getter to allow the system to read the registered outputs.
     * @return the output registry.
     */
    public static BoxList<TrackGazeCustom> getOutputRegistry() { return outputRegistry; }
    /**
     * A getter to allow the system to check if it is in running mode.
     * @return if the system is running.
     */
    public static boolean isRunning() { return running; }
}

// Future:
//  - Reader, allowing to use a file or other output source to read the given data and use it as wished for.
//  - Useful for filter systems and web interfaces.
//  - Add prefix data so all the information is always available