package CustomException;

public class UnImplementedMethodException extends RuntimeException {

	public UnImplementedMethodException(String message) {
		super(message);
	}
	public UnImplementedMethodException(String message,
            Throwable cause) {
		super(message, cause);
	}
}
