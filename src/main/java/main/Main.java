package main;

import model.ParserArgs;
import model.SimpleCalculator;

public class Main {

    public static void main(String[] args) {
        try {
            calculate();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }


    private static void calculate() {
        ParserArgs parserArgs = new ParserArgs();
        SimpleCalculator simpleCalculator = new SimpleCalculator();
        parserArgs.parserArgs();
        int s = simpleCalculator.calculationNumbers(parserArgs.symbolList, parserArgs.integerList);
        parserArgs.writerSystem(s);

    }
}




