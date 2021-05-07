package model;

import exception.CalculatorException;
import mathematicalSimbols.MathematicalSymbols;
import mathematicalSimbols.RomanNumerals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ReaderDataSystem {
    private BufferedReader bufferedReader;
    private String inputLine;
    private List<Integer> integerList = new ArrayList<>();
    private List<String> symbolList = new ArrayList<>();

    BufferedReader getBufferedReader() {
        return bufferedReader;
    }

    List<Integer> getIntegerList() {
        return integerList;
    }

    List<String> getSymbolList() {
        return symbolList;
    }

    public String getInputLine() {
        return inputLine;
    }

    void readerSystem() throws IOException {
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String readLine = bufferedReader.readLine();
        inputLine = readLine;
        for (MathematicalSymbols value : MathematicalSymbols.values()) {
            if (readLine.contains(value.symbol)) {
                checkInputSymbols(readLine, value.symbol, value.indexSymbol);
            }
        }
    }

    private void checkInputSymbols(String lineInputData, String mathematicalSymbol, int indexMathematicalSymbol) {
        symbolList.add(mathematicalSymbol);
        String[] arrayInputSymbols = createStringArray(lineInputData, indexMathematicalSymbol);
        for (String symbol : arrayInputSymbols) {
            if (symbol.matches("\\d*")) {
                int number = Integer.parseInt(symbol);
                integerList.add(number);
            } else if (symbol.matches("[IVX]+")) {
                parserArabicNumerals(symbol);
            } else {
                throw new CalculatorException("Введен некорректный символ: " + "'" +
                        symbol + "'" + " Завершение программы.");
            }
        }
    }

    private String[] createStringArray(String lineInputData, int indexMathematicalSymbol) {
        String[] regex = {"\\+", "-", "/", "\\*"};
        String[] arrayInputSymbols;
        if (lineInputData.contains(" ")) {
            String replaceAll = lineInputData.replaceAll("\\s", "");
            arrayInputSymbols = replaceAll.split(regex[indexMathematicalSymbol]);
        } else {
            arrayInputSymbols = lineInputData.split(regex[indexMathematicalSymbol]);
        }
        return arrayInputSymbols;
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
