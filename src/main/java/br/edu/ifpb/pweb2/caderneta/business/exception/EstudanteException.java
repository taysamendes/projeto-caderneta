package br.edu.ifpb.pweb2.caderneta.business.exception;

public class EstudanteException extends Exception {
	private static final long serialVersionUID = 1L;

	public EstudanteException() {
		super();
	}

	public EstudanteException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	public EstudanteException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public EstudanteException(String arg0) {
		super(arg0);
	}

	public EstudanteException(Throwable arg0) {
		super(arg0);
	}
}
