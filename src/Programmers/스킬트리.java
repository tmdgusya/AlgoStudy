package Programmers;

import java.util.Arrays;
import java.util.List;

public class 스킬트리 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] skillTree = {"BACDE", "CBADF", "AECB", "BDA", "CXF", "ASF", "BDF", "CEFD"};
        final int cbd = solution.solution("CBD", skillTree);
        System.out.println(cbd);
    }

    static class Solution {
        public int solution(String skill, String[] skill_trees) {
            int answer = 0;

            for(int i = 0; i < skill_trees.length; i++){
                String skill_tree = skill_trees[i];
                String skill_clone = new String(skill_tree);
                int size = skill_tree.length();
                for (int j =0;  j< size; j++) {
                    String oneSkill = String.valueOf(skill_clone.charAt(j));
                    if (!skill.contains(oneSkill)) {
                        skill_tree = skill_tree.replace(oneSkill, "");

                    }
                }
                if (skill.indexOf(skill_tree) == 0) {
                    answer++;
                }
            }
            return answer;
        }
    }
}
