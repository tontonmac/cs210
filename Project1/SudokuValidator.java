import java.util.*;
import java.io.*;

/** 
 * This class instantiates a Sudoku object passing a Scanner on a
 * file to the Sudoku constructor.  It prints the puzzle using the
 * Sudoku toString method.  It determines if the digit matrix is a
 * valid solution for a Sudoku puzzle or not and prints the result.
 * 
 * @version 01/05/2012
 * @author Bob Wilson
 * 
 */

public class SudokuValidator
{
  private Sudoku puzzle;
  
  /**
   * @param args - not used
   */
  public static void main( String [] args)
  {
    Scanner scan = new Scanner(System.in);
    System.out.println("Please enter name of file containing puzzle to verify");   
    SudokuValidator myValidator = new SudokuValidator(scan.nextLine());
    System.out.println(myValidator.isSolution() ? 
                "It is a valid solution" : "It is not a valid solution");
  }
    
  public SudokuValidator(String fileName)
  {
    Scanner file = null;
    try
    {
      file = new Scanner(new File(fileName));
    }
    catch (Exception e)
    {
      System.out.println("Bad file name");
      System.exit(0);
    }
    
    puzzle = new Sudoku(file);
    System.out.println(puzzle);
  }
  
  public boolean isSolution()
  {
    // write your code to validate the puzzle solution here



    return false;  
  }
}  /* 201220 */
