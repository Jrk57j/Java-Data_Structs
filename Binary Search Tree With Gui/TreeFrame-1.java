package pro4;

import javax.swing.JFrame;
import javax.swing.JPanel;
/**
 * Represent the Tree Frame for the program.
 * @author Julian Itwaru
 * @version 1.0
 */
public class TreeFrame extends JFrame 
{
	private JFrame frame;
	
	public TreeFrame()
	{
		this.frame = new JFrame();
		this.frame.setTitle("My Binary Tree");
		this.frame.add(new TreeGui(), "Center");
		this.frame.setSize(800,600);
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.frame.setVisible(true);
		this.frame.setResizable(true);
	}
}