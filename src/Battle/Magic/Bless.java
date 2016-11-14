package Battle.Magic;

import Battle.Player;
import Calcuration.Unit;

public class Bless extends Magic {
	private long mana = 40L;
	
	public long getMana()
	{
		return mana;
	}
	
	public String magicMethod(Player p1, Player p2)
	{
		Unit u = new Unit();
		
		String process = p1.getName() + " 마법 사용 : 축복(" + mana + "MP 사용)\n";
		
		try 
		{
			p1.setMP(mana, Player.SUBSTRACT);
		} catch (Exception e) {  }
		
		long MPamount = 0L;
		long ATKamount = 0L;
		long DEFamount = 0L;
		
		MPamount = p1.getMP() * (p1.getMAGIC_LEVEL() == 1? 30 : p1.getMAGIC_LEVEL() == 2? 40 : 50) / 100;	
								// 레벨을 비교하여 퍼센테이지 계산 (삼항 연산자 사용)
		
		ATKamount = p1.getATK() * 20 / 100;
		DEFamount = (p1.getUsingDef() == "defaultDEF"? p1.getDefaultDEF() * 20
					: p1.getDEF() * 20) / 100;	// 기본 방어력을 비교하여 퍼센테이지 계산 (삼항 연산자 사용)
		
		try { p1.setMP(MPamount, Player.ADD); } catch (Exception e) {}
		p1.setATKandDEF(u.convert(p1.getATK() + ATKamount), u.convert(p1.getUsingDef() == "DEF"?p1.getDEF() 
						: p1.getDefaultDEF() + DEFamount));
		
		process += p1.getName() + "의 " + "MP가 " + MPamount + "만큼, 공격력이 " + u.getUnit(ATKamount)
				+ "만큼, 방어력이 " + u.getUnit(DEFamount) + "만큼 증가하였다. 공격력과 방어력은 다음 " + p1.getName() +"의 턴에 원래대로 돌아온다.\n";
		
		return process;
	}
}
