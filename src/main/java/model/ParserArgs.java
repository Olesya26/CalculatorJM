package model;

import java.util.List;

public class ParserArgs {
    private ReaderSystemArgs readerSystemArgs = new ReaderSystemArgs();
    public List<Integer> integerList;
    public List<String> symbolList;

    public ReaderSystemArgs getReaderSystemArgs() {
        return readerSystemArgs;
    }

    public void parserArgs() {
        readerSystemArgs.readerSystem();
        integerList = readerSystemArgs.getIntegerList();
        symbolList = readerSystemArgs.getSymbolList();
        checkInputData(readerSystemArgs.getInputData());
        check();
        checkMathematicsSymbol();
        checkNumberList();

    }

    private void checkInputData(String argsCmd) {
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

    private void check(){
        if (integerList.isEmpty() && symbolList.isEmpty()){
            throw new CalculatorException("Данные для вычисления отсутсвуют.");
        }
    }
}
