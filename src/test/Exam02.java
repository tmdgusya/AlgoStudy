package test;

import java.util.ArrayList;
import java.util.Arrays;

public class Exam02 {

    public static void main(String[] args) {
        int[][] line = {{2, -1, 4}, {-2, -1, 4}, {0, -1, 1}, {5, -8, -12}, {5, 8, 12}};
        int[][] line2 = {{0, 1, -1}, {1, 0, -1}, {1, 0, 1}};
        Solution solution = new Solution();
        System.out.println(solution.solution(line));
    }

    static class Solution {
        static ArrayList<int[]> pointers = new ArrayList<>();
        static ArrayList<String> answers = new ArrayList<>();
        static char[][] board;
        public String[] solution(int[][] line) {
            String[] answer = {};
            for(int i = 0; i < line.length; i++){
                for(int j = i+1; j < line.length; j++){
                    getPoint(line[i], line[j]);
                }
            }
            int maxX = 0;
            int maxY = 0;
            for(int[] pointer : pointers){
                int pointerMaxX = Math.max(maxY, pointer[1]);
                int pointerMaxY = Math.max(maxY, pointer[0]);
                maxX = Math.max(maxX, pointerMaxX);
                maxY = Math.max(maxY, pointerMaxY);
            }
            board = new char[maxX*2+1][maxY*2+1];
            for(char[] arr : board){
                Arrays.fill(arr, '.');
            }
            for(int[] pointer : pointers){
                board[maxX - pointer[1]][maxY-pointer[0]] = '*';
            }
            for (char[] i : board){
                String s = Arrays.toString(i);
                final String replace = s.replace("[", "");
                String good = replace.replace("]", "");
                answers.add(good);
            }
            answer = new String[answers.size()];
            for(int i = 0; i < answers.size(); i++){
                answer[i] = answers.get(i);
            }
            return answer;
        }

        public void getPoint(int[] a, int[] b){
            if(!(a[0]*b[1]-a[1]*b[0] == 0)){
                int x = (a[1]*b[2]-b[1]*a[2])/(a[0]*b[1]-b[0]*a[1]);
                int y = (a[2]*a[0]-a[0]*b[2])-(a[0]*b[1]-a[1]*b[0]);
                pointers.add(new int[]{x,y});
            }
        }
    }
}
