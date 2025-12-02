package src.net.TrackGaze.log;

import java.time.LocalDateTime;

/**
 * The formatting for a log entry
 * @param time The time at which the log was created.
 * @param path The origin location of the log.
 * @param severity The severity level of the log.
 * @param group The grouping the log belongs to.
 * @param name The name of the log.
 * @param message The log message.
 */
public record LogEntry(
        LocalDateTime time,
        String path,
        TrackGazeSeverity severity,
        LogGroup group,
        String name,
        String message
) {}
