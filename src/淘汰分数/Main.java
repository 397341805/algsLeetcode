package 淘汰分数;

import java.util.Arrays;
import java.util.Scanner;
import basicDataStructure.Sort;
/**
 * @Classname Main
 * @Description TODO
 * @Date 2021/5/8 11:03
 * @Created by Fabric
 */
public class Main {
    public static void main(String[] args) {
        int n,x,y;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        x = sc.nextInt();
        y = sc.nextInt();
        int [] student = new int[n];
        for (int i = 0; i < n; i++) {
            student[i] = sc.nextInt();
        }

        Sort.numSort(student,0, student.length);
        for(int i =x ; i<=y;i++){
            if(x<=student.length-i && student.length-i<=y){
                System.out.println(student[i-1]);
                return;
            }
        }
        System.out.println(-1);

    }

}