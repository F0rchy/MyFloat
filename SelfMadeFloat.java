package com.max.idea;

public class SelfMadeFloat
{
    private long mantissa;
    private long exponent;
    private long myInteger;
    private long myFraction;

    public SelfMadeFloat(long mantissa, long exponent) {
        this.mantissa = mantissa;
        this.exponent = exponent;
    }

    private void intFract() {
        myInteger = (long)(this.mantissa / Math.pow(10, this.exponent));
        myFraction = (long)(this.mantissa % Math.pow(10, this.exponent));
    }
}