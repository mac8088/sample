package net.atos.sample.leetcode;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.lang.Character;

public class LC0020 {

//	使用栈，遍历输入字符串
//
//	如果当前字符为左半边括号时，则将其压入栈中
//
//	如果遇到右半边括号时，分类讨论：
//
//	1）如栈不为空且为对应的左半边括号，则取出栈顶元素，继续循环
//
//	2）若此时栈为空，则直接返回 false
//
//	3）若不为对应的左半边括号，反之返回 false
	static class Solution {

		// mine
		public boolean isValid2(String s) {
			boolean valid = true;
			Stack<Character> sk = new Stack<Character>();
			final Map<Character, Character> map = new HashMap<>();
			map.put('{', '}');
			map.put('[', ']');
			map.put('(', ')');
			final Collection<?> collection = map.values();
			char c;
			for (int i = 0; i < s.length(); i++) {
				c = s.charAt(i);
				if (map.containsKey(c)) {
					sk.push(c);
				} else {
					if (collection.contains(c)) {
						if (!sk.isEmpty()) {
							if (!map.get(sk.pop()).equals(c)) {
								valid = false;
								break;
							}
						} else {
							valid = false;
							break;
						}
					}
				}
			}
			return valid && sk.isEmpty();
		}

		// good
		public boolean isValid(String s) {
			Stack<Character> stack = new Stack<Character>();
			for (char c : s.toCharArray()) {
				if (c == '(')
					stack.push(')');
				else if (c == '[')
					stack.push(']');
				else if (c == '{')
					stack.push('}');
				else if (stack.isEmpty() || c != stack.pop())
					return false;
			}
			return stack.isEmpty();
		}
	}

	static void showpush(Stack<Character> st, char a) {
		st.push(new Character(a));
		System.out.println("push--> " + a + " <--");
		System.out.println("stack: " + st);
	}

	static Character showpop(Stack<Character> st) {
		Character a = (Character) st.pop();
		System.out.println("pop -> " + a);
		System.out.println("stack: " + st);
		return a;
	}

	public static void main(String args[]) {
		Solution s = new Solution();
		System.out.println(s.isValid("[")); // false
		System.out.println(s.isValid("()")); // true
		System.out.println(s.isValid("()[]{}")); // true
		System.out.println(s.isValid("(]")); // false
		System.out.println(s.isValid("([)]")); // false
		System.out.println(s.isValid("{[]}")); // true
	}

}
