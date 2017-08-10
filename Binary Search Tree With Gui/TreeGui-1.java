package pro4;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
/**
 * Represents a TreeControl Panel.
 * @author Julian Itwaru
 * @version 1.0
 */
public class TreeGui extends JPanel 
{
	
	//The NorthPanel of this TreeControl.
	 private JPanel p1;
	
	 // The SouthPanel of this TreeControl.
	private JPanel p2;
	
	// The Label of this TreeControl.
	 private JLabel key;
	
	 //The TextField of this TreeControl.
	private JTextField keyText;
	
	 // The Search button of this TreeControl.
	private JButton search;
	
	 //The Insert button of this TreeControl.
	private JButton insert;
	
	// The InOrder button of this TreeControl.
	private JButton inorder;
	
	 // The PreOrder button of this TreeControl.
    private JButton preorder;
	
	// The PostOrder button of this TreeControl.
	private JButton postorder;
	
	//Setting up some data for search, insert, etc.
	private TreeIterator<Integer> iterator;
	private Integer keyInput;
	private String redixCheck = "\\d+";
	private ArrayList<Integer> iteratorData = new ArrayList<Integer>();
	private Tree p = new Tree();
	private int counter = 0;
	
	
		/**
		 * The default constructor for this TreeControl.
		 */
		public TreeGui()
		{	
		//Setting up the layout for the main panel
		this.setLayout(new BorderLayout());
		ButtonListener listener = new ButtonListener(this);
		//Sets up the North Panel
		this.p1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		p1.add(p); //new PaintPanel
		//Sets up the South Panel
		this.p2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		this.key = new JLabel("Enter a key:");
		this.keyText = new JTextField(5);
		this.search = new JButton("Search");
		this.insert = new JButton("Insert");
		this.inorder = new JButton("InOrder");
		this.preorder = new JButton("PreOrder");
		this.postorder = new JButton("PostOrder");
		p2.add(key);
		p2.add(keyText);
		p2.add(search);
		this.search.addActionListener(listener);
		p2.add(insert);
		this.insert.addActionListener(listener);
		p2.add(inorder);
		this.inorder.addActionListener(listener);
		p2.add(preorder);
		this.preorder.addActionListener(listener);
		p2.add(postorder);
		this.postorder.addActionListener(listener);
		
		//Adds the panels into the main panels
		this.add(p1, BorderLayout.CENTER);
		this.add(p2, BorderLayout.SOUTH);
	}
		
		public class ButtonListener implements ActionListener 
		{
			/**
			 * The actionPanel of this ButtonActionListener.
			 */
			private JPanel actionPanel;
			/**
			 * The default constructor for ButtonActionListener.
			 * @param actionPanel A reference to the actionPanel of this ButtonActionListener.
			 */
			public ButtonListener(JPanel actionPanel){
				this.actionPanel = actionPanel;
			}
			
			/**
			 * Sets up the listeners for Search, Insert, InOrder, PreOrder, and PostOrder.
			 */
			public void actionPerformed(ActionEvent e){
				if(e.getSource() == ((TreeGui)actionPanel).getSearch()){
					((TreeGui)this.actionPanel).Search();
				}
				else if(e.getSource() == ((TreeGui)actionPanel).getInsert()){
					((TreeGui)this.actionPanel).Insert();
				}	
				else if(e.getSource() ==((TreeGui)actionPanel).getInOrder()){
					((TreeGui)this.actionPanel).InOrder();
				}
				else if(e.getSource() ==((TreeGui)actionPanel).getPreOrder()){
					((TreeGui)this.actionPanel).PreOrder();
				}
				else if(e.getSource() ==((TreeGui)actionPanel).getPostOrder()){
					((TreeGui)this.actionPanel).PostOrder();
				}
		}
}
	
	/**
	 * Returns the Search button of this TreeControl
	 * @return A reference to the Search button of this TreeControl
	 */
	public JButton getSearch()
	{
		return this.search;
	}
	
	/**
	 * Returns the Insert button of this TreeControl
	 * @return A reference to the Insert button of this TreeControl
	 */
	public JButton getInsert()
	{
		return this.insert;
	}
	
