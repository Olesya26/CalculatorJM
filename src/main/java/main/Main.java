package main;

import model.ParserArgs;
import model.ReaderSystemArgs;
import model.SimpleCalculator;
import model.WriterSystemArgs;

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
            parserArgs.parserArgs();
            SimpleCalculator simpleCalculator = new SimpleCalculator();
            int s = simpleCalculator.calculationNumbers(parserArgs.symbolList, parserArgs.integerList);
            WriterSystemArgs writerSystemArgs = new WriterSystemArgs();
            writerSystemArgs.writerSystem(s, parserArgs.getReaderSystemArgs());
        }
    }




