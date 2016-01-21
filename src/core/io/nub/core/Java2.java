package io.nub.core;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.imageio.ImageIO;

import io.nub.core.file.File2;
import io.nub.core.lang.String2;
import io.nub.core.util.Logger2;

public class Java2
{
	/**
	 * A static class that is navigable through the JavaDoc code assist. All of the values are based
	 * on their representations in the String value of System.getProperty().<br><br>
	 * System.getProperty("sun.arch.data.model") == Java2.SysProps.sun.arch.data.model()<br>
	 * 
	 * @author Nektro
	 */
	public static class SysProps
	{
		public static class java {
			public static String version() { return System.getProperty("java.version"); }
			public static String home() { return System.getProperty("java.home"); }
			public static String vendor() { return System.getProperty("java.vendor"); }
			public static class runtime {
				public static String name() { return System.getProperty("java.runtime.name"); }
				public static String version() { return System.getProperty("java.runtime.version"); }
			}
			public static class vm {
				public static String version() { return System.getProperty("java.vm.version"); }
				public static String vendor() { return System.getProperty("java.vm.vendor"); }
				public static String name() { return System.getProperty("java.vm.name"); }
				public static String specification() { return System.getProperty("java.vm.specification"); }
				public static String info() { return System.getProperty("java.vm.info"); }
				public static class specification {
					public static String vendor() { return System.getProperty("java.vm.specification.vendor"); }
					public static String version() { return System.getProperty("java.vm.specification.version"); }
				}
			}
			public static class vendor {
				public static String url() { return System.getProperty("java.vendor.url"); }
				
				public static class url {
					public static String bug() { return System.getProperty("java.vendor.url.bug"); }
				}
			}
			public static class awt {
				public static String graphicsenv() { return System.getProperty("java.awt.graphicsenv"); }
				public static String printerjob() { return System.getProperty("java.awt.printerjob"); }
			}
			public static class endorsed {
				public static String dirs() { return System.getProperty("java.endorsed.dirs"); }
			}
			public static class io {
				public static String tmpdir() { return System.getProperty("java.io.tmpdir"); }
			}
			public static class library {
				public static String path() { return System.getProperty("java.library.path"); }
			}
			public static class specification {
				public static String name() { return System.getProperty("java.specification.name"); }
				public static String version() { return System.getProperty("java.specification.version"); }
				public static String vendor() { return System.getProperty("java.specification.vendor"); }
			}
			public static class classs {
				public static String version() { return System.getProperty("java.class.version"); }
				public static String path() { return System.getProperty("java.class.path"); }
			}
			public static class ext {
				public static String dirs() { return System.getProperty("java.ext.dirs"); }
			}
		}
		public static class os {
			public static String name() { return System.getProperty("os.name"); }
			public static String arch() { return System.getProperty("os.arch"); }
			public static String version() { return System.getProperty("os.version"); }
		}
		public static class sun {
			public static class arch {
				public static class data {
					public static String model() { return System.getProperty("sun.arch.data.model"); }
				}
			}
			public static class boot {
				public static class library {
					public static String path() { return System.getProperty("sun.boot.library.path"); }
				}
				public static class classs {
					public static String path() { return System.getProperty("sun.boot.class.path"); }
				}
			}
			public static class java {
				public static String launcher() { return System.getProperty("sun.java.launcher"); }
				public static String command() { return System.getProperty("sun.java.command"); }
			}
			public static class os {
				public static class patch {
					public static String level() { return System.getProperty("sun.os.patch.level"); }
				}
			}
			public static class jnu {
				public static String encoding() { return System.getProperty("sun.jnu.encoding"); }
			}
			public static class management {
				public static String compiler() { return System.getProperty("sun.management.compiler"); }
			}
			public static class cpu {
				public static String endian() { return System.getProperty("sun.cpu.endian"); }
				public static String isalist() { return System.getProperty("sun.cpu.isalist"); }
			}
			public static class io {
				public static class unicode {
					public static String encoding() { return System.getProperty("sun.io.unicode.encoding"); }
				}
			}
			public static String desktop() { return System.getProperty("sun.desktop"); }
		}
		public static class user {
			public static String script() { return System.getProperty("user.script"); }
			public static String country() { return System.getProperty("user.country"); }
			public static String dir() { return System.getProperty("user.dir"); }
			public static String variant() { return System.getProperty("user.varient"); }
			public static String home() { return System.getProperty("user.home"); }
			public static String timezone() { return System.getProperty("user.timezone"); }
			public static String name() { return System.getProperty("user.name"); }
			public static String language() { return System.getProperty("user.language"); }
		}
		public static class path {
			public static String separator() { return System.getProperty("path.separator"); }
		}
		public static class file {
			public static String encoding() { return System.getProperty("file.encoding"); }
			public static String separator() { return System.getProperty("file.separator"); }
			public static class encoding {
				public static String pkg() { return System.getProperty("file.encoding.pkg"); }
			}
		}
		public static class line {
			public static String separator() { return System.getProperty("line.separator"); }
		}
		public static class awt {
			public static String toolkit() { return System.getProperty("awt.toolkit"); }
		}
		public static class java2 {
			public static final float version = 1.0F;
			public static final String author = "Nektro";
		}
	}
	
