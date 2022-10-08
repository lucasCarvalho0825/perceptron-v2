package v2;

import v2.domin.FnData;
import v2.domin.Iris;
import v2.domin.Network;

import java.util.List;
import java.util.Scanner;

public class MainData {

    public static void main(String[] args) {

        Scanner leitor = new Scanner(System.in);
        //##############################################################################################################
        System.out.println("########### CONFIG OS DADOS ###########");
        //String file = "src/v2/arqIris2class.txt";
        //String regex = ";";

        System.out.println("digite caminho para o local do arquivo de dados: ");
        String file = leitor.next();

        System.out.println("digite o caracter separador dos dados: ");
        String regex = leitor.next();

        FnData data = new FnData(file, regex);

        List<double[]> doubleDataList = data.trainingData(FnData.data, 0, FnData.data.get(0).length-1);
        List<Integer> intLabelList = data.labelData(FnData.data, FnData.data.get(0).length-1);
        //##############################################################################################################
        //##############################################################################################################
        System.out.println("########### CONFIG NETWORK ###########");
        System.out.println("defina a quantidade de entradas para o neuronio: ");
        int entreis = leitor.nextInt();

        System.out.println("defina o valor da taxa de aprendizado: ");
        double rate = leitor.nextDouble();

        Network network = new Network(rate, new Iris(entreis));
        Iris iris = network.treining(doubleDataList, intLabelList);
        //##############################################################################################################
        //##############################################################################################################
        System.out.println("########### CLASSIFICANDO OS DADOS ###########");

        while (true){
            double values[] = new double[entreis];
            System.out.println(" Informe  os valores do conjunto de dados");
            for (int i = 0; i < entreis; i++) {
                values[i] = leitor.nextDouble();
            }

            //exemplos //4.9;3.1;1.5;0.1 setosa(0) // 6.7;3.1;4.4;1.4 verticolor(1)
            String saida = iris.classify(data.numberLabels(data.numberLabels(data.selectColumnData(FnData.data, FnData.data.get(0).length-1))), values);
            System.out.println(saida.toUpperCase() + " CLASSE para o conjunto de entradas.");

            System.out.println(" digite 0 para sair ou qualquer numero para fazer um novo teste");
            int teste = leitor.nextInt();
            if(teste == 0){
                break;
            }
        }
    }
}
