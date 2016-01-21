package io.nub.core.file;

import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

import io.nub.core.lang.String2;

public class ZipFile extends File2
{
	private static final long serialVersionUID = -448551384141140776L;
	
	private ZipOutputStream zos;
	
	public ZipFile(String path) {
		super(path);
	}
	
	public ZipFile(String2 path) {
		this(path.toString());
	}
	
	public ZipInputStream getZipIS()
	{
		return new ZipInputStream(getInputStream());
	}
	
	public void writeFile(String path, byte[] bytes) throws IOException
	{
		if (zos == null)
			zos = new ZipOutputStream(getOutputStream());
		
		zos.putNextEntry(new ZipEntry(path));
		zos.write(bytes);
		zos.closeEntry();
	}
	
	public void closeZOS() throws IOException
	{
		zos.flush();
		zos.close();
	}
	
	public String getFile(String intpath)
	{
		try {
			String s = "";
			ZipInputStream in = getZipIS();
			ZipEntry ze;
			while ((ze = in.getNextEntry()) != null) {
				if (ze.getName().equals(intpath)) {
					byte[] buf = new byte[1024];
					int len;
					while ((len = in.read(buf)) != -1) {
						String thefile = new String(buf, 0, len);
						s += thefile;
					}
					break;
				}
			}
			in.close();
			return s;
		}
		catch (IOException e) {
			return null;
		}
	}
}
