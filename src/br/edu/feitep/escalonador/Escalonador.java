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
            forneceQuantumAleatorio(fila.getBuffer().get(i)); /* Fornece os quantums aos processos da fila */
            fornecePrioridadeAleatoria(fila.getBuffer().get(i)); /* Fornece as prioridades aos processos da fila */
        }

    }

    public void roundRobin() {

        ultimoProcessoDaFila = fila.getUltimoDaFila();

        while(ciclos != 0) {

            processoEmExecucao = fila.getPrimeiroDaFila();
            processoEmExecucao.setStatus("Executando");

            while(processoEmExecucao.getQuantum() != 0) {
                processoEmExecucao.executaProcesso();
            }

            processoEmExecucao.setStatus("Pronto");
            this.forneceQuantumAleatorio(processoEmExecucao); /* Para a próxima execução/iteração */

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
            this.forneceQuantumAleatorio(processoEmExecucao); /* Para a próxima execução/iteração */

            fila.desenfileirarProcesso(); /* Remove o processo em execução da fila */
            fila.enfileirarProcesso(processoEmExecucao); /* E insere no fim da fila */

            if (fila.getPrimeiroDaFila() == ultimoProcessoDaFila){
                ciclos--;
                System.out.println("Ciclos Restantes: " + ciclos);

                for (Processo processo : fila.getBuffer()) {
                    fornecePrioridadeAleatoria(processo); /* Fornece nova prioridade */
                }

                Collections.sort(fila.getBuffer()); /* Ordena a fila novamente com base na prioridade */

                ultimoProcessoDaFila = fila.getUltimoDaFila(); /* Novo ultimo da fila */

            }

        }

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
            this.forneceQuantumAleatorio(processoEmExecucao); /* Para a próxima execução/iteração */

            fila.desenfileirarProcesso(); /* Remove o processo em execução da fila */
            fila.enfileirarProcesso(processoEmExecucao); /* E insere no fim da fila */

            if (fila.getPrimeiroDaFila() == ultimoProcessoDaFila){
                ciclos--;
                System.out.println("Ciclos Restantes: " + ciclos);

                for (Processo processo : fila.getBuffer()) {
                    fornecePrioridadeAleatoria(processo); /* Fornece nova prioridade */
                }
            }

        }

    }

    public void compartilhamentoJusto() {

        Fila filaUsuario1 = new Fila();
        Fila filaUsuario2 = new Fila();

        for (Processo processo : fila.getBuffer()) {

            forneceQuantumFixo(processo, 10);

            if(processo.getNome().equalsIgnoreCase("Processo 0") || processo.getNome().equalsIgnoreCase("Processo 1") || processo.getNome().equalsIgnoreCase("Processo 2")) {
                filaUsuario1.getBuffer().add(processo);
            } else {
                filaUsuario2.getBuffer().add(processo);
            }

        }

        fila.getBuffer().clear();

        System.out.println("Processos 0, 1 e 2 foram adicionados ao usuário 1!");
        System.out.println("Restante dos processos foram adicionados ao usuário 2!");
        System.out.println("");
        System.out.println("Iniciando execução do usuário 1:");

        while(filaUsuario1.getBuffer().size() != 0) {

            processoEmExecucao = filaUsuario1.getPrimeiroDaFila();
            processoEmExecucao.setStatus("Executando");

            while(processoEmExecucao.getQuantum() != 0) {
                processoEmExecucao.executaProcesso();
            }

            processoEmExecucao.setStatus("Terminado");

            filaUsuario1.desenfileirarProcesso(); /* Remove o processo em execução da fila */

        }

        System.out.println("");
        System.out.println("Iniciando execução do usuário 2:");

        while(filaUsuario2.getBuffer().size() != 0) {

            processoEmExecucao = filaUsuario2.getPrimeiroDaFila();
            processoEmExecucao.setStatus("Executando");

            while(processoEmExecucao.getQuantum() != 0) {
                processoEmExecucao.executaProcesso();
            }

            processoEmExecucao.setStatus("Terminado");

            filaUsuario2.desenfileirarProcesso(); /* Remove o processo em execução da fila */

        }



    }

    private void forneceQuantumAleatorio(Processo processo) {
        processo.setQuantum(new Random().nextInt(100)+1); /* Fornece um quantum aleatório ao processo de 1 a 100, simulando os milissegundos */
    }

    private void fornecePrioridadeAleatoria(Processo processo) {
        processo.setPrioridade(new Random().nextInt(10) + 1); /* Fornece uma prioridade aleatória ao processo de 1 a 10 */
    }

    private void forneceQuantumFixo(Processo processo, int quantum) {
        processo.setQuantum(quantum); /* Fornece um quantum fixo ao processo */
    }

    private void fornecePrioridadeFixa(Processo processo, int prioridade) {
        processo.setPrioridade(prioridade); /* Fornece uma priorirade fixa ao processo */
    }


}
