package src.net.TrackGaze.log;

public class LogGroup {

    public final LogGroup parent;
    public final String name;

    public final String groupPath;
    public final int indent;

    /**
     * The group around logs.
     * @param parent The group containing the newly created group
     * @param name The name of the group
     */
    public LogGroup(LogGroup parent, String name) {
        this.parent = parent;
        this.name = name;

        this.groupPath = getGroupPath(parent);
        this.indent = getIndent(parent);
    }

    /**
     * Gets the path of the given group.
     * @param parent The group containing the given group.
     * @return The path to the root group.
     */
    private static String getGroupPath(LogGroup parent) {
        return parent == null ? "" : getGroupPath(parent.name, parent.parent);
    }
    /**
     * Gets the path of the given group.
     * @param path The existing path.
     * @param parent The group containing the given group.
     * @return The path to the root group.
     */
    private static String getGroupPath(String path, LogGroup parent) {
        return parent == null ? path : getGroupPath(parent.name + "." + path, parent.parent);
    }

    /**
     * Gets the amount of indentations of the given group.
     * @param parent The group containing the given group.
     * @return The amount of indentations the group has.
     */
    private static int getIndent(LogGroup parent) {
        return parent == null ? 0 : getIndent(1, parent.parent);
    }
    /**
     * Gets the amount of indentations of the given group.
     * @param indent The existing indentations.
     * @param parent The group containing the given group.
     * @return The amount of indentations the group has.
     */
    private static int getIndent(int indent, LogGroup parent) {
        return parent == null ? indent : getIndent(indent + 1, parent.parent);
    }
}
