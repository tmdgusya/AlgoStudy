# 프로그래머스 level3 - 단어변환

두 개의 단어 begin, target과 단어의 집합 words가 있습니다. 아래와 같은 규칙을 이용하여 begin에서 target으로 변환하는 가장 짧은 변환 과정을 찾으려고 합니다.

1. 한 번에 한 개의 알파벳만 바꿀 수 있습니다.
2. words에 있는 단어로만 변환할 수 있습니다.
   예를 들어 begin이 "hit", target가 "cog", words가 ["hot","dot","dog","lot","log","cog"]라면 "hit" -> "hot" -> "dot" -> "dog" -> "cog"와 같이 4단계를 거쳐 변환할 수 있습니다.

두 개의 단어 begin, target과 단어의 집합 words가 매개변수로 주어질 때, 최소 몇 단계의 과정을 거쳐 begin을 target으로 변환할 수 있는지 return 하도록 solution 함수를 작성해주세요.

## Concept

음 잘 생각해보면 쉬운문제 같은데 일단 내가생각한 컨셉은

1. target 단어가 words 에 있는지 확인 [없으면 0 리턴 | 있으면 2로 Go]

2. words 를 begin 과 얼마차이안나는 순으로 sort 한다.

3. target 단어와 1개 차이나는 단어를 찾아 변환 

4. 변환한 단어가 begin 과 1개 차이날 시 결과 리턴 [아니라면 3과정으로 다시]

## 풀이코드

```java
import java.util.*;

public class 단어변환 {

    public static void main(String[] args) {
        String[] case1 = new String[]{"dog", "lot", "log", "cog", "hot", "hog"};
        String[] case2 = new String[]{"hot", "dot", "dog", "lot", "log"};
        String[] case3 = new String[]{"cog", "log"};
        Solution solution = new Solution();
        System.out.println(solution.solution("hit", "cog", case1));
    }

    static class Solution {
        static int answer = 1;
        static ArrayList<String> duplicateWords = new ArrayList<>();

        static Map<String, Integer> map = new LinkedHashMap<>();


        public int solution(String begin, String target, String[] words) {
            for(String word : words){
                map.put(word, getDifferentCount(begin, word));
            }
            map = sortMapByValue(map);
            int index = 0;
            for(String word : map.keySet()){
                words[index] = word;
                index++;
            }
            if(!isExistTarget(target, words)) {
                return 0;
            }
            findSimilarWord(begin, target, words, duplicateWords.size());
            return answer;
        }

        public boolean isExistTarget(String target, String[] words) {
            for(int j = 0; j < words.length; j++) {
                if(target.equals(words[j])) return true;
            }
            return false;
        }

        public void findSimilarWord(String begin, String word, String[] words, int preSize) {
            if(getDifferentCount(begin, word) == 1) {
                return;
            }
            for(String word_ : words) {
                if(getDifferentCount(word, word_) == 1) {
                    if(duplicateWords.contains(word_)){
                        continue;
                    }
                    answer++;
                    duplicateWords.add(word_);
                    findSimilarWord(begin, word_, words, duplicateWords.size());
                    break;
                }
            }

            if(preSize == duplicateWords.size()){
                answer = 0;
            }
        }

        public int getDifferentCount(String word, String word_) {
            int count = 0;
            for(int i = 0; i < word.length(); i++) {
                if(word.charAt(i) != word_.charAt(i)) {
                    count++;
                }
            }
            return count;
        }

        public LinkedHashMap<String, Integer> sortMapByValue(Map<String, Integer> map) {
            List<Map.Entry<String, Integer>> entries = new LinkedList<>(map.entrySet());
            Collections.sort(entries, (o1, o2) -> o1.getValue().compareTo(o2.getValue()));

            LinkedHashMap<String, Integer> result = new LinkedHashMap<>();
            for (Map.Entry<String, Integer> entry : entries) {
                result.put(entry.getKey(), entry.getValue());
            }
            return result;
        }
    }

}
```

