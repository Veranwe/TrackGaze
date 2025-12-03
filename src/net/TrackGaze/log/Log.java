package src.net.TrackGaze.log;

import src.net.TrackGaze.process.TrackGazeProcess;

public class Log {

    /**
     * Logging a message under the debug severity level.
     * @param group The group containing the log.
     * @param name The name of the log.
     * @param message The log message.
     */
    public static void debug(LogGroup group, String name, String message) {
        TrackGazeProcess.entry(TrackGazeSeverity.DEBUG, group, name, message);
    }
    /**
     * Logging a message under the info severity level.
     * @param group The group containing the log.
     * @param name The name of the log.
     * @param message The log message.
     */
    public static void info(LogGroup group, String name, String message) {
        TrackGazeProcess.entry(TrackGazeSeverity.INFO, group, name, message);
    }
    /**
     * Logging a message under the warning severity level.
     * @param group The group containing the log.
     * @param name The name of the log.
     * @param message The log message.
     */
    public static void warning(LogGroup group, String name, String message) {
        TrackGazeProcess.entry(TrackGazeSeverity.WARNING, group, name, message);
    }
    /**
     * Logging a message under the error severity level.
     * @param group The group containing the log.
     * @param name The name of the log.
     * @param message The log message.
     */
    public static void error(LogGroup group, String name, String message) {
        TrackGazeProcess.entry(TrackGazeSeverity.ERROR, group, name, message);
    }
}
