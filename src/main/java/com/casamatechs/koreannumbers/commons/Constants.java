package com.casamatechs.koreannumbers.commons;

public class Constants {

    private Constants() {

    }

    static final String[] SINO_KOREAN_ARRAY = new String[]{"영", "일", "이", "삼", "사", "오", "육", "칠", "팔", "구", "십", "백", "천"};
    static final String[] NATIVE_KOREAN_ARRAY_UNITS = new String[]{null, "하나", "둘", "셋", "넷", "디삿", "여섯", "일곱", "여덟", "아홉"};
    static final String[] NATIVE_KOREAN_ARRAY_DEC = new String[]{null, "열", "스물", "서른", "마흔", "쉰", "여순", "일순", "여든", "아흔"};

    static final int DEC_POSTIION = 10;
    static final int CENT_POSITION = 11;

    public static final int CHECK_CORRECT = 1;
    public static final int CHECK_BOTH_INCORRECT = 2;
    public static final int CHECK_NATIVE_INCORRECT = 3;
    public static final int CHECK_SINO_INCORRECT = 4;



}
