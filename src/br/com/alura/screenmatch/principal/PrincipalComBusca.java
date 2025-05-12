package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.excecao.ErroDeConversaoDeAnoException;
import br.com.alura.screenmatch.modelo.Titulo;
import br.com.alura.screenmatch.modelo.TituloOmdb;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrincipalComBusca {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        String leitura = "";
        List<Titulo> titulos = new ArrayList<>();
        Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).setPrettyPrinting().create();

        while (!leitura.equalsIgnoreCase("sair")) {

            System.out.println("Digite um filme para busca: ");
            leitura = scanner.nextLine();
            String resposta = leitura.trim().replaceAll("\\s+", "+");

            if (leitura.equalsIgnoreCase("sair")) {
                break;
            }

            try {
                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://www.omdbapi.com/?t=" + resposta + "&apikey=8cdc00b0")).build();
                HttpResponse<String> response = client
                        .send(request, HttpResponse.BodyHandlers.ofString());

                TituloOmdb meuTituloOmdb = gson.fromJson(response.body(), TituloOmdb.class);

                Titulo meuTitulo = new Titulo(meuTituloOmdb);
                titulos.add(meuTitulo);

            } catch (NumberFormatException e) {
                System.out.println("Erro: " + e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println("Erro no argumento de busca: " + e.getMessage());
            } catch (ErroDeConversaoDeAnoException e) {
                System.out.println(e.getMessage());
            }
        }
        FileWriter filmesJSON = new FileWriter("filmes.json");
        filmesJSON.write(gson.toJson(titulos));
        filmesJSON.close();
    }
}
