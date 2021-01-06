package CodeSquad.Week2;

import java.util.Scanner;

public class Back1052 {
    public static void main(String[] args) {
        int bottles;
        int maximumMoveCount;
        int purchaseCount = 0;

        Scanner scan = new Scanner(System.in);
        bottles = scan.nextInt();

        maximumMoveCount = scan.nextInt();
        purchaseCount = getNeedPurchaseBottles(bottles, maximumMoveCount, purchaseCount);
        System.out.print(purchaseCount);
        scan.close();
    }

    private static int getNeedPurchaseBottles(int bottles, int maximumMoveCount, int purhcaseCount) {
        if(bottles <= maximumMoveCount){
            return 0;
        }
        else {
            while(true){
                if(getRemainBottles(bottles) <= maximumMoveCount) break;
                purhcaseCount++;
                bottles++;
            }
        }
        return purhcaseCount;
    }

    private static int getRemainBottles(int bottle){
        int mixCount = 0;
        while(bottle > 0){
            if(bottle % 2 == 1){
                mixCount++;
            }
            bottle /= 2;
        }
        return mixCount;
    }
}

/*
* [1] = [1]
* [1 1] = [2] 🔫
* [1 1 1] = [2 1] 💰=> [2 1 1] => [2 2] => 4
* [1 1 1 1] = [2 2] = [4] 🔫
* [1 1 1 1 1] = [2 2 1] = [4 1] 💰 = [4 2] 💰=> [4 2 1] 💰=> [4 2 1 1] => [4 2 2] => [4 4] => [8]
* [1 1 1 1 1 1] = [2 2 2] = [4 2] Need 2
* [1 1 1 1 1 1 1] = [2 2 2 1] = [4 2 1] Need 1
* [1 1 1 1 1 1 1 1] = [2 2 2 2] = [4 4] = [8] 🔫
*
*2^n 승인 친구들이 정상적인 물병
* 2/2 2%2 = 1🍶 + 0 [1 + 0 이 앞에건 합쳐진 병 0은 남은 병 우리는 이제 이형태를 만들어줄때까지 반복해야함]
* 3/2 3%2 = 1🍶 + 1 = 2/2 + 2%2 = 1  0
* 5/2 5%2 = 2🍶 + 1 💰=> 2/2 2%2 => 1  0
* 6/2 6%2 = 3🍶 + 0 💰=> 3/2 3%2 => 1  1 => 0  1

* 즉 X % 2 == 1 일때 마다 💰
* 그리고 X / 2 씩 나누어져야 함.
* */