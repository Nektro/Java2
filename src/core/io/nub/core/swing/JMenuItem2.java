package io.nub.core.swing;

import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

import io.nub.core.lang.String2;

/**
 * @author Nektro
 */
public class JMenuItem2 extends JMenuItem
{
	private static final long serialVersionUID = -3021491341152979432L;

	public JMenuItem2(String2 name)
	{
		super(name.toString());
	}
	
	public JMenuItem2 addEventListener(ActionListener action)
	{
		super.addActionListener(action);
		return this;
	}
}
