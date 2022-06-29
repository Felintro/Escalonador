package br.edu.feitep.escalonador;

import br.edu.feitep.buffer.Fila;
import br.edu.feitep.processo.Processo;

import java.util.*;

public class Escalonador {

    private Fila fila;
    private int ciclos;
    private Processo processoEmExecucao;
    private Processo ultimoProcessoDaFila;

    public Escalonador(int qtdeProcessos, int ciclos){

        this.fila = new Fila();
        this.ciclos = ciclos;

        for(int i=0; i<qtdeProcessos; i++){
            fila.enfileirarProcesso(new Processo("Processo " + i)); /* Inicia os processos na fila */
            forneceQuantum(fila.getBuffer().get(i)); /* Fornece os quantums aos processos da fila */
            fornecePrioridade(fila.getBuffer().get(i)); /* Fornece as prioridades aos processos da fila */
        }

    }

    public Escalonador(int qtdeProcessos, int ciclos, String teste) {

    }

    public void roundRobin() {

        ultimoProcessoDaFila = fila.getUltimoDaFila();

        while(ciclos != 0){

            processoEmExecucao = fila.getPrimeiroDaFila();
            processoEmExecucao.setStatus("Executando");

            while(processoEmExecucao.getQuantum() != 0) {
                processoEmExecucao.executaProcesso();
            }

            processoEmExecucao.setStatus("Pronto");
            this.forneceQuantum(processoEmExecucao); /* Para a próxima execução/iteração */

            fila.desenfileirarProcesso(); /* Remove o processo em execução da fila */
            fila.enfileirarProcesso(processoEmExecucao); /* E insere no fim da fila */

            if (fila.getPrimeiroDaFila() == ultimoProcessoDaFila){
                ciclos--;
                System.out.println("Ciclos Restantes: " + ciclos);
            }

        }

    }

    public void comPrioridades() {

        for (Processo processo : fila.getBuffer()) {
            processo.setTipoPrioridade("Prioridade"); /* Seta o tipo de prioridade para o valor da prioridade do processo */
        }

        Collections.sort(fila.getBuffer()); /* Ordena a fila com base no valor da prioridade */

        ultimoProcessoDaFila = fila.getUltimoDaFila();

        while(ciclos != 0){

            processoEmExecucao = fila.getPrimeiroDaFila();

            while(processoEmExecucao.getQuantum() != 0) {
                processoEmExecucao.executaProcesso();
            }

            processoEmExecucao.setStatus("Pronto");
            this.forneceQuantum(processoEmExecucao); /* Para a próxima execução/iteração */

            fila.desenfileirarProcesso(); /* Remove o processo em execução da fila */
            fila.enfileirarProcesso(processoEmExecucao); /* E insere no fim da fila */

            if (fila.getPrimeiroDaFila() == ultimoProcessoDaFila){
                ciclos--;
                System.out.println("Ciclos Restantes: " + ciclos);

                for (Processo processo : fila.getBuffer()) {
                    fornecePrioridade(processo); /* Fornece nova prioridade */
                }

                Collections.sort(fila.getBuffer()); /* Ordena a fila novamente com base na prioridade */

                ultimoProcessoDaFila = fila.getUltimoDaFila(); /* Novo ultimo da fila */

            }

        }

    }

    public void ComClasseDePrioridades() {



    }

    public void proximoMenorTempo() {

        for (Processo processo : fila.getBuffer()) {
            processo.setTipoPrioridade("Tempo");
        }

        Collections.sort(fila.getBuffer()); /* */

        ultimoProcessoDaFila = fila.getUltimoDaFila();

        while(ciclos != 0){

            processoEmExecucao = fila.getPrimeiroDaFila();

            while(processoEmExecucao.getQuantum() != 0) {
                processoEmExecucao.executaProcesso();
            }

            processoEmExecucao.setStatus("Pronto");
            this.forneceQuantum(processoEmExecucao); /* Para a próxima execução/iteração */

            fila.desenfileirarProcesso(); /* Remove o processo em execução da fila */
            fila.enfileirarProcesso(processoEmExecucao); /* E insere no fim da fila */

            if (fila.getPrimeiroDaFila() == ultimoProcessoDaFila){
                ciclos--;
                System.out.println("Ciclos Restantes: " + ciclos);

                for (Processo processo : fila.getBuffer()) {
                    fornecePrioridade(processo); /* Fornece nova prioridade */
                }
            }

        }

    }

    public void loteria() {

    }

    private void compartilhamentoJusto() {



    }

    private void forneceQuantum(Processo processo) {
        processo.setQuantum(new Random().nextInt(100)+1); /* Fornece um quantum aleatório ao processo de 1 a 100, simulando os milissegundos */
    }

    private void fornecePrioridade(Processo processo) {
        processo.setPrioridade(new Random().nextInt(10) + 1); /* Fornece uma prioridade aleatória ao processo de 1 a 10 */
    }

    private

}
