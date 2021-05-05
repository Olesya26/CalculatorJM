package mathematicalSimbols;

public enum MathematicalSymbols {
    ADDITION("+", 0),
    SUBTRACTION("-", 1),
    DIVISION("÷", 2),
    MULTIPLICATION("*", 3);

    public final String symbol;
    public final int indexSymbol;

    MathematicalSymbols(String symbol, int indexSymbol) {
        this.symbol = symbol;
        this.indexSymbol = indexSymbol;
    }
}
