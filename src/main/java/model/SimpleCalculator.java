package model;

import mathematicalSimbols.MathematicalSymbols;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

public class SimpleCalculator extends Calculate {
    public int calculationNumbers(List<String> symbolList, List<Integer> numberList) {
        for (MathematicalSymbols symbols : MathematicalSymbols.values()) {
            if (symbolList.get(0).equals(symbols.symbol)) {
                Method[] methods = SimpleCalculator.class.getMethods();
                for (Method method : methods) {
                    if (method.toString().contains(symbols.name().toLowerCase())) {
                        try {
                            return (int) method.invoke(this, numberList.get(0), numberList.get(1));
                        } catch (IllegalAccessException | InvocationTargetException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        return 0;
    }

    @Override
    public int additionNumbers(int numberOne, int numberTwo) {
        return numberOne + numberTwo;
    }

    @Override
    public int subtractionNumbers(int numberOne, int numberTwo) {
        return numberOne - numberTwo;
    }

    @Override
    public int multiplicationNumbers(int numberOne, int numberTwo) {
        return numberOne * numberTwo;
    }

    @Override
    public int divisionNumbers(int numberOne, int numberTwo) {
        if (numberTwo == 0) {
            System.err.println("Деление на 0 невозможно.");
        }
        return numberOne / numberTwo;
    }
}
