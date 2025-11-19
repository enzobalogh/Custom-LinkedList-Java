package teste;

import com.enzo.estruturadados.lista.ListaEncadeada;

public class ListaEncadeadaApp {
    public static void main(String[] args) {
        System.out.println("== LISTA ENCADEADA ==");
        ListaEncadeada <Integer> lista = new ListaEncadeada<>();
        lista.add(1);
        System.out.println(lista);
        System.out.println("Tamanho da lista: "+lista.getTamanho());

        lista.add(2);
        System.out.println(lista);
        System.out.println("Tamanho da lista: "+lista.getTamanho());

        lista.add(3);
        System.out.println(lista);
        System.out.println("Tamanho da lista: "+lista.getTamanho());

        System.out.println("Removendo o elemento "+lista.removeInicio()+"..");
        System.out.println(lista);
        System.out.println("Tamanho da lista: "+lista.getTamanho());
        System.out.println("Removendo o elemento "+lista.removeInicio()+"..");
        System.out.println(lista);
        System.out.println("Tamanho da lista: "+lista.getTamanho());
        System.out.println("Removendo o elemento "+lista.removeInicio()+"..");
        System.out.println(lista);
        System.out.println("Tamanho da lista: "+lista.getTamanho());

        System.out.println("Adicionando elementos novamente..");
        lista.add(1);
        lista.add(2);
        lista.add(3);
        System.out.println(lista);

        System.out.println("Esvaziando lista..");
        lista.clear();
        System.out.println(lista);




    }
}
