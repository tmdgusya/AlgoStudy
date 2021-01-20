package Programmers;

import java.util.*;
import java.io.*;

class bboki {
    public static void main(String[] args) {
        int[][] board = {{0,0,0,0,0},
                         {0,0,1,0,3},
                         {0,2,5,0,1},
                         {4,2,4,4,2},
                         {3,5,1,3,1}};
        int[] moves = {1,5,3,5,1,2,1,4};
//                      {4,3,1,1,3,2,null,4};
        int solution = solution(board, moves);
        System.out.println("answer : " + solution);
    }
    static public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> got = new Stack<>();
        for(int i = 0; i < moves.length; i++){
            int idx = 0;
            while(idx < board.length){
                if(board[idx][moves[i]-1] != 0){
                    System.out.println(board[idx][moves[i]-1]);
                    if(!got.isEmpty()){
                        int predoll = got.peek();
                        if(predoll == board[idx][moves[i]-1]){
                            answer++;
                            got.pop();
                        }else{
                            got.add(board[idx][moves[i]-1]);
                        }
                    }else{
                        got.add(board[idx][moves[i]-1]);
                    }
                    board[idx][moves[i]-1] = 0;
                    break;
                }
                idx++;
            }
        }
        return answer*2;
    }
}