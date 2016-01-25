package io.nub.core.file.text;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import io.nub.core.lang.String2;
import io.nub.core.util.Logger2;

/**
 * @author Nektro
 */
public class TxtFile extends TextFile
{
	private static final long serialVersionUID = 1318103255239757321L;

	public TxtFile(String path) {
		super(path);
	}
	
	public TxtFile(String2 path) {
		this(path.toString());
	}
	
	/**
	 * Writes text to this file.
	 * 
	 * @param content String to write to this file
	 * @param startFromTop defers whether or not this text should be appended or overwritten
	 */
	public void write(String content, boolean startFromTop)
	{
		try
		{
			BufferedWriter bw = new BufferedWriter(new FileWriter(this.path, !startFromTop));
			bw.write(content.toString());
			bw.flush();
			bw.close();
		}
		catch (IOException e) {
			Logger2.getLogger().error(e);
		}
	}
	
	/**
	 * Write text to a file
	 * 
	 * @param content a String to write
	 * @param overwrite start fresh?
	 */
	public void writeln(String content, boolean startFromTop)
	{
		write(content + "\n", startFromTop);
	}
}
