package BasicAlgorithm.recursion;

public class CustomString {

    public static void main(String[] args) {
        System.out.println(length("asc"));
    }

    //recursion
    public static int length(String str){
        if(str.equals(""))
            return 0;
        System.out.println(str);
        return 1+length(str.substring(1));
    }

    public static char[] toCharArray(String str){
        int length = length(str);
        char[] charArray = new char[length];
        for(int i = 0; i < length; i++){
            charArray[i] = str.charAt(i);
        }
        return charArray;
    }
    // 이게 메소드가 스택에 쌓이기때문에 가능한거임 LIFO
    public static void printReverseString(String str){
        if(str.length() == 0)
            return;
        printReverseString(str.substring(1));
        System.out.print(str.charAt(0));
    }

    public static void printInBinary(int n){
        if(n < 2)
            System.out.print(n);
        else{
            printInBinary(n/2);
            System.out.print(n%2);
        }
    }
}
