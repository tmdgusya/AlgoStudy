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
        System.out.println(result);
        if(r == 0){
            stringCombination.add(result);
        }else{
            for (char c : str) {
                nCr(str, r - 1, result + c);
            }
        }
    }
}