	/**
	 * Returns the InOrder button of this TreeControl
	 * @return A reference to the InOrder button of this TreeControl
	 */
	public JButton getInOrder()
	{
		return this.inorder;
	}
	
	/**
	 * Returns the PreOrder button of this TreeControl
	 * @return A reference to the PreOrder button of this TreeControl
	 */
	public JButton getPreOrder()
	{
		return this.preorder;
	}
	
	/**
	 * Returns the PostOrder button of this TreeControl
	 * @return A reference to the PostOrder button of this TreeControl
	 */
	public JButton getPostOrder()
	{
		return this.postorder;
	}
	
	/**
	 * Searches the BinaryTree for an input value 
	 */
	public void Search()
	{
		boolean data;
		ArrayList<Integer> searchPath = new ArrayList<Integer>();
		String redixSearchCheck = keyText.getText();
		
		if(counter == 1){
			counter--;
			p.repaint();
			JOptionPane.showMessageDialog(null,"Tree has been formated, please enter a value again and search for it");
			
		}
		else{
		if(!redixSearchCheck.matches(redixCheck)){
			p.repaint(); 
			JOptionPane.showMessageDialog(null, "Enter a new number not a char/string");
		}
		else{
		keyInput = Integer.parseInt(keyText.getText());
		data = p.getTree().search(keyInput);
		if(data == true){
			p.getTree().searchPath(keyInput,searchPath, p.getTree().root);
			p.search(p.getGraphics(),p.getTree().root,searchPath, 400, 0, 200);
			Tree.insert(p.getGraphics(), p.getTree().root, 400, 0, 200);
			counter++;
		}
		else if(data != true){
			p.repaint();
			JOptionPane.showMessageDialog(null,"Number not found");
		}
		searchPath.clear();
		}
		}

	}
	
	/**
	 * Inserts the input value in the tree.
	 */
	public void Insert()
	{
		if(counter == 1)
		{
		counter--;
		p.repaint();
		String Check = keyText.getText();
		 if(!Check.matches(redixCheck))
		 {
			 JOptionPane.showMessageDialog(null, "Enter a number not a char/string");
		 }
		 else{
		 keyInput = Integer.parseInt(keyText.getText());
		 p.getTree().insert(keyInput,p.getTree());
		 Tree.insert(p.getGraphics(), p.getTree().root, 400, 0, 200);
		 }
		}
		else{
			p.repaint();
			String Check = keyText.getText();
			 if(!Check.matches(redixCheck))
			 {
				 JOptionPane.showMessageDialog(null, "Enter a number not a char/string");
			 }
			 else{
			 keyInput = Integer.parseInt(keyText.getText());
			 p.getTree().insert(keyInput,p.getTree());
			 Tree.insert(p.getGraphics(), p.getTree().root, 400, 0, 200);
			 }
		}
	}
	
	/**
	 * Sorts the BinaryTree values in InOrder
	 */
	public void InOrder()
	{
		iterator = new TreeIterator<Integer>(p.getTree());
		iterator.setInorder();
		while(iterator.hasNext())
		{
			iteratorData.add(iterator.next());		
		}
		Arrays.toString(iteratorData.toArray());
		JOptionPane.showMessageDialog(null,"Inorder: " + iteratorData);
		iteratorData.clear();
	}
	
	/**
	 * Sorts the BinaryTree values in PreOrder
	 */
	public void PreOrder()
	{
		iterator = new TreeIterator<Integer>(p.getTree());
		iterator.setPreorder();
		while(iterator.hasNext())
		{
			iteratorData.add(iterator.next());		
		}
		Arrays.toString(iteratorData.toArray());
		JOptionPane.showMessageDialog(null,"Inorder: " + iteratorData);
		iteratorData.clear();
	}
	
	/**
	 * Sorts the BinaryTree values in PostOrder
	 */
	public void PostOrder()
	{
		iterator = new TreeIterator<Integer>(p.getTree());
		iterator.setPostorder();
		while(iterator.hasNext()){
			iteratorData.add(iterator.next());		
		}
		Arrays.toString(iteratorData.toArray());
		JOptionPane.showMessageDialog(null,"Inorder: " + iteratorData);
		iteratorData.clear();
	}
	
}