package level2;

public class Test {

    public static void main(String[] args) {

        int test = 7;
        int test2 = 8;
        String testStr = Integer.toBinaryString(test^test2);
        long count = testStr.chars()
                        .filter(c -> c == '1')
                                .count();
        System.out.println(Integer.toBinaryString(test^test2).getClass().getName());

        System.out.println(testStr);
        System.out.println(count);

    }

}
