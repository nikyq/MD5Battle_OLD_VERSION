package Battle.Magic;

import Battle.Player;
import Calcuration.Unit;

public class Fireball extends Magic {
	private long mana = 40L;
	
	public long getMana()
	{
		return mana;
	}
	
	public String magicMethod(Player p1, Player p2)
	{
		Unit u = new Unit();
		
		String process = p1.getName() + " 마법 사용 : 파이어볼(" + mana + "MP 사용)\n";
		try{ p1.setMP(mana, Player.SUBSTRACT); } catch(Exception e) {}
		
		long damagePercent = p1.getMAGIC_LEVEL() == 1? 10L : p1.getMAGIC_LEVEL() == 2? 20L : 30L;
		long damage = p2.getHP() * damagePercent / 100;
		
		try
		{
			p2.setHP(u.convert(damage), Player.SUBSTRACT);
		}
		catch(Exception e) {}
		
		process += p2.getName() + "에게 " + u.getUnit(damage) + "만큼의 데미지를 주었다.\n";
		return process;
	}
}
