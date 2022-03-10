import java.util.HashMap;
import java.util.Map;

public class Numbers {

    public static boolean toRoman(String s) {
        return s.matches("[CLXVI]+");
    }

    public static String arabicToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        int times;
        String[] romans = new String[] { "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X" };
        int[] ints = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        for (int i = ints.length - 1; i >= 0; i--) {
            times = num / ints[i];
            num %= ints[i];
            while (times > 0) {
                sb.append(romans[i]);
                times--;
            }
        }
        return sb.toString();
    }

    private static final Map<String, Integer> roman = new HashMap<>()
    {{
        put("I", 1);
        put("II", 2);
        put("III", 3);
        put("IV", 4);
        put("V", 5);
        put("VI", 6);
        put("VII", 7);
        put("VIII", 8);
        put("IX", 9);
        put("X", 10);
    }};

    public static Integer romanToArabic(String s)
    {
        if (roman.containsKey(s)){
            return roman.get(s);
        }
        else {
            throw new RuntimeException("Не соответствует римской системе счилсения");
        }
    }
}
