package io.nub.core.swing;

import javax.swing.JMenuBar;

/**
 * @author Nektro
 */
public class JMenuBar2 extends JMenuBar
{
	private static final long serialVersionUID = -8992915060334751109L;
	
	public JMenuBar2 add(JMenu2 menu)
	{
		super.add(menu);
		return this;
	}
}
