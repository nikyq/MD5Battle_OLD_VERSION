package Battle.Action;

import Battle.*;
import javax.swing.*;

public class MyAction {
	public String Action(Player p1, Player p2, MyAction a)
	{	
		//text.append(a.execute(p1, p2));
		return a.execute(p1, p2);
	}
	
	public String execute(Player p1, Player p2)
	{
		return null;
	}
}
