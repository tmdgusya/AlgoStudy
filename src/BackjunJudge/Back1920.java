package BackjunJudge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Back1920 {

    public static void main(String[] args) throws IOException {

        int n;
        int m;
        int[] arr;
        int[] arr1;
        int[] answer;

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;

        n = Integer.parseInt(bufferedReader.readLine());
        arr = new int[n];

        stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");
        int index = 0;

        while (stringTokenizer.hasMoreTokens()) {
            arr[index] = Integer.parseInt(stringTokenizer.nextToken());
            index++;
        }

        m = Integer.parseInt(bufferedReader.readLine());
        arr1 = new int[m];
        answer = new int[m];
        stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");
        index = 0;


        while (stringTokenizer.hasMoreTokens()) {
            arr1[index] = Integer.parseInt(stringTokenizer.nextToken());
            index++;
        }

        for (int i = 0; i < arr1.length; i++){
            for (int j = 0; j < arr.length; j++) {
                if(arr1[i] == arr[j]) {
                    answer[i] = 1;
                }
            }
        }

        for(int a : answer) {
            System.out.println(a);
        }

    }

}
