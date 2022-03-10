import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class RomeCalculator {
    public static void main(String[] args) {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            while (true) {
                System.out.print("Введите выражение: ");
                String userInput = br.readLine();
                if (userInput.toUpperCase().trim().equals("ВЫХОД"))
                    break;

                List<String> expression = Arrays.asList(userInput.split("\\s"));

                if (expression.size()!=3) {
                    throw new RuntimeException("Не верный формат!");
                }

                String firstNumber = expression.get(0);
                String secondNumber = expression.get(2);
                String operation = expression.get(1);

                if (!operation.matches("[+-/*]?+")) {
                    throw new RuntimeException("Не правильный оператор!");
                }

                if (Numbers.toRoman(firstNumber) && Numbers.toRoman(secondNumber)) {
                    System.out.println(Calculation.calculateRoman(expression.get(0), expression.get(2), operation));

                } else if (!Numbers.toRoman(firstNumber) && !Numbers.toRoman(secondNumber)) {
                    System.out.println(Calculation.calculateArabic(Integer.parseInt(firstNumber), Integer.parseInt(secondNumber), operation));

                } else {
                    throw new RuntimeException("Ошибка. Разные системы счисления!");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
