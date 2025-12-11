public class Fila {

    private Lista lista = new Lista();

    public void Insere(Object objeto) {
        lista.adiciona(objeto);
    }

    public Object remover() {
        if (!pEmpty()) {
            Object objeto = lista.pega(0);
            lista.remove(0);
            return objeto;
        }
        return null;
    }

    public boolean pEmpty() {
        return lista.vazia();
    }

    public Object mostra() {
        return lista.toString();
    }
}
