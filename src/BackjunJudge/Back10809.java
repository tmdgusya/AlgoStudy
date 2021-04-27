package BackjunJudge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Back10809 {

    public static void main(String[] args) throws IOException {
        char[] alphabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};

        int[] ans = new int[alphabet.length];

        Arrays.fill(ans, -1);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] charArray = br.readLine().toCharArray();

        for(int i = 0; i < alphabet.length; i++) {
            for(int j = 0; j < charArray.length; j++) {
                if(alphabet[i] == charArray[j]) {
                    ans[i] = j;
                    break;
                }
            }
        }

        for (int an : ans) {
            System.out.print(an + " ");
        }
    }

}
