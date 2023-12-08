package fr.eni.lesencheres.messages;

public class ErrorManager extends RuntimeException{
	    public ErrorManager() {
	    }

	    public ErrorManager(String message) {
	        super(message);
	    }

	    public ErrorManager(String message, Throwable cause) {
	        super(message, cause);
	    }

	    @Override
	    public String getMessage() {
	        return super.getMessage();
	    }
	}
