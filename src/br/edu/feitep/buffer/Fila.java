package br.edu.feitep.buffer;

import br.edu.feitep.processo.Processo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Fila {

    private List<Processo> buffer = new ArrayList<Processo>();

    public Fila() {

    }

    public int getN() {
        return buffer.size();
    }

    public Processo getPrimeiroDaFila() {
        return buffer.get(0);
    }

    public Processo getUltimoDaFila() {
        return buffer.get(buffer.size()-1);
    }

    public Processo[] getBuffer() {
        return buffer;
    }

    public void enfileirarProcesso(Processo processo) { /* Insere 1 processo novo na fila de processos */

        buffer.add(processo);

    }

    public Processo desenfileirarProcesso() {

        Processo primeiro = getPrimeiroDaFila();
        buffer.remove(0);

    }

    public boolean isVazia() {
        return buffer.size() == 0;
    }

    @Override
    public String toString() {
        return "Fila{" + "buffer=" + buffer + "}";
    }
}