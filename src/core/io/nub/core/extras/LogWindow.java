package io.nub.core.extras;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

import io.nub.core.swing.JFrame2;
import io.nub.core.swing.JTextAreaOutputStream;

/**
 * @author Nektro
 */
public class LogWindow
{
	private JFrame2 frame;
	private JScrollPane scrollp;
	private JTextAreaOutputStream taos;
	
	public LogWindow(int width, int height)
	{
		this.frame = new JFrame2();
		this.scrollp = new JScrollPane();
		this.taos = new JTextAreaOutputStream();
		
		this.frame.setSize(width, height);
		this.frame.setLocation(0, 0);
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.scrollp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		this.scrollp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		this.taos.setLineWrap(false);
		this.taos.setEditable(false);
		
		this.scrollp.setViewportView(taos);
		this.frame.add(scrollp);
	}
	
	public void activate()
	{
		this.frame.setVisible(true);
		System.setOut(this.taos.ps);
		System.setErr(this.taos.ps);
	}
}
