package sortcomparison;

import View_Resultados.GUI;
import Controlador_Ordenamiento.Controlador_Ordenar;
import Metodos_Ordenamiento.MergeClass;
import Metodos_Ordenamiento.Metodos_deOrdenacion;
import Metodos_Ordenamiento.QuickSClass;

public class SortComparisonApp {

    public static void main(String[] args) {
            Controlador_Ordenar ctrl = new Controlador_Ordenar(new Metodos_deOrdenacion(), new GUI(),new MergeClass(),new QuickSClass());
            
    }
    
}
