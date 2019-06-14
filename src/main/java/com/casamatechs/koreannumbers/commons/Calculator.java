package com.casamatechs.koreannumbers.commons;

import static com.casamatechs.koreannumbers.commons.Constants.*;

public class Calculator {

    private Calculator() {

    }

    public static String getResult(final int number, final NumberType type) {
        if (number < 0 || (number == 0 && type == NumberType.NATIVE)) return "";
        return getResult(number, type, "");
    }

    private static String getResult(final int number, final NumberType type, final String acc) {
        switch (type) {
            case SINO:
                if (number == 0 && acc.equals("")) return SINO_KOREAN_ARRAY[0];
                else if (number >= 100) {
                    final int cent = number / 100;
                    return getResult(number - (cent * 100), type, acc.concat(concatenator(cent, CENT_POSITION)));

                } else if (number >= 10) {
                    final int dec = number / 10;
                    return getResult(number - (dec * 10), type, acc.concat(concatenator(dec, DEC_POSTIION)));

                } else {
                    if (number != 0) {
                        return acc.concat(SINO_KOREAN_ARRAY[number]);
                    } else {
                        return acc;
                    }
                }
            case NATIVE:
                if (number > 100) {
                    final int cent = number / 100;
                    return getResult(number - (cent * 100), type, getResult(cent * 100, NumberType.SINO, ""));
                } else {
                    final int dec = number / 10;
                    final int unit = number - (dec * 10);
                    return acc.concat(nativeComposer(dec, unit));
                }
            default:
                return "";
        }
    }

    private static String concatenator(final int number, final int factor) {
        if (number != 1) return SINO_KOREAN_ARRAY[number].concat(SINO_KOREAN_ARRAY[factor]);
        else return SINO_KOREAN_ARRAY[factor];
    }

    private static String nativeComposer(final int dec, final int unit) {
        if (dec == 0 && unit == 0) return "";
        else if (dec == 0) return NATIVE_KOREAN_ARRAY_UNITS[unit];
        else if (unit == 0) return NATIVE_KOREAN_ARRAY_DEC[dec];
        else return NATIVE_KOREAN_ARRAY_DEC[dec].concat(NATIVE_KOREAN_ARRAY_UNITS[unit]);
    }
}
