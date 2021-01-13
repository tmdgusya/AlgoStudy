package leetCode;

import java.util.Arrays;

public class LongestCommonPrefix {
    public static void main(String[] args) {

        System.out.println(longestCommonPrefix(new String[]{"flower","flow","flight"}));
        System.out.println(longestCommonPrefix(new String[]{"aaa","aa","aaa"}));
//        System.out.println(Arrays.toString(new String[]{}).equals("[]"));
    }

    public static String longestCommonPrefix(String[] strs) {
        if(Arrays.toString(strs).equals("[]")){
            return "";
        }else if(strs.length == 1){
            return strs[0];
        }
        String pre = strs[0];
        StringBuilder answerBuilder = new StringBuilder();
        int minlength = strs[0].length();
        for(int i = 0; i < pre.length(); i++){
            for(int j = 1; j < strs.length; j++){
                minlength = Math.min(minlength, strs[j].length());
                if(i < minlength){
                    if(pre.charAt(i) == strs[j].charAt(i)){
                        if(j == strs.length-1){
                            answerBuilder.append(pre.charAt(i));
                        }
                    }else{
                        return answerBuilder.toString();
                    }
                }
            }
        }
        return answerBuilder.toString();
    }
}
