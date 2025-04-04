import br.com.alura.screenmatch.calculos.FiltroRecomendacao;
import br.com.alura.screenmatch.modelo.Episodio;
import br.com.alura.screenmatch.modelo.Filme;
import br.com.alura.screenmatch.calculos.CalculadoraDeTempo;
import br.com.alura.screenmatch.modelo.Serie;

public class Principal {
    public static void main(String[] args) {
        Filme oBichoVaiPegar = new Filme();
        Filme segredoDosAnimais = new Filme();
        Serie rickAndMorty = new Serie();
        CalculadoraDeTempo calculadora = new CalculadoraDeTempo();
        Episodio episodio = new Episodio();

        rickAndMorty.setNome("Rick and Morty");
        rickAndMorty.setMinutosPorEpisodio(24);
        rickAndMorty.setTemporadas(3);
        rickAndMorty.setEpisodiosPorTemporada(15);

        oBichoVaiPegar.setNome("O bicho vai pegar");
        oBichoVaiPegar.avalia(6);
        oBichoVaiPegar.avalia(6);
        oBichoVaiPegar.avalia(6);
        oBichoVaiPegar.setDuracaoEmMinutos(201);

        segredoDosAnimais.setNome("O Segredo dos Animais");
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
    }
}
