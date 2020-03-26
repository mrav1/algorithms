package set1;

// Count opposite bits
public class HammingDistance {

    public static void main(String[] args) {
        System.out.println(hammingDistance(9, 2)); // 1001, 0010
    }

    public static int hammingDistance(int x, int y) {
        int z = x ^ y;
        int count = 0;
        while (z != 0) {
            count += z & 1;
            z >>= 1;
        }
        return count;
    }

}
