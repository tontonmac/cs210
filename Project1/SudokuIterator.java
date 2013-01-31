import java.util.Iterator;

public class SudokuIterator implements Iterator<Cell[]>
{
 private Cell[][] puzzle;
 private int cursor;
 
 public SudokuIterator(Cell[][] puzzle)
 {
  this.puzzle = puzzle;
  cursor = 0;
 }
 public boolean hasNext()
 {
  return cursor < puzzle.length; 
 }
 public Cell[] next()
 {
   if(hasNext())
    {
      if(cursor < puzzle.length)
      {
        return puzzle[cursor++];
      }
      else if(cursor < (puzzle.length *2))
      {
        Cell[] mypuzzle = new Cell[puzzle.length];

        for(int i=0;i<puzzle.length;i++) mypuzzle[i]=puzzle[i][cursor-puzzle.length];
        cursor++;
        return mypuzzle;
      }
      else
      {        
        Cell[] mypuzzle = new Cell[puzzle.length];
        int c = (int)Math.sqrt(puzzle.length);
        int row = ((cursor - (puzzle.length)*2)/c)*c;
        int col = ((cursor - (puzzle.length)*2)%c)*c;
        for(int i = 0;i<c;i++)
          for(int j = 0;j<c;j++)
        {
          mypuzzle[i*c+j] = puzzle[row+i][col+j];
        }
        cursor++;
        return mypuzzle;
      }
    }
    else 
      return null;
  }
 public void remove()
 {
   
 }
}