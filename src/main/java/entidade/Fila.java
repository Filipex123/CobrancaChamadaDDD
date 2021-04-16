package entidade;

public class Fila {

    private class Nodo {
        private String info;
        private Nodo prox;

        public Nodo(String info) {
            this.info = info;
        }

        public String getInfo() {
            return info;
        }

        public void setInfo(String info) {
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

    public void insere(String elem) throws Exception {

        //regex para validar entrada de numero telefônico
        if (!elem.matches("^\\(?[0-9]{2}\\)?[0-9]{5}-?[0-9]{4}$")) {
            throw new Exception("Número telefônico inválido");
        }

        Nodo novo = new Nodo(elem);

        if(this.prim == null) {
            //TODO remover parenteses do primeiro
            this.prim = novo;
            this.ult = novo;
        } else {
            inserOrdenada(novo);
        }
    }

    public String remove() throws Exception {
        if(isVazia()) {
            throw new Exception("Fila vazia");
        }

        String aux = this.prim.getInfo();

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

    private void inserOrdenada(Nodo novo) {
        //TODO padronizar texto de numero
        Integer ddd = Integer.parseInt(novo.getInfo().replace("(", "").substring(0,2));


        for(Nodo aux = this.prim ; aux != null ; aux = aux.getProx()) {
            Integer dddAux = Integer.parseInt(aux.getInfo().substring(0,2));
            Integer dddAuxProx = Integer.parseInt(aux.getProx().getInfo().substring(0,2));
            //TODO inserir por ultimo caso tenha igual

            if(ddd > dddAux) {
                novo.setProx(this.prim);
                this.prim = novo;
            } else if(ddd <= dddAux && ddd > dddAuxProx) {
                novo.setProx(aux.getProx());
                aux.setProx(novo);
            } else {
                //TODO colocar no final de elementos iguais
            }
        }
    }
}
