package io.nub.core;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import io.nub.core.file.File2;
import io.nub.core.lang.String2;
import io.nub.core.util.ArrayString;
import io.nub.core.util.Logger2;

/**
 * @author Nektro
 */
public class Nub
{
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
		return SysProps.sun.arch.data.model().equals("64");
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
	 * @throws IOException 
	 */
	public static String getStringContent(File file) throws IOException 
	{
		/*
		Scanner scan = new Scanner(new FileInputStream(file));
		String s = "";
		while (scan.hasNextLine())
		{
			s += scan.nextLine();
			if (scan.hasNextLine()) { s += "\n"; }
		}
		scan.close();
		return (s);
		*/
		String s = "";
		BufferedReader br = new BufferedReader(new FileReader(file));
		while (br.ready())
			s += br.readLine() + "\n";
		br.close();
		return s;
	}
	
	/**
	 * A safe version of getStringContent() for use if you are sure the file exists.
	 * 
	 * @param file the text file
	 * @return the text contents
	 */
	public static String getStringContentC(File file)
	{
		try {
			return Nub.getStringContent(file);
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
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
		return new ArrayString(new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8"))).lines().toArray()).join("\n");
	}
}
