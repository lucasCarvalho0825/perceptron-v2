package v2.domin;

import v2.view.DataFn;
import java.util.List;

public record FnData (String fileName, String regex) implements DataFn {

    public static List<String[]> data;
    public FnData {
        if(fileName.isEmpty()) throw new IllegalArgumentException("Caminho Inválido");
        if(regex.isEmpty()) throw new IllegalArgumentException("Separador Inválido");

        data = loadData(fileName, regex);
    }



}
