package set4;

public class CanWin {

    public static void main(String[] args) {
        System.out.println(canWin(4));
    }

    private static boolean canWin(int n) {
        return n % 4 > 0;
    }

}
