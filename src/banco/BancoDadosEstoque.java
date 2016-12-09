
package banco;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import models.Carro;

public class BancoDadosEstoque {
 private static Scanner leitor = new Scanner(System.in);    
    private static List<Carro> TabelaEstoque;
    
    public static List<Carro> getTabelaEstoque() {
        return TabelaEstoque;
    }
    
    public static void InicializarBanco(){
        TabelaEstoque = new ArrayList<>();
    }
    
}
