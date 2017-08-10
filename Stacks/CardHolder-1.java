package project3;
import javax.swing.JFrame;

/**
 * @author Julian
 * @version 1.0
 */
public class CardHolder extends JFrame
{

	private JFrame cardHolder;
	
	public CardHolder() 
	{
		this.cardHolder = new JFrame();
		this.cardHolder.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.cardHolder.add(new CardControl(), "Center");
		this.cardHolder.setTitle("24 point card game");
		this.cardHolder.setSize(500,400);
		this.cardHolder.setVisible(true);
		
	}
	
}
