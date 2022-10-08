package v2.view;


import V3.utils.Utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public interface DataFn {

    /**
     * método que converte um arquivo em uma lista de arreys do tipo strings
     *
     * @param fileName  caminho do arquivo com os dados
     * @param regex separador dos elementos dentro do arquivo
     *
     * @return rowList lista de arreys de strings com os dados
     * */
    default List<String[]> loadData(String fileName, String regex){
        List<String[]> rowList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line = br.readLine();

            while (line != null){
                String[] value = line.split(regex);
                rowList.add(value);
                line = br.readLine();
            }

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return rowList;
    }

    /**
     * método que extrai as colunas com os dados para treinamento da rede, e converte para o tipo especifico
     *
     * @param data lista dos dados
     * @param start indice desejado inicial da matriz de dados
     * @param end indice desejado final da matriz de dados
     * */
    default List<double[]> trainingData(List<String[]> data, int start, int end){
        return stringToDouble(data.stream().map(s -> Arrays.copyOfRange(s, start, end)).toList());
    }

    /**
     * método que extrai e converte a coluna de clases desejadas do conjunto de dados.
     *
     * @param data lista dos dados
     * @param col indice da coluna desejada
     *
     * @return uma lista com um v0,0,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,
     * ,000alor inteiro correspondente a cada classe desejada do conjunto.
     *
     * */
    default List<Integer> labelData(List<String[]> data,int col) {
        List<String> dataColumn = selectColumnData(data, col);
        List<String> item = numberLabels(dataColumn);
        return dataColumn.stream().map(item::indexOf).toList();
    }

    /**
     * método que devolve uma lista de String com uma coluna especifica dos dados
     *
     * @param data lista dos dados
     * @param col indice da coluna desejada
     * */
    default List<String> selectColumnData(List<String[]> data, int col) {
        return data.stream().map(s -> s[col]).toList();
    }

    /**
     * método que reduz o numero de classes para um elemetento de cada
     *
     * @param listLabels lista de valores
     *
     * */
    default List<String> numberLabels(List<String> listLabels) {
        return listLabels.stream().distinct().toList();
    }

    /**
     * método que converte o valor String de um dado para Doubble
     *
     * @param values lista de valores
     *
     * @return uma lista de arrays de valores double
     * */
    static public List<double[]> stringToDouble(List<String[]> values){
        return values.stream().map(Utils::toDouble).toList();
    }
}
