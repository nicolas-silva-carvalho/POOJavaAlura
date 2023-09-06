package br.com.alura.POOJava.principal;

import br.com.alura.POOJava.modelos.Titulo;
import br.com.alura.POOJava.modelos.TituloOmdb;
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
import java.util.Locale;
import java.util.Scanner;

public class PrincipalComBusca {
    public static void main(String[] args) throws IOException, InterruptedException {
        String busca = "";
        Scanner scanner = new Scanner(System.in);
        List<Titulo> titulos = new ArrayList<>();

        while (!busca.equalsIgnoreCase("sair")) {
            System.out.println("Digite um filme para busca: ");
            busca = scanner.next();

            if(busca.equalsIgnoreCase("sair")){
                break;
            }

            HttpClient client = HttpClient.newHttpClient();
            String url = "https://www.omdbapi.com/?t=" + busca.replace(" ", "+") + "&apikey=6585022c";

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .build();

            HttpResponse<String> responde = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(responde.body());

            Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).create();
            TituloOmdb filme = gson.fromJson(responde.body(), TituloOmdb.class);
            System.out.println(filme);

            Titulo filmeDto = new Titulo(filme);
            titulos.add(filmeDto);

            FileWriter fileWriter = new FileWriter("filmes.json");
            fileWriter.write(gson.toJson(titulos));
            fileWriter.close();
        }
    }
}
