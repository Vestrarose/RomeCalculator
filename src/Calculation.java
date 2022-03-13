public class Calculation {

    public static String calculateRoman(String a, String b, String operator){

            int number1 = Numbers.romanToArabic(a);
            int number2 = Numbers.romanToArabic(b);
            int result = calculateArabic(number1, number2, operator);

            if (result < 1)
                throw new RuntimeException("Ошибка. В римской системе нет отрицательныых чисел");
            return Numbers.arabicToRoman(result);
    }

    public static int calculateArabic(int a, int b, String operator){

        if (!(a >=1 && a <= 10)){
            throw new RuntimeException("ОШИБКА. Число 1 должно быть от 1 до 10 или от I до X");
        }
        if (!(b >= 1 && b <=10)){
            throw new RuntimeException("ОШИБКА. Число 2 должно быть от 1 до 10 или от I до X");
        }

        try {
            return switch (operator) {
                case ("+") -> a + b;
                case ("-") -> a - b;
                case ("*") -> a * b;
                default -> a / b;
            };
        } catch (Exception e){
            System.out.println("Не верный оператор");
        }
        return a;
    }
}
