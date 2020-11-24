import java.io.*;

/**
 * Class to read from and write to a file
 * @author: Aye Thuzar
 */
public class FileMaker
{
	/**
	 * Private fields
	 */
	private BufferedReader inputFile;
	private int next;

	/**
	 * Constructor
	 * @param filename name of the file to be read from
	 */
	public FileMaker(String filename)
	{
		try
		{
			// Try opening the file for reading
			inputFile = new BufferedReader(new FileReader(filename), 1024);
		}
		catch(IOException e)
		{
			// Provide an error message and exit the program if the file does not exist
			System.out.println("Error! File does not exist.");
			System.exit(1);
		}
		// Read the first character in the file
		next = read();
	}

	/**
	 * method to read the next character in the file
	 * This method is private
	 * @return The character that was read (as an int)
	 */
	private int read()
	{
		int x = 0;
		try
		{
			x = inputFile.read();
		}
		catch(IOException ioe)
		{
			System.out.println("Problem reading file.");
		}
		return x;
	}

  /**
	 * Method to read the next character from the file
	 * This is the public method that should be used by the client
	 * @return The character that was last read
	 */
	public char readChar()
	{
		int temp = next;
		next = read();
		return (char) temp;
	}

	/**
	 * Method to determine if there are more characters to be read by the file
	 * @return True if there are more characters, false otherwise
	 */
	public boolean hasNext()
	{
		return next != -1;
	}

	/**
	 * Method to write data to a file
	 * @param text the data to be written out to the file
	 * @param filename the file to write the data out to
	 */
  public static void writeFile(String text, String filename)
	{
		PrintWriter outputFile;
		try
		{
			// Try opening the file for writing and write the text out
			outputFile = new PrintWriter(new FileWriter(filename));
			outputFile.println(text);
			outputFile.close();
		}
		catch(IOException e)
		{
			// Provide an error message and exit the program if the file cannot be created
			System.out.println("Error creating file");
			System.exit(1);
		}
  }
}
