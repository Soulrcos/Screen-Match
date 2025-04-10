package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.calculos.FiltroRecomendacao;
import br.com.alura.screenmatch.modelo.Episodio;
import br.com.alura.screenmatch.modelo.Filme;
import br.com.alura.screenmatch.calculos.CalculadoraDeTempo;
import br.com.alura.screenmatch.modelo.Serie;

import java.util.ArrayList;

public class Principal {
    public static void main(String[] args) {
        Filme oBichoVaiPegar = new Filme("O bicho vai pegar", 2006);
        Filme segredoDosAnimais = new Filme("O Segredo dos Animais", 2006);
        Serie rickAndMorty = new Serie("Rick and Morty", 2013);
        CalculadoraDeTempo calculadora = new CalculadoraDeTempo();
        Episodio episodio = new Episodio();

        rickAndMorty.setMinutosPorEpisodio(24);
        rickAndMorty.setTemporadas(3);
        rickAndMorty.setEpisodiosPorTemporada(15);

        oBichoVaiPegar.avalia(6);
        oBichoVaiPegar.avalia(6);
        oBichoVaiPegar.avalia(6);
        oBichoVaiPegar.setDuracaoEmMinutos(201);

        segredoDosAnimais.setDuracaoEmMinutos(127);

        episodio.setNumero(1);
        episodio.setSerie(rickAndMorty);
        episodio.setTotalVisualizacoes(100);

        calculadora.inclui(segredoDosAnimais);
        calculadora.inclui(oBichoVaiPegar);
        calculadora.inclui(rickAndMorty);
        System.out.println(calculadora.retornaHora() + " horas e " + calculadora.retornaMinutos() + " minutos");


        FiltroRecomendacao filtro = new FiltroRecomendacao();
        filtro.filtra(oBichoVaiPegar);
        filtro.filtra(episodio);



        var filmeMarcos = new Filme("Ta dando onda", 2009);
        filmeMarcos.setDuracaoEmMinutos(107);
        filmeMarcos.avalia(10);

        ArrayList<Filme> listaDeFilmes = new ArrayList<>();
        listaDeFilmes.add(filmeMarcos);
        listaDeFilmes.add(oBichoVaiPegar);
        listaDeFilmes.add(segredoDosAnimais);
        System.out.println("Tamanho lista: " + listaDeFilmes.size());
        System.out.println("Primeiro filme: " + listaDeFilmes.getFirst().getNome());
        System.out.println(listaDeFilmes);
    }
}
