package mathematicalSimbols;

enum RomanNumerals {
    ONE("I", 1),
    TWO("II", 2),
    THREE("III", 3),
    FOUR("IV", 4),
    FIVE("V", 5),
    SIX("VI", 6),
    SEVEN("VII", 7),
    EIGHT("VII", 8),
    NINE("IX", 9),
    TEN("X", 10);


    public final String romanNumerals;
    public final int arabicNumerals;

    RomanNumerals(String romanNumerals, int arabicNumerals) {
        this.arabicNumerals = arabicNumerals;
        this.romanNumerals = romanNumerals;
    }
}
