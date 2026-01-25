package com.br.ordofy.ordofy_api.entities.enums;

public enum DayOfWeek {
    MONDAY(1),
    TUESDAY(2),
    WEDNESDAY(3),
    THURSDAY(4),
    FRIDAY(5),
    SATURDAY(6),
    SUNDAY(7);

    private final int number;

    DayOfWeek(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public static DayOfWeek fromNumber(int number) {
        for (DayOfWeek day : values()) {
            if (day.number == number) {
                return day;
            }
        }
        throw new IllegalArgumentException("Invalid day number: " + number);
    }
}
