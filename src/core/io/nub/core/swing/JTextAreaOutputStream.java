package io.nub.core.swing;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import javax.swing.JTextArea;

/**
 * @author Nektro
 */
public class JTextAreaOutputStream extends JTextArea
{
	private static final long serialVersionUID = 6782780904007169321L;
	
	public PrintStream ps;
	
	public JTextAreaOutputStream()
	{
		this.ps = new PrintStream(new TextAreaOutputStream(this));
	}
	
	private class TextAreaOutputStream extends OutputStream
	{
		private final JTextArea jta;
		
		public TextAreaOutputStream(JTextArea jta)
		{
			this.jta = jta;
		}
		
		@Override
		public void write(int b) throws IOException
		{
			this.jta.append(String.valueOf((char)b));
			this.jta.setCaretPosition(this.jta.getDocument().getLength());
		}
	}
}
