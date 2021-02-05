package Programmers;

import java.util.ArrayList;

public class 메뉴리뉴얼 {
    // 나중에 풀어보기
    public static void main(String[] args) {
        String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
        int[] course = {2,3,4};
        Solution solution = new Solution();
        String[] solution1 = solution.solution(orders, course);
        System.out.println("solution1 = " + solution1);
    }

     static class Solution {
         public String[] solution(String[] orders, int[] course) {
             ArrayList<String[]> menulist = new ArrayList<>();
             for(String menu : orders){ 
                 String[] split = menu.split("");
                 menulist.add(split);
             }
             for(int i = 0; i < menulist.size(); i++){
                 String[] strings = menulist.get(i);
             }
             return menulist.get(0);
         }
     }
}
