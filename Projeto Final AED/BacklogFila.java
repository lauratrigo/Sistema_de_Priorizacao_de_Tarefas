public class BacklogFila {

    private Lista backlog = new Lista();

    public void adicionarTarefa(Dados nova) {

        int n = backlog.tamanho();

        // caso o backlog esteja vazio
        if (n == 0) {
            backlog.adiciona(nova);
            return;
        }

        int prioridade = nova.getPrioridade();

        // 1. busca da posição correta (insertion sort)
        int j = n - 1;
        while (j >= 0 && ((Dados) backlog.pega(j)).getPrioridade() > prioridade) {
            j--;
        }

        int indiceInsercao = j + 1;

        // 2. criar fila auxiliar
        Fila fila = new Fila();

        // 3. colocar na fila todos os elementos que precisam ser deslocados
        for (int k = indiceInsercao; k < n; k++) {
            fila.Insere(backlog.pega(k));
        }

        // 4. remover da lista esses elementos (abrindo “espaço”)
        for (int k = n - 1; k >= indiceInsercao; k--) {
            backlog.remove(k);
        }

        // 5. inserir a nova tarefa na posição correta
        backlog.adiciona(indiceInsercao, nova);

        // 6. recolocar tudo da fila (mantendo ordem FIFO)
        while (!fila.pEmpty()) {
            backlog.adiciona(fila.remover());
        }
    }

    // usado pela interface gráfica
    public Object[] getListaComoArray() {
        Object[] arr = new Object[backlog.tamanho()];
        for (int i = 0; i < backlog.tamanho(); i++) {
            arr[i] = backlog.pega(i);
        }
        return arr;
    }
}
