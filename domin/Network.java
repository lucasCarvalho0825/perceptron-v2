package v2.domin;

import v2.domin.Iris;

import java.util.List;

public class Network {

    private int era;
    private double error;
    private double rate;
    private Iris iris;

    public Network(double rate , Iris iris) {
        era = 0;
        error = 0;
        this.rate = rate;
        this.iris = iris;
    }

    public Iris treining(List<double[]> data, List<Integer> label){
        boolean treined = false;


        while (!treined){
            treined = true;
            era++;

            for (int i=0; i<data.size(); i++){
                iris.setX(data.get(i));
                error = label.get(i) - iris.synapse();
                if(error != 0){
                    iris.wUpdate(rate, error);
                    treined = false;
                }
            }
        }

        System.out.println("Network treined with " + era);
        return iris;
    }
}
