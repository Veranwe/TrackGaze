package src.net.TrackGaze.log;

public record LogGroup(
        LogGroup parent,
        String groupPath,
        String name
) {
}
