package main;

import model.*;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) {
        try {
            calculate();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    private static void calculate() throws IOException, InvocationTargetException, IllegalAccessException {
        boolean start = true;
        while (start) {
            CheckingInputData checkingData = new CheckingInputData();
            checkingData.checkAndParseData();
            if (checkingData.getReaderSystemData().getInputLine().equalsIgnoreCase("exit")) {
                start = false;
            } else {
                SimpleCalculator calculator = new SimpleCalculator();
                int result = calculator.calculationNumbers(checkingData.symbolList, checkingData.integerList);
                WriterDataSystem writerSystemData = new WriterDataSystem();
                writerSystemData.writerSystem(result, checkingData.getReaderSystemData());
            }
        }
    }
}




