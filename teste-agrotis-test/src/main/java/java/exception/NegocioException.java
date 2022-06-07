package exception;

public class NegocioException extends RuntimeException {

	private static final long serialVersionUID = 5959901370633421855L;
	
	public NegocioException(String message) {
		super(message);
	}

}
