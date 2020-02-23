package CustomException;

public class IllegalMapperAnnotationException extends RuntimeException {
	public IllegalMapperAnnotationException(String message) {
		super(message);
	}

	public IllegalMapperAnnotationException(String message, Throwable cause) {
		super(message, cause);
	}

}
