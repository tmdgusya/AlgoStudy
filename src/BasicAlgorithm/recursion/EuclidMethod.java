package BasicAlgorithm.recursion;

public class EuclidMethod {

    public static void main(String[] args) {
        System.out.println(print(0, new int[]{1,2,3}, 0));
    }


    public static double gcd(int m, int n){
        if(m < n){
            int tmp = m;
            m = n;
            n = tmp;
        }
        if(m % n == 0)
            return n;
        return gcd(n, m%n);
    }

    public static int print(int startPoint, int[] a, int result){
        if(startPoint == a.length){
            return result;
        }
        return print(startPoint+1, a, result+a[startPoint]);
    }
}
