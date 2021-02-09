package BasicAlgorithm.recursion;

import java.util.ArrayList;

public class 조합 {
    static ArrayList<String> stringCombination = new ArrayList<>();
    static int count = 0;
    public static void main(String[] args) {
        nCr("abcd".toCharArray(), 2, "");
        System.out.println(stringCombination.toString());
    }

    static void nCr(char[] str, int r, String result){
        count++;
        if(r == 0){
            System.out.println(result);
            stringCombination.add(result);
            return;
        }else{
            System.out.println("count : " + count + " value : " + result);
            for(int i = 0; i < str.length; i++){
                nCr(str, r-1, result+str[i]);
            }
        }
    }
}
