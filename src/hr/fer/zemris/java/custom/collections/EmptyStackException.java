package hr.fer.zemris.java.custom.collections;

@SuppressWarnings("serial")
public class EmptyStackException extends RuntimeException {

	public EmptyStackException() {
	}

	public EmptyStackException(String arg0) {
		super(arg0);
	}

	public EmptyStackException(Throwable arg0) {
		super(arg0);
	}

	public EmptyStackException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public EmptyStackException(String arg0, Throwable arg1, boolean arg2,
			boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

}
