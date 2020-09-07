package biz.fabiotecnico1.cursomc.services.exceptions;

public class ObjectNotFoundException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	public ObjectNotFoundException(String msg) {	//Reaproveitamento da infraestrutura das exeções do java
		super(msg);
	}
	
	public ObjectNotFoundException(String msg, Throwable cause) { //Sobrecarga do construtor
		super(msg, cause);
	}
}
