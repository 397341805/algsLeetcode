package leetcode_67;

/**
 * @Classname Solution
 * @Description TODO
 * @Date 2021/8/25 21:10
 * @Created by Fabric
 */
class Solution {
 public static String addBinary(String a, String b) {
  if(a.length()<b.length()){
   b = "0" + b;
  }else if(a.length() == b.length()){
   a = "0" + a;
   b = "0" + b;
  }else{
   a = "0" + a;
  }
  int idxa = a.length()-1;
  int idxb = b.length()-1;
  char [] achar = a.toCharArray();
  char [] bchar = b.toCharArray();
  StringBuffer sb = new StringBuffer();
  int res = 0;
  int x;
  int y;
  while(idxa>=0||idxb>=0){

   if(idxa>=0 && idxb >= 0){
    if(achar[idxa]=='1') x =1;
    else x = 0;
    if(bchar[idxb] == '1') y =1;
    else y = 0;
    sb.append((x + y + res)%2);
    res = (x + y + res)/2;

   }else if (idxa<0){
    if(bchar[idxb] == '1') y =1;
    else y = 0;
    sb.append(( y + res)%2);
    res = ( y + res)/2;

   }else{
    if(achar[idxa]=='1') x =1;
    else x = 0;
    sb.append((x + res)%2);
    res = (x  + res)/2;

   }
   idxa--;
   idxb--;

  }
  String result = sb.toString();
  if(result.charAt(0)=='0') result = result.substring(1);
  return result;

 }

 public static void main(String[] args) {

 }
}