package Battle.Action;

import javax.crypto.CipherInputStream;

import Battle.Player;
import Calcuration.Unit;

public class Attack extends MyAction {
	@Override
	public String execute(Player p1, Player p2)
	{
		String process = "";
		Unit u = new Unit();
		boolean criticalHit = false;
		
		long attack = u.convert(p1.getATK());
		
		if(p1.getPP() >= 20)
		{
			criticalHit = true;
		}
		
		if(criticalHit)
		{
			process += "치명타! "; 
			attack = u.convert((long)(attack * (p1.getCRITICAL_HIT() / 10))); 
		}
		process += p1.getName() + " 공격 : ";
		
		try
		{
			if(p2.getUsingDef() == "defaultDEF")
			{
				long damage = attack - p2.getDefaultDEF();
				if(damage <= 0L) { damage = 0; process+=p1.getName() + "은(는) 아무런 데미지도 주지 못하였다.\n";}
				else
				{
					p2.setHP(damage, Player.SUBSTRACT);
					process += p1.getName() + " 공격력(" + u.getUnit(attack) + ") - " +
							p2.getName() + " 기본 방어력 (" + u.getUnit(p2.getDefaultDEF()) + ") ="
						   + u.getUnit(damage) + "의 데미지를 " + p2.getName() + "에게 주었다.\n";
				}
				
				p2.setInitHP(p2.getHP());
			}
			else if(p2.getUsingDef() == "DEF")
			{
				if(attack >= p2.getDEF())
				{
					long damage = attack - p2.getDEF();
					long tempdef = p2.getDEF();
					p2.setATKandDEF(p2.getATK(), 0);
					p2.setHP(damage, Player.SUBSTRACT);
					p2.switchUsingDef();
					
					process += p1.getName() + "이(가) " + p2.getName() + "의 방어력을 0으로 만들었고, "
							+ p1.getName() + " 공격력(" + u.getUnit(attack) + ") - " + p2.getName()
							+ " 방어력(" + u.getUnit(tempdef) + ") = " + u.getUnit(damage) + "의 데미지를 " + p2.getName()
							+ "에게 주었다. (" + p2.getName() + " 현재 체력 : " + u.getUnit(p2.getHP()) + ")\n";
					
					if(p2.getHP() != 0)
						process += p2.getName() + "은(는) 앞으로 기본 방어력(" + u.getUnit(p2.getDefaultDEF()) + ")을"
								+ "방어력으로 사용한다.\n";
					
					p2.setInitHP(p2.getHP());
					p2.setInitDEF(0L);
				}
				else
				{
					long remaining = p2.getDEF() - attack;
					long tempdef = p2.getDEF();
					p2.setATKandDEF(p2.getATK(), remaining);
					
					process += p2.getName() + "의 방어력(" + u.getUnit(tempdef) +")을 " + p1.getName() 
							+ "의 공격력(" + u.getUnit(attack) + ")만큼 깎아 " + u.getUnit(remaining) + "으로 만들었다.\n";
					p2.setInitDEF(p2.getDEF());
				}
			}
			else
			{
				long damage = u.convert(attack);
				
				p2.setHP(damage, Player.SUBSTRACT);
				p2.setInitHP(p2.getHP());
				
				process += p1.getName() + "이(가) " + p2.getName() + "의 방어력을 무시하고 공격하였다.\n";
				process += p2.getName() + "의 HP를 " + u.getUnit(damage) + "만큼 깎았다.\n";
			}
			
			
		}
		
		catch(Exception e)
		{
			
		}
		
		try {
			p1.setPP(10L, Player.ADD);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return process;
	}
}
