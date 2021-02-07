package test;

import java.text.SimpleDateFormat;
import java.util.*;

public class Exam01 {

    public static void main(String[] args) {
        final String[] recipes = {"SPAGHETTI 3", "FRIEDRICE 2", "PIZZA 8"}; // MENU COOKING TIME
        final String[] orders = {"PIZZA 1", "FRIEDRICE 2", "SPAGHETTI 4", "SPAGHETTI 6", "PIZZA 7", "SPAGHETTI 8"}; // MENU_NAME ORDER_TIME
        Solution solution = new Solution();
        final int solution1 = solution.solution(3, recipes, orders);
        System.out.println(solution1);
    }

    static class Solution {
        public int solution(int n, String[] recipes, String[] orders) {
            int answer = 0;

            HashMap<String, Integer> menuInfo = new HashMap<>();
            Queue<String> orderQueue = new LinkedList<>();
            ArrayList<Shief> shiefs = new ArrayList<>();
            ArrayList<Integer> times = new ArrayList<>();

            for(String menu : recipes){
                 String name = menu.split(" ")[0];
                 Integer time = Integer.parseInt(menu.split(" ")[1]);
                 menuInfo.put(name, time);
            }
            orderQueue.addAll(Arrays.asList(orders));

            for(int i = 0; i < n; i++){
                shiefs.add(new Shief());
            }

            while(!orderQueue.isEmpty()){
                for(int i = 0; i < n; i++){
                    Shief shief = shiefs.get(i);
                    String order = orderQueue.poll();
                    String menu = order.split(" ")[0];
                    Integer time = Integer.parseInt(order.split(" ")[1]);
                    Integer cookingTime = menuInfo.get(menu);
                    if(shief.getTime() == 0){
                        shief.setTime(time);
                    }
                    if(shief.getTime() > 0){
                        shief.setTime(cookingTime);
                    }
                    if(shief.getTime() <= time){
                        shief.setTime(cookingTime);
                    }
                    times.add(shief.getTime());
                }
            }
            Collections.sort(times);
            Collections.reverse(times);
            answer = times.get(0);
            return answer;
        }
    }

    static class Shief {
        int time = 0;

        public void setTime(int time) {
            this.time += time;
        }

        public int getTime() {
            return time;
        }
    }


}
