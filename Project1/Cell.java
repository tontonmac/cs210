public class Cell
{
 private int value;
 
 public Cell(int value)
 {
  this.value = value; 
 }
 public int getValue()
 {
  return value; 
 }
 public boolean equals(Cell that)
 {
  if(value==that.value)
    return true;
  else
    return false;
 }
 public String toString()
 {
  return(" " + value); 
 }
}