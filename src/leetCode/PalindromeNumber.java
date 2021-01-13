package leetCode;

public class PalindromeNumber {
    public static void main(String[] args) {
        System.out.println(isPalindrome(101));
    }

    public static boolean isPalindrome(int x) {
        if(x<0){return false;}
        int reverse = reverse(x);
        if(x == reverse){
            return true;
        }else{
            return false;
        }
    }

    public static int reverse(int x) {
        String s = "";
        while(x / 10 != 0){
            s += Integer.toString(x % 10);
            x = x/10;
        }
        s += Integer.toString(x % 10);
        try{
            return Integer.valueOf(s);
        }catch(Exception e){
            return 0;
        }
    }
}
