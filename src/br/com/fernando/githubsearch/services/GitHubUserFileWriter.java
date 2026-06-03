package br.com.fernando.githubsearch.services;

import br.com.fernando.githubsearch.models.GitHubUser;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;

public class GitHubUserFileWriter {
    Gson gson = new GsonBuilder()
            .setPrettyPrinting()
            .create();

    public void saveFile (GitHubUser user) throws IOException {
        var nameFile = user.login() + ".txt";

        try (FileWriter writer = new FileWriter(nameFile)) {
            writer.write("===================================\n");
            writer.write("        Usuário encontrado\n");
            writer.write("===================================\n");
            writer.write("Nome do usuário: " + user.login() + "\n");
            writer.write("Id do usuário:   " + user.id() + "\n");
            writer.write("Tipo de usuário: " + user.userViewType() + "\n");
            writer.write("Repositórios:    " + user.publicRepos() + "\n");
        }

        System.out.println("Arquivo salvo com sucesso!");

    }

    public void saveFileJSON (GitHubUser user) throws IOException {
        var nameFile = user.login() + "Json.txt";

        FileWriter writer = new FileWriter(nameFile);
        writer.write(gson.toJson(user));

        writer.close();

        System.out.println("Arquivo salvo com sucesso!");
    }
}
