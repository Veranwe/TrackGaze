package src.net.TrackGaze.process;

import net.boxes.BoxList;
import src.net.TrackGaze.log.LogEntry;
import src.net.TrackGaze.log.TrackGazeSeverity;

public class TrackGazeProcess {

    private static final BoxList<LogEntry> entries = new BoxList<>();

    public static void run() {
        // TODO | Loop through the entries and process() them (pause for X ms if empty)
    }
    private static void process(LogEntry entry) {
        // TODO | Process given entries
    }

    private static void outConsole(String message) {
        // TODO | Output to console
    }
    private static void outFile(String message) {
        // TODO | Output to file if applicable
        //          - Don't cache the file, directly append to existing
    }
    private static void outCustom(String message) {
        // TODO | Output data to custom location using registry list and TrackGazeCustom
    }
}
