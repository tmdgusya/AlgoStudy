# 풍선 터뜨리기

## 규칙성 찾기

- 양 사이드는 무조건 통과가 된다. (이건 몇번 해보니 규칙적으로 보였음)
- 중간 것들은 양 사이드 보다 작으면 통과가 된다.

## 느낀점

- 아 첫번째 규칙 까지는 어떻게 도출이 됬는데 두번째는 찾지 못했다..
- 검색해보니 이렇게 풀더라, 참 세상엔 머리 좋은사람이 많다.

## 코드

```java
class Solution {
        public int solution(int[] a) {
            int answer = 0;
            int MAX_VALUE = 1000000000;

            int left = MAX_VALUE;
            int right = MAX_VALUE;

            for (int i = 0; i < a.length; i++) {
                if (a[i] < left) {
                    answer++;
                    left = a[i];
                }
                if (a[a.length - 1 - i] < right) {
                    answer++;
                    right = a[a.length - 1 - i];
                }
                if (left == right)
                    break;
            }

            return answer + (left == right ? -1 : 0);
    }
}
```
