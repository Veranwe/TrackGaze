package src.net.TrackGaze.log;

/**
 * The information of a logging group.
 * @param parent The group the current group belongs to.
 * @param groupPath The path of the group to the root group.
 * @param indent The amount of indentations of the group.
 * @param name The name of the group
 */
public record LogGroup(
        LogGroup parent,
        String groupPath,
        int indent,
        String name
) {
}
