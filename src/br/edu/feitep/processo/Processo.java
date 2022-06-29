package br.edu.feitep.processo;

public class Processo implements Comparable<Processo> {

    private String nome;
    private String status;
    private String tipoPrioridade;
    private int quantum;
    private int prioridade;
    private int[] tickets;

    public Processo(String nome) {
        this.nome = nome;
        this.status = "Pronto";
    }

    public Processo(){
        this.nome = "Vazio";
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getQuantum() {
        return quantum;
    }

    public void setQuantum(int quantum) {
        this.quantum = quantum;
    }

    public int getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(int prioridade) {
        this.prioridade = prioridade;
    }

    public int[] getTickets() {
        return tickets;
    }

    public void setTickets(int[] tickets) {
        this.tickets = tickets;
    }

    public String getTipoPrioridade() {
        return tipoPrioridade;
    }

    public void setTipoPrioridade(String tipoPrioridade) {
        this.tipoPrioridade = tipoPrioridade;
    }

    @Override
    public String toString() {
        return "Processo:{" + "Nome= " + nome + ", Status= " + status + ", Quantum= " + quantum + ", Prioridade= " + prioridade + "}";
    }

    public void executaProcesso() {
        this.quantum--;
        System.out.println(this.toString());
    }


    @Override
    public int compareTo(Processo outroProcesso) {

        if(this.tipoPrioridade == "Tempo") {
            if(this.quantum < outroProcesso.quantum){
                return -1;
            } else if (this.quantum > outroProcesso.quantum) {
                return 1;
            } else {
                return 0;
            }
        }

        if(this.tipoPrioridade == "Prioridade") {
            if(this.prioridade > outroProcesso.prioridade) {
                return -1;
            } else if(this.prioridade < outroProcesso.prioridade) {
                return 1;
            } else {
                return 0;
            }

        }

        return 0;

    }

}