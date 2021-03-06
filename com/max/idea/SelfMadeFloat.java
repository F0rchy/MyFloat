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
        out(b, count, resultInteger, resultFraction);
    }

    public void dif(SelfMadeFloat b) {
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
            myFraction *= (long)(Math.pow(10, maxExponent - minExponent));
        }
        myFraction += (long)(Math.pow(10, maxExponent));
        resultFraction = myFraction - b.myFraction;
        if (resultFraction < (long)(Math.pow(10, maxExponent))) {
            resultInteger = -1;
        }
        resultFraction %= (long)(Math.pow(10, maxExponent));
        resultInteger = resultInteger + myInteger - b.myInteger;
        if (resultInteger < 0) {
            resultFraction = (long)(Math.pow(10, maxExponent)) - resultFraction;
            resultInteger++;
        }
        for (long i = resultFraction ; i < (long)(Math.pow(10, maxExponent - 1)) ; i *= 10) {
            count++;
        }
        out(b, count, resultInteger, resultFraction);
    }

    public void out(SelfMadeFloat b, int count, long resultInteger, long resultFraction) {
        System.out.print(resultInteger + ".");
        for (int i = 0 ; i < count ; i++) {
            System.out.print("0");
        }
        System.out.println(resultFraction);
    }
}