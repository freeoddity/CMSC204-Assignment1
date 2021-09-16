public class NoLowerAlphaException extends Exception
{
	NoLowerAlphaException()
	{
		super("The password must contain at least one lower case alphabetic character");
	}
}