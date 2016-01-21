package io.nub.core.swing;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import io.nub.core.Java2;
import io.nub.core.lang.String2;
import io.nub.core.util.Logger2;

/**
 * A replacement JFrame with extra methods.
 * 
 * @author Nektro
 */
public class JFrame2 extends JFrame
{
	private static final long serialVersionUID = 7032019736359405468L;
	
	public JFrame2()
	{
		this(new String2());
	}
	
	public JFrame2(String2 title)
	{
		this(title, EXIT_ON_CLOSE);
	}
	
	public JFrame2(String2 title, int closeOp)
	{
		super();
		this.setDefaultCloseOperation(closeOp);
		this.setTitle(title.toString());
		
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
			Logger2.getLogger().error(e);
		}
	}
	
	/**
	 * Set the current window to be maximized
	 * @return this
	 */
	public JFrame2 setMaximized()
	{
		this.setExtendedState(this.getExtendedState() | JFrame.MAXIMIZED_BOTH);
		return this;
	}
	
	/**
	 * Set the takbar icon of this frame based on a path
	 * @param abspath
	 * @return this
	 */
	public JFrame2 setIconImage(String2 abspath)
	{
		this.setIconImage(Java2.newImage(abspath));
		return this;
	}
	
	public JFrame2 addJMenuBar(JMenuBar2 menuBar)
	{
		this.setJMenuBar(menuBar);
		return this;
	}
}
