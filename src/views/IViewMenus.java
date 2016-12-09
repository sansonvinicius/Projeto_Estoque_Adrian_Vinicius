package views;

import banco.BancoDadosEstoque;
import controllers.EstoqueController;
import java.util.InputMismatchException;
import models.Carro;


public interface IViewMenus {
    
    public void exibirMenu();
    
    public void adicionarProdutoEstoque();
    
    public void ExibirCarrosEstoque();

    public void BuscarCarroEstoque();

    public void AlterarDadosCarro();

    public void ExcluirCarroEstoque();

    public void vendaProduto();

    public void OperacaoInvalida();
}
