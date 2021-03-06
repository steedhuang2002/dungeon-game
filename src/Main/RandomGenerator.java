package Main;

import java.util.Random;

public class RandomGenerator {
    private static Random generator = new Random();

    public static int getRandom(int min, int max){
        return generator.nextInt((max - min) + 1) + min;
    }
    public static double getRandom(double min, double max){
        return generator.nextDouble()*(max-min) + min;
    }
}