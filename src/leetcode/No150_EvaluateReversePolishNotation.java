package leetcode;

import java.util.Stack;

/**
 * Leetcode No150
 * @author Huanzhou
 * AC time:2015/3/11 3:10 
 * PS:面试后，春假的第一题，stack,equals和Integer.parseInt()的应用
 */
public class No150_EvaluateReversePolishNotation {

	public static int evalRPN(String[] tokens) {
		Stack<Integer> s = new Stack<Integer>();

		for (int i = 0; i < tokens.length; i++) {
			if ( ! (tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("*") ||  tokens[i].equals("/")) )  {
				s.push(Integer.parseInt(tokens[i]));
			} else {
				int a = s.pop();
				int b = s.pop();
				int c = 0;
				switch (tokens[i].charAt(0)) {
				case '+':
					c = b + a;
					break;
				case '-':
					c = b - a;
					break;
				case '*':
					c = b * a;
					break;
				case '/':
					c = b / a;
					break;
				default:
					break;
				}
				s.push(c);
			}
		}
		return s.pop();
	}

	

	public static void main(String[] args) {

		String[] str = { "-78","-33","196","+","-19","-","115","+","-","-99","/","-18","8","*","-86","-","-","16","/","26","-14","-","-","47","-","101","-","163","*","143","-","0","-","171","+","120","*","-60","+","156","/","173","/","-24","11","+","21","/","*","44","*","180","70","-40","-","*","86","132","-84","+","*","-","38","/","/","21","28","/","+","83","/","-31","156","-","+","28","/","95","-","120","+","8","*","90","-","-94","*","-73","/","-62","/","93","*","196","-","-59","+","187","-","143","/","-79","-89","+","-"};
		String[] str1 = { "4","-2","/","2","-3","-","-"};
		String[] str2 = { "3", "-4", "+" };
		
		System.out.println(evalRPN(str));
	}

}

/*
	逆波兰式的应用
	["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
  	["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
  	
  	题目大意，给你一个字符串数组，让你得出它的逆波兰式运算的结果
  	
  	波兰记法中，操作符置于操作数的后面。例如表达“三加四”时，写作“3 4 +”，而不是“3 + 4”。
  	如果有多个操作符，操作符置于第二个操作数的后面，所以常规中缀记法的“3 - 4 + 5”在逆波兰记法中写作“3 4 - 5 +”：先3减去4，再加上5。
  	使用逆波兰记法的一个好处是不需要使用括号。例如中缀记法中“3 - 4 * 5”与“（3 - 4）*5”不相同，但后缀记法中前者写做“3 4 5 * -”，无歧义地表示“3 (4 5 *) −”；后者写做“3 4 - 5 *”。
	逆波兰表达式的解释器一般是基于堆栈的。解释过程一般是：操作数入栈；遇到操作符时，操作数出栈，求值，将结果入栈；当一遍后，栈顶就是表达式的值。
	因此逆波兰表达式的求值使用堆栈结构很容易实现，和能很快求值。
 
 
 	其实就是一个堆栈的结构，首先按顺序入栈，当遍历到加减乘除时，把栈的前两个元素pop出来，按照相应的那个符号进行运算
 	要注意的是那两个元素的运算顺序是有讲究的，比如说栈里面 [2,1] pop的顺序是1,2 (2在栈底) 这时遇到了符号/ 应该是2/1而不是1/2
 	
 	还有一个问题是符号的判断，一开始我是用tokens[0].charAt(0) == '+' 这种方法来判断的。 这种方法的问题在于，当有负数时，
 	它的tokens[0].charAt(0) 也是 "-"，所以要进行一些逻辑的构造，还挺复杂的。
 	这时有个非常好的解决办法，即用.equals， 直接tokens[0].equals("+") 注意是双引号。 这样直接就可以判断而且不用去考虑负数的情况了。
 	
	另外，java自己有自带的String转int的方法，即Integer.parseInt()
	
	
 	hhz
 	2015/3/11 3:30 
 
 
 
*/
