package classicProblems;

import java.util.Stack;

public class ReversePolishNotation {

	private Stack<String> stack;
	private String operators;

	public ReversePolishNotation() {
		// TODO Auto-generated constructor stub
		stack = new Stack<String>();
		operators = "-+*/";
	}

	public int evalRPN(String[] notation) {
		int result = 0;
		for (String token : notation) {
			if (!operators.contains(token))
				stack.push(token);
			else {
				int a = Integer.parseInt(stack.pop());
				int b = Integer.parseInt(stack.pop());
				switch (token) {
				case "+":
					stack.push(String.valueOf(a+b));
					break;
				case "-":
					stack.push(String.valueOf(b-a));
					break;
				case "/":
					stack.push(String.valueOf(b/a));
					break;
				case "*":
					stack.push(String.valueOf(a*b));
					break;
				}
			}
		}
		result = Integer.parseInt(stack.pop());
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReversePolishNotation rPN = new ReversePolishNotation();
		String[] notation = new String[] { "2", "1", "+", "3", "*" };
		System.out.println(rPN.evalRPN(notation));

	}

}
