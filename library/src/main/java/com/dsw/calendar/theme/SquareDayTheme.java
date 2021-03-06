package com.dsw.calendar.theme;

import android.graphics.Color;

/**
 * Created by Administrator on 2016/8/9.
 */
public class SquareDayTheme implements IDayTheme {
    @Override
    public int colorSelectBG() {
        return Color.parseColor("#F3ECFE");
    }

    @Override
    public int colorSelectDay() {
        return Color.parseColor("#8B49F6");
    }

    @Override
    public int colorToday() {
        return Color.parseColor("#8B49F6");
    }

    @Override
    public int colorMonthView() {
        return Color.parseColor("#FFFFFF");
    }

    @Override
    public int colorWeekday() {
        return Color.parseColor("#4F4F4F");
    }

    @Override
    public int colorWeekend() {
        return Color.parseColor("#BEBEBE");
    }

    @Override
    public int colorOtherMonth() {
        return Color.parseColor("#C2C2C2");
    }

    @Override
    public int colorDecor() {
        return Color.parseColor("#4AB9AE");
    }

    @Override
    public int colorRest() {
        return Color.parseColor("#2AC5C8");
    }

    @Override
    public int colorWork() {
        return Color.parseColor("#C78D7D");
    }

    @Override
    public int colorDesc() {
        return Color.parseColor("#4F4F4F");
    }

    @Override
    public int sizeDay() {
        return 16;
    }

    @Override
    public int sizeDesc() {
        return 4;
    }

    @Override
    public int sizeDecor() {
        return 4;
    }

    @Override
    public int dateHeight() {
        return 36;
    }

    @Override
    public int colorLine() {
        return Color.parseColor("#CBCBCB");
    }

    @Override
    public int smoothMode() {
        return 0;
    }
}
