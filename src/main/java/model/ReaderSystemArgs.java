package model;

import mathematicalSimbols.MathematicalSymbols;
import mathematicalSimbols.RomanNumerals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ReaderSystemArgs {
    private List<Integer> integerList = new ArrayList<>();
    private List<String> symbolList = new ArrayList<>();
    private String inputData;

    List<Integer> getIntegerList() {
        return integerList;
    }

    List<String> getSymbolList() {
        return symbolList;
    }

    String getInputData() {
        return inputData;
    }

    void readerSystem() {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            String readLine = bufferedReader.readLine();
            inputData = readLine;
            for (MathematicalSymbols value : MathematicalSymbols.values()) {
                if (readLine.contains(value.symbol)) {
                    checkInputSymbols(readLine, value.symbol, value.indexSymbol);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void checkInputSymbols(String lineInputData, String mathematicalSymbol, int indexMathematicalSymbol) {
        String[] regex = {"\\+", "-", "/", "\\*"};
        symbolList.add(mathematicalSymbol);
        String[] arrayInputSymbols = lineInputData.split(regex[indexMathematicalSymbol]);
        for (String symbol : arrayInputSymbols) {
            if (symbol.matches("\\d*")) {
                int number = Integer.parseInt(symbol);
                integerList.add(number);
            } else if (symbol.matches("[IVX]+")) {
                parserArabicNumerals(symbol);
            } else {
                throw new CalculatorException("Введен некорректный символ: " + "'" + symbol + "'" + " Завершение программы.");
            }
        }
    }

    private void parserArabicNumerals(String symbol) {
        for (RomanNumerals numeral : RomanNumerals.values()) {
            if (symbol.equals(numeral.romanNumeral)) {
                int number = numeral.arabicNumeral;
                integerList.add(number);
            }
        }
    }
}
