package br.edu.feitep;

import br.edu.feitep.escalonador.Escalonador;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("========= Bem-Vindo ao Escalonador =========");
        System.out.println("===== Selecione o algoritmo desejado =======");
        System.out.println("1 - Escalonamento Round Robin");
        System.out.println("2 - Escalonamento Com Prioridades");
        System.out.println("3 - Escalonamento do Próximo Menor Tempo");
        System.out.println("4 - Escalonamento por Compartilhamento Justo");
        int seletor = scanner.nextInt();

        Escalonador escalonador = new Escalonador(10, 5);

        switch (seletor) {
            case 1:
                escalonador.roundRobin();
                break;

            case 2:
                escalonador.comPrioridades();
                break;

            case 3:
                escalonador.proximoMenorTempo();
                break;

            case 4:
                escalonador.compartilhamentoJusto();
                break;

        }

    }
}
