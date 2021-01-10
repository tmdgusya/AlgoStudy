package GreedyAlgo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Back11047 {

    public static void main(String[] args) throws IOException {
        int count = 0;
        int N;
        int K;
        Scanner scan = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();
        N = scan.nextInt();
        K = scan.nextInt();
        for(int i = 0; i < N; i++){
            stack.add(scan.nextInt());
        }
        while(K > 0){
            while(stack.peek() <= K){
                int money = stack.peek();
                K -= money;
                count++;
                if(stack.peek() > K){
                    stack.pop();
                }
            }
            if(stack.size() > 0){
                stack.pop();
            }
        }
        System.out.println(count);
    }
}
