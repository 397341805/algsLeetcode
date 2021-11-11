package MeituanTest;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;
import hashPractice.Hash;
/**
 * @Classname Bookshell
 * @Description TODO
 * @Date 2021/8/29 10:12
 * @Created by Fabric
 */
public class Bookshell {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int [] bookWidth = new int[n];
		int [] bookLocation = new int[n];
		for(int i=0;i<n;i++){
			bookWidth[i] = sc.nextInt();
		}
		for (int i = 0;i<n;i++){
			bookLocation[i] = sc.nextInt();
		}
		Arrays.sort(bookLocation);
		Arrays.sort(bookWidth);
		int idx = n-1;
		int res = 1;
		for (int i = n-1;i>=0;i--){
			int count = 0;
			int temp = bookWidth[i];
			while (idx-count>=0 && temp <= bookLocation[idx-count]) {
			    count++;
			}
			res = (res*count) %1_000_000_007;
			idx--;
		}
		System.out.println(res);

		Hash s = new Hash();

	}

}