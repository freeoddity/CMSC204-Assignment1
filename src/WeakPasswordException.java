	public class WeakPasswordException extends Exception
	{
		WeakPasswordException()
		{
			super("Error! Password contains 6 to 9 characters which are otherwise valid");
		}
		
	}