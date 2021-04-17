package entidade;

public class Fila {

    private class Nodo {
        private Chamada info;
        private Nodo prox;

        public Nodo(Chamada info) {
            this.info = info;
        }

        public Chamada getInfo() {
            return info;
        }

        public void setInfo(Chamada info) {
            this.info = info;
        }

        public Nodo getProx() {
            return prox;
        }

        public void setProx(Nodo prox) {
            this.prox = prox;
        }
    }

    private Nodo prim;
    private Nodo ult;

    public void insere(Chamada elem) throws Exception {

        Nodo novo = new Nodo(elem);

        if(this.prim == null) {
            this.prim = novo;
            this.ult = novo;
        } else if (elem.getDdd().getCodigo() == 19) {
            this.ult.setProx(novo);
            this.ult = this.ult.getProx();
        }
        else {
            insereOrdenada(novo);
        }
    }

    public Chamada remove() throws Exception {
        if(isVazia()) {
            throw new Exception("Fila vazia");
        }

        Chamada aux = this.prim.getInfo();

        if(this.prim == this.ult) {
            this.prim = null;
            this.ult = null;
        } else {
            this.prim = this.prim.getProx();
        }

        return aux;
    }

    private boolean isVazia() {
         return this.prim == null;
    }

    private void insereOrdenada(Nodo novo) {

        int ddd = novo.getInfo().getDdd().getCodigo();
        for(Nodo aux = this.prim ; aux != null ; aux = aux.getProx()) {
            if(aux.getProx() == null) {
                aux.setProx(novo);
                this.ult = aux.getProx();
                return;
            }

            int dddAux = aux.getInfo().getDdd().getCodigo();
            int dddAuxProx = aux.getProx().getInfo().getDdd().getCodigo();

            if(ddd > dddAux && this.prim.getInfo().getDdd().getCodigo() == dddAux) {
                novo.setProx(this.prim);
                this.prim = novo;
                return;
            } else if(ddd <= dddAux && ddd > dddAuxProx) {
                novo.setProx(aux.getProx());
                aux.setProx(novo);
                return;
            }
        }
    }

    public void printaFila() {
        System.out.println("Fila de espera: ");
        System.out.println("----------------------------------");
        int pos = 1;
        for (Nodo aux = this.prim; aux != null; aux = aux.getProx()) {
            System.out.println("Posição na fila: "+pos+"º " + aux.getInfo().toString());
            pos++;
        }
        System.out.println("----------------------------------");
    }
}
