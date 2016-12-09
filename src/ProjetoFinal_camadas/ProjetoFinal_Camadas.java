
package ProjetoFinal_camadas;

import banco.BancoDadosEstoque;
import views.EstoqueView;


public class ProjetoFinal_Camadas {
    

 
    public static void main(String[] args) {
        
        BancoDadosEstoque.InicializarBanco();
                
        EstoqueView estoqueView = new EstoqueView();
        
        while(true){
        estoqueView.exibirMenu();
        }
    
    }
}


