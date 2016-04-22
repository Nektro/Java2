package io.nub.core.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import io.nub.core.SysProps;
import io.nub.core.lang.String2;
import io.nub.core.util.arrays.ArrayString;

/**
 * @author Nektro
 */
public class File2 extends File
{
	private static final long serialVersionUID = -1625974972913690006L;
	
	public final String path;
	public final boolean exists;
	public final String extension;
	
	public File2(String path)
	{
		super(path);
		this.path = this.getAbsolutePath();
		this.exists = this.exists();
		this.extension = new ArrayString(path.split("[.]")).reverse().get(0);
	}
	
	public File2(String2 path)
	{
		this(path.toString());
	}
	
	public File2(File file)
	{
		this(file.getAbsolutePath());
	}
	
	/**
	 * If this File2 object denotes a file, and not a directory, then this will return the object
	 * denoting the directory that this file is a child of. Else it will return the parent folder
	 */
	public File2 parentDir()
	{
		String2 p = new String2(this.path);
		p = p.substring(0, p.toString().lastIndexOf(SysProps.file.separator()));
		return new File2(p);
	}
	
	public FileInputStream getInputStream()
	{
		try {
			return new FileInputStream(this);
		}
		catch (Exception e) {
			return null;
		}
	}
	
	public byte[] getAllBytes()
	{
		try {
			return Files.readAllBytes(Paths.get(path));
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public FileOutputStream getOutputStream()
	{
		try {
			return new FileOutputStream(this);
		}
		catch (Exception e) {
			return null;
		}
	}
}
