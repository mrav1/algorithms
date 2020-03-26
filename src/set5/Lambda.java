package set5;

public class Lambda {

    @FunctionalInterface
    interface StringOperation {
        String run(String input);
    }

    public static void main(String[] args) {
        StringOperation reverse = (input) -> {
            String reversed = "";
            for (int i = input.length() - 1; i >= 0; i--) {
                reversed += input.charAt(i);
            }
            return reversed;
        };

        System.out.println(taskRunner(reverse, "hello"));
    }

    private static String taskRunner(StringOperation task, String input) {
        return task.run(input);
    }

}
