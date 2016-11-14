package Battle.Magic;

import Battle.Player;

public class Piercing extends Magic {
	private long mana = 90L;
	
	public long getMana()
	{
		return mana;
	}
	
	public String magicMethod(Player p1, Player p2)
	{
		String process = p1.getName() + " 마법 사용 : 관통\n";
		
		try
		{
			p1.setMP(mana, Player.SUBSTRACT);
		}
		catch(Exception e) {}
		
		MagicUtils m = new MagicUtils();
		m.ignoreDefence(p1, p2);
		process += p1.getName() + "은(는) 이번 턴 " + p2.getName() + "의 방어력을 무시하고 공격할 수 있다.\n"; 
		return process;
	}
}
