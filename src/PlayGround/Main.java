package PlayGround;

import java.util.HashMap;
import java.util.HashSet;
import java.util.concurrent.ConcurrentHashMap;

public class Main {

    public static void main(String[] args) {
        ObservableSet<Integer> set = new ObservableSet<>(new HashSet<>());

//        set.addObserver((s,e) -> System.out.println(e));

        set.addObserver(new SetObserver<Integer>() {
            @Override
            public void added(ObservableSet<Integer> s, Integer element) {
                System.out.println(element + " setObserver");
                if(element == 23) {
                    s.removeObservers(this);
                }
            }
        });

        for(int i = 0; i < 100; i++){
            set.add(i);
        }
    }
}
