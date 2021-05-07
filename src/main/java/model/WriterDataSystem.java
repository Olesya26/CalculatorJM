package model;

import exception.CalculatorException;
import mathematicalSimbols.RomanNumerals;

import java.util.ArrayList;

public class WriterDataSystem {
    public void writerSystem(int result, ReaderDataSystem readerSystemArgs) {
        String inputData = readerSystemArgs.getInputLine();
        String[] romanNumerals = {"I", "V", "X", "L", "C"};
        for (String symbol : romanNumerals) {
            if (inputData.contains(symbol)) {
                if (result <= 0) {
                    throw new CalculatorException("Ноль или все что меньше него - это отсутсвие числа. " +
                            "А зачем записывать то, чего нет.\n" +
                            "P.S. Римляне. " + "\u2764");
                }
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
