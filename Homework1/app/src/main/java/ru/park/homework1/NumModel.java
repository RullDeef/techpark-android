package ru.park.homework1;

import android.graphics.Color;

import java.io.Serializable;

public class NumModel implements Serializable {
    public static final int COLOR_EVEN = Color.RED;
    public static final int COLOR_ODD = Color.BLUE;
    private final int number;
    private final int color;

    NumModel(int number) {
        this.number = number;
        this.color = number % 2 == 0 ? COLOR_EVEN : COLOR_ODD;
    }

    public int getNumber() {
        return number;
    }

    public int getColor() {
        return color;
    }
}
