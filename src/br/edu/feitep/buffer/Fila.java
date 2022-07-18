package br.edu.feitep.buffer;

import br.edu.feitep.processo.Processo;

import java.util.ArrayList;
import java.util.List;

public class Fila {

    private List<Processo> buffer = new ArrayList<>();

    public Fila() {

    }

    public Processo getPrimeiroDaFila() {
        return buffer.get(0);
    }

    public Processo getUltimoDaFila() {
        return buffer.get(buffer.size()-1);
    }

    public List<Processo> getBuffer() {
        return buffer;
    }

    public void enfileirarProcesso(Processo processo) { /* Insere 1 processo novo na fila de processos */
        buffer.add(processo);
    }

    public Processo desenfileirarProcesso() {

        Processo primeiro = getPrimeiroDaFila();
        buffer.remove(0);

        return primeiro;

    }

    @Override
    public String toString() {
        return "Fila{" + "buffer=" + buffer + "}";
    }
}