package HUAWEI;

import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Classname Solution
 * @Description TODO
 * @Date 2021/9/11 20:04
 * @Created by Fabric
 */
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int Q = sc.nextInt();
        int [] qArr = new int[Q];
        for (int i = 0; i < Q; i++) {
            qArr[i] = sc.nextInt();
        }

        int [] que = new int[N];
        Arrays.fill(que, 1);
        for (int i = 0; i < Q; i++) {
            int res =0;
            int m1 = qArr[i];
            if(que[0] ==0){
                int idx =0;
                while (idx<N && que[idx] == 0){ //找到第一个要移动的
                    idx++;
                }
                res+= idx;
                que[0] = 1;
                que[idx] = 0;
            }
            que[0] = 0;
            for (int j = 0; j < m1; j++ ) {
                int idx =j;
                while (idx<N && que[idx] == 0){ //找到第一个要移动的
                    idx++;
                }
                res+= (idx-j);
                que[j] = 1;
                que[idx] = 0;
            }
            System.out.println(res);

        }
    }
}
