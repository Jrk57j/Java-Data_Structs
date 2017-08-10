package project3;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @author Julian
 * @version 1.0
 */
public class CardControl extends JPanel
{
	
private ArrayList<ImageIcon> deck = new ArrayList<>();
	//creates a jbutton for refresh
	private JButton refresh;
	//creates a jbutton for verify
	private JButton verify;
	//creates jlabels for the cards
	private JLabel card1, card2, card3, card4;
	//creates a jlabel to tell the user to enter expression
	private JLabel entExp;
	//jextfield for the user to enter an expression
	private JTextField expression;
	//declared final int for the answer 
	private final int ANSWER = 24;
	
	public CardControl(){
		
		// Set layout
		this.setLayout(new BorderLayout());
		
		// Top panel
		JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.TRAILING));
		this.refresh = new JButton("Refresh");
		this.refresh.addActionListener(new CardListener());
		topPanel.add(this.refresh);
		
		// Middle panel
		// gets the card values
		for(int i = 1; i <= 52; i++){
			this.deck.add(new ImageIcon("card/" + i + ".png"));
		}
		for(int i = 0; i <= 12; i++){
			this.deck.get(i).setDescription( "" + (i + 1));
		}
		for(int i = 13; i <= 25; i++){
			this.deck.get(i).setDescription("" + (i - 12));
		}
		for(int i = 26; i <= 38; i++){
			this.deck.get(i).setDescription("" + (i - 25));
		}
		for(int i = 39; i <= 51; i++){
			this.deck.get(i).setDescription("" + (i - 38));
		}
		this.deck.trimToSize();
		
		JPanel middlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		Collections.shuffle(this.deck);
		// JLabel
		this.card1 = new JLabel(this.deck.get(0));
		this.card2 = new JLabel(this.deck.get(1));
		this.card3 = new JLabel(this.deck.get(2));
		this.card4 = new JLabel(this.deck.get(3));
		middlePanel.add(card1);
		middlePanel.add(card2);
		middlePanel.add(card3);
		middlePanel.add(card4);
		
		// Bottom panel
		JPanel bottomPanel = new JPanel();
		this.expression = new JTextField(20);
		this.verify = new JButton("Verify");
		this.verify.addActionListener(new CardListener());
		this.entExp = new JLabel("Enter an expression: ");
		bottomPanel.add(this.entExp);
		bottomPanel.add(this.expression);
		bottomPanel.add(this.verify);
		this.add(topPanel, BorderLayout.NORTH);
		this.add(middlePanel, BorderLayout.CENTER);
		this.add(bottomPanel, BorderLayout.SOUTH);
		
		
	}

	
	
	private class CardListener implements ActionListener
	{

		public void actionPerformed(ActionEvent e) 
		{
			
			Object source = e.getSource();
			if(source == refresh){
				Collections.shuffle(deck);
				// Update JLabels
				card1.setIcon(deck.get(0));
				card2.setIcon(deck.get(1));
				card3.setIcon(deck.get(2));
				card4.setIcon(deck.get(3));
				
			}else if(source == verify){
				
				String text = expression.getText();
				StringTokenizer operand = new StringTokenizer(text, "+-*/()",false);
				ArrayList<String> postFix;
				ArrayList<String> userOperands = new ArrayList<String>();
				ArrayList<String> cardValues = new ArrayList<String>();
				StackExpression exp = new StackExpression(text);
				postFix = exp.infixToPostfix(text);
				int result = exp.evaluate(postFix);
				
				// Add operands to array
				while(operand.hasMoreTokens()){
					String str = operand.nextToken();
					userOperands.add(str);
				}
				userOperands.trimToSize();
				
				// Add card values to array
				for(int i = 0; i < 4; i++){
					String cardValue = deck.get(i).getDescription();
					cardValues.add(cardValue);
				}
				cardValues.trimToSize();
				
				// Check if all card values exits in operands
				if(userOperands.size() != 4){
					JOptionPane.showMessageDialog(null, "Not enough operands in your expression");
				}
				else if(!(userOperands.containsAll(cardValues))){
					JOptionPane.showMessageDialog(null, "Please, use the card values you are given");
				}
				else {
					if(result != ANSWER){
						JOptionPane.showMessageDialog(null, "Incorrect!");
					}
					else {
						JOptionPane.showMessageDialog(null, "Correct!");
					}
				}
				
			
			}
			
		}
		
	}
}
