import br.com.alura.screenmatch.modelo.Filme;

public class Principal {
    public static void main(String[] args) {
        Filme meuFilme = new Filme();
        meuFilme.nome = "Ta dando onda";
        meuFilme.sinopse = "Surfar é a atividade do pinguim adolescente Cody Maverick. Acompanhado por uma equipe de filmagem, " +
                "ele deixa sua casa na Antárdida para ir à Ilha de Pen Gu participar do torneio Big Z Memorial Surf Off. Cody acredita " +
                "que ganhando a competição terá o respeito e a admiração de todos.";

        meuFilme.exibeFichaTecnica();
        meuFilme.avalia(8.5);
        meuFilme.avalia(5);
        meuFilme.avalia(10);
        System.out.println(meuFilme.obtemMedia());
        System.out.println(meuFilme.getTotalAvaliacoes());

    }
}
