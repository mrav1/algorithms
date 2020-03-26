package set5;

public class NumberToWords {

    static String one[] = {"", "one ", "two ", "three ", "four ",
            "five ", "six ", "seven ", "eight ",
            "nine ", "ten ", "eleven ", "twelve ",
            "thirteen ", "fourteen ", "fifteen ",
            "sixteen ", "seventeen ", "eighteen ",
            "nineteen "
    };

    static String ten[] = {"", "", "twenty ", "thirty ", "forty ",
            "fifty ", "sixty ", "seventy ", "eighty ",
            "ninety "
    };

    public static void main(String[] args) {
        long n = 898712345;
        System.out.println(n);
        System.out.println(numberToWords(n));
    }

    private static String numberToWords(long n) {
        String o = "";
        // handles digits at ten millions and hundred
        // millions places (if any)
        o += numToWord((int) (n / 10000000), "crore ");
        System.out.println("crore="+n / 10000000);
        // handles digits at hundred thousands and one
        // millions places (if any)
        //Take take first two digits after division
        o += numToWord((int) ((n / 100000) % 100), "lakh ");
        System.out.println("lakh="+(n / 100000)+", "+(n / 100000) % 100);
        // handles digits at thousands and tens thousands
        // places (if any)
        //Take take first two digits after division
        o += numToWord((int) ((n / 1000) % 100), "thousand ");
        System.out.println("thousand="+(n / 1000)+", "+(n / 1000) % 100);

        // handles digit at hundreds places (if any)
        //Take take first one digits after division
        o += numToWord((int) ((n / 100) % 10), "hundred ");

        if (n > 100 && n % 100 > 0) {
            o += "and ";
        }

        // handles digits at ones and tens places (if any)
        o += numToWord((int) (n % 100), "");

        return o;
    }

    //["", "one ",..."ninteen "]
    //["", "", "twenty ",..."ninety"]
    private static String numToWord(int n, String s) {
        String str = "";
        if (n > 19) {
            str += ten[n / 10] + one[n % 10]; //23 ten[2]="twenty " one[1]="one "
        } else {
            str += one[n]; // 8 one[8]="eight "
        }

        if (n != 0) {
            str += s;
        }
        return str;
    }
}
