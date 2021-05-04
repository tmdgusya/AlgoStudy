package BackjunJudge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * N 장의 카드가 있다.
 * 1 부터 N 까지의 번호가 붙어 있는 카드가 있다.
 *
 * 로직은 아래와 같다.
 * 1. 제일 위에 수를 POP 한다.
 * 2. 제일 위의 수를 맨 아래로 옮긴다.
 * 3. 이걸 SIZE = 1 일때 까지 반복한다.
 */
public class Back2164 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Queue<Integer> queue = new LinkedList<>();

        int act_count = 1;

        for(int i = 1; i <= N; i++) {
            queue.add(i);
        }

        if(queue.size() == 1) {
            System.out.println(queue.poll());
            return;
        }

        while (queue.size() != 1) {
            if(act_count % 2 == 1) {
                queue.poll();
            }else {
                int tmp = queue.remove();
                queue.offer(tmp);
            }
            act_count++;
        }

        System.out.println(queue.poll());

    }

}
