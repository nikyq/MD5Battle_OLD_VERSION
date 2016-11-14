package Battle.Magic;

import Battle.Player;
import Calcuration.Unit;

public class LifeDrain extends Magic {
	private long mana = 50L;
	
	public long getMana()
	{
		return mana;
	}
	
	public String magicMethod(Player p1, Player p2)
	{
		Unit u = new Unit();
		
		String process = p1.getName() + " 마법 사용 : 라이프 드레인(" + mana + "MP 사용)\n";
		try{ p1.setMP(mana, Player.SUBSTRACT); } catch(Exception e) {}
		
		long percent = p1.getMAGIC_LEVEL() == 1? 10L: p1.getMAGIC_LEVEL() == 2? 15L: 20L;
		long amount = u.convert(p2.getHP() * percent / 100);
		
		try
		{
			p1.setHP(amount, Player.ADD);
			p2.setHP(amount, Player.SUBSTRACT);			
		} catch(Exception e) {}
		
		process += u.getUnit(p2.getHP()) + "의 체력 중 " + u.getUnit(amount) + "만큼을 " + p1.getName()
				+ "의 체력에 흡수시켰다.\n";
		return process;
	}
}
