package Calcuration;

import java.io.*;
import java.math.*;
import java.security.*;

public class MD5 {
	public String getMD5(String str)
	{
		try
		{
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(str.getBytes("UTF-8"));
			
			byte[] raw = md.digest();
			
		    final StringBuilder hex = new StringBuilder( 2 * raw.length );
		    for ( final byte b : raw ) {
		      hex.append(String.format("%02x", b & 0xff));
		    }
		    
			return hex.toString();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
}
