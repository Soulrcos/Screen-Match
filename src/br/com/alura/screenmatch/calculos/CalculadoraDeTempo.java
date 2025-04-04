package br.com.alura.screenmatch.calculos;

import br.com.alura.screenmatch.modelo.Titulo;

public class CalculadoraDeTempo {
    private int tempoTotal;

    public int getTempoTotal() {
        return tempoTotal;
    }

    public void inclui(Titulo titulo){
        this.tempoTotal += titulo.getDuracaoEmMinutos();
    }

    public int retornaHora(){
        return tempoTotal/60;
    }

    public int retornaMinutos(){
        return tempoTotal%60;
    }
}
