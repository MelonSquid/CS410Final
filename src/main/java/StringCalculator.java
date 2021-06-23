public class StringCalculator {
    public static int add(final String numbers) {
        int returnValue = 0;
        String[] numbersArray = numbers.split(",|\n");
        for (String number : numbersArray) {
            if (!number.trim().isEmpty()) {
                int nextInt = Integer.parseInt(number.trim());

                //exception throwing
                if (nextInt < 0) {
                    throw new IllegalArgumentException("Negatives not allowed");
                }

                //ignoring big numbers
                if(nextInt < 1000) {
                    returnValue += nextInt;
                }
            }
        }
        return returnValue;
    }
}