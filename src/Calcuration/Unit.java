package Calcuration;

import java.math.*;

public class Unit {
	public long convert(long num)
	{
		Unit u = new Unit();
		return u.parseUnit(u.getUnit(num));
	}
	
	public String getUnit(long num)
	{
		String concated;
		
		double temp;
		
		if(num>=1000000000000L)
		{
			temp = num/100000000000L;
			//temp = num / (getDigit(num) / 100L);
			temp = (double)num / getDigit(num);
			//temp = Math.round(temp);
			concated = getT(temp);
		}
		else if(num>=1000000000L)
		{
			temp = num/100000000L;
			//temp = num / (getDigit(num) / 100L);
			temp = (double)num / getDigit(num);
			//temp = Math.round(temp);
			concated = getG(temp);
		}
		else if(num>=1000000L)
		{
			temp = num/10000L;
			//temp = num / (getDigit(num) / 100L);
			temp = (double)num / getDigit(num);
			//temp = Math.round(temp);
			concated = getM(temp);
		}
		else if(num>=1000L)
		{
			temp = num / 10L;
			//temp = num / (getDigit(num) / 100L);
			temp = (double)num / getDigit(num);
			//temp = Math.round(temp);
			concated = getk(temp);
		}
		else
		{
			concated = Long.toString(num);
		}
				

		return concated;
	}
	
	public Long parseUnit(String str)
	{
		String result;
		Long resultLong;
		
		if(str.endsWith("k"))
		{
			result = deleteUnit(str);
			resultLong = (long)(Double.parseDouble(result) * 1000L);
		}
		else if(str.endsWith("M"))
		{
			result = deleteUnit(str);
			resultLong = (long)(Double.parseDouble(result) * 1000000L);
		}
		else if(str.endsWith("G"))
		{
			result = deleteUnit(str);
			resultLong = (long)(Double.parseDouble(result) * 1000000000L);
		}
		else if(str.endsWith("T"))
		{
			result = deleteUnit(str);
			resultLong = (long)(Double.parseDouble(result) * 1000000000000L);
		}
		else
		{
			resultLong = Long.parseLong(str);
		}

		return resultLong;
	}
	
	private String deleteUnit(String str)
	{
		return (new StringBuilder(str)).deleteCharAt(str.length() - 1).toString();
	}
	
	private Long getDigit(Long num)
	{
		Long i = 0L;
		Long digit = 1L;
		int Zeros = 0;
		
		for(i = 1L; (num/i) >= 10L; i*=10L)
		{
			digit *= 10L;
			Zeros++;
		}
		Zeros++;
		
		if(Zeros%3==0)
		{
			digit = digit / 100L;
		}
		else if(Zeros%2==0)
		{
			digit = digit / 10L;
		}
		
		return digit;
	}
	
	private String getM(double num)
	{
		return String.format("%.2f", num) + "M";
	}
	
	private String getG(double num)
	{
		return String.format("%.2f", num) + "G";
	}
	
	private String getT(double num)
	{
		return String.format("%.2f", num) + "T";
	}
	private String getk(double num)
	{
		return String.format("%.2f", num) + "k";
	}
	
}
