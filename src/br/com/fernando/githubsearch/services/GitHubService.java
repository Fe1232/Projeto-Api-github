package br.com.fernando.githubsearch.services;

import br.com.fernando.githubsearch.exceptions.UserDoesNotExistException;
import br.com.fernando.githubsearch.models.GitHubUser;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class GitHubService {
    private final Gson gson = new Gson();
    private final HttpClient client = HttpClient.newHttpClient();

    public GitHubUser gitHubSearch(String nameUser) throws IOException, InterruptedException {
        var address = "https://api.github.com/users/" + nameUser;

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(address))
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() == 404) {
            throw new UserDoesNotExistException("Este usuário não existe.");
        }
        GitHubUser gitHubUser = gson.fromJson(response.body(), GitHubUser.class);

        return gitHubUser;
    }
}
