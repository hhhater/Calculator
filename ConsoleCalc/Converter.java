package ConsoleCalc;

import java.util.TreeMap;

public class Converter {
    TreeMap<Character, Integer> roman = new TreeMap<>();
    TreeMap<Integer, String> arabic = new TreeMap<>();

     Converter() {
        roman.put('I', 1);
        roman.put('V', 5);
        roman.put('X', 10);
        roman.put('L', 50);
        roman.put('C', 100);
        roman.put('D', 500);
        roman.put('M', 1000);

        arabic.put(1000, "M");
        arabic.put(900, "CM");
        arabic.put(500, "D");
        arabic.put(400, "CD");
        arabic.put(100, "C");
        arabic.put(90, "XC");
        arabic.put(50, "L");
        arabic.put(40, "XL");
        arabic.put(10, "X");
        arabic.put(9, "IX");
        arabic.put(5, "V");
        arabic.put(4, "IV");
        arabic.put(1, "I");

    }


    boolean isRoman(String number){
         return roman.containsKey(number.charAt(0));
    }
    String intToRoman(int number) {
        String roman = "";
        int arabicKey;
        do {
            arabicKey = arabic.floorKey(number);
            roman += arabic.get(arabicKey);
            number -= arabicKey;
        } while (number != 0);
        return roman;
    }

     int romanToInt(String s) {
        int end = s.length() - 1;
        char[] arr = s.toCharArray();
        int arabic;
        int result = roman.get(arr[end]);
        for (int i = end - 1; i >= 0; i--) {
            arabic = roman.get(arr[i]);

            if (arabic < roman.get(arr[i + 1])) {
                result -= arabic;
            } else {
                result += arabic;
            } }
        return result;
    }
}
