package model;

import mathematicalSimbols.MathematicalSymbols;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ParserArgs {
    public List<Integer> integerList = new ArrayList<>();
    public List<String> symbolList = new ArrayList<>();

    public void parserArgs() {
        readerSystem();
        checkMathematicsSymbol();
        checkNumberList();
    }

    private void readerSystem() {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            String readLine = bufferedReader.readLine();
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
            } else {
                System.err.println("Введены некорректные данные: " + "'" + str + "'" + " Завершение программы.");
                throw new RuntimeException();
            }
        }
    }

    private void parserArabicNumerals() {
    }

    private void checkMathematicsSymbol() {
        if (symbolList.isEmpty()) {
            System.err.print("Веденные не верные данные, отсутствует математический знак. Завершение программы.");
        }
    }

    private void checkNumberList() {
        if (integerList.size() < 2) {
            System.err.println("Недостаточно данных для вычислений. \n");
        }

        for (Integer integer : integerList) {
            if (integer < 1 || integer > 10) {
                System.err.println("Введено неккоректное число: " + integer);
                throw new RuntimeException();
            }
        }
    }

    public void writerSystem(int result) {
        System.out.println(result);

    }
}
