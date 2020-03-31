package demo;

import java.util.Random;

public class RandomGenerator {
    private static String range = "1234567abcdef";

    public static synchronized String getRandomString() {

        Random random = new Random();

        StringBuffer result = new StringBuffer();

        for (int i = 0; i < 300; i++) {
            if(i % 30 == 0){
                System.out.println(result);
                System.out.println("-----------------------------------------------------------------------------------------------------------------------" );
                result.setLength(0);
                System.out.println("------------------------------------------------------------------------------------------------------------------" );

            }
            result.append(range.charAt(random.nextInt(range.length()))).append(" | ");


        }

        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(getRandomString());
    }
}
