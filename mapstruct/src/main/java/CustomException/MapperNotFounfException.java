package CustomException;

public class MapperNotFounfException extends RuntimeException {
	public MapperNotFounfException(String message) {
		super(message);
	}

	public MapperNotFounfException(String message, Throwable cause) {
		super(message, cause);
	}
}
