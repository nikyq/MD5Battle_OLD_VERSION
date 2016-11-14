package Battle.Magic;

import Battle.Player;
import Calcuration.Unit;

public class Heal extends Magic {
	private long mana = 35L;
	
	public long getMana()
	{
		return mana;
	}
	
	public String magicMethod(Player p1, Player p2)
	{
		Unit u = new Unit();
		
		String process = p1.getName() + " 마법 사용 : 힐(" + mana + "MP 사용)\n";
		try{ p1.setMP(mana, Player.SUBSTRACT); } catch(Exception e) {}
		
		long percent = p1.getMAGIC_LEVEL() == 1? 10L: p1.getMAGIC_LEVEL() == 2? 20L: 30L;
		long amount = p1.getHP() * percent / 100;
		
		try
		{
			p1.setHP(u.convert(amount), Player.ADD);
		} catch(Exception e) {}
		
		process += p1.getName() + "의 HP가 " + u.getUnit(amount) + "만큼 회복되었다.\n";
		
		return process;
	}
}
