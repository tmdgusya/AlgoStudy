package BackjunJudge;
    
import java.util.*;

class Sugar {
    
    public static void main(String args[]){
               int N; // weight
        int packaging = 0;
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        
        while(true){
            if(N%5 == 0){
                packaging += N/5;
                break;
            }
            
            N -= 3;
            packaging++;
            System.out.println(N);
            if(N < 0){
                System.out.print("-1");
                System.exit(0);
            }
        }
        System.out.println(packaging);
    }
    
}