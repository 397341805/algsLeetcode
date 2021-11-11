package MeituanTest;

import hashPractice.Hash;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

/**
 * @Classname CloveTree
 * @Description TODO
 * @Date 2021/8/29 10:30
 * @Created by Fabric
 */
public class CloveTree {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int [] fragment = new int [31];
		fragment[0] = sc.nextInt();
		for (int i = 1; i < n; i++){
			fragment[i] = sc.nextInt();
		}
		int result = 0;
		HashSet<Integer> fragmentSet = new HashSet<>();
		int preMax = fragment[0];
		for (int i = 1; i < n; i++) {
			for(int tmp:fragmentSet){
				if (tmp<fragment[i]){
					result++;
				}
			}
			fragmentSet.add(fragment[i]);
		}
		System.out.println(result);

	}
}