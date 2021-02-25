package Programmers.step3.추석트래픽;

public class 추석트래픽 {

    public static void main(String[] args) {
        String[] lines = {
                "2016-09-15 20:59:57.421 0.351s",
                "2016-09-15 21:00:00.966 0.381s",
                "2016-09-15 20:59:58.299 0.8s",
                "2016-09-15 20:59:58.688 1.041s",
                "2016-09-15 20:59:58.233 1.181s",
                "2016-09-15 20:59:59.591 1.412s",
                "2016-09-15 21:00:00.464 1.466s",
                "2016-09-15 21:00:00.741 1.581s",
                "2016-09-15 21:00:00.748 2.31s",
                "2016-09-15 21:00:02.066 2.62s"
        };

        String[] case2 = {"2016-09-15 01:00:04.002 2.0s", "2016-09-15 01:00:07.000 2s"};
        String[] case3 = {"2016-09-15 01:00:04.001 2.0s", "2016-09-15 01:00:07.000 2s"};

        Solution solution = new Solution();
        System.out.println(solution.solution(case3));
    }

    static class Solution {

        public static int SECOND = 1000;
        public static int MINUTE_TO_SECOND = 60;

        public int solution(String[] lines) {
            int answer = 0;
            int[] startTimes = new int[lines.length];
            int[] endTimes = new int[lines.length];
            convertToSecond(lines, startTimes, endTimes);

            answer = getAnswer(lines, answer, startTimes, endTimes);

            return answer;
        }

        private int getAnswer(String[] lines, int answer, int[] startTimes, int[] endTimes) {
            for(int i = 0; i < lines.length ; i++) {
                int task = 0;
                int startTime = endTimes[i];
                int endTime = startTime + 1000;

                for(int j = 0; j < lines.length ; j++) {
                    if(startTimes[j] >= startTime && startTimes[j] < endTime) {
                        task++;
                    } else if(endTimes[j] >= startTime && endTimes[j] < endTime) {
                        task++;
                    } else if(startTimes[j] <= startTime && endTimes[j] >= endTime) {
                        task++;
                    }
                }

                answer = Math.max(task, answer);
            }
            return answer;
        }

        private void convertToSecond(String[] lines, int[] startTimes, int[] endTimes) {
            for(int i = 0 ; i < lines.length ; i++) {
                String[] log = lines[i].split(" ");
                String[] responseTime = log[1].split(":");
                int processingTime = (int) (Double.valueOf(log[2].substring(0, log[2].length() - 1)) * SECOND);
                int startTime = 0;
                int endTime = 0;

                endTime += Integer.parseInt(responseTime[0]) * MINUTE_TO_SECOND * MINUTE_TO_SECOND * SECOND;
                endTime += Integer.parseInt(responseTime[1]) * MINUTE_TO_SECOND * SECOND;
                endTime += (int)(Double.parseDouble(responseTime[2]) * SECOND);
                startTime = endTime - processingTime + 1;

                startTimes[i] = startTime;
                endTimes[i] = endTime;
            }
        }
    }
}


