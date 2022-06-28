package br.edu.feitep;

import br.edu.feitep.buffer.Fila;
import br.edu.feitep.escalonador.Escalonador;
import br.edu.feitep.processo.Processo;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

/*
        Fila fila = new Fila(5);
        fila.enfileirarProcesso(new Processo("A"));
        fila.enfileirarProcesso(new Processo("B"));
        fila.enfileirarProcesso(new Processo("C"));
        fila.enfileirarProcesso(new Processo("D"));


        System.out.println("Antes");
        System.out.println(fila.toString());

        System.out.println("Depois de desenfileirar:");
        Processo primeiro = fila.desenfileirarProcesso();
        System.out.println(fila.toString());

        System.out.println("Depois de enfileirar:");
        fila.enfileirarProcesso(primeiro);
        System.out.println(fila.toString());

        System.out.println("");



        Escalonador escalonador = new Escalonador(5, 5);
        escalonador.roundRobin();
        escalonador.comPrioridades();


 */

        List<Processo> listaProcessos = new ArrayList<>();
        listaProcessos.add(new Processo("A"));
        listaProcessos.add(new Processo("B"));
        listaProcessos.add(new Processo("C"));
        System.out.println(listaProcessos.toString());
        System.out.println("");

        listaProcessos.remove(0);
        listaProcessos.add(new Processo("A"));
        System.out.println(listaProcessos.toString());

        listaProcessos.get(listaProcessos.size()-1)


    }
}
