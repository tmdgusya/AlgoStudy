package CodeSquad.Week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Back1076 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, String> colorsHashMap = createColorsHashMap();
        long result[] = new long[3];
        long answer;
        for(int i = 0; i<3; i++){
            String color = br.readLine();
            String colorCharacteristic = colorsHashMap.get(color);
            if(i < 2){
                result[i] = Long.parseLong(colorCharacteristic.split(" ")[0]);
            }else{
                result[i] = Long.parseLong(colorCharacteristic.split(" ")[1]);
            }
        }
        answer = (result[0]*10 + result[1])*result[2];
        System.out.println(answer);
    }

    private static HashMap<String, String> createColorsHashMap() {
        HashMap<String, String> Om = new HashMap<>();

        Om.put("black", "0 1");
        Om.put("brown", "1 10");
        Om.put("red", "2 100");
        Om.put("orange", "3 1000");
        Om.put("yellow", "4 10000");
        Om.put("green", "5 100000");
        Om.put("blue", "6 1000000");
        Om.put("violet", "7 10000000");
        Om.put("grey", "8 100000000");
        Om.put("white", "9 1000000000");

        return Om;
    }
}
