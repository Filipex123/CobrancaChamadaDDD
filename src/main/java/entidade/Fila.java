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
            this.prim = novo;
            this.ult = novo;
        } else {
            this.ult.setProx(novo);
            this.ult = this.ult.getProx();
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

    private void ordena(String elem) {

        Integer ddd = Integer.parseInt(elem.replace("(", "").substring(0,2));

        for(Nodo aux = this.prim ; aux != null ; aux = aux.getProx()) {
            //TODO ordenação ASC
        }
    }


    public void insertionSort(int[] vetor){
        for (int i = 1; i < vetor.length; i++){

            int aux = vetor[i];
            int j = i;

            while ((j > 0) && (vetor[j-1] > aux)){
                vetor[j] = vetor[j-1];
                j -= 1;
            }
            vetor[j] = aux;
        }
    }

}
