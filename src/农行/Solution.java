package 农行;

import com.sun.deploy.util.StringUtils;
import hashPractice.Hash;

import java.lang.String;
import java.util.*;

import java.util.Scanner;
public class Solution{
    public static int n;
    public static int k;
    public static int [][] matrix;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        matrix = new int[n][n];
        if(k>=n*n){
            for (int i = 0; i < n; i++) {
                Arrays.fill(matrix[i],0);
            }
            for (int i = 0; i < n; i++) {
                int [] arr = matrix[i];
                StringBuffer sb = new StringBuffer();
                sb.append(arr[0]);
                for (int j = 1; j < n; j++) {
                    sb.append(" ");
                    sb.append(arr[j]);
                }
                System.out.println(sb.toString());
            }
        }
        for (int i = 0; i < n; i++) {
            Arrays.fill(matrix[i],1);
        }
        fill();
        for (int i = 0; i < n; i++) {int [] arr = matrix[i];
            StringBuffer sb = new StringBuffer();
            sb.append(arr[0]);
            for (int j = 1; j < n; j++) {sb.append(" ");
                sb.append(arr[j]);
            }System.out.println(sb.toString());
        }

        }
        public static void  fill(){
            int point = 0;
            while (k >0){
                if(k==1){
                int dig = 0;//对角
                while (matrix[dig][dig]==0){
                    dig++;

                }
                matrix[dig][dig] = 0;
                k--;
            }else if(point%n == point / n){
                matrix[point % n][point / n] = 0;
                k --;
                point++;
            }else{
                matrix[point % n][point / n] = 0;
                matrix[point / n][point % n] = 0;
                k -= 2;
                point++;
            }
            if(point%n==0){
                point+=point/n;
            }
            }
        }
}

