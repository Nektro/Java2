package io.nub.core.util;

import java.util.Arrays;
import java.util.Date;

import io.nub.core.lang.String2;

/**
 * @author Nektro
 */
public class Logger2
{
	private final String name;
	
	private Logger2(String name) { this.name = name; }
	private Logger2()            { this(null);       }
	
	public static Logger2 getLogger()            { return new Logger2();     }
	public static Logger2 getLogger(String name) { return new Logger2(name); }
	
	public void info(Object msg)   { log("INFO", new String2(msg)); }
	public void error(Object msg)  { log("EROR", new String2(msg)); }
	public void warn(Object msg)   { log("WARN", new String2(msg)); }
	public void error(Exception e) { log("EROR", new String2(e.getClass().getName()).concat(" @ ").concat(e.getStackTrace()[0].toString())); }
	public void error(int[] e)     { log("EROR", new String2(Arrays.toString(e))); }
	public void error(Object[] e)  { log("EROR", new String2(Arrays.toString(e))); }
	
	private void log(String level, String2 msg)
	{
		String out = "[" + getTime() + "][" + getThread() + "][" + level +  "]" + getName() + ": " + msg;
		switch (level) {
			case "INFO":
			case "WARN":
				System.out.println(out);
				break;
			case "EROR":
				System.err.println(out);
				break;
		}
	}
	
	private String getTime()
	{
		return new Date().toString().split(" ")[3];
	}
	
	private String getThread()
	{
		return Thread.currentThread().getName();
	}
	
	private String getName()
	{
		return this.name == null ? "" : "[" + name + "]";
	}
}
