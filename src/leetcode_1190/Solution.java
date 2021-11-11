package leetcode_1190;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Classname Solution
 * @Description TODO
 * @Date 2021/5/26 10:12
 * @Created by Fabric
 */
class Solution {
	public String reverseParentheses(String s) {
		Deque<Character> que = new ArrayDeque<>();
		Deque<Character> strQue = new ArrayDeque<>();
		boolean reverse = true;
		for(char c:s.toCharArray()){
			if(c == ')'){
				while(que.getLast() != '('){
					strQue.addLast(que.removeLast());
				}
				que.removeLast();
				while (!strQue.isEmpty()){
					que.addLast(strQue.removeLast());
				}
			}else{
				que.addLast(c);
			}

		}
		StringBuffer sb = new StringBuffer();
		while (!que.isEmpty()){
			sb.append(que.removeFirst());
		}
		return sb.toString();
	}
}