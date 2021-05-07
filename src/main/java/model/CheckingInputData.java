package model;

import exception.CalculatorException;

import java.io.IOException;
import java.util.List;

public class CheckingInputData {
    public List<Integer> integerList;
    public List<String> symbolList;
    private ReaderDataSystem readerSystemData = new ReaderDataSystem();

    public ReaderDataSystem getReaderSystemData() {
        return readerSystemData;
    }

    public void checkAndParseData() throws IOException {
        try {
            readerSystemData.readerSystem();
            integerList = readerSystemData.getIntegerList();
            symbolList = readerSystemData.getSymbolList();
            checkingIsExit();

        } catch (IOException e) {
            e.printStackTrace();
            readerSystemData.getBufferedReader().close();
        }
    }

    private void checkingIsExit() throws IOException {
        if (readerSystemData.getInputLine().equalsIgnoreCase("exit")) {
            readerSystemData.getBufferedReader().close();
            System.out.println("Программа завершена.");
        } else {
            checkingListData();
            checkInputLine(readerSystemData.getInputLine());
            checkInputMathematicsSymbol();
            checkInputNumeralList();
        }
    }

    private void checkingListData() {
        if (integerList.isEmpty() && symbolList.isEmpty()) {
            throw new CalculatorException("Данные для вычисления отсутсвуют. Завершение программы.");
        }
    }

    private void checkInputLine(String inputLine) {
        if (inputLine.matches("\\d+.\\D+") || inputLine.matches("\\D+.\\d+")) {
            throw new CalculatorException("Введены недопустимые данные: " + "'" + inputLine +
                    "'" + " Завершение программы. \n" +
                    "Программа не работотает одновременно с римскими и арабскими цифрами.");
        }
    }

    private void checkInputMathematicsSymbol() {
        if (symbolList.isEmpty()) {
            throw new CalculatorException("Отсутствует математический знак. Завершение программы.");
        }
    }

    private void checkInputNumeralList() {
        if (integerList.size() < 2) {
            throw new CalculatorException("Недостаточно данных для вычислений. Завершение программы");
        }
        for (Integer integer : integerList) {
            if (integer < 1 || integer > 10) {
                throw new CalculatorException("Введено неккоректное число: " + integer + ". Завершение программы.");
            }
        }
    }
}
