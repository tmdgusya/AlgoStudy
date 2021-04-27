package BackjunJudge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 준규는 N 가지의 종류를 가지고 있고,
 * MOUNT 만큼의 돈을 주는데 가장 적은 동전을 사용하고 싶다.
 *
 * 1. Greedy 조건은 배수일 경우 만족할 수 있다.
 * 2. mount 보다 적은 배열의 Value 에서 멈춘다.
 * 3. 해당 Value 로 mount 를 나눈다.
 * 4. 나눈 몫을 count 에 더한다.
 * 5. 나머지가 있다면 3번을 반복한다. 0이라면 프로그램을 종료한다.
 *
 */
public class Back11047 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int count = 0;

        int N = Integer.parseInt(st.nextToken());
        int mount = Integer.parseInt(st.nextToken());
        int[] money = new int[N];

        for(int i = 0; i < N; i++) {
            money[i] = Integer.parseInt(br.readLine());
        }

        while (mount != 0) {
            int m = 0;
            for(int i = 0; i < money.length; i++) {
                if(money[i] > mount) {
                    if(i != 0) {
                        m = money[i-1];
                        break;
                    }
                }
                m = money[i];
            }
            int c = mount / m;
            mount -= m*c;
            count += c;
        }

        System.out.println(count);

    }

}
