package Programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class 순위검색 {

    public static void main(String[] args) {
        String[] info = {"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150",
                "cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"};
        String[] query = {"java and backend and junior and pizza 100","python and frontend and senior and chicken 200",
                "cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"};
        int[] expectedData = {1,1,1,1,2,4};

        Solution solution = new Solution();
        final int[] solution1 = solution.solution(info, query);
        System.out.println(Arrays.toString(solution1));
    }

    static class Solution {
        public int[] solution(String[] info, String[] query) {
            int[] answer;
            ArrayList<Candidate> candidateList = new ArrayList<>();
            ArrayList<Candidate> queryList = new ArrayList<>();
            HashMap<Integer, Integer> matchCountList = new HashMap();
            for (String information : info){
                String[] s = information.split(" ");
                candidateList.add(new Candidate(s[0], s[1], s[2], s[3], Integer.parseInt(s[4])));
            }

            for(String query_ : query){
                String[] s = query_.replace("and ", "").split(" ");
                queryList.add(new Candidate(s[0], s[1], s[2], s[3], Integer.parseInt(s[4])));
            }

            for(int i = 0; i < queryList.size(); i++){
                Candidate query_ = queryList.get(i);
                for(int j = 0; j < candidateList.size(); j++){
                    Candidate candidate = candidateList.get(j);
                    if(!query_.getCarrer().equals("-")){
                        if(!query_.getCarrer().equals(candidate.getCarrer()))
                            continue;
                    }
                    if(!query_.getLang().equals("-")){
                        if(!query_.getLang().equals(candidate.getLang()))
                            continue;

                    }
                    if(!query_.getFavoriteFood().equals("-")){
                        if(!query_.getFavoriteFood().equals(candidate.getFavoriteFood()))
                            continue;
                    }
                    if(!query_.getSubject().equals("-")){
                        if(!query_.getSubject().equals(candidate.getSubject()))
                            continue;
                    }
                    if(query_.score <= candidate.score){
                        if(matchCountList.size()-1 == i){
                            Integer integer = matchCountList.get(i);
                            matchCountList.put(i, ++integer);
                        }else{
                            matchCountList.put(i, 1);
                        }
                    }
                }
                if(matchCountList.size() < i){
                    matchCountList.put(i, 0);
                }
            }
            answer = new int[matchCountList.size()];
            for(int i = 0; i < matchCountList.size(); i++){
                answer[i] = matchCountList.get(i);
            }

            return answer;
        }
    }



    static class Candidate {
        String lang;
        String subject;
        String carrer;
        String favoriteFood;
        int score;

        public Candidate(String lang, String subject, String carrer, String favoriteFood, int score) {
            this.lang = lang;
            this.subject = subject;
            this.carrer = carrer;
            this.favoriteFood = favoriteFood;
            this.score = score;
        }

        public String getLang() {
            return lang;
        }

        public String getSubject() {
            return subject;
        }

        public String getCarrer() {
            return carrer;
        }

        public String getFavoriteFood() {
            return favoriteFood;
        }

        public int getScore() {
            return score;
        }
    }
}
