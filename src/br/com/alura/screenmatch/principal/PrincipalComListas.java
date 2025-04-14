package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.modelo.Filme;
import br.com.alura.screenmatch.modelo.Serie;
import br.com.alura.screenmatch.modelo.Titulo;

import java.util.*;

public class PrincipalComListas {
    public static void main(String[] args) {
        var oBichoVaiPegar = new Filme("O Bicho vai pegar", 2006);
        oBichoVaiPegar.avalia(8);
        var oSegredoDosAnimais = new Filme("O Segredo dos Animais", 2006);
        oSegredoDosAnimais.avalia(9);
        var taDandoOnda = new Filme("Ta Dando Onda", 2007);
        taDandoOnda.avalia(7);
        var rickAndMorty = new Serie("Rick and Morty", 2013);

        ArrayList<Titulo> assistidos = new ArrayList<>();
        assistidos.add(oBichoVaiPegar);
        assistidos.add(oSegredoDosAnimais);
        assistidos.add(taDandoOnda);
        assistidos.add(rickAndMorty);

        for (Titulo item: assistidos){
            System.out.println(item.getNome());
            if (item instanceof Filme filme){
                System.out.println("Classificação " + filme.getClassificacao());
            }
        }

        List<String> buscaPorArtista = new LinkedList<>();
        buscaPorArtista.add("Jason Momoa");
        buscaPorArtista.add("The Rock");
        buscaPorArtista.add("Terry Crews");

        System.out.println(buscaPorArtista);

        Collections.sort(buscaPorArtista);

        System.out.println("Pós ordenação \n" + buscaPorArtista);

        Collections.sort(assistidos);

        System.out.println("Titulos ordenados: \n" + assistidos);

        assistidos.sort(Comparator.comparing(Titulo::getAnoDeLancamento));

        System.out.println("Titulos ordenados por lancamento: \n" + assistidos);

    }
}
