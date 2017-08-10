package project3;
import java.util.StringTokenizer; 
import java.util.ArrayList; 

/**
 * @author Julian
 * @version 1.0
 */
public class StackExpression
{
	
	/**
	 * The String of this Expression.
	 */
	private String exp;
	
	/**
	 * The default constructor of this Expression.
	 */
	public StackExpression(){
		this.exp = null;
	}
	
	/**
	 * The default constructor of this Expression
	 * @param exp
	 */
	public StackExpression(String exp){
		this.exp = exp;
	}
	
	/**
	 * The infix to postfix conversion of this Expression.
	 * @param infixExpression
	 * @return ArrayList<String>
	 * @throws StackException 
	 */
	public ArrayList<String> infixToPostfix(String infixExpression) {
	StringTokenizer token = new StringTokenizer(infixExpression,"-+*/)(", true);
	ArrayList<String> finalPostFix = new ArrayList<String>();
	Stack<String> stack = new Stack<String>();
		while(token.hasMoreTokens()){
			String current = token.nextToken();
			if(!(current.equals("+")||current.equals("-")||current.equals("/")||current.equals("*")||current.equals("(")||current.equals(")")))
			{
				finalPostFix.add(current);
			}
			else if(current.equals("(")){
				stack.push(current);
			}
			else if(current.equals("+")||current.equals("-")||current.equals("*")||current.equals("/"))
			{
				if(stack.isEmpty()){
					stack.push(current);
				}
				else if(!stack.isEmpty() && (current.equals("+") || current.equals("-")))
				{
					while(!stack.isEmpty()&& stack.peek().equals(")")){
						finalPostFix.add(stack.peek());
						stack.pop();
					}
					stack.push(current);
				}
				else if(!stack.isEmpty() && (current.equals("*") || current.equals("/")))
				{
					while(!stack.isEmpty()&& !stack.peek().equals(")") && !stack.peek().equals("+") && !stack.peek().equals("-"))
					{
						finalPostFix.add(stack.peek());
						stack.pop();
					}
				stack.push(current);
				}
				
			}
			else if(current.equals(")"))
			{
				while(!stack.peek().equals("("))
				{
					finalPostFix.add(stack.peek());
					stack.pop();
				}
				stack.pop();
			}
			
		}
		while(!stack.isEmpty())
		{
			finalPostFix.add(stack.peek());
			stack.pop();
		}
		finalPostFix.trimToSize();
		return finalPostFix;
	}
	
	/**
	 * The evaluation of this Expression.
	 * @param postFix
	 * @return
	 * @throws StackException 
	 */
	public static int evaluate(ArrayList<String> postFix)
	{
		Stack<String> stack = new Stack<String>();
		int operand1;
		int operand2;
		int result;
		for(int i = 0; i < postFix.size(); i++){
			if(!(postFix.get(i).equals("+") || postFix.get(i).equals("-") || postFix.get(i).equals("*") || postFix.get(i).equals("/"))){
				stack.push(postFix.get(i));
			}
			else{
					if(postFix.get(i).equals("+")){
					
					operand2 = Integer.parseInt(stack.pop());
					operand1 = Integer.parseInt(stack.pop());
					result = operand1 + operand2;
					stack.push(Integer.toString(result));
				}
					else if(postFix.get(i).equals("-")){
					operand2 = Integer.parseInt(stack.pop());
					operand1 = Integer.parseInt(stack.pop());
					result = operand1 - operand2;
					stack.push(Integer.toString(result));
				}
					else if(postFix.get(i).equals("*")){
					operand2 = Integer.parseInt(stack.pop());
					operand1 = Integer.parseInt(stack.pop());
					result = operand1 * operand2;
					stack.push(Integer.toString(result));
				}
				else if(postFix.get(i).equals("/")){
					operand2 = Integer.parseInt(stack.pop());
					operand1 = Integer.parseInt(stack.pop());
					result = operand1 / operand2;
					stack.push(Integer.toString(result));
				}
			}
			
		}
		return Integer.parseInt(stack.peek());
	}



}