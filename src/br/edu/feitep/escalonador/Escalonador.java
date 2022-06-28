package br.edu.feitep.escalonador;

import br.edu.feitep.buffer.Fila;
import br.edu.feitep.processo.Processo;

import java.util.*;

public class Escalonador {

    private Fila fila;
    private int ciclos;

    public Escalonador(int qtdeProcessos, int ciclos){

        this.fila = new Fila(qtdeProcessos+1);
        this.ciclos = ciclos;

        for(int i=0; i<qtdeProcessos; i++){
            fila.enfileirarProcesso(new Processo("Processo " + i)); /* Inicia os processos na fila */
            forneceQuantum(fila.getBuffer()[i]); /* Fornece os quantums aos processos da fila */
            fornecePrioridade(fila.getBuffer()[i]); /* Fornece as prioridades aos processos da fila */
        }

    }

    public Escalonador(int qtdeProcessos, int ciclos, String teste) {

    }

    public void roundRobin() {

        while(ciclos != 0){

            Processo processoEmExecucao = fila.getPrimeiroDaFila();
            processoEmExecucao.setStatus("Executando");

            while(processoEmExecucao.getQuantum() != 0) {
                processoEmExecucao.gastaQuantum();
                System.out.println(processoEmExecucao.toString());
            }

            processoEmExecucao.setStatus("Pronto");
            this.forneceQuantum(processoEmExecucao); /* Para a próxima execução/iteração */

            fila.desenfileirarProcesso(); /* Remove o processo em execução da fila */
            fila.enfileirarProcesso(processoEmExecucao); /* E insere no fim da fila */

            if (fila.getInicio() == fila.getN()-1){
                ciclos--;
                System.out.println("Ciclos Restantes: " + ciclos);
            }

        }

    }

    public void comPrioridades() {

        while(ciclos != 0){

            List<Processo> listaProcessos = new ArrayList<>();
            listaProcessos = Arrays.asList(this.fila.getBuffer());
            Fila filaExecucao = new Fila(5);

            for(int i=0; i<fila.getBuffer().length-1; i++) {
                listaProcessos.add(fila.getBuffer()[i]);
                listaProcessos.get(i).setTipoPrioridade("Prioridade");
            }

            System.out.println("Antes:");
            System.out.println(listaProcessos.toString());
            Collections.sort(listaProcessos);
            System.out.println("Depois:");
            System.out.println(listaProcessos.toString());

        }

    }

    public void ComClasseDePrioridades() {



    }

    public void proximoMenorTempo() {



    }

    public void loteria() {

    }

    private void compartilhamentoJusto() {

    }

    private void forneceQuantum(Processo processo) {
        processo.setQuantum(new Random().nextInt(100)+1); /* Fornece um quantum ao processo de 1 a 100, simulando os milissegundos */
    }

    private void fornecePrioridade(Processo processo) {
        processo.setPrioridade(new Random().nextInt(10) + 1); /* Fornece uma prioridade de 1 a 10 */
    }

}
