package src.test.net.TrackGaze;

import net.aSysSync.ASysUtil;
import src.net.TrackGaze.TrackGaze;
import src.net.TrackGaze.log.Log;
import src.net.TrackGaze.log.LogGroup;

public class TrackGazeTest {
    public static void main(String[] args) {
        TrackGaze.start();

        Log.info(new LogGroup(TrackGaze.rootGroup, "testGroup"), "TestLog", "Testing to see if the basics function.");

        ASysUtil.threadSleep(2000);

        TrackGaze.stop();
    }
}
