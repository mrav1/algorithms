package set5;

public class OverrideStaticMethod {

    public static void main(String[] args) {
        OverrideStaticMethod s1 = new Class2();
        s1.test1();
        s1.test2();
    }

    public static void test1() {
        System.out.println("HI-1");
    }

    public void test2() {
        System.out.println("HI-11");
    }
}

class Class2 extends OverrideStaticMethod {

    public static void test1() {
        System.out.println("HI-2");
    }

    public void test2() {
        System.out.println("HI-22");
    }

}