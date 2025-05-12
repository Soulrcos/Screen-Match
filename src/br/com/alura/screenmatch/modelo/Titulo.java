package br.com.alura.screenmatch.modelo;

import br.com.alura.screenmatch.excecao.ErroDeConversaoDeAnoException;

public class Titulo implements Comparable<Titulo>{
    private String nome;
    private int anoDeLancamento;
    private boolean incluidoNoPlano;
    private double somaDasAvaliacoes;
    private int totalAvaliacoes;
    private String sinopse;
    private int duracaoEmMinutos;

    public Titulo(String nome, int anoDeLancamento) {
        this.nome = nome;
        this.anoDeLancamento = anoDeLancamento;
    }

    public Titulo(TituloOmdb meuTituloOmdb) {
        this.nome = meuTituloOmdb.title();

        try {
            if (meuTituloOmdb.year().length() > 4) {
                throw new ErroDeConversaoDeAnoException("Não consegui converter o ano.");
            }
        } catch (Exception e) {
            System.out.println("Não foi possível encontrar seu filme!");
        }

        this.anoDeLancamento = Integer.valueOf(meuTituloOmdb.year());

        if (meuTituloOmdb.runtime().contains("min")){
            this.duracaoEmMinutos = Integer.valueOf(meuTituloOmdb.runtime().substring(0, meuTituloOmdb.runtime().length() - 4));
        }
        else {
            this.duracaoEmMinutos = 0;
        }

    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setAnoDeLancamento(int anoDeLancamento) {
        this.anoDeLancamento = anoDeLancamento;
    }

    public void setIncluidoNoPlano(boolean incluidoNoPlano) {
        this.incluidoNoPlano = incluidoNoPlano;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    public int getDuracaoEmMinutos() {
        return duracaoEmMinutos;
    }

    public void setDuracaoEmMinutos(int duracaoEmMinutos) {
        this.duracaoEmMinutos = duracaoEmMinutos;
    }

    public String getNome() {
        return nome;
    }

    public int getAnoDeLancamento() {
        return anoDeLancamento;
    }

    public boolean isIncluidoNoPlano() {
        return incluidoNoPlano;
    }

    public int getTotalAvaliacoes(){
        return totalAvaliacoes;
    }

    public String getSinopse() {
        return sinopse;
    }

    public void exibeFichaTecnica () {
        System.out.println("Nome: " + nome);
        System.out.println("Ano de lançamento: " + anoDeLancamento);
    }

    public void avalia(double nota){
        somaDasAvaliacoes += nota;
        totalAvaliacoes++;
    }

    public double obtemMedia(){
        return somaDasAvaliacoes/totalAvaliacoes;
    }

    @Override
    public int compareTo(Titulo outroTitulo) {
        return this.getNome().compareTo(outroTitulo.getNome());
    }

    @Override
    public String toString() {
        return "nome: " + nome +
                "\nanoDeLancamento: " + anoDeLancamento +
                "\nDuração: " + duracaoEmMinutos + " min\n";
    }
}
