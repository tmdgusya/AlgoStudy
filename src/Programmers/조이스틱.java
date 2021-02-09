package Programmers;

public class 조이스틱 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution("JAN"));
    }

    static class Solution {
        public int solution(String name) {
            int answer = 0 ;

            for ( char c : name.toCharArray()) {
                if( c < 'N' ) answer+=c%'A';
                else answer+=('Z'+1) - c;
            }

            int min = name.length()-1;

            // A가 연속되는 경우에는 뒤로돌아갔을때 최솟값을 구해주어서 비교해준다.
            for ( int i = 0; i < name.length(); i ++ ) {
                int index = i;

                if( name.charAt(index)=='A' ) {
                    while( index < name.length() && name.charAt(index)=='A') {
                        index++;
                    }

                    // 종료시점의 index는 연속된 A가 끝나는지점이다.

                    // ((i-1)*2)은  A가 가기전까지 갔다가, 다시 Back하는 수를 세준것이다.
                    // 연속된 A가 끝나는 index까지 뒤에서 세야함으로 ( 전체길이 - index )를 해준다.
                    int moveCnt = ((i-1)*2) + name.length() - index;
                    min = Math.min(min, moveCnt);
                }
            }
            System.out.println(" 좌,우 이동거리 : " + min );
            return answer+min;
        }
    }
}
