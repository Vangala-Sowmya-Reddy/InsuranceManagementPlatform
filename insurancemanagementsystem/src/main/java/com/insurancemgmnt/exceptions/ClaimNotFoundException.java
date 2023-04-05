package com.insurancemgmnt.exceptions;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(HttpStatus.NOT_MODIFIED)
public class ClaimNotFoundException extends RuntimeException{
	public ClaimNotFoundException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public ClaimNotFoundException(String message)
	{
	super(message);

}

}
