package Battle;

import Battle.Action.*;
import Battle.Magic.*;

import javax.swing.JList;
import javax.swing.JProgressBar;

import Battle.Player;
import Calcuration.Unit;

public class Battle  {
	public final static String HEAL = "힐";
	public final static String BLESS = "축복";
	public final static String LOCK = "봉인";
	public final static String PIERCING = "관통";
	public final static String CURSE = "저주";
	public final static String FIREBALL = "파이어볼";
	public final static String LAZER_BEAM = "레이져빔";
	public final static String EXPLOSION = "자폭";
	public final static String LIFE_DRAIN = "라이프 드레인";
	
	public String getMagic(long magic)
	{
		switch((int)magic)
		{
			case Magic.HEAL: return HEAL;
			case Magic.BLESS: return BLESS;
			case Magic.LOCK: return LOCK;
			case Magic.PIERCING: return PIERCING;
			case Magic.CURSE: return CURSE;
			case Magic.FIREBALL: return FIREBALL;
			case Magic.LAZER_BEAM: return LAZER_BEAM;
			case Magic.EXPLOSION: return EXPLOSION;
			case Magic.LIFE_DRAIN: return LIFE_DRAIN;
			default:return null;
		}
	}
	
	public void run(Player p1, Player p2, JList prog, JProgressBar HP, JProgressBar MP) throws InterruptedException
	{
		MagicUtils mu = new MagicUtils();
		
		Player off, def, temp;
		if(p1.getFIRST_ATTACK() > p2.getFIRST_ATTACK())
		{
			off = p1;
			def = p2;
			System.out.println(p1.getName() + " 선공\n");
		}
		else
		{
			off = p2;
			def = p1;
			System.out.println(p2.getName() + " 선공\n");
		}
		
		MyAction act = new MyAction();
		Unit u = new Unit();
		
		System.out.println(p1.getName() + "- HP : " + u.getUnit(p1.getHP()) + ", 공격력 : " + u.getUnit(p1.getATK())
							+ ", 방어력 : " + u.getUnit(p1.getDEF()) + ", 치명타율 : " + p1.getCRITICAL_HIT() / 10 +
							", 마법 : " + getMagic(p1.getMAGIC()) + ", 마법 레벨 : " + p1.getMAGIC_LEVEL());
		
		System.out.println(p2.getName() + "- HP : " + u.getUnit(p2.getHP()) + ", 공격력 : " + u.getUnit(p2.getATK())
		+ ", 방어력 : " + u.getUnit(p2.getDEF()) + ", 치명타율 : " + p2.getCRITICAL_HIT() / 10 +
		", 마법 : " + getMagic(p2.getMAGIC()) + ", 마법 레벨 : " + p2.getMAGIC_LEVEL());
		
		System.out.println();
		Thread.sleep(1000);
		
		while(true)
		{
			if(isAlive(def))
			{
				if(off.canUseMagic)
				{
					System.out.println(act.Action(off, def, new UseMagic()));
				}
				else
				{
					System.out.println(off.getName() + "은(는) 이번 턴 마법을 사용할 수 없다.");
				}
				Thread.sleep(1000);
				
				if(isAlive(def))
				{
					if(off.canAttack)
					{
						System.out.println(act.Action(off, def, new Attack()));
					}
					else
					{
						System.out.println(off.getName() + "은(는) 이번 턴 공격할 수 없다.");
					}
					Thread.sleep(1000);
					if(isAlive(def))
					{
						temp = off;
						off = def;
						def = temp;
						off.Initialize();
					}
					else break;
				}
				else break;
			}
			else break;
		}
		
		System.out.println(off.getName() + "의 승리!");
	}
	
	boolean isAlive(Player p)
	{
		if(p.getHP() <= 0)
		{
			return false;
		}
		else return true;
	}
}
