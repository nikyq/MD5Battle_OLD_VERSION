package Battle.Magic;

import Battle.Player;

public class Magic {
	public final static int HEAL = 0;
	public final static int BLESS = 1;
	public final static int LOCK = 2;
	public final static int PIERCING = 3;
	public final static int CURSE = 4;
	public final static int FIREBALL = 5;
	public final static int LAZER_BEAM = 6;
	public final static int EXPLOSION = 7;
	public final static int LIFE_DRAIN = 8;
	
	public String doMagic(Player p1, Player p2, Magic m)
	{
		if(m.getMana() >= p1.getMP())
			return p1.getName() + "의 MP가 부족하여 마법을 사용할 수 없다.\n";
		else
			return m.magicMethod(p1, p2);
	}
	
	public long getMana()
	{
		return 0L;
	}
	
	public String magicMethod(Player p1, Player p2)
	{
		return null;
	}
	
	public Magic getMagic(int index) throws Exception
	{
		switch(index)
		{
			case HEAL : return new Heal();
			case LIFE_DRAIN : return new LifeDrain();
			case FIREBALL : return new Fireball();
			case LOCK : return new Lock();
			case EXPLOSION : return new Explosion();
			case PIERCING : return new Piercing();
			case BLESS : return new Bless();
			case CURSE : return new Curse();
			case LAZER_BEAM : return new LazerBeam();
			default: return null;
		}
	}
}
