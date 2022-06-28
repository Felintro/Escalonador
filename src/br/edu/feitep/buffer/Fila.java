package br.edu.feitep.buffer;

import br.edu.feitep.processo.Processo;

import java.util.Arrays;

public class Fila {

    private Processo[] buffer;
    private int inicio, fim, n; /* índices de início e fim da fila de processos, e número de processos dentro da fila */

    public Fila(int tamanhoBuffer) {
        this.buffer = new Processo[tamanhoBuffer];
        this.inicio = 0;
        this.fim = 0;
        this.n = 0;
    }

    public int getN() {
        return n;
    }

    public int getInicio() {
        return inicio;
    }

    public int getFim() {
        return fim;
    }

    public Processo getPrimeiroDaFila() {
        return buffer[inicio];
    }

    public Processo getUltimoDaFila() {
        return buffer[fim];
    }

    public Processo[] getBuffer() {
        return buffer;
    }

    public void enfileirarProcesso(Processo processo) { /* Insere 1 processo novo na fila de processos */

        buffer[fim] = processo;

        if(fim == buffer.length-1) {
            fim = 0; /* Garantir o enfileiramento circular */
        } else {
            fim +=1;

        }

        n++; /* Incrementa 1 no tamanho do buffer */

    }

    public Processo desenfileirarProcesso() {

        Processo primeiro = buffer[inicio];
        buffer[inicio] = new Processo(); /* "Removendo" o valor do buffer */

        if(inicio == buffer.length-1) {
            inicio = 0; /* Garantir o enfileiramento circular */
        } else {
            inicio++;
        }

        n--;

        return primeiro;

    }

    public boolean isVazia() {
        return n == 0;
    }

    public boolean isCheia() {
        return n == buffer.length;
    }

    @Override
    public String toString() {
        return "Buffer: " + Arrays.toString(buffer) + " N: " + n;
    }

}