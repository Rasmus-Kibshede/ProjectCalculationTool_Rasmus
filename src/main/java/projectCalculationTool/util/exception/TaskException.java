package projectCalculationTool.util.exception;

public class TaskException extends Exception {

    public TaskException(String message, Throwable cause) {
        super(message, cause);
    }

    public TaskException(String message) {
        super(message);
    }
}
