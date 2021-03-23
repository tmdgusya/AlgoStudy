package BackjunJudge;

import java.util.*;

public class Back2292 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextInt();
        int count = 1;
        if(n == 1) {
            System.out.println(1);
            return;
        }
        while(n > 0) {
            if(count==1) {
                n -= 7;
            }else{
                n -= (6L *count);
            }
            count++;
        }
        System.out.print(count);
    }


}
