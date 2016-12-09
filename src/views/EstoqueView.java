package views;

import banco.BancoDadosEstoque;
import controllers.EstoqueController;
import java.util.InputMismatchException;
import java.util.Scanner;
import models.Carro;

public class EstoqueView implements IViewMenus {

    private static Scanner leitor = new Scanner(System.in);
    Scanner scan = new Scanner(System.in);

    @Override
    public void exibirMenu() {
        System.out.println("Digite:");
        System.out.println("1 - Adicionar Carros ao Estoque");
        System.out.println("2 - Exibir Carros em Estoque");
        System.out.println("3 - Alterar Dados de Carro");
        System.out.println("4 - Excluir Carro");
        System.out.println("5 - Buscar Carro em Estoque");
        System.out.println("6 - Vender Carro");

        try {

            int opcao = scan.nextInt();
            scan.nextLine();

            switch (opcao) {

                case 1:
                    adicionarProdutoEstoque();
                    break;
                case 2:
                    ExibirCarrosEstoque();
                    break;
                case 3:
                    AlterarDadosCarro();
                    break;
                case 4:
                    ExcluirCarroEstoque();
                    break;
                case 5:
                    BuscarCarroEstoque();
                    break;
                case 6:
                    vendaProduto();
                    break;
                default:
                    System.out.println("Opção Inválida");
                    OperacaoInvalida();
                    break;

            }
        } catch (InputMismatchException ie) {
            System.out.println("Erro: Favor digitar números inteiros para o código do carro.( " + ie.toString() + ")");
            scan.nextLine();
        } catch (UnsupportedOperationException ue) {
            System.out.println("Erro: Operação não suportada!( " + ue.toString() + ")");
            scan.nextLine();
        }

    }

    @Override
    public void adicionarProdutoEstoque() {
        System.out.println("Digite o  código do carro:");
        int codigo = scan.nextInt();
        scan.nextLine();

        System.out.println("Digite a marca do carro:");
        String marca = scan.nextLine();

        System.out.println("Digite o modelo do carro");
        String modelo = scan.nextLine();

        System.out.println("Digite o ano de fabricação do carro");
        int ano = scan.nextInt();
        scan.nextLine();

        System.out.println("Digite o valor do carro");
        float valor = scan.nextFloat();
        scan.nextLine();

        EstoqueController.adicionarCarroEstoque(codigo, marca, modelo, ano, valor);
    }

    @Override
    public void ExibirCarrosEstoque() {

        for (Carro c : BancoDadosEstoque.getTabelaEstoque()) {
            System.out.println("----");
            System.out.println("Codigo: " + c.getCodigo());
            System.out.println("Marca: " + c.getMarca());
            System.out.println("Modelo: " + c.getModelo());
            System.out.println("Ano: " + c.getAno());
            System.out.println("Valor: " + c.getValor());
            System.out.println("");

        }
    }

    @Override
    public void BuscarCarroEstoque() {

        //Pedir o código
        System.out.println("Digite o  código do carro:");
        int codigo = scan.nextInt();
        scan.nextLine();

        Carro c = EstoqueController.buscarPorCodigo(codigo);

        if (c != null) {
            System.out.println("----");
            System.out.println("Codigo: " + c.getCodigo());
            System.out.println("Marca: " + c.getMarca());
            System.out.println("Modelo: " + c.getModelo());
            System.out.println("Ano: " + c.getAno());
            System.out.println("Valor: " + c.getValor());

            System.out.println("----");
        } else {
            System.out.println("O carro não consta em estoque");
        }

    }

    @Override
    public void AlterarDadosCarro() {
        System.out.println("Informe o codigo do carro: ");
        int codigo = leitor.nextInt();
        leitor.nextLine();

        Carro c = EstoqueController.buscarPorCodigo(codigo);

        if (c != null) {
            System.out.print("Informe o novo codigo do carro: (anterior: " + c.getCodigo() + "): ");
            int cod = leitor.nextInt();
            leitor.nextLine();
            c.setCodigo(cod);

            System.out.print("Informe a nova marca do carro: (anterior: " + c.getMarca() + "): ");
            String marca = leitor.nextLine();
            c.setMarca(marca);

            System.out.print("Informe o novo modelo do carro: (anterior: " + c.getModelo() + "): ");
            String modelo = leitor.nextLine();
            c.setModelo(modelo);

            System.out.print("Informe o novo ano de fabricação do carro: (anterior: " + c.getAno() + "): ");
            int ano = leitor.nextInt();
            leitor.nextLine();
            c.setAno(ano);

            System.out.print("Informe o novo valor do carro: (anterior: " + c.getValor() + "): ");
            float valor = leitor.nextInt();
            leitor.nextLine();
            c.setValor(valor);

        } else {
            System.out.println("Carro não consta no sistema!!!");
        }
    }

    @Override
    public void ExcluirCarroEstoque() {
        System.out.print("Digite o codigo do carro: ");
        int codigo = leitor.nextInt();
        leitor.nextLine();

        Carro c = EstoqueController.buscarPorCodigo(codigo);

        if (c != null) {
            EstoqueController.buscarPorCodigo(codigo);
            BancoDadosEstoque.getTabelaEstoque().remove(c);
            System.out.println("Carro removido do estoque");
        } else {
            System.out.println("Carro não encontrado!!");
        }
    }
    @Override
    public void vendaProduto() {
    System.out.print("Digite o codigo do carro: ");
        int codigo = leitor.nextInt();
        leitor.nextLine();

        Carro c = EstoqueController.buscarPorCodigo(codigo);

        if (c != null) {
            EstoqueController.buscarPorCodigo(codigo);
            BancoDadosEstoque.getTabelaEstoque().remove(c);
            System.out.println("O carro " + c.getModelo() + " marca " + c.getMarca() + " e valor de " + c.getValor() + " foi vendido com sucesso ");
        } else {
            System.out.println("A venda não pode ser realizada!!");
        }
    }
    
    @Override
    public void OperacaoInvalida() {
        throw new UnsupportedOperationException("Operação não consta no Menu.");
    }
}
