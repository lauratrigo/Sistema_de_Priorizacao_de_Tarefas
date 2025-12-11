public class Dados {

    private int id;
    private int prioridade;

    public Dados(int id, int prioridade) {
        this.id = id;
        this.prioridade = prioridade;
    }

    public int getId() {
        return id;
    }

    public int getPrioridade() {
        return prioridade;
    }

    public String toString() {
        return String.valueOf(prioridade);
    }
}
