public class Lista {

    private Object[] dados = new Object[1];
    StringBuilder builder;
    private int total = 0;

    // método que adiciona um elemento no final da lista
    public void adiciona(Object dados) {
        this.liberaEspaco();
        this.dados[this.total] = dados;
        this.total++;
    }

    public int tamanho() {
        return this.total;
    }

    public String toString() {
        if (this.total == 0) {
            return "[]";

        }
        builder = new StringBuilder();
        builder.append("[");
        for (int i = 0; i < this.total - 1; i++) {
            builder.append(this.dados[i]);
            builder.append(",");
        }
        builder.append(this.dados[this.total - 1]);
        builder.append("]");
        return builder.toString();
    }

    public boolean contem(Object dados) {
        this.toString();
        return builder.indexOf(dados.toString()) >= 0 ? true : false;
    }

    public boolean posicaoValida(int posicao) {
        return posicao >= 0 && posicao <= total;
    }

    // método que adiciona um elemento em uma posição específica
    public void adiciona(int posicao, Object dados) {
        this.liberaEspaco();
        if (!posicaoValida(posicao)) {
            throw new IllegalArgumentException("***** Posicao invalida ******");
        }

        for (int i = this.total - 1; i >= posicao; i--) {
            this.dados[i + 1] = this.dados[i];
        }

        this.dados[posicao] = dados;
        this.total++;
    }

    private boolean posicaoOcupada(int posicao) {
        return posicao >= 0 && posicao < total;
    }

    public Object pega(int posicao) {
        if (!posicaoOcupada(posicao)) {
            throw new IllegalArgumentException("***** Posicao invalida ******");
        }
        return this.dados[posicao];
    }

    public boolean vazia() {
        return this.total <= 0;
    }

    private void liberaEspaco() {
        if (total == dados.length) {
            Object[] novaArray = new Object[this.dados.length * 2];
            for (int i = 0; i <= dados.length - 1; i++) {
                novaArray[i] = this.dados[i];
            }
            dados = novaArray;
        }
    }

    public void remove(int posicao) {
        if (!posicaoOcupada(posicao)) {
            throw new IllegalArgumentException("***** Posicao invalida ******");
        }

        for (int i = posicao; i < total - 1; i++) { 
            this.dados[i] = this.dados[i + 1];
        }
        total--;
    }

}
