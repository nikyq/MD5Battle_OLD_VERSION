package Battle.Magic;

import Battle.Player;

public class MagicUtils {
	public boolean attackLimit(Player p)
	{
		if(p.limitTurn > 0)
		{
			p.limitTurn--;
			return false;
		}
		else
		{
			return true;
		}
	}
	
	public void ignoreDefence(Player p1, Player p2)
	{
		p2.disableDef();
	}
	
	public void setLimitTurn(Player p, int turn)
	{
		p.limitTurn = 1;
	}
}
