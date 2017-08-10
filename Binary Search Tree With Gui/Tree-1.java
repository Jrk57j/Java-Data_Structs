package pro4;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JComponent;
/**
 * The paintPanel for the frame
 * @author Julian Itwaru
 * @version 1.0
 */
public class Tree extends JComponent
{
	/**
	 * The binaryTree of this PaintPanel
	 */
	private BinarySearchTree<Integer> tree = new BinarySearchTree(50);
	/**
	 * The index of this paintPanel
	 */
	private int counter = 0;

	/**
	 * The default constructor for PaintPanel, sets up the size of the panel.
	 */
	public Tree()
	{
		setPreferredSize(new Dimension(800, 350));
	}
	/**
	 * The paintComponent of this PaintPanel.
	 */
	public void paintComponent(Graphics paint){
		super.paintComponent(paint);
		if(tree.getRootData() != null){
			insert(paint, tree.root, 400, 0, 200);
		}
		
	}
	
	/**
	 * Draws the binaryTree on the panel.
	 */
	public static void insert(Graphics paint, TreeNode<Integer> node, int x, int y, int gap){
		String Data = node.getData().toString();
		paint.drawOval(x,y,45,45);
		paint.drawString(Data, x + 12, y + 32);
		if(node.getLeftChild() != null){
			paint.drawLine(x, y + 25, x - gap + 25, y + 100);
			insert(paint, node.getLeftChild(), x - gap, y + 100, gap/2);
		}
		if(node.getRightChild() != null){
			paint.drawLine(x + 45, y + 25, (x + (gap)) + 25, y + 100);
			insert(paint, node.getRightChild(), x + gap, y + 100, gap/2);
		}
	}
	
	/**
	 * Draws the highlighted path of the specified value on the binaryTree
	 */
	public void search(Graphics paint, TreeNode<Integer> node, ArrayList<Integer> holder, int x, int y, int gap)
	{
		if(node.getData() == holder.get(counter)){
			paint.setColor(Color.GREEN);
			paint.fillOval(x,y, 45, 45);
		}
		if(counter + 1 < holder.size()){
			if(holder.get(counter) >= holder.get(counter + 1) && node.getLeftChild() != null){
				paint.setColor(Color.GREEN);
				paint.fillOval(x,y,45,45);
				counter++;
				search(paint, node.getLeftChild(), holder, x - gap, y + 100, gap/2);
			}
			else if(holder.get(counter) < holder.get(counter + 1) && node.getRightChild() != null){
				paint.setColor(Color.GREEN);
				paint.fillOval(x,y,45,45);
				counter++;
				search(paint, node.getRightChild(), holder, x + gap, y + 100, gap/2);
			}
		}
		counter = 0;
		
	}
	
	/**
	 * Returns the binaryTree of this PaintPanel.
	 * @return Returns a binaryTree of this class.
	 */
	public BinarySearchTree<Integer> getTree()
	{
		return this.tree;
	}
 
	


}