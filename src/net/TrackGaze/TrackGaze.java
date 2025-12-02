package src.net.TrackGaze;

import src.net.TrackGaze.config.TrackGazeConfig;

public class TrackGaze {

    public static final TrackGazeConfig config = new TrackGazeConfig();

    private static boolean running;

    static {
        // TODO | Create root group

        // TODO | Trigger log entry check loop

        // TODO | Toggle running

        // TODO | Send ready log
    }

    public static boolean isRunning() { return running; }

    public static void stop() {
        // TODO | Close log entry check loop, let existing logs finish.
        // TODO | Compress log file & rename
        // TODO | Send shutdown log
    }
}

// Future:
//  - Reader, allowing to use a file or other output source to read the given data and use it as wished for.
//  - Useful for filter systems and web interfaces.