
package models;

public abstract class Produto {

    private String marca;
    private String modelo;
    private int ano;
    private float valor;
    
    
    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public int getAno() {
        return ano;
    }

    public float getValor() {
        return valor;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }
   
   
    
}
