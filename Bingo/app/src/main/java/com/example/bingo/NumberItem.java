package com.example.bingo;

public class NumberItem {
    private int         mNumber;
    private boolean     mSelect;

    public NumberItem(int number) {

        mNumber = number;
        mSelect = false;
    }

    @Override
    public String toString() {
//        return "NumberItem{" +
//                "mNumber=" + mNumber +
//                ", mSelect=" + mSelect +
//                '}';
        return ""+mNumber;
    }
}
