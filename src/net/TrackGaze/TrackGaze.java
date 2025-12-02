package src.net.TrackGaze;

import net.boxes.BoxList;
import src.net.TrackGaze.config.TrackGazeConfig;
import src.net.TrackGaze.process.TrackGazeCustom;

public class TrackGaze {

    /**
     * The path to the configurations of the logging system.
     */
    public static final TrackGazeConfig config = new TrackGazeConfig();

    /**
     * The output registry for custom outputs.
     */
    private static final BoxList<TrackGazeCustom> outputRegistry = new BoxList<>();

    /**
     * Letting the system know if it is in running mode.
     * Used when shutting down.
     */
    private static boolean running;

    /**
     * Setting up and initializing all the needed data in the logging system. Once ready it announces it in the logs.
     */
    public static void start() {
        // TODO | Create root group

        // TODO | Trigger log entry check loop

        // TODO | Toggle running

        // TODO | Send ready log
    }

    /**
     * Shutting down the system safely, allowing the logs to finish processing. Once done it saves the active log
     * file and compresses it down. Renaming it for future needs.
     */
    public static void stop() {
        // TODO | Send log saying system is shutting down.
        // TODO | Close log entry check loop, let existing logs finish.
        // TODO | Compress log file & rename
    }

    /**
     * Registers and saves custom output locations.
     */
    public static void registerOutput() {
        // TODO | Put the new output into the registry list.
    }

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