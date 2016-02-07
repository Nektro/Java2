package io.nub.core.error;

/**
 * @author Nektro
 */
public class InvalidArgumentsException extends RuntimeException
{
	private static final long serialVersionUID = 5391097031927316348L;
	
	public InvalidArgumentsException(String cause) {
		super(cause);
	}
}
