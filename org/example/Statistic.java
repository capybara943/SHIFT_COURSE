package org.example;

public class Statistic {

    private int countInt = 0;
    private int countFloat = 0;
    private int countString = 0;

    private int maxInt = Integer.MIN_VALUE;
    private int minInt = Integer.MAX_VALUE;
    private int sumInt = 0;

    private float maxFloat = Float.MIN_VALUE;
    private float minFloat = Float.MAX_VALUE;
    private float sumFloat = 0f;

    private int lenMaxString = -1;
    private int lenMinString = Integer.MAX_VALUE;

    public Statistic(){}

    public int getCountInt() {
        return countInt;
    }

    public void setCountInt(int countInt) {
        this.countInt = countInt;
    }

    public int getCountFloat() {
        return countFloat;
    }

    public void setCountFloat(int countFloat) {
        this.countFloat = countFloat;
    }

    public int getCountString() {
        return countString;
    }

    public void setCountString(int countString) {
        this.countString = countString;
    }

    public int getMaxInt() {
        return maxInt;
    }

    public void setMaxInt(int maxInt) {
        this.maxInt = maxInt;
    }

    public int getMinInt() {
        return minInt;
    }

    public void setMinInt(int minInt) {
        this.minInt = minInt;
    }

    public int getSumInt() {
        return sumInt;
    }

    public void setSumInt(int sumInt) {
        this.sumInt = sumInt;
    }

    public float getMaxFloat() {
        return maxFloat;
    }

    public void setMaxFloat(float maxFloat) {
        this.maxFloat = maxFloat;
    }

    public float getMinFloat() {
        return minFloat;
    }

    public void setMinFloat(float minFloat) {
        this.minFloat = minFloat;
    }

    public float getSumFloat() {
        return sumFloat;
    }

    public void setSumFloat(float sumFloat) {
        this.sumFloat = sumFloat;
    }

    public int getLenMaxString() {
        return lenMaxString;
    }

    public void setLenMaxString(int lenMaxString) {
        this.lenMaxString = lenMaxString;
    }

    public int getLenMinString() {
        return lenMinString;
    }

    public void setLenMinString(int lenMinString) {
        this.lenMinString = lenMinString;
    }

    public String getFullStatistic(){
        return "\nInteger:"+
                "\nколичество = "+countInt+
                "\nмаксимальное значение = "+maxInt+
                "\nминимальное значение = "+minInt+
                "\nсумма = "+sumInt+
                "\nFloat:"+
                "\nколичество = "+countFloat+
                "\nмаксимальное значение = "+maxFloat+
                "\nминимальное значение = "+minFloat+
                "\nсумма = "+sumFloat+
                "\nString:"+
                "\nколичество = "+countString+
                "\nмаксимальная длина строки = "+lenMaxString+
                "\nминимальная длина строки = "+lenMinString;
    }
    public String getSmallStatistic(){
        return "\nInteger количество = "+countInt+
                "\nFloat количество = "+countFloat+
                "\nString количество = "+countString;
    }
}
