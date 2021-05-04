package BasicAlgorithm.Sorting;

public class QuickSort {

    private static int number = 5;
    private static int[] data;
    private static int cnt = 0; // count of Call quick sort

    public static void quick_sort(int[] data, int x, int y) {
        cnt++;

        if(x >= y) {
            return;
        }

        int pivot = x;
        int left = pivot + 1;
        int right = y;
        int temp;

        while (left < right) {
            while (left <= y && data[left] < data[pivot]) {
                left++;
            }
            while (right >= pivot && data[pivot] < data[right]) {
                right--;
            }

            if(left < right) { // 정상적으로 left value 가 크고 right value 가 작을때 둘이 swap
                temp = data[left];
                data[left] = data[right];
                data[right] = temp;
            } else { // 큰 값 작은값을 찾았는데 그때는 이제 pivot 을 스와핑
                temp = data[pivot];
                data[pivot] = data[right];
                data[right] = temp;
            }

            quick_sort(data, pivot, right - 1);
            quick_sort(data, right + 1, y);

        }

    }

    public static void printData(int[] data, int number) {
        for (int i = 0; i < number; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }


    public static void main(String[] args) {
        // 1~100 랜덤한 값 출력
        data = new int[number];
        for (int i = 0; i < number; i++) {
            data[i] = (int) (Math.random() * 100);
        }

        // 정렬 전
        printData(data, number);
        // 정렬 시작
        quick_sort(data, number/2, number - 1);
        // 정렬 후
        printData(data, number);
        // 연산 횟수
        System.out.println("N : " + number + " cnt : " + cnt);

    }

}
