package BackjunJudge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Back7568 {

    static class Person implements Comparable<Person> {
        int weight;
        int tall;
        int rank;

        public Person(int weight, int tall) {
            this.weight = weight;
            this.tall = tall;
            this.rank = 1;
        }

        @Override
        public int compareTo(Person o) {
            if(o.weight > this.weight && o.tall > this.tall){
                return -1;
            }else{
                return 0;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        int N;
        Person[] people;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bufferedReader.readLine());
        people = new Person[N];

        for(int i = 0; i < N; i++){
            final String[] s = bufferedReader.readLine().split(" ");
            int weight = Integer.parseInt(s[0]);
            int tall = Integer.parseInt(s[1]);
            Person person = new Person(weight, tall);
            people[i] = person;
        }

        for (int i = 0; i < N; i++){
            for (int j = 0; j < N; j++){
                if(people[i].compareTo(people[j]) == -1){
                    people[i].rank++;
                }
            }
        }

        for (Person p : people){
            System.out.println(p.rank);
        }

    }

}