	/**
	 * Return a new {@code java.util.List} of any type by saying List list = Java2.newList();
	 * 
	 * @return a new List
	 */
	public static <T> List<T> newList()
    {    	
        return new ArrayList<T>();
    }
	
	/**
	 * Fills a List with an array of items.
	 * 
	 * @param list an existing List
	 * @param o the array of items
	 * @return a full array
	 */
	@SuppressWarnings("unchecked")
	public static <T> List<T> newList(List<T> list, T... o) 
    {
		for (T p : o)
			list.add(p);
        return list;
    }
	
	/**
	 * 
	 * @return whether or not the host machine has x64 processing
	 */
	public static boolean is64Bit()
	{
		return Java2.SysProps.sun.arch.data.model().equals("64");
	}
	
	/**
	 * 
	 * @return the height of the screen in pixels
	 */
	public static int getScreenHeight()
	{
		return Toolkit.getDefaultToolkit().getScreenSize().height;
	}
	
	/**
	 * 
	 * @return the width of the screen in pixels
	 */
	public static int getScreenWidth()
	{
		return Toolkit.getDefaultToolkit().getScreenSize().width;
	}
	
	/**
	 * 
	 * @param path the path to the image
	 * @return a new {@link java.awt.Image} from a path
	 */
	public static Image newImage(String2 path)
	{
		return Toolkit.getDefaultToolkit().getImage(path.toString());
	}
	
	/**
	 * 
	 * @param path the path to the image
	 * @return a new {@link java.awt.image.BufferedImage}
	 */
	public static BufferedImage newBufferedImage(String2 path)
	{
		try {
			return ImageIO.read(new File2(path));
		}
		catch (IOException e) {
			Logger2.getLogger().error(e);
		}
		return null;
	}
	
	/**
	 * Returns the message digest of a String in multiple algorithms. Acceptable algorithm names are
	 * MD5, SHA-1, and SHA-256.
	 * 
	 * @param algorithm a cryptographic hash function
	 * @param input a String to be hashed
	 * @return hashed output
	 */
	public static String2 hash(String algorithm, String2 input)
	{
		switch (algorithm) {
			case "MD5":
			case "SHA-1":
			case "SHA-256":
			try {
				MessageDigest md = MessageDigest.getInstance(algorithm);
				byte[] bytes = md.digest(input.toString().getBytes());
				StringBuffer sb = new StringBuffer();
				for (int i = 0; i < bytes.length; i++) {
					sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
				}
				return new String2(sb.toString());
			}
			catch (NoSuchAlgorithmException e) {
				return new String2();
			}
			default:
				return new String2();
		}
	}
	
	/**
	 * Retrieves a {@code java.io.File} from {@code path} relative to the current working directory.
	 * @param path
	 * @return
	 */
	public static File2 getResource(String path)
	{
		return new File2(Class.class.getClass().getResource(path).getPath());
	}
	
	/**
	 * Reads the entire contents of a given text file and returns it as a {@code String2}.
	 * @param file the text file
	 * @return the text contents
	 * @throws FileNotFoundException
	 */
	public static String2 getStringContent(File2 file) throws FileNotFoundException 
	{
		Scanner scan = new Scanner(new FileInputStream(file));
		String s = "";
		while (scan.hasNextLine())
		{
			s += scan.nextLine();
			if (scan.hasNextLine()) { s += "\n"; }
		}
		scan.close();
		return new String2(s);
	}
	
	/**
	 * A safe version of getStringContent() for use if you are sure the file exists.
	 * 
	 * @param file the text file
	 * @return the text contents
	 */
	public static String2 getStringContentC(File2 file)
	{
		try {
			return Java2.getStringContent(file);
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * Return a substring of an array beginning at <i>start</i> and ending at <i>end</i> inclusive.
	 * @param array a source array
	 * @param start the beginning index
	 * @param end the ending index
	 * @return the elements from start to end
	 */
	public static Object[] getArrayEles(Object[] array, int start, int end)
	{
		Object[] r = new Object[end - start + 1];
		System.arraycopy(array, start, r, 0, end - start + 1);
		return r;
	}
	
	/**
	 * Read all the String content available in this InputStream. 
	 * 
	 * @param inputStream
	 * @return
	 */
	public static String readAllContent(InputStream is) {
		Scanner scan = new Scanner(is);
		String result = "";
		
		while (scan.hasNextLine()) {
			result += scan.nextLine() + "\n";
		}
		
		scan.close();
		return result;
	}
}
