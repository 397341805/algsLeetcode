package 农行;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

/**
 * @Classname Solution2
 * @Description TODO
 * @Date 2021/11/7 14:55
 * @Created by Fabric
 */
public class Solution2 {
	public static void main(String[] args) {
		Deque<Integer> stack = new ArrayDeque<>();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for (int i = 0; i < n; i++){
			String str = sc.next();
			switch (str) {
				case "Push":
					stack.push(1);
					break;
				case "Add":
					stack.push(stack.pop()+1);
					break;
				case "Pop":
					if(!stack.isEmpty())
					stack.pop();
					break;
				default:
			}
		}
		if(stack.isEmpty()){
			System.out.println("No number");
		}else{
			System.out.println(stack.pop());
		}
	}
}