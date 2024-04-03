package com.example;
public class Main {
    public static void main(String[] args) {
        funcionario funcionario1=new funcionario();
        funcionario funcionario2=new funcionario();
        funcionario funcionario3=new funcionario();
        funcionario funcionario4=new funcionario();
        funcionario funcionario5=new funcionario();
        funcionario1.inserirDados(1, funcionario1);
        funcionario2.inserirDados(2, funcionario2);
        funcionario3.inserirDados(3, funcionario3);
        funcionario4.inserirDados(4, funcionario4);
        funcionario5.inserirDados(5, funcionario5);
        funcionario1.imprimirDados(funcionario1);
        funcionario2.imprimirDados(funcionario2);
        funcionario3.imprimirDados(funcionario3);
        funcionario4.imprimirDados(funcionario4);
        funcionario5.imprimirDados(funcionario5);
    }
}