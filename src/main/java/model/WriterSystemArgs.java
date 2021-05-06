package model;

import mathematicalSimbols.RomanNumerals;

import java.util.ArrayList;

public class WriterSystemArgs {
    public void writerSystem(int result, ReaderSystemArgs readerSystemArgs) {
        String inputData = readerSystemArgs.getInputData();
        String[] roman = {"I", "V", "X", "L", "C"};
        for (String s : roman) {
            if (inputData.contains(s)) {
                parserArabicNumerals(result);
                break;
            } else {
                System.out.println(result);
                break;
            }
        }
    }

    private void parserArabicNumerals(int outputNumber) {
        String result = String.valueOf(outputNumber);
        char[] resultCharArray = result.toCharArray();
        ArrayList<StringBuilder> listOfResultNumbers = new ArrayList<>(resultCharArray.length);
        for (char symbol : resultCharArray) {
            listOfResultNumbers.add(new StringBuilder().append(symbol));
        }
        if (listOfResultNumbers.size() < 2 || result.contains("0")) {
            iteratorRomanNumerals(outputNumber);
        } else {
            listOfResultNumbers.get(0).append("0");
            for (StringBuilder symbolResult : listOfResultNumbers) {
                for (RomanNumerals numeral : RomanNumerals.values()) {
                    if (symbolResult.toString().equals(String.valueOf(numeral.arabicNumeral))) {
                        System.out.print(numeral.romanNumeral);
                    }
                }
            }
        }
    }

    private void iteratorRomanNumerals(int outputNumber) {
        for (RomanNumerals numeral : RomanNumerals.values()) {
            if (outputNumber == numeral.arabicNumeral) {
                System.out.println(numeral.romanNumeral);
            }
        }
    }
}
