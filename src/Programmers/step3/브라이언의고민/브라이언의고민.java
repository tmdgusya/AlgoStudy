package Programmers.step3.브라이언의고민;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class 브라이언의고민 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String case1 = "♚프☆렌☆즈☆레☆이☆싱♚★사전예약★진행중\n" +
                "$지금$예약시♜이모티콘♜100%※증정※\n" +
                "★라이언★카트♨전원♨획@득@기@회\n" +
                "즉시이동 http://...";
        String case2 = "HaEaLaLaObWORLDb";
        String case3 = "SpIpGpOpNpGJqOqA";

        System.out.println(solution.solution(case1));
    }

    static class Solution {

        static Set<Character> blockingwords = new HashSet<>();

        public String solution(String message) {
            final String[] sentence = message.split("\n");
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < sentence.length; i++) {
                sb.append(searchBlockingCharacterPre(searchBlockingCharacter(sentence[i])));
                if(i != sentence.length - 1){
                    sb.append(" ");
                }
            }
            return sb.toString();
        }

        public String searchBlockingCharacterPre(String sentence) {
            StringBuilder sb = new StringBuilder();
            final char[] words = sentence.toCharArray();
            for(int currentPlacePutWord = 0; currentPlacePutWord < words.length; currentPlacePutWord++) {
                if (duplicateWord(sb, words, currentPlacePutWord)) continue;
                if(sentence.lastIndexOf(words[currentPlacePutWord]) != -1 && words[currentPlacePutWord] != '\0'
                        && (Character.isLowerCase(words[currentPlacePutWord]) || !Character.isAlphabetic(words[currentPlacePutWord]))){
                    int otherPlacePutWord = sentence.lastIndexOf(words[currentPlacePutWord]);
                    if(currentPlacePutWord != otherPlacePutWord){
                        words[currentPlacePutWord] = '\0';
                        words[otherPlacePutWord] = '\0';
                    }
                }
                if(words[currentPlacePutWord] == '\0'){
                    continue;
                }
                sb.append(words[currentPlacePutWord]);
            }
            return sb.toString();
        }

        private boolean duplicateWord(StringBuilder sb, char[] words, int currentPlacePutWord) {
            if(currentPlacePutWord + 1 < words.length){
                if(words[currentPlacePutWord] == words[currentPlacePutWord + 1]){
                    sb.append(words[currentPlacePutWord]);
                    return true;
                }
            }
            return false;
        }

        public String searchBlockingCharacter(String sentence) {
            StringBuilder sb = new StringBuilder();
            final char[] words = sentence.toCharArray();
            int nextBlockingChar = -10;
            for(int i = 0; i < words.length; i++) {
                if (duplicateWord(sb, words, i)) continue;
                if(i + 2 < words.length) {
                    if (words[i] == words[i + 2] && (Character.isLowerCase(words[i]) || Character.isBmpCodePoint(words[i]))) {
                        if(!blockingwords.contains(words[i]) && blockingwords.size() > 1){
                            words[i - 2] = ' ';
                        }
                        blockingwords.add(words[i]);
                        words[i] = '\0';
                        nextBlockingChar = i + 2;
                    }
                }
                if (nextBlockingChar == i) {
                    words[nextBlockingChar] = '\0';
                }
                if(words[i] == '\0'){
                    continue;
                }
                sb.append(words[i]);
            }
            return sb.toString();
        }
    }
}
