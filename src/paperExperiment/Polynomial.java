package paperExperiment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Classname Polynomial
 * @Description TODO
 * @Date 2021/6/30 21:28
 * @Created by Fabric
 */
public class Polynomial {
    public List<Integer> poly = new ArrayList<>();
    public void createPolynomial(List<Integer> aList){
        int num = aList.size()+1;
        this.poly = new ArrayList<Integer>(num);
        for(int i = 0; i <= num; i++){
            this.poly.add(0);
        }
        poly.set(0,aList.get(0));
        poly.set(1, 1);
        for(int i =1;i<=aList.size(); i++){
            int x = 1;
            int y = aList.get(i);
            for(int j=0;j<i;j++){
                poly.set(j, poly.get(j)*y);
            }
            for (int j = 1; j < i; j++) {
                poly.set(j, poly.get(j) + poly.get(j-1) * x);
            }
            poly.set(i, x);
        }
    }
    public void showPoly(){
        for (int i = 0; i < poly.size();i++){
            System.out.printf("%d,%d",i,poly.get(i));
            System.out.println();
        }
    }
    public Polynomial(List<Integer> list){
        createPolynomial(list);
    }
    public static void main(String[] args) {
        int [] nums = {1,2,3};
        List<Integer> numList = new ArrayList(nums.length);
        for(int i =0;i<nums.length;i++){
            numList.add(nums[i]);
        }
        Polynomial pol = new Polynomial(numList);
        pol.showPoly();


    }

}