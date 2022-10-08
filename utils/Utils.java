package v2.utils;

import java.util.Arrays;
import java.util.Random;

public class Utils {

    private static Random rnd = new Random();

    public static double[] rand(int length){
        double[] values = new double[length];
        return Arrays.stream(values).map(x -> rnd.nextDouble()).toArray();
    }

    public static Number toConvert(Class<?> TYPE, String value){
        return TYPE.isInstance(Integer.class) ? Integer.parseInt(value) : Double.parseDouble(value);
    }

    public static double mult(double a, double b){
        return a * b;
    }

    public static double mult(double a, double b, double c){
        return a * b * c;
    }

    public static double[] toDouble(String[] s){
        return Arrays.stream(s).mapToDouble(Double::parseDouble).toArray();
    }

    public static int[] toInt(String[] s){
        return Arrays.stream(s).mapToInt(Integer::parseInt).toArray();
    }
}

