package Battle.Magic;

import Battle.Player;

public class Lock extends Magic {
	private long mana = 70L;
	
	public long getMana()
	{
		return mana;
	}
	
	public String magicMethod(Player p1, Player p2)
	{
		String process = p1.getName() + " 마법 사용 : 봉인(" + mana + "MP 사용)\n";
		
		p2.canUseMagic = false;
		p2.canBeAwaken = false;		
		
		return process;
	}
}
