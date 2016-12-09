
package controllers;

import banco.BancoDadosEstoque;
import models.Carro;


public class EstoqueController implements INegociacao {
   
    
    public static void adicionarCarroEstoque(int codigo,String marca, String modelo,  int ano, float valor){
        
        //Criei o objeto para ir para o banco
        Carro c = new Carro();
        
        //Preenchendo o objeto
        c.setCodigo(codigo);
        c.setMarca(marca);
        c.setModelo(modelo);
        c.setAno(ano);
        c.setValor(valor);
        
        BancoDadosEstoque.getTabelaEstoque().add(c);     
    }
    public static Carro buscarPorCodigo(int codigo){
        for (Carro c : BancoDadosEstoque.getTabelaEstoque()){
            if(c.getCodigo() == codigo){
                return c;
            }
        }
        return null;
    }
    
    @Override
    public void vendaProduto() {
    }
}    