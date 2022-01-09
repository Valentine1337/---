package com.javarush.task.pro.task09.task0908;

import java.util.regex.Pattern;

/* 
Двоично-шестнадцатеричный конвертер
*/

public class Solution {
    private static final String HEX = "0123456789abcdef";
    private static final String[] BINARY = {"0000", "0001", "0010", "0011", "0100", "0101", "0110", "0111", "1000", "1001",
    "1010", "1011", "1100", "1101", "1110", "1111"};

    public static void main(String[] args) {
        String binaryNumber = "100111010000";
        System.out.println("Двоичное число " + binaryNumber + " равно шестнадцатеричному числу " + toHex(binaryNumber));
        String hexNumber = "9d0";
        System.out.println("Шестнадцатеричное число " + hexNumber + " равно двоичному числу " + toBinary(hexNumber));
    }

    public static String toHex(String binaryNumber) {
        String hexNumber = "";
        int indexSubstring = 0;
        if (binaryNumber == "" || binaryNumber == null || !binaryNumber.matches("[0-1]+")) {
            return "";
        }
        StringBuffer sb = new StringBuffer(binaryNumber);
        while ((sb.length() % 4) != 0) {
            sb.setLength(sb.length() + 1);
            sb.setCharAt(sb.length() - 1, '0');
        }
        int numberOfSubstring = binaryNumber.length() / 4;
        for (int i = 0; i < numberOfSubstring; i++) {
            if (indexSubstring + 4 >= sb.length()) {
                String firstSubstring = sb.substring(indexSubstring);
                for (int j = 0; j < BINARY.length; j++) {
                    if (firstSubstring.equals(BINARY[j])) {
                        firstSubstring = HEX.charAt(j) + "";
                        hexNumber = hexNumber + firstSubstring;
                        break;
                    }
                }
            } else {
                String firstSubstring = sb.substring(indexSubstring, indexSubstring + 4);
                for (int j = 0; j < BINARY.length; j++) {
                    if (firstSubstring.equals(BINARY[j])) {
                        firstSubstring = HEX.charAt(j) + "";
                        hexNumber = hexNumber + firstSubstring;
                        break;
                    }
                }
            }
            indexSubstring += 4;
        }
        return hexNumber;
    }

    public static String toBinary(String hexNumber) {
        if (hexNumber == null || !hexNumber.matches("[0-9a-f]+")) {
            return "";
        }
        StringBuffer sb = new StringBuffer(hexNumber);
        String binaryNumber = "";
        for (int i = 0; i < sb.length(); i++) {
            String firstSubstring = sb.substring(i, i + 1);
            for (int j = 0; j < BINARY.length; j++) {
                String secondSubstring = HEX.substring(j, j + 1);
                if (firstSubstring.equals(secondSubstring)) {
                    binaryNumber = binaryNumber + BINARY[j];
                    break;
                }
            }
        }
        return binaryNumber;
    }
}
