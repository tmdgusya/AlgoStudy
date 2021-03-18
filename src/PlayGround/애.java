package PlayGround;

public class 애 {

    public static void main(String[] args) {

    }

    static class Example {

        @LoginCheck(role = {Role.ADMIN, Role.PERSON})
        public void xxx() {
            System.out.println();
        }
    }
}
