package leetCode;

import java.util.Arrays;
import java.util.Collections;

public class ReverseInteger {

    public static void main(String[] args) {
        System.out.println(reverse(-112)) ;
    }

    public static int reverse(int x) {
        String s = "";
        boolean isMinus = false;
        if(x < 0){
            x *= -1;
            isMinus = true;
        }
        while(x / 10 != 0){
            s += Integer.toString(x % 10);
            x = x/10;
        }
        s += Integer.toString(x % 10);
        if(isMinus == true){
            try{
                return -1*Integer.valueOf(s);
            }catch (Exception e){
                return 0;
            }
        }else{
            try{
                return Integer.valueOf(s);
            }catch (Exception e){
                return 0;
            }
        }
    }
}
