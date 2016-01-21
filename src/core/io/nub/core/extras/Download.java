package io.nub.core.extras;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import io.nub.core.file.File2;
import io.nub.core.util.Logger2;
import io.nub.core.util.Math2;

/**
 * @author Nektro
 */
public class Download
{
	private static void write(HttpURLConnection con, InputStream is, OutputStream os, boolean debug) throws IOException
	{
		int length = -1;
		byte[] buffer = new byte[1024];
		long bytesProgress = 0;
		long bytesTotal = con.getContentLengthLong();
		long start = System.currentTimeMillis();
		Looper l = new Looper(0, 2, 0, 1000);
		int lv = -1;
		l.running = true;
		while ((length = is.read(buffer,0,buffer.length)) != -1) {
			os.write(buffer, 0, length);
			bytesProgress += length;
			if (debug) {
				l.update();
				if (lv != l.val()) {
					Logger2.getLogger().info("Progress: " + Math2.round(((double)bytesProgress / (double)bytesTotal) * (100.0), 3) +  "%");
				}
				lv = l.val();
			}
        }
		long end = System.currentTimeMillis();
		long duration = end - start;
		if (debug) Logger2.getLogger().info("Download complete with " + bytesProgress + " bytes read in " + duration + " time");
	}
	
	private static boolean get(HttpURLConnection con, File2 saveAs, boolean debug) throws IOException
	{
		InputStream in = con.getInputStream();
		FileOutputStream fout = saveAs.getOutputStream();
		if (!saveAs.exists()) saveAs.createNewFile();
		write(con, in, fout, debug);
		in.close();
		fout.close();
		con.disconnect();
		return true;
	}
	
	public static boolean as(URL url, File2 saveAs, boolean notify, boolean debugOut)
	{
		if (notify) Logger2.getLogger().info("Downloading " + url.toString());
		if (debugOut) Logger2.getLogger().info("Saving as " + saveAs.path);
		try
		{
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			int response = con.getResponseCode();
			if (response == 200)
			{
				return get(con, saveAs, debugOut);
			}
			else {
				Logger2.getLogger().error("Connection denied with response code " + response);
				return false;
			}
		}
		catch (IOException e) {
			Logger2.getLogger().error(e);
			return false;
		}
	}
	
	public static boolean to(URL url, File2 saveDir, String fileName, boolean notify, boolean debugOut)
	{
		if (saveDir.isDirectory())
		{
			File2 saveAs = new File2(saveDir.getAbsolutePath() + "\\" + fileName);
			return as(url, saveAs, notify, debugOut);
		}
		else {
			Logger2.getLogger().error(saveDir.path + " is not a directory.");
			return false;
		}
	}
	
	public static boolean to(URL url, File2 saveDir, boolean notify, boolean debugOut)
	{
		String fileName = url.getFile().substring(url.getFile().lastIndexOf('/')+1, url.getFile().length());
		return to(url, saveDir, fileName, notify, debugOut);
	}
}
