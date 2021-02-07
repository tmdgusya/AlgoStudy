package test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Exam03 {

    public static void main(String[] args) throws ParseException {
        final String[] strings = {"01/14", "01/15", "01/18", "01/22", "01/23", "01/29", "02/01", "02/03", "02/07"};
        Solution solution = new Solution();
        System.out.println(solution.solution(strings, 1));
    }

    static class Solution {
        public int solution(String[] holidays, int k) throws ParseException {
            int answer = 0;
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
            Calendar c = Calendar.getInstance();
            ArrayList<Integer> countlist = new ArrayList<>();
            for(int i = 0; i < holidays.length-1; i++){
                Date date = sdf.parse("2021/"+holidays[i]);
                c.setTime(date);
                c.add(Calendar.DATE, 1);
                String nextDate = sdf.format(c.getTime());
                int idx = i;
                int count = 1;
                while(c.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY || c.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY)
                {
                    count++;
                    c.add(Calendar.DATE, 1);
                }
                while((nextDate.equals("2021/"+holidays[i+1]))){
                    idx++;
                    c.add(Calendar.DATE, 1);
                    count++;
                    while(c.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY || c.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY)
                    {
                        count++;
                        c.add(Calendar.DATE, 1);
                    }
                    nextDate = sdf.format(c.getTime());
                    if(nextDate.equals("2021/"+holidays[idx+1])){
                        count++;
                    }
                }
                countlist.add(count);
                int index = 0;
                for (String a : holidays){
                    if(a.equals(sdf.format(c.getTime()).split("2021/")[1])){
                        i = index;
                        break;
                    }
                    index++;
                }
            }
            for(int i : countlist){
                if(i >= k){
                    answer++;
                }
            }
            return answer;
        }
    }
}
