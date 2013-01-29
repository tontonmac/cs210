public class BingoSquare extends BingoNumber
{
  public BingoSquare(int num)
  {
    super(num);
  }
  
  public boolean equals(BingoNumber that)
  {
    return this.number == that.number;
  }
}