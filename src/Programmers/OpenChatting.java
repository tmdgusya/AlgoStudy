package Programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class OpenChatting {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] testCase1 = new String[]{"Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan"};
        System.out.println(Arrays.toString(solution.solution(testCase1)));
    }

    static class Solution {
        public String[] solution(String[] record) {
            HashMap<String, String> userMap = new HashMap<>();
            ArrayList<String> Message = new ArrayList<>();
            String[] answer = {};
            for(String user : record){
                if(user.split(" ")[0].equals("Enter") || user.split(" ")[0].equals("Change")){
                    String id = user.split(" ")[1];
                    String name = user.split(" ")[2];
                    userMap.put(id, name);
                }
            }
            for(String user : record){
                String id = user.split(" ")[1];
                String enterUserName = userMap.get(id);
                if(user.split(" ")[0].equals("Enter")){
                    Message.add(enterUserName+"님이 들어왔습니다.");
                }
                if(user.split(" ")[0].equals("Leave")){
                    Message.add(enterUserName+"님이 나갔습니다.");
                }
            }
            answer = Message.toArray(new String[0]);
            return answer;
        }
    }

}
