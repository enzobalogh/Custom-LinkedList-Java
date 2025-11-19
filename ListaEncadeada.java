package com.enzo.estruturadados.lista;

public class ListaEncadeada<T> {

    private Node<T> inicio;
    private Node<T> ultimo;
    private int tamanho;

    private final int NAO_ENCONTRADO = -1;


    public void add(T elemento) {
        Node<T> celula = new Node<T>(elemento);
        if (isEmpty()) {
            this.inicio = celula;
        } else {
            this.ultimo.setProximo(celula);
        }
        this.ultimo = celula;
        this.tamanho++;
    }

    public void adicionaInicio(T elemento) {
        if (this.tamanho == 0) {
            Node<T> novoNode = new Node<>(elemento);
            this.inicio = novoNode;
            this.ultimo = novoNode;

        } else {
            Node<T> novoNode = new Node<>(elemento, this.inicio);
            this.inicio = novoNode;
        }
        this.tamanho++;
    }

    public void add(int posicao, T elemento) {
        if (posicao < 0 || posicao > this.tamanho) {
            throw new IllegalArgumentException("Posição não existe no vetor.");
        }
        if (posicao == 0) { //inicio
            adicionaInicio(elemento);
        } else if (posicao == this.tamanho) { //final
            add(elemento);
        } else { //meio
        Node<T> nodeAnterior = this.buscaNode(posicao - 1);
        Node<T> proximoNode = nodeAnterior.getProximo();
        Node<T> novoNode = new Node<>(elemento, proximoNode);
        nodeAnterior.setProximo(novoNode);
        this.tamanho++;
        }
    }
    public T removeInicio(){
        if(isEmpty()){
            throw new RuntimeException("Lista está vazia!");
        }
        T removido = this.inicio.getElemento();
        this.inicio = this.inicio.getProximo();
        this.tamanho--;
        if(this.tamanho == 0){
            this.ultimo = null;
        }
        return removido ;
    }

    public T removeFinal(){
        if (isEmpty()){
            throw new RuntimeException("Lista está vazia!");
        }
        if(this.tamanho == 1){
            return removeInicio();
        }
        Node<T> penultimo = buscaNode(tamanho-2);
        T removido = penultimo.getProximo().getElemento();
        penultimo.setProximo(null);
        this.ultimo = penultimo;
        this.tamanho--;
        return removido;
    }

    public T removePosicao(int posicao){
        if (posicao < 0 || posicao >= this.tamanho) {
            throw new IllegalArgumentException("Posição não existe no vetor.");
        }
        if(isEmpty()){
            throw new RuntimeException("Lista está vazia!");
        }
        if(posicao == 0){
            return removeInicio();
        }
        if(posicao == this.tamanho-1){
            return removeFinal();
        }
        Node<T> nodeAnterior = this.buscaNode(posicao - 1);

        T removido = nodeAnterior.getProximo().getElemento();

        Node<T> nodePosterior = this.buscaNode(posicao + 1);
        nodeAnterior.setProximo(nodePosterior);
        this.tamanho--;
        return removido;

    }

    public int getTamanho() {
        return this.tamanho;
    }

    public boolean isEmpty() {
        if (this.tamanho == 0) {
            return true;
        } else return false;
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "[]";
        }
        StringBuilder builder = new StringBuilder("[");

        Node<T> atual = this.inicio;
        for (int i = 0; i < this.tamanho - 1; i++) {
            builder.append(atual.getElemento()).append(",");
            atual = atual.getProximo();
        }
        builder.append(atual.getElemento()).append("]");
        return builder.toString();
    }

    public void clear() {
        this.inicio = null;
        this.tamanho = 0;

    }

    public Node<T> buscaNode(int posicao) {

        if (!(posicao >= 0 && posicao <= this.tamanho)) {
            throw new IllegalArgumentException("Posição não existe");
        }
        Node<T> atual = this.inicio;
        for (int i = 0; i < posicao; i++) {
            atual = atual.getProximo();
        }

        return atual;
    }

    public T buscaPorPosicao(int posicao) {
        return this.buscaNode(posicao).getElemento();
    }

    public int busca(T elemento) {
        int pos = 0;
        Node<T> atual = this.inicio;
        while (atual != null) {
            if (atual.getElemento().equals(elemento)) {
                return pos;
            }
            pos++;
            atual = atual.getProximo();


        }
        return NAO_ENCONTRADO;
    }
}
