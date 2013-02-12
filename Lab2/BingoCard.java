public class BingoCard
{
	private BingoSquare[][] card;
	
	public BingoCard()
	{	
	    card = new BingoSquare[][]
		{
		{new BingoSquare(3),
		new BingoSquare(6),
		new BingoSquare(9),
		new BingoSquare(12),
		new BingoSquare(15)},
			
		{new BingoSquare(18),
		new BingoSquare(21),
		new BingoSquare(24),
		new BingoSquare(27),
		new BingoSquare(30)},

		{new BingoSquare(33),
		new BingoSquare(36),
		null,
		new BingoSquare(42),
		new BingoSquare(45)},

		{new BingoSquare(48), 
		new BingoSquare(51),
		new BingoSquare(54),
		new BingoSquare(57),
		new BingoSquare(60)},

		{new BingoSquare(63),
		new BingoSquare(66),
		new BingoSquare(69),
		new BingoSquare(72),
		new BingoSquare(75)}};
	}
	public String toString()
	{
		String s = "";

		for(int i=0; i < card.length; i++)
		{
			for (int j=0; j < card[i].length; j++)
			{
				if(card[i][j] == null)
					s += " ****";
				else
					s += " " + card[j][i];
			}
			s += "\n";
		}
		return s;
	}
	public boolean cover(BingoSquare mycover)
	{
		boolean covered = true;

		for(int i=0; i<card.length; i++)
		{
			for(int j=0; j<card[i].length; j++)
			{
				if(mycover.equals(card[i][j]))
				{
					cover[i][j] = null;
					return true;
				}
			}
		}
		return covered;
	}
	public boolean hasBingo()
	{
		boolean bingo = true;

		//row checking

		for(int i=0; i<card.length; i++)
		{
			for(int j=0; j<card[i].length; j++)
			{
				if(card[i][j] != null)
				return false;
			}
			if(false)
				return bingo;
		}
		//column checking

		for(i=0; i<card.length; i++)
		{
			for(int j=0; j<card[i].length; j++)
			{
				if(card[j][i] != null)
					return false;
			}
			if(false)
				return bingo;
		}
		//left diagonal checking

		for(int i=0; i<card.lenght; i++)
		{
			if(card[i][i] != null)
				return false;
		}
		if(false)
			return bingo;

		//right diagonal checking

		for(int i=0; i<card.length; i++)
		{
			if(card[i][j] != null)
					return false;
			j--;
			}
		if(false)
			return bingo;

		return false;
		}
	}
}

	

	

