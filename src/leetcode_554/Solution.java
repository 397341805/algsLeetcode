package leetcode_554;

import java.util.*;

/**
 * @Classname Solution
 * @Description 你的面前有一堵矩形的、由 n 行砖块组成的砖墙。这些砖块高度相同（也就是一个单位高）但是宽度不同。每一行砖块的宽度之和应该相等。
 *
 * 你现在要画一条 自顶向下 的、穿过 最少 砖块的垂线。如果你画的线只是从砖块的边缘经过，就不算穿过这块砖。你不能沿着墙的两个垂直边缘之一画线，这样显然是没有穿过一块砖的。
 *
 * 给你一个二维数组 wall ，该数组包含这堵墙的相关信息。其中，wall[i] 是一个代表从左至右每块砖的宽度的数组。你需要找出怎样画才能使这条线 穿过的砖块数量最少 ，并且返回 穿过的砖块数量 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/brick-wall
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 2021/5/2 15:53
 * @Created by Fabric
 */
class Solution {
//    public int leastBricks(List<List<Integer>> wall) {//超内存版本
//        int high = wall.size();
//        long width = wall.get(0).stream().reduce(Integer::sum).orElse(0); //java 利用流求List数组和
//        int result = Integer.MAX_VALUE;
//        int [][] map = new int[high][(int)width+1];
//        for(int i = 0; i<high ;i++){
//            Arrays.fill(map[i],0);
//            int tmpLen = 0; //临时长度
//            for(int n:wall.get(i)){
//                tmpLen += n;
//                map[i][n] = 1;
//            }
//        }
//        for (int i = 0; i < width; i++) {
//            int tmpNum = 0; //穿过的砖块数量
//            for (int j = 0; j < high; j++) {
//                tmpNum += map[j][i];
//            }
//            result = Math.min(result,tmpNum);
//        }
//        return result;
//    }
public int leastBricks(List<List<Integer>> wall) {
    int high = wall.size();
    long width = wall.get(0).stream().reduce(Integer::sum).orElse(0);
    int result = 0;
    HashMap<Integer,Integer> edgeWidth = new HashMap<>(); //记录每行的边缘位置。
    for (int i = 0; i < high; i++) {
        int tmpLen = 0; //临时长度
        for(int n:wall.get(i)){
            tmpLen += n;
            edgeWidth.put(tmpLen, edgeWidth.getOrDefault(tmpLen,0)+1);
//            Java HashMap getOrDefault() 方法
//            getOrDefault() 方法获取指定 key 对应对 value，如果找不到 key ，则返回设置的默认值。
//            getOrDefault() 方法的语法为：hashmap.get(Object key, V defaultValue)
        }
    }
    edgeWidth.put((int)width,0);
    for(Map.Entry<Integer, Integer> entry : edgeWidth.entrySet()){
        result = Math.max(result,entry.getValue());
    }
    return high - result;
}

}