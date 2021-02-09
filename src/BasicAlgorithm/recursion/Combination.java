package BasicAlgorithm.recursion;

import java.util.HashMap;

public class Combination {

    static HashMap<String, Integer> hm = new HashMap<>();

    public static void main(String[] args) {
        combination("abc");
    }

    public static void combination(String str) {
        final char[] chars = str.toCharArray();
        for (int i = 1; i <= str.length(); i++) {

        }
        nCr(chars, str.length(), 2, 0, "");
        System.out.println(hm.toString());
    }

    static void nCr(char[] str, int n, int r, int start, String result) {
        if (r == 0) {
            hm.put(result, hm.getOrDefault(result, 0) + 1);
            return;
        } else {
            for (int i = start; i < str.length; i++) {
                nCr(str, n, r - 1, i + 1, result + str[i]);
            }
        }
    }

}
