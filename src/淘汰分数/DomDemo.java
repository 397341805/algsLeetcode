package 淘汰分数;



import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DomDemo {

    public  static String regex(String xml,String label) {
        String context = "";
        int len = label.length()+2;
        String part1 = "<"+label+">";
        String part2 = "</"+label+">";
        String start = xml.substring(0,len);
        String end = xml.substring(xml.length()-len-1);
        if(start .equals( part1) && end.equals( part2)){
            context =xml.substring(len,xml.length()-len-1);
        }
        return context;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        String [] s2Split = s2.split("\\.");
        String pre ="";
        String tmp = s1;
        for(String s:s2Split){
            tmp = regex(tmp,s);
            if(tmp.length()==0){
                break;
            }
            pre = tmp;
        }
        System.out.println(pre);
}
}