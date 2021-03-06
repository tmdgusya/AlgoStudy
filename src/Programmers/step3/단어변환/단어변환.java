package Programmers.step3.단어변환;

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
            sortWords(begin, words);
            if(!isExistTarget(target, words)) {
                return 0;
            }
            findSimilarWord(begin, target, words, duplicateWords.size());
            return answer;
        }

        private void sortWords(String begin, String[] words) {
            for(String word : words){
                map.put(word, getDifferentCount(begin, word));
            }
            map = sortMapByValue(map);
            int index = 0;
            for(String word : map.keySet()){
                words[index] = word;
                index++;
            }
        }

        private boolean isExistTarget(String target, String[] words) {
            for(int j = 0; j < words.length; j++) {
                if(target.equals(words[j])) return true;
            }
            return false;
        }

        private void findSimilarWord(String begin, String word, String[] words, int preSize) {
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

        private int getDifferentCount(String word, String word_) {
            int count = 0;
            for(int i = 0; i < word.length(); i++) {
                if(word.charAt(i) != word_.charAt(i)) {
                    count++;
                }
            }
            return count;
        }

        private LinkedHashMap<String, Integer> sortMapByValue(Map<String, Integer> map) {
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
