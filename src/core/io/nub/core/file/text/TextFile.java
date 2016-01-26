package io.nub.core.file.text;

import io.nub.core.Nub;
import io.nub.core.file.File2;
import io.nub.core.lang.String2;

/**
 * A base class for handlers of a file with the MIME type of text/*
 * 
 * @author Nektro
 */
public class TextFile extends File2
{
	private static final long serialVersionUID = 7129237661845686530L;

	public TextFile(String path) {
		super(path);
	}
	
	public TextFile(String2 path) {
		super(path);
	}
	
	public String getValue()
	{
		return Nub.getStringContentC(this);
	}
}
