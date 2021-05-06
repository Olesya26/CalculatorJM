package mathematicalSimbols;

public enum RomanNumerals {
    ONE("I", 1),
    TWO("II", 2),
    THREE("III", 3),
    FOUR("IV", 4),
    FIVE("V", 5),
    SIX("VI", 6),
    SEVEN("VII", 7),
    EIGHT("VIII", 8),
    NINE("IX", 9),
    TEN("X", 10),
    TWENTY("XX", 20),
    THIRTY("XXX", 30),
    FORTY("XL", 40),
    FIFTY("L", 50),
    SIXTY("LX", 60),
    SEVENTY("LXX", 70),
    EIGHTY("LXXX", 80),
    NINETY("XC", 90),
    ONE_HUNDRED("C", 100);


    public final String romanNumeral;
    public final int arabicNumeral;

    RomanNumerals(String romanNumeral, int arabicNumeral) {
        this.arabicNumeral = arabicNumeral;
        this.romanNumeral = romanNumeral;
    }
}
