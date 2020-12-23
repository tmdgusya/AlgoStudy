package Retry;

import java.util.Scanner;

public class Sugar {
    
    public static void main(String[] args){
        int weight;
        int pack = 0;
        int[] dp = new int[50];
        Scanner scan = new Scanner(System.in);
        weight = scan.nextInt();
        while(true){
            if(weight % 5 == 0){
                pack += weight/5;
                break;
            }
            pack++;
            weight -= 3;
            if(weight == 0){
                break;
            }
            if(weight < 0){
                System.out.println("-1");
                return;
            }
        }
        System.out.println(pack);
    }
}