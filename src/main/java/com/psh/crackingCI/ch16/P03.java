package com.psh.crackingCI.ch16;

import org.apache.commons.lang3.tuple.Pair;

import java.util.Optional;

public class P03 {

    public static void main(String[] args) {

        System.out.println(intersect(Pair.of(1.,1.), Pair.of(3., 3.),
                Pair.of(1.,3.), Pair.of(3., 1.)));
    }

    public static Optional<Pair<Double, Double>> intersect(Pair<Double, Double> aFrom, Pair<Double, Double> aTo,
                                                           Pair<Double, Double> bFrom, Pair<Double, Double> bTo) {

        double aSlope = getSlope(aFrom, aTo);
        double aIntercept = getIntercept(aSlope, aFrom);
        double bSlope = getSlope(bFrom, bTo);
        double bIntercept = getIntercept(bSlope, bFrom);

        if (aSlope == bSlope && aIntercept == bIntercept) {
            return Optional.empty();
        }

        double x = (bIntercept - aIntercept) / (aSlope - bSlope);
        double y = x * aSlope + aIntercept;

        if (x >= Math.min(aFrom.getLeft(), aTo.getLeft()) && x <= Math.max(aFrom.getLeft(), aTo.getLeft()) &&
                x >= Math.min(bFrom.getLeft(), bTo.getLeft()) && x <= Math.max(bFrom.getLeft(), bTo.getLeft()) &&
                y >= Math.min(aFrom.getRight(), aTo.getRight()) && y <= Math.max(aFrom.getRight(), aTo.getRight()) &&
                y >= Math.min(bFrom.getRight(), bTo.getRight()) && y <= Math.max(bFrom.getRight(), bTo.getRight())) {
            return Optional.of(Pair.of(x, y));
        } else {
            return Optional.empty();
        }
    }

    private static double getSlope(Pair<Double, Double> from, Pair<Double, Double> to) {
        return (to.getRight() - from.getRight()) / (to.getLeft() - from.getLeft());
    }

    private static double getIntercept(double slope, Pair<Double, Double> point) {
        return point.getRight() - slope * point.getLeft();
    }
}
