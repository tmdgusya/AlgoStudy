package Programmers;

import java.util.*;

public class 메뉴리뉴얼 {
    // 나중에 풀어보기
    public static void main(String[] args) {
        String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
        int[] course = {2,3,4};
        Solution solution = new Solution();
        String[] solution1 = solution.solution(orders, course);
        System.out.println("solution1 = " + Arrays.toString(solution1));
    }

     static class Solution {

        static HashMap<String, Integer> hm = new HashMap<>();

         public String[] solution(String[] orders, int[] course) {
             String[] answer = {};
             int len[] = new int[course[course.length-1]+1];
             ArrayList<String> al = new ArrayList<>();
             //Sorting
             for(int i = 0; i < orders.length; i++){
                 final char[] chars = orders[i].toCharArray();
                 Arrays.sort(chars);
                 for(int j = 0; j < course.length; j++){
                     if(course[j] <= orders[i].length()){
                         nCr(chars, orders[i].length(), course[j], 0, "");
                     }
                 }
             }
             for(String k : hm.keySet()){
                 if(2 <= hm.get(k)){
                     if(len[k.length()] < hm.get(k)){
                         len[k.length()] = hm.get(k);
                     }
                 }
             }
             for (String k: hm.keySet()){
                 if(2 <= hm.get(k) && len[k.length()] == hm.get(k)){
                     al.add(k);
                 }
             }
             Collections.sort(al);
             final String[] strings = al.toArray(new String[0]);
             return strings;
         }

         static void nCr(char[] str, int n, int r, int start, String result){
             if(r == 0){
                 hm.put(result, hm.getOrDefault(result, 0)+1);
                 return;
             }else{
                 for(int i = start; i < str.length; i++){
                     nCr(str, n, r-1, i+1, result+str[i]);
                 }
             }
         }

     }
}
