package model;

import mathematicalSimbols.MathematicalSymbols;
import mathematicalSimbols.RomanNumerals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ParserArgs {
    public List<Integer> integerList = new ArrayList<>();
    public List<String> symbolList = new ArrayList<>();
    private String argsCmd;

    public void parserArgs() {
        readerSystem();
        checkCmd(argsCmd);
        checkMathematicsSymbol();
        checkNumberList();
    }

    private void readerSystem() {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            String readLine = bufferedReader.readLine();
            argsCmd = readLine;
            for (MathematicalSymbols value : MathematicalSymbols.values()) {
                if (readLine.contains(value.symbol)) {
                    checkArgs(readLine, value.symbol, value.indexSymbol);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void checkArgs(String line, String s, int i) {
        String[] regex = {"\\+", "-", "/", "\\*"};
        symbolList.add(s);
        String[] strings = line.split(regex[i]);
        for (String str : strings) {
            if (str.matches("\\d*")) {
                int number = Integer.parseInt(str);
                integerList.add(number);
            } else if (str.matches("[IVX]+")) {
                parserArabicNumerals(str);
            } else {
                throw new CalculatorException("Введен некорректный символ: " + "'" + str + "'" + " Завершение программы.");
            }
        }
    }

    private void parserArabicNumerals(String str) {
        for (RomanNumerals value : RomanNumerals.values()) {
            if (str.equals(value.romanNumerals)) {
                int number = value.arabicNumerals;
                integerList.add(number);
            }
        }
    }

    private void checkCmd(String argsCmd) {
        if (argsCmd.matches("\\d+.\\D+") || argsCmd.matches("\\D+.\\d+")) {
            throw new CalculatorException("Введены недопустимые данные: " + "'" + argsCmd + "'" + " Завершение программы. \n" +
                    "Программа не работотает одновременно с римскими и арабскими цифрами.");
        }
    }

    private void checkMathematicsSymbol() {
        if (symbolList.isEmpty()) {
            throw new CalculatorException("Отсутствует математический знак. Завершение программы.");
        }
    }

    private void checkNumberList() {
        if (integerList.size() < 2) {
            throw new CalculatorException("Недостаточно данных для вычислений.");
        }
        for (Integer integer : integerList) {
            if (integer < 1 || integer > 10) {
                throw new CalculatorException("Введено неккоректное число: " + integer);
            }
        }
    }

    public void writerSystem(int result) {
        String[] roman = {"I", "V", "X", "L", "C"};
        for (String s : roman) {
            if (argsCmd.contains(s)) {
                parserArabicNumerals(result);
                break;
            } else {
                System.out.println(result);
                break;
            }
        }
    }

    private void parserArabicNumerals(int result) {
        String re = String.valueOf(result);
        char[] toCharArray = re.toCharArray();
        ArrayList<StringBuilder> builders = new ArrayList<>(toCharArray.length);
        for (char c : toCharArray) {
            builders.add(new StringBuilder().append(c));
        }
        if (builders.size() < 2 || re.contains("0")) {
            iteratorRomanNumerals(result);
        } else {
            builders.get(0).append("0");
            for (StringBuilder stringBuilder : builders) {
                for (RomanNumerals romanNumerals : RomanNumerals.values()) {
                    if (stringBuilder.toString().equals(String.valueOf(romanNumerals.arabicNumerals))) {
                        System.out.print(romanNumerals.romanNumerals);
                    }
                }
            }
        }
    }

    private void iteratorRomanNumerals(int result) {
        for (RomanNumerals romanNumerals : RomanNumerals.values()) {
            if (result == romanNumerals.arabicNumerals) {
                System.out.println(romanNumerals.romanNumerals);
            }
        }
    }
}
