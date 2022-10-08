package v2.view;

import v2.utils.Utils;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 **/
public interface Neurons {

    int activate(double valor);
    void wUpdate(double N, double E);
    String classify(List<String> label, double ... value);
    static double sum(double[] x, double[] w) {
        AtomicInteger i = new AtomicInteger();
        return Arrays.stream(x).map(value -> Utils.mult(value, w[i.getAndIncrement()])).sum();
    }


}
