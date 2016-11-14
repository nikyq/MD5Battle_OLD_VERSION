package Battle.Magic;

import Battle.Player;
import Calcuration.Unit;

public class Curse extends Magic {
	private long mana = 40L;
	
	public long getMana()
	{
		return mana;
	}
	
	public String magicMethod(Player p1, Player p2)
	{
		Unit u = new Unit();
		String process = p1.getName() + " 마법 사용 : 저주(" + mana + "MP 사용)\n";

		try
		{
			p1.setMP(mana, Player.SUBSTRACT);
		} catch(Exception ex) {}
		
		long MPamount =  p2.getMP() * (p1.getMAGIC_LEVEL() == 1? 30 : p1.getMAGIC_LEVEL() == 2? 40: 50) / 100;
		long ATKamount = p2.getATK() * 20 / 100;
		long DEFamount = (p2.getUsingDef() == "defaultDEF"? p2.getDefaultDEF() : p2.getDEF()) * 20 / 100;
		
		long DEF = p2.getUsingDef() == "DEF"? p2.getDEF() : p2.getDefaultDEF();
		
		try
		{
			p2.setMP(MPamount, Player.SUBSTRACT);
			p2.setATKandDEF(u.convert(p2.getATK() - ATKamount), u.convert(DEF - DEFamount));
		}
		catch(Exception e) {}
		
		process += p2.getName() + "의 MP를 " + MPamount + ", 공격력을 " + u.getUnit(ATKamount) + ", 방어력을 "
				+ u.getUnit(DEFamount) + "만큼을 감소시켰다. 공격력과 방어력은 다음 " + p1.getName() +"의 턴에 원래대로 돌아온다.\n";
		return process;
	}
}
