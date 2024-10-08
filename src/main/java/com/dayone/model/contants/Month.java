package com.dayone.model.contants;

public enum Month {

    JAN("Jan", 1),
    FEB("Feb", 2),
    MAR("Mar", 3),
    APR("Apr", 4),
    MAY("May", 5),
    JUN("Jun", 6),
    JUL("Jul", 7),
    AUG("Aug", 7),
    SEP("Sept", 7),
    OCT("Oct", 10),
    NOV("Nov", 11),
    DEC("Dec", 12);

    private String s;
    private int number;

    Month(String s, int number) {
        this.s = s;
        this.number = number;
    }

    public static int strToNumber(String s) {
        for (var m : Month.values()) {
            if (m.s.equals(s)) {
                return m.number;
            }
        }

        return -1;
    }

}


