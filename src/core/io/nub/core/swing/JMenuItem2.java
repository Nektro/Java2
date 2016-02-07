package io.nub.core.swing;

import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

/**
 * @author Nektro
 */
public class JMenuItem2 extends JMenuItem
{
	private static final long serialVersionUID = -3021491341152979432L;

	public JMenuItem2(String string)
	{
		super(string.toString());
	}
	
	public JMenuItem2 addEventListener(ActionListener action)
	{
		super.addActionListener(action);
		return this;
	}
}
