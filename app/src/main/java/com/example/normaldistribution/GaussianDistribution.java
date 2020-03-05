package com.example.normaldistribution;

import android.util.Log;

import org.apache.commons.math3.distribution.NormalDistribution;

public class GaussianDistribution {

    private NormalDistribution normalDistribution;
    private NormalDistribution standardNormalDistribution;
    private double mean = 0.0;
    private double stdev = 0.0;

    public GaussianDistribution(double mean, double stdev) {
        this.mean = mean;
        this.stdev = stdev;
        normalDistribution = new NormalDistribution(mean, stdev);
        standardNormalDistribution = new NormalDistribution();
    }

    private double standardise(double X, double mean, double stdev) {
        return ((X - mean) / stdev);
    }

    private double destandardise(double Z, double mean, double stdev) {
        return ((Z * stdev) + mean);
    }

    private double calculateCumulativeProbablility(double x) {
        return normalDistribution.cumulativeProbability(x);
    }

    private double inverseNormalDistribution(double area) {
        Log.i("AREA FROM INVD: ",String.valueOf(area));
        return standardNormalDistribution.inverseCumulativeProbability(area);
    }

    public double calculateIQR() {
        double z2 = inverseNormalDistribution(0.75);
        Log.i("Z2: ",String.valueOf(z2));
        double z1 = inverseNormalDistribution(0.25);
        Log.i("Z1: ",String.valueOf(z1));
        double x2 = destandardise(z2, this.mean, this.stdev);
        double x1 = destandardise(z1, this.mean, this.stdev);
        return (x2 - x1);
    }

}
