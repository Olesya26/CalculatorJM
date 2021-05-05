package main;

import model.ParserArgs;
import model.SimpleCalculator;

public class Main {

    public static void main(String[] args) {
        ParserArgs parserArgs = new ParserArgs();
        SimpleCalculator simpleCalculator = new SimpleCalculator();
        try {
            parserArgs.parserArgs();

            int s = simpleCalculator.calculationNumbers(parserArgs.symbolList, parserArgs.integerList);

            parserArgs.writerSystem(s);
        } catch (Exception e) {


        }

    }
}


