package com.wy.tests.util;

import javax.validation.ValidationException;

public class DefinedMessageException extends ValidationException{
	 private String code;
	    private static final long serialVersionUID = 1L;

	    public String getCode() {
	        return this.code;
	    }

	    public void setCode(String code) {
	        this.code = code;
	    }

	    public DefinedMessageException() {
	    }

	    public DefinedMessageException(String code, String message) {
	        super(message);
	        this.code = code;
	    }

	    public DefinedMessageException(String code, String message, Throwable cause) {
	        super(message, cause);
	        this.code = code;
	    }

	    public DefinedMessageException(String code, Throwable cause) {
	        super(cause);
	        this.code = code;
	    }
}
