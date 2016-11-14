package Battle.Action;

import Battle.Player;
import Battle.Magic.*;

public class UseMagic extends MyAction {
	@Override
	public String execute(Player p1, Player p2)
	{
		Magic m = new Magic();
		
		try
		{
			return m.doMagic(p1, p2, m.getMagic((int)p1.getMAGIC()));
		}
		catch(Exception e) { return null; }
	}
}
