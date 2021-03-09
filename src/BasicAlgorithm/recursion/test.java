package BasicAlgorithm.recursion;

import java.util.ArrayList;
import java.util.List;

public class test {

    public static String result = "";
    public static List<String> strings = new ArrayList<>();

    public static void main(String[] args) {
        combination("abcdef".toCharArray(), 2, result);
        System.out.println(strings.toString());
    }

    public static void combination(char[] chars , int r, String result) {
        if(r == 0) {
            strings.add(result);
        }else{
            for(char c : chars) {
                combination(chars, r-1, result+c);
            }
        }
    }
}
