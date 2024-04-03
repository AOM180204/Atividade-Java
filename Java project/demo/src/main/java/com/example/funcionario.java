package com.example;

import java.util.Scanner;

public class funcionario {
    int ordem;
    String nome;
    int departamento;
    float salario_base;
    int horas;
    int extra;
    float insalubridade;
    float bonificacao;
    float INSS;
    float imposto_renda;
    float salario_liquido;
    float salario_bruto;

    public static int PLANO_DE_SAUDE = 20;
    public static int DEPART_1_HORA = 22;
    public static int DEPART_2_HORA = 12;
    public static float INSALUBRIDADE = 0.15f;
    public static float IMPOSTO_RENDA = 0.12f;
    public static float constINSS = 0.07f;

    float calculoBase(funcionario pessoa) {
        if (pessoa.departamento == 1) {
            if (pessoa.departamento > 40) {
                pessoa.salario_base = DEPART_1_HORA * 40;
            } else {
                pessoa.salario_base = DEPART_1_HORA * pessoa.horas;
            }
        } else {
            if (pessoa.departamento > 40) {
                pessoa.salario_base = DEPART_2_HORA * 40;
            } else {
                pessoa.salario_base = DEPART_2_HORA * pessoa.horas;
            }
        }
        return pessoa.salario_base;
    }

    float calculoBonificacao(funcionario pessoa) {
        if (pessoa.departamento == 1) {
            if (pessoa.horas > 20 && pessoa.horas < 30) {
                pessoa.bonificacao = pessoa.salario_base * 0.03f;
            } else if (pessoa.horas >= 30 && pessoa.horas < 40) {
                pessoa.bonificacao = pessoa.salario_base * 0.05f;
            } else if (pessoa.horas >= 40) {
                pessoa.bonificacao = pessoa.salario_base * 0.1f;
            } else {
                pessoa.bonificacao = 0;
            }
        } else {
            pessoa.bonificacao = 0;
        }
        return pessoa.bonificacao;
    }

    float calculoInsalubridade(funcionario pessoa) {
        if (pessoa.departamento == 2) {
            pessoa.insalubridade = pessoa.salario_base * INSALUBRIDADE;
        } else {
            pessoa.insalubridade = 0;
        }
        return pessoa.insalubridade;
    }

    float calculoBruto(funcionario pessoa) {
        if (pessoa.departamento == 1) {
            pessoa.salario_bruto = pessoa.salario_base + (pessoa.extra * DEPART_1_HORA * 2) + pessoa.bonificacao;
        } else {
            pessoa.salario_bruto = pessoa.salario_base + (pessoa.extra * DEPART_2_HORA * 2) + pessoa.insalubridade;
        }
        return pessoa.salario_bruto;
    }

    float calculoImposto(funcionario pessoa) {
        return pessoa.imposto_renda = pessoa.salario_bruto * IMPOSTO_RENDA;
    }

    float calculoInss(funcionario pessoa) {
        return pessoa.salario_bruto * constINSS;
    }

    float calculoLiquido(funcionario pessoa) {
        return pessoa.salario_bruto - calculoImposto(pessoa) - calculoInss(pessoa) - PLANO_DE_SAUDE;
    }

    void inserirDados(int numero, funcionario pessoa){
        pessoa.ordem=numero;
        System.out.println("Insira o nome do funcionario");
        Scanner nome = new Scanner(System.in);
        pessoa.nome=nome.nextLine();

        int escolha=0;
        Scanner dept = new Scanner(System.in);
        while(pessoa.departamento==0){
        System.out.println("Insira o departamento do funcionario");
        escolha= dept.nextInt();
        switch(escolha){
        case 1:pessoa.departamento=1;
        break;

        case 2: pessoa.departamento=2;
        break;
        
        default:
        System.out.println("Opçao invalida");
        }}
        
    


        System.out.println("Insira o numero de horas do funcionario");
        Scanner hora = new Scanner(System.in);
        pessoa.horas= hora.nextInt();
        


        if(pessoa.horas>40){
            pessoa.extra=pessoa.horas-40;
        }
        else{
            pessoa.extra=0;
        }
        pessoa.salario_base=calculoBase(pessoa);
        pessoa.bonificacao=calculoBonificacao(pessoa);
        pessoa.insalubridade=calculoInsalubridade(pessoa);
        pessoa.salario_bruto=calculoBruto(pessoa);
        pessoa.imposto_renda=calculoImposto(pessoa);
        pessoa.INSS=calculoInss(pessoa);
        pessoa.salario_liquido=calculoLiquido(pessoa);
        nome.close();
        dept.close();
        hora.close();
    }

    void imprimirDados(funcionario pessoa){
        System.out.print(pessoa.ordem + ")");
        System.out.println("Nome: "+pessoa.nome);
        System.out.println("Salario Base: "+pessoa.salario_base);
        System.out.println("Horas: "+pessoa.horas);
        System.out.println("Horas extra: "+pessoa.extra);
        System.out.println("Insalubridade: "+pessoa.insalubridade);
        System.out.println("Bonificaçao: "+pessoa.bonificacao);
        System.out.println("INSS: "+pessoa.INSS);
        System.out.println("Imposto de Renda: "+pessoa.imposto_renda);
        System.out.println("Plano de Saude: "+PLANO_DE_SAUDE);
        System.out.println("Salario Liquido: "+pessoa.salario_liquido);

    }
}
