package modelos;

import java.io.Serializable;

public class Operacao implements Serializable{
    // Atributos
    private double A;
    private double B;
    private char tipo;
    
    // Construtor(es)
    public Operacao() {
    }
    
    public Operacao(double A, double B) {
        this.A = A;
        this.B = B;
        this.tipo = '+';
    }
    
    public Operacao(double A, double B, char tipo) {
        this.A = A;
        this.B = B;
        this.tipo = tipo;
    }
    
    // Métodos Getters e Setters
    public double getA() {
        return A;
    }

    public void setA(double A) {
        this.A = A;
    }

    public double getB() {
        return B;
    }

    public void setB(double B) {
        this.B = B;
    }

    public char getTipo() {
        return tipo;
    }

    public void setTipo(char tipo) {
        this.tipo = tipo;
    }
    
    // Métodos especialistas
    public double calcular(){
        switch(this.tipo){
            case '+':
                return this.somar();
            case '-':
                return this.subtrair();
            case '*':
                return this.multiplicar();
            case '/':
                return this.dividir();
            default:
                return this.somar();
        }
    }
    
    // Operações
    private double somar(){
        return this.A + this.B;
    }
    private double subtrair(){
        return this.A - this.B;
    }
    private double multiplicar(){
        return this.A - this.B;
    }
    private double dividir(){
        if(this.B == 0)
            return 0;
        return this.A / this.B;
    }
    
    
}
