package Battle;

import java.util.ArrayList;

public class Player {
	private String name;
	public boolean canAttack;
	public boolean canUseMagic;
	public boolean canBeAwaken;
	public int limitTurn;
	
	private long HP;
	private long ATK;
	private long DEF;
	private long FIRST_ATTACK;
	private double CRITICAL_HIT;
	private long MAGIC;
	private long MAGIC_LEVEL;
	private long AWAKE_PP;
	private long AWAKE_LEVEL = 0;
	
	private long PP;
	private long MP;
	private final long MAX_MP = 300;
	private long firstHP;
	private long defaultDEF;
	private long MPRecover;
	
	private long initHP;
	private long initATK;
	private long initDEF;
	private long initDefaultDef;
	private String initUsingDef = "DEF";
	
	private String usingDef = "DEF";
	
	public final static int ADD = 0;
	public final static int SUBSTRACT = 1;
	
	public Player(String name, ArrayList<Long> stats)
	{
		this.name = name;
		
		this.HP = stats.get(Stats.HP);
		this.firstHP = this.HP;
		this.initHP = this.HP;
		
		this.ATK = stats.get(Stats.ATK);
		this.initATK = this.ATK;
		this.DEF = stats.get(Stats.DEF);
		this.initDEF = this.DEF;
		this.defaultDEF = DEF / 4;
		this.initDefaultDef = this.defaultDEF;
		
		this.FIRST_ATTACK = stats.get(Stats.FIRST_ATTACK);
		this.CRITICAL_HIT = stats.get(Stats.CRITICAL_HIT);
		this.MAGIC = stats.get(Stats.MAGIC);
		this.MAGIC_LEVEL = stats.get(Stats.MAGIC_LEVEL);
		
		this.PP = 0L;
		this.MP = 50L;
		this.MPRecover = 20L;
	}
	
	public void Initialize()
	{
		this.ATK = this.initATK;
		this.DEF = this.initDEF;
		this.HP = this.initHP;
		this.defaultDEF = this.initDefaultDef;
	}
	
	public void setHP(long amount, int action) throws Exception
	{
		switch(action)
		{
			case ADD : this.HP += amount; break;
			case SUBSTRACT : 
				if(amount >= this.HP)
				{
					this.HP = 0;
				}
				else
				{
					this.HP -= amount;
				} break;
				
			default : throw new Exception();
		}
	}
	
	public void setMP(long amount, int action) throws Exception
	{
		switch(action)
		{
			case ADD : this.MP += amount; if(this.MP >= this.MAX_MP) this.MP = this.MAX_MP; break;
			case SUBSTRACT : 
				if(amount >= this.MP)
				{
					this.MP = 0;
				}
				else
				{
					this.MP -= amount;
				} break;
				
			default : throw new Exception();
		}
	}
	
	public void setATKandDEF(long atk, long def)
	{
		this.ATK = atk;
		this.DEF = def;
		
		if(this.ATK < 0) this.ATK = 0;
		if(this.DEF < 0) this.DEF = 0;
	}	
	
	public void setPP(long amount, int action) throws Exception
	{
		switch(action)
		{
			case ADD : this.PP += amount; break;
			case SUBSTRACT : 
				if(amount >= this.PP)
				{
					this.PP = 0;
				}
				else
				{
					this.PP -= amount;
				} break;
				
			default : throw new Exception();
		}
	}
	
	public void switchUsingDef()
	{
		if(usingDef == "DEF")
		{
			usingDef = "defaultDEF";
			initUsingDef = "defaultDEF";
		}
		else if(usingDef == "defaultDEF")
		{
			usingDef = "DEF";
			initUsingDef = "DEF";
		}
	}
	
	public void disableDef()
	{
		this.initUsingDef = this.usingDef;
		this.usingDef = "disabled";
	}

	public long getHP() {
		return HP;
	}

	public long getATK() {
		return ATK;
	}

	public long getDEF() {
		return DEF;
	}

	public long getFIRST_ATTACK() {
		return FIRST_ATTACK;
	}

	public double getCRITICAL_HIT() {
		return CRITICAL_HIT;
	}

	public long getMAGIC() {
		return MAGIC;
	}

	public long getMAGIC_LEVEL() {
		return MAGIC_LEVEL;
	}

	public long getAWAKE_PP() {
		return AWAKE_PP;
	}
	
	public long getAWAKE_LEVEL()
	{
		return AWAKE_LEVEL;
	}
	
	public void setAWAKE_LEVEL(int amount)
	{
		this.AWAKE_LEVEL += amount;
	}
	
	public void initializeAwake()
	{
		this.AWAKE_LEVEL = 0;
	}

	public long getPP() {
		return PP;
	}

	public long getMP() {
		return MP;
	}

	public long getMAX_MP() {
		return MAX_MP;
	}

	public long getFirstHP() {
		return firstHP;
	}

	public long getDefaultDEF() {
		return defaultDEF;
	}

	public long getMPRecover() {
		return MPRecover;
	}

	public String getUsingDef() {
		return usingDef;
	}
	
	public String getName()
	{
		return name;
	}

	public long getInitHP() {
		return initHP;
	}

	public void setInitHP(long initHP) {
		this.initHP = initHP;
	}

	public long getInitATK() {
		return initATK;
	}

	public void setInitATK(long initATK) {
		this.initATK = initATK;
	}

	public long getInitDEF() {
		return initDEF;
	}

	public void setInitDEF(long initDEF) {
		this.initDEF = initDEF;
	}

	public long getInitDefaultDef() {
		return initDefaultDef;
	}

	public void setInitDefaultDef(long initDefaultDef) {
		this.initDefaultDef = initDefaultDef;
	}
}
