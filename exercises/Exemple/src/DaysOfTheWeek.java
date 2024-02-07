public enum DaysOfTheWeek {
    SUNDAY("Domingo"),
    MONDAY("Segunda"),
    TUESDAY("Terca"),
    WEDNESDAY("Quarta"),
    THURSDAY("Quinta"),
    FRIDAY("Sexta"),
    SATURDAY("Sabado");

    private String daysInPortuguese;

    DaysOfTheWeek(String daysInPortuguese) {
        this.daysInPortuguese = daysInPortuguese;
    }

    public String getDaysInPortuguese() {
        return this.daysInPortuguese;
    }

    public static String translateAll() {
        String allTranslated = "The days in Portuguese: ";

        for (DaysOfTheWeek week : DaysOfTheWeek.values()) {
            allTranslated += week.daysInPortuguese + " , ";
        }
        return allTranslated;
    }
}