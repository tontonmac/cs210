import java.util.*;
import java.io.*;
import java.util.Iterator;
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
    boolean row = true;
    
    Iterator<Cell[]> itr = puzzle.iterator();
     
    while(itr.hasNext())
    {
      Cell[] mypuzzle = itr.next();
      boolean puzz[] = new boolean[mypuzzle.length];
    
      for(int i=0; i<mypuzzle.length; i++)
        puzz[i] = false;
    
      for(int j=0; j<mypuzzle.length; j++)
        puzz[mypuzzle[j].getValue()-1] = true;
      boolean valid = true;
      for(int i = 0; i<mypuzzle.length;i++)
        row=(row && puzz[i]);
    
      if(!row)
        return false;
    
    }
    return true;
  }
}
  
/* 201220 */
