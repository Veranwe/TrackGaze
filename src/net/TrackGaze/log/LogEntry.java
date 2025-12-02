package src.net.TrackGaze.log;

import java.time.LocalDateTime;

public record LogEntry(
        LocalDateTime time,
        String path,
        TrackGazeSeverity severity,
        LogGroup group,
        String name,
        String message
) {


}
