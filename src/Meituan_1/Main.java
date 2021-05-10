package Meituan_1;
import java.util.Scanner;
import java.util.Arrays;
import java.util.Deque;
import java.util.ArrayDeque;
/**
 * @Classname Main
 * @Description TODO
 * @Date 2021/5/8 9:30
 * @Created by Fabric
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int [][] scores = new int[n][m];
        for(int i =0;i<n;i++){
            for (int j = 0; j < m; j++) {
                scores[i][j] = sc.nextInt();
            }
        }
        Deque<Integer> stack = new ArrayDeque<>();
        int [] result = new int[n];
        Arrays.fill(result, 0);
        int maxl = 0;
        stack.addLast(maxl);
        for(int j =0;j<m;j++){
            for(int i = 0;i<n;i++){
                if(scores[i][j]>=scores[maxl][j]){
                    maxl = i;
                    stack.addLast(maxl);
                }
            }
            int maxscore = scores[maxl][j];
            while (scores[stack.getLast()][j] == maxscore){
                result[maxl]++;
                stack.removeLast();
            }
        }
        int ans = 0;
        for(int t:result){
            if(t>0) ans++;
        }
        System.out.println(ans);
    }
}