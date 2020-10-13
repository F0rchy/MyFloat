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
        intFract();
    }

    private void intFract() {
        myInteger = (long)(this.mantissa / Math.pow(10, this.exponent));
        myFraction = (long)(this.mantissa % Math.pow(10, this.exponent));
    }

    public void sum(SelfMadeFloat b) {
        long resultFraction = 0;
        long resultInteger = 0;
        int count = 0;
        long maxExponent = 0;
        long minExponent = 0;
        if(this.exponent >= b.exponent) {
            maxExponent = this.exponent;
            minExponent = b.exponent;
            b.myFraction *= (long)(Math.pow(10, maxExponent - minExponent));
        }
        else {
            maxExponent = b.exponent;
            minExponent = this.exponent;
            this.myFraction *= (long)(Math.pow(10, maxExponent - minExponent));
        }
        resultFraction = b.myFraction + myFraction;
        if (resultFraction >= (long)(Math.pow(10, maxExponent))) {
            resultInteger = 1;
        }
        resultFraction %= (long)(Math.pow(10, maxExponent));
        resultInteger += b.myInteger + myInteger;
        for (long i = resultFraction ; i < (long)(Math.pow(10, maxExponent - 1)) ; i *= 10) {
            count++;
        }
    }
}