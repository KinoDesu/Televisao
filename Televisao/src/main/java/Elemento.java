public class Elemento {
    private Object objeto;
    private Elemento prox;
    private Elemento ant;

    public Elemento(Object objeto, Elemento ant,Elemento prox) {
        this.objeto = objeto;
        this.ant = ant;
        this.prox = prox;
    }

    public Object getObjeto() {
        return objeto;
    }

    public void setObjeto(Object objeto) {
        this.objeto = objeto;
    }

    public Elemento getProx() {
        return prox;
    }

    public void setProx(Elemento prox) {
        this.prox = prox;
    }

    public Elemento getAnt() {
        return ant;
    }

    public void setAnt(Elemento ant) {
        this.ant = ant;
    }
}
