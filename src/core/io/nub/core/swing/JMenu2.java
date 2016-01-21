package io.nub.core.swing;

import java.awt.Component;

import javax.swing.JMenu;

/**
 * @author Nektro
 */
public class JMenu2 extends JMenu
{
	private static final long serialVersionUID = 2699291489076819456L;
	
	public JMenu2(String string)
	{
		super(string.toString());
	}
	
	public JMenu2 add(JMenuItem2 item)
	{
		super.add(item);
		return this;
	}
	
	public JMenu2 add(Component c)
	{
		super.add(c);
		return this;
	}
}
