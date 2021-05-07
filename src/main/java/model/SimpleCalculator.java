package model;

import mathematicalSimbols.MathematicalSymbols;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

public class SimpleCalculator extends Calculate {
    public int calculationNumbers(List<String> symbolList, List<Integer> numberList) throws InvocationTargetException, IllegalAccessException {
        int result = 0;
        for (MathematicalSymbols mathematicalSymbol : MathematicalSymbols.values()) {
            if (symbolList.get(0).equals(mathematicalSymbol.symbol)) {
                Method[] methods = SimpleCalculator.class.getMethods();
                for (Method method : methods) {
                    if (method.toString().contains(mathematicalSymbol.name().toLowerCase())) {
                        result = (int) method.invoke(this, numberList.get(0), numberList.get(1));
                    }
                }
            }
        }
        return result;
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
        return numberOne / numberTwo;
    }
}
