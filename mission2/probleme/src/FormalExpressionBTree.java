import java.util.Stack;


public class FormalExpressionBTree implements FormalExpressionTree {

	private Node root;
	private FormalExpressionTree left;
	private FormalExpressionTree right;
	
	public FormalExpressionBTree(String expr, Operator[] operationsList)
	{
		Stack<Object> stack = new Stack<Object>();
		
		// The way to consider negative numbers here is completely independent of the fact
		// that we actually have implemented a subtraction operation.
		while(expr.length() > 0)
		{
			if(Character.isWhitespace(expr.charAt(0)))
			{
				expr = expr.substring(1);
			}
			else if(expr.charAt(0) == '(' && expr.charAt(1) != '-')
			{
				// We needed to check if char 1 was not '-' to ensure we're not on
				// a negative number. Opening parenthesis are omitted in the process
				expr = expr.substring(1);
			}
			else if(expr.charAt(0) == ')')
			{
				// If a closing parenthesis is found, we just pop the subtrees in the stack
				// and create the parent tree. If operator is unary, left tree is null
				expr = expr.substring(1);
				FormalExpressionTree right = (FormalExpressionTree) stack.pop();
				Operator op = (Operator) stack.pop();
				FormalExpressionTree left = op.isUnaryOperator() ? null : (FormalExpressionTree) stack.pop();
				stack.push(new FormalExpressionBTree(op, left, right));
			}
			else if(expr.charAt(0) == 'x')
			{
				expr = expr.substring(1);
				stack.push(new FormalExpressionBTree(new Variable(), null, null));
			}
			else if(Character.isDigit(expr.charAt(0)) || ((expr.charAt(0) == '-' || expr.startsWith("(-")) && (stack.isEmpty() || stack.peek() instanceof Operator)))
			{
				// Negative number is found when start of remaining elements of expression
				// seems to be negative and when the stack is empty or its top element is an
				// operator. This enables parsing negative numbers between parenthesis or not.
				
				// Determines if a parenthesis will have to be removed later
				boolean frontPar = false;
				if(expr.charAt(0) == '(')
				{
					frontPar = true;
					expr = expr.substring(1);
				}
				
				// Determines if number is negative
				int mask = 1; 
				if(expr.charAt(0) == '-')
				{
					mask = -1;
					expr = expr.substring(1);
				}
				
				// Parse the number until it's finished
				int tmp = 0;
				while(expr.length() > 0 && Character.isDigit(expr.charAt(0)))
				{
					tmp = tmp * 10 + mask * Character.getNumericValue(expr.charAt(0));
					expr = expr.substring(1);
				}
				
				// Removes eventual remaining parenthesis
				// We look for it before because if the negative number was a term
				// of an binary operator, it won't have a closing parenthesis at its end
				if(frontPar && expr.length() > 0 && expr.charAt(0) == ')') expr = expr.substring(1);
				
				stack.push(new FormalExpressionBTree(new Scalar(tmp), null, null));
			}
			else
			{
				boolean isOperator = false;
				for(Operator n : operationsList)
				{
					// Checks if we have an operator
					if(expr.startsWith(n.toString()))
					{
						isOperator = true;
						expr = expr.substring(n.toString().length());
						stack.push(n);
					}
				}
				if(!isOperator)
				{
					// If not, parsing failed, the operation was unknown
					System.err.println("Error : Unknown operation");
					System.exit(-1);
				}
			}
		}
		
		// Check if stack meets the parsing post-condition requirements
		// that is, if the only remaining thing in stack is the Formal Expression Tree
		if(stack.size() == 1)
		{
			Object result = stack.pop();
			if(!(result instanceof FormalExpressionTree))
			{
				System.err.println("Parse Error");
				System.exit(-1);
			}
			FormalExpressionTree tree = (FormalExpressionTree) result;
			this.root = tree.getRoot();
			this.left = tree.getLeft();
			this.right = tree.getRight();
		}
		else
		{
			System.err.println("Parse Error");
			System.exit(-1);
		}
	}
	
	public FormalExpressionBTree(Node root, FormalExpressionTree left, FormalExpressionTree right)
	{
		this.root = root;
		this.left = left;
		this.right = right;
	}
	
	@Override
	public FormalExpressionTree derive() {
		return this.root.derive(left, right);
	}

	@Override
	public void setLeft(FormalExpressionTree left) {
		this.left = left;
	}

	@Override
	public void setRight(FormalExpressionTree right) {
		this.right = right;

	}

	@Override
	public FormalExpressionTree getLeft() {
		return left;
	}

	@Override
	public FormalExpressionTree getRight() {
		return right;
	}

	@Override
	public Node getRoot() {
		return root;
	}

	@Override
	public void setRoot(Node n) {
		this.root = n;

	}
	
	@Override
	public String toString() {
		String result;
		if(root instanceof Operator)
		{
			if (((Operator)root).isUnaryOperator())
				// If unary operator, we only need parenthesis around the parameters
				result = root.toString() + "(" + right.toString() + ")";
			else
				// Else we need parenthesis around the whole sub-expression
				result = "(" + left.toString() + root.toString() + right.toString() + ")";
		}
		else
			// If node is a scalar or the variable, print only parenthesis around negative ones.
			result = root.toString().charAt(0) == '-' ? "(" + root.toString() + ")" : root.toString();
		return result;
	}

}
