package math.leetcode_149;

import java.util.HashMap;
import java.util.Map;

/**
 * @Classname Solution
 * @Description TODO
 * @Date 2021/6/24 9:34
 * @Created by Fabric
 */
class Solution {
	public int gcd(int a,int b){
		return b!=0 ? gcd(b,b%a) : a;
	}
	public int maxPoints(int[][] points) {
		int result = 0;
		int len = points.length;
		Map<Integer,Integer> keymap = new HashMap<>();
		for( int i = 0;i < points.length; i++){
			int x = points[i][0];
			int y = points[i][1];
			if(result > len-i || result> len/2) return result;
			for(int j = i+1;j<points.length; j++){
				int mx = (points[j][0] - x);
				int my = (points[j][1] - y);
				if(mx == 0) my = 1;
				else if(my == 0) mx =1;
				else{
					if(my<0){
						my = -my;
						mx = -mx;
					}
					int mxy = gcd(Math.abs(mx),Math.abs(my));
					mx = mx/mxy;
					my = my/mxy;
					int key = mx + 20001*my;
					keymap.put(key,keymap.getOrDefault(key,0)+1);
				}

			}
		}
		for(Map.Entry<Integer,Integer> entry : keymap.entrySet()){
			int n = entry.getValue();
			result = Math.max(result,n);
		}
		return result;
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		int [][] points = {{1,1},{2,2},{3,3}};
		System.out.println();
	}
}