package leetcode_67;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Classname Test
 * @Description TODO
 * @Date 2021/8/27 20:11
 * @Created by Fabric
 */
import java.util.Scanner;

public class Test {

 public static int f(int num, String command) {
  char ch = command.charAt(0);
  if(ch == '+') {
   int num1 = Integer.parseInt(command.substring(2));
   return num + num1;
  }else if(ch == '-') {
   int num1 = Integer.parseInt(command.substring(2));
   return num - num1;
  }else if(ch == '/') {
   int num1 = Integer.parseInt(command.substring(2));
   double a = num * 1.0 / num1;
   if(a < 0) {
    return (int) Math.floor(a);
   }else if(a > 0) {
    return (int) Math.ceil(a);
   }else {
    return 0;
   }
  }else if(ch == 's') {
   if(num > 0) {
    return (int) Math.ceil(Math.sqrt(num));
   }else if(num < 0) {
    return ((int) Math.ceil(Math.sqrt(-num))) * -1;
   }else {
    return 0;
   }
  }else {
   return -num;
  }
 }
 public static void main(String[] args) {
  Scanner sc = new Scanner(System.in);
  int n = sc.nextInt();
  sc.nextLine();
  String[][] array = new String[n - 1][n];
  for(int i = 0; i < n - 1; i++) {
   for(int j = 0; j < i + 2; j++) {
    array[i][j] = sc.nextLine().trim();
   }
  }

  int[][] max = new int[n - 1][n];
  int[][] min = new int[n - 1][n];
  for(int j = 0; j < 2; j++) {
   max[0][j] = min[0][j] = f(1, array[0][j]);
  }
  for(int i = 1; i < n - 1; i++) {
   for(int j = 0; j < i + 2; j++) {
    if(j == 0) {
     int a = f(max[i - 1][j], array[i][j]);
     int b = f(min[i - 1][j], array[i][j]);
     max[i][j] = Math.max(a, b);
     min[i][j] = Math.min(a, b);
    }else if(j == i + 1) {
     int a = f(max[i - 1][j - 1], array[i][j]);
     int b = f(min[i - 1][j - 1], array[i][j]);
     max[i][j] = Math.max(a, b);
     min[i][j] = Math.min(a, b);
    }else {
     int a = f(max[i - 1][j - 1], array[i][j]);
     int b = f(min[i - 1][j - 1], array[i][j]);
     int c = f(max[i - 1][j], array[i][j]);
     int d = f(min[i - 1][j], array[i][j]);
     max[i][j] = Math.max(a, Math.max(b, Math.max(c, d)));
     min[i][j] = Math.min(a, Math.min(b, Math.min(c, d)));
    }
   }
  }
  for(int j = 0; j < n; j++) {
   System.out.print(max[n - 2][j] + " ");
  }
  System.out.println();
  for(int j = 0; j < n; j++) {
   System.out.print(min[n - 2][j] + " ");
  }
 }
}