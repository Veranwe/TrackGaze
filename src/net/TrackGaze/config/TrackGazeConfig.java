package src.net.TrackGaze.config;

public class TrackGazeConfig {

    /**
     * Time related settings.
     */
    private boolean showTime = true;
    private boolean showDay = true;

    /**
     * Severity level related settings.
     */
    private boolean showDebug = false;
    private boolean showInfo = true;
    private boolean showWarning = true;
    private boolean showError = true;

    /**
     * Group related settings.
     */
    private boolean showGroup = true;
    private boolean showPath = true;
    private boolean showIndent = false;

    /**
     * Name related settings.
     */
    private boolean showName = true;

    /**
     * File related settings.
     */
    private boolean outputToFile = true;
    private String filePath = "logs";



    // Getters & Setters:

    public boolean showTime() { return this.showTime; }
    public TrackGazeConfig showTime(boolean setting) {
        this.showTime = setting;
        return this;
    }

    public boolean showDay() { return this.showDay; }
    public TrackGazeConfig showDay(boolean setting) {
        this.showDay = setting;
        return this;
    }

    public boolean showDebug() { return this.showDebug; }
    public TrackGazeConfig showDebug(boolean setting) {
        this.showDebug = setting;
        return this;
    }

    public boolean showInfo() { return this.showInfo; }
    public TrackGazeConfig showInfo(boolean setting) {
        this.showInfo = setting;
        return this;
    }

    public boolean showWarning() { return this.showWarning; }
    public TrackGazeConfig showWarning(boolean setting) {
        this.showWarning = setting;
        return this;
    }

    public boolean showError() { return this.showError; }
    public TrackGazeConfig showError(boolean setting) {
        this.showError = setting;
        return this;
    }

    public boolean showGroup() { return this.showGroup; }
    public TrackGazeConfig showGroup(boolean setting) {
        this.showGroup = setting;
        return this;
    }

    public boolean showPath() { return this.showPath; }
    public TrackGazeConfig showPath(boolean setting) {
        this.showPath = setting;
        return this;
    }

    public boolean showIndent() { return this.showIndent; }
    public TrackGazeConfig showIndent(boolean setting) {
        this.showIndent = setting;
        return this;
    }

    public boolean showName() { return this.showName; }
    public TrackGazeConfig showName(boolean setting) {
        this.showName = setting;
        return this;
    }

    public boolean outputToFile() { return this.outputToFile; }
    public TrackGazeConfig outputToFile(boolean setting) {
        this.outputToFile = setting;
        return this;
    }

    public String getFilePath() { return this.filePath; }
    public TrackGazeConfig setFilePath(String path) {
        this.filePath = path;
        return this;
    }
}
