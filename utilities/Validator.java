package utilities;



/**
 * @author Sara Wille
 * The Validator class can get an integer, double or String from the user.
 * It implements the Validatable class to confirm that the user input
 * is valid given the type of data requested. 
 */

public class Validator implements Validatable {
	static String userInput = "";
	static int userInteger = 0;
	static double userDouble = 0;
	static String userString = "";
	static Displayable screen;
	static Validator validator;

	private Validator() {}
	
	public static Displayable getScreen() {
		return screen;
	}
	public static void setScreen(Displayable screen) {
		Validator.screen = screen;
	}
	public static Validator getValidator() {
		return validator;
	}
	public static void setValidator(Validator validator) {
		Validator.validator = validator;
	}

	/**
	 * getInt - ask the user for an integer and confirm that it is a valid integer
	 * @param s
	 * @return userInteger
	 */
	public int getInt(String prompt) {
		while (true) {
			try {
				screen.display(prompt);
				userInput = RequestInformation.getInfo();
				userInteger = isValidInt(userInput);
			}
			catch (NumberFormatException e) {
				screen.displayln("Error! Invalid integer value. Try again.");
				continue;
			}
			return userInteger;
		}
	}
	
	

	/**
	 * getInt - ask the user for an integer, confirm that it is a valid integer, and 
	 * confirm that it is within the range min-max
	 * @param prompt
	 * @param min
	 * @param max
	 * @return userInteger
	 */
	public int getInt(String prompt, int min, int max) {
		while (true) {
			try {
				screen.display(prompt);
				userInput = RequestInformation.getInfo();
				userInteger = isValidInt(userInput);
				if (isInRange(userInteger, min, max)) {
					return userInteger;
				}
				else if (userInteger < min)
				{
					System.out.println("Error! Number must be greater than " + min + ". Try again.");
					continue;
				}
				else
				{
					System.out.println("Error! Number must be less than " + max + ". Try again.");
					continue;
				}
			}
			catch (NumberFormatException e) {
				screen.displayln("Error! Invalid integer value. Try again.");
			}
		}
	}
	
	/**
	 * getDouble - ask the user for a double and confirm that it is a valid double
	 * @param s
	 * @return userDouble
	 */
	public double getDouble(String prompt) {
		while (true) {
			try {
				screen.display(prompt);
				userInput = RequestInformation.getInfo();
				userDouble = isValidDouble(userInput);
			}
			catch (NumberFormatException e) {
				screen.displayln("Error! Invalid number value. Try again.");
				continue;
			}
			return userDouble;
		}
	}
	
	/**
	 * getDouble - ask the user for a double, confirm that it is a valid double, and 
	 * confirm that it is within the range min-max
	 * @param prompt
	 * @param min
	 * @param max
	 * @return userDouble
	 */
	public double getDouble(String prompt, double min, double max) {
		while (true) {
			try {
				screen.display(prompt);
				userInput = RequestInformation.getInfo();
				userDouble = isValidDouble(userInput);
				if (isInRange(userDouble, min, max)) {
					return userDouble;
				}
				else if (userDouble < min)
				{
					System.out.println("Error! Number must be greater than " + min + ". Try again.");
					continue;
				}
				else
				{
					System.out.println("Error! Number must be less than " + max + ". Try again.");
					continue;
				}
			}
			catch (NumberFormatException e) {
				screen.displayln("Error! Invalid number value. Try again.");
			}
		}
	}

	
	/**
	 * getString - ask the user for a String, confirm that they did not enter an empty line
	 * @param prompt
	 * @return userString
	 */
	public String getString(String prompt) {
		while (true) {
			screen.display(prompt);
			userInput = RequestInformation.getInfo();
			if (isValidString(userInput))
			{
				userString = userInput;
				return userString;
			}
			else 
			{
				screen.displayln("Error! This entry is required. Try again.");
			}
		}
	}
	
	/**
	 * getString - ask the user for a String, confirm that they entered a String of the right length
	 * @param prompt
	 * @param len
	 * @return userString
	 */
	public String getString(String prompt, int len) {
		while (true) {
			screen.display(prompt);
			userInput = RequestInformation.getInfo();
			if (isValidString(userInput, len))
			{
				userString = userInput;
				return userString;
			}
			else 
			{
				screen.displayln("Error! This entry is required to be length "
						+ len + ". Try again.");
			}
		}
	}
	
	/**
	 * getString - ask the user for a String, confirm that they entered a one of the String options
	 * @param prompt
	 * @param option1
	 * @param option2
	 * @return userString
	 */
	public String getString(String prompt, String option1, String option2) {
		while (true) {
			screen.display(prompt);
			userInput = RequestInformation.getInfo();
			if (isValidString(userInput, option1, option2))
			{
				userString = userInput;
				return userString;
			}
			else 
			{
				screen.displayln("Error! Please enter " + option1 + " or " + option2 + ". Try again.");
			}
		}
	}
}
