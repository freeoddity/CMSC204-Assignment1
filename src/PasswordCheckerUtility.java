import java.util.ArrayList;
import java.util.regex.*;
import java.util.Scanner;
import java.io.*;
public class PasswordCheckerUtility {
	public PasswordCheckerUtility()
	{
		
	}
	
	public static void comparePasswords(String password, String passwordConfirm) throws UnmatchedException
	{
		if (!password.equals(passwordConfirm))
		{
			throw new UnmatchedException();
		}
	}
	public static boolean comparePasswordsWithReturn(String password,String passwordConfirm)
	{
		return (password.equals(passwordConfirm));
			
		
	}
	
	public static ArrayList<String> getInvalidPasswords(ArrayList<String> passwords)
	{
		ArrayList<String> invalidPasswords = new ArrayList<String>();
		ArrayList<String> validPasswords = new ArrayList<String>();
		
		for (String e:passwords)
		{
			try {
				if (isValidPassword(e))
					validPasswords.add(e);
			} catch (LengthException e1) {
				// TODO Auto-generated catch block
				invalidPasswords.add(e + " -> " + e1.getMessage());
			} catch (NoUpperAlphaException e1) {
				// TODO Auto-generated catch block
				invalidPasswords.add(e + " -> " + e1.getMessage());
			} catch (NoLowerAlphaException e1) {
				// TODO Auto-generated catch block
				invalidPasswords.add(e + " -> " + e1.getMessage());
			} catch (NoDigitException e1) {
				// TODO Auto-generated catch block
				invalidPasswords.add(e + " -> " + e1.getMessage());
			} catch (NoSpecialCharacterException e1) {
				// TODO Auto-generated catch block
				invalidPasswords.add(e + " -> " + e1.getMessage());
			} catch (InvalidSequenceException e1) {
				// TODO Auto-generated catch block
				invalidPasswords.add(e + " -> " + e1.getMessage());
			}
		}
		return invalidPasswords;
	}
	public static boolean hasBetweenSixAndNineChars(String password)
	{
		return (password.length()  >= 6 && password.length() <= 9);
		
	}
	public static boolean hasDigit(String password) throws NoDigitException
	{
		boolean hasDigit = false;
		ArrayList<Character> stringCharacters = new ArrayList<Character>();
		for (int i = 0; i < password.length(); i++)
		{
			stringCharacters.add(password.charAt(i));
		}
		for (Character e: stringCharacters)
		{
			if (Character.isDigit(e))
			{
				hasDigit = true;
			}
		}
		if (!hasDigit)
		{
			throw new NoDigitException();
		}
		return hasDigit;
		
	}
	public static boolean hasLowerAlpha(String password) throws NoLowerAlphaException
	{
		boolean hasLowerAlpha = false;
		ArrayList<Character> passwordCharacters = new ArrayList<Character>();
		for(int i = 0; i < password.length(); i++)
		{
			passwordCharacters.add(password.charAt(i));
		}
		for (Character e:passwordCharacters)
		{
			if (Character.isLowerCase(e))
			{
				hasLowerAlpha = true;
			}
		}
		if (!hasLowerAlpha)
		{
			throw new NoLowerAlphaException();
		}
		return hasLowerAlpha;
			
		
	}
	public static boolean hasSameCharInSequence(String Password) throws InvalidSequenceException
	{
		boolean hasSamecharInSequence = false;
		for (int i = 0; i < Password.length(); i++)
		{
			if (i > 0)
			{
				if ((Character.getNumericValue(Password.charAt(i))) == Character.getNumericValue(Password.charAt(i-1)))
				{
					hasSamecharInSequence = true;
					throw new InvalidSequenceException();
				}
			}
		}
		return hasSamecharInSequence;
	}
	public static boolean hasSpecialChar(String Password) throws NoSpecialCharacterException
	{
		boolean hasSpecialChar = true;
		Pattern pattern = Pattern.compile("[^A-Za-z0-9]*");
		Matcher matcher = pattern.matcher(Password);
		hasSpecialChar = matcher.matches();
		if (!hasSpecialChar)
		{
			throw new NoSpecialCharacterException();
		}
		return hasSpecialChar;
		
	}
	public static boolean hasUpperAlpha(String password) throws NoUpperAlphaException
	{
		boolean hasUpperAlpha = false;
		ArrayList<Character> passwordCharacters = new ArrayList<Character>();
		for(int i = 0; i < password.length(); i++)
		{
			passwordCharacters.add(password.charAt(i));
		}
		for (Character e:passwordCharacters)
		{
			if (Character.isUpperCase(e))
			{
				hasUpperAlpha = true;
			}
		}
		if (!hasUpperAlpha)
		{
			throw new NoUpperAlphaException();
		}
		return hasUpperAlpha;
		
	}
	public static boolean isValidLength(String Password) throws LengthException
	{
		boolean length = false;
		if (Password.length() >= 6)
		{
			length = true;
		}
		else 
			throw new LengthException();
		return length;
		
	}
	public static boolean isValidPassword(String Password) throws LengthException, NoUpperAlphaException, NoLowerAlphaException, NoDigitException, NoSpecialCharacterException, InvalidSequenceException
	{
		boolean validPass = false;
		int check = 0;
		if (isValidLength(Password))
		{
			check++;
		}
		if (hasUpperAlpha(Password))
		{
			check++;
		}
		if (hasLowerAlpha(Password))
		{
			check++;
		}
		if (hasDigit(Password))
		{
			check++;
		}
		if (hasSpecialChar(Password))
		{
			check++;
		}
		if (hasSameCharInSequence(Password))
		{
			check++;
		}
		if (check == 6)
		{
			validPass = true;
		}
		return validPass;
		
	}
	public static boolean isWeakPassword(String Password) throws WeakPasswordException
	{
		boolean weakPass = false;
		try {
			if (isValidPassword(Password))
			{
				if (Password.length() >= 6 && Password.length() <= 9)
				{
					weakPass = true;
					throw new WeakPasswordException();
				}
			}
		} catch (LengthException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoUpperAlphaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoLowerAlphaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoDigitException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSpecialCharacterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidSequenceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (WeakPasswordException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return weakPass;
		
	}
	
	
	

}
