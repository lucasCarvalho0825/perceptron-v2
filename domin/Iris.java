package v2.domin;

import v2.utils.Utils;
import v2.view.Neurons;

import java.util.List;

public class Iris implements Neurons {

    public static String especie;
    static double[] x;
    static double[] w;

    public Iris(double sepalLength, double sepalWidth, double petalLength, double petalWidth){
        x = new double[]{sepalLength, sepalWidth, petalLength, petalWidth};
    }
    public Iris(int entreis) {
        w = Utils.rand(entreis);
    }
    @Override
    public int activate(double valor) {
        return (valor >= 1) ? 1 : 0;
    }
    @Override
    public void wUpdate(double N, double E) {
        for (int i = 0; i < w.length; i++) {
            w[i] += x[i] * N * E;
        }
    }
    @Override
    public String classify(List<String> label, double... value) {
        x = value; return especie = label.get(synapse());
    }
    public Integer synapse(){
        return activate(Neurons.sum(x, w));
    }
    public void setX(double[] x) {
        this.x = x;
    }
}
