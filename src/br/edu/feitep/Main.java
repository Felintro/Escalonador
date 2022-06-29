package br.edu.feitep;

import br.edu.feitep.buffer.Fila;
import br.edu.feitep.escalonador.Escalonador;
import br.edu.feitep.processo.Processo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("========= Bem-Vindo ao Escalonador =========");
        System.out.println("===== Selecione o algoritmo desejado =======");
        System.out.println("1 - Escalonamento Round Robin");
        System.out.println("2 - Escalonamento Com Prioridades");
        System.out.println("3 - Escalonamento do Próximo Menor Tempo");
        System.out.println("4 - ");
        int seletor = scanner.nextInt();

        System.out.println("Insira a quantidade de processos:");
        int qtdeProcessos = scanner.nextInt();

        System.out.println("Insira a quantidade de ciclos:");
        int ciclos = scanner.nextInt();

        Escalonador escalonador = new Escalonador(qtdeProcessos, ciclos);

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

                break;
        }

    }
}
