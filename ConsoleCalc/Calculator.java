package ConsoleCalc;

import java.util.Scanner;
import java.nio.charset.IllegalCharsetNameException;

public class Calculator {
    public static void main(String[] args) throws NullPointerException {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        calc(input);
    }
        public static String calc(String input){
        Converter converter=new Converter();
        int a, b;
        char operator;
        String[] parts = input.split(" ");
        operator = parts[1].charAt(0);
        int result;
        if(converter.isRoman(parts[0]) == converter.isRoman(parts[2])){
            boolean isRoman = converter.isRoman(parts[0]);
            if(isRoman){ 
                a = converter.romanToInt(parts[0]);
                b = converter.romanToInt(parts[2]);
            }else{
                a = Integer.parseInt(parts[0]);
                b = Integer.parseInt(parts[2]);
            }

        System.out.println();
        switch (operator) {
            case '+':
                result = a + b;
                break;
            case '-':
                result = a - b;
                break;
            case '*':
                result = a * b;
                break;
            case '/':
                result = a / b;
                break;
            default:
                throw new IllegalCharsetNameException("введен неверный оператор");
        }
            if (parts.length != 3) {
                throw new IllegalArgumentException("допустимы только 2 операнда и 1 оператор");
            }
        if (a < 0 || a > 11 || b < 0 || b > 11) {
            System.out.println("введите числа от 1 до 10");
            return input;
        }
            if (isRoman) {
                converter.intToRoman(result);
                if (result > 0) {
                    System.out.println(converter.intToRoman(result));
                } else {
                    throw new NullPointerException("результат не должен быть меньше 0 ");
                }
            }
            if(isRoman) {
                System.out.println(converter.intToRoman(result));
            }
            }else {
               throw new IllegalArgumentException("одновременно может использоваться только одна система счисления");
            }
            return input;
        }
    }