package Battle;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Random;

import Calcuration.MD5;
import Calcuration.Unit;

public class Stats {
	public final static int HP = 0;
	public final static int ATK = 1;
	public final static int DEF = 2;
	public final static int FIRST_ATTACK = 3;
	public final static int CRITICAL_HIT = 4;
	public final static int MAGIC = 5;
	public final static int MAGIC_LEVEL = 6;
	public final static int AWAKE_PP = 7;
	
	public ArrayList<Long> getStat(String player, String sword, String shield, String wand)
	{
		MD5 md5 = new MD5();
		ArrayList<Long> stats = new ArrayList<Long>();
		
		player = md5.getMD5(player);
		sword = md5.getMD5(sword);
		shield = md5.getMD5(shield);
		wand = md5.getMD5(wand);
		
		stats.add(getNormalStat(player));	// HP
		stats.add(getNormalStat(sword));	// ATK
		stats.add(getNormalStat(shield));	// DEF
		stats.add(getSpecialStat(player, 10));	// FIRST_ATTACK
		stats.add(getSpecialStat(sword, 9) + 15L);	// CRITICAL_HIT
		stats.add(getSpecialStat(wand, 9) - 1);		// magic
		stats.add(getSpecialStat(wand, 3));		// magic level
		
		return stats;
	}
	
	private static Long getNormalStat(String str)
	{		
		String parsed = str.substring(0, 5);
		Long seed = Long.parseLong(new BigInteger(parsed, 16).toString(10));
		SecureRandom r = new SecureRandom(seed.toString().getBytes());
		Unit u = new Unit();
		
		return (long)(r.nextDouble() * u.parseUnit("10T")) + 1;
	}
	
	private static Long getSpecialStat(String str, int max)
	{
		String parsed = str.substring(0, 5);
		Long seed = Long.parseLong(new BigInteger(parsed, 16).toString(10));
		SecureRandom r = new SecureRandom(seed.toString().getBytes());
		
		return (long)(r.nextDouble() * max) + 1;	
	}	
}
