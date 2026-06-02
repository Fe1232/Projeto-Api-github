package br.com.fernando.githubsearch.main;

import br.com.fernando.githubsearch.exceptions.UserDoesNotExistException;
import br.com.fernando.githubsearch.models.GitHubUser;
import br.com.fernando.githubsearch.services.GitHubService;
import br.com.fernando.githubsearch.ui.GitHubUserView;

import java.io.IOException;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        GitHubService gitHubService = new GitHubService();

        System.out.println("Bem vindo ao sistema de pesquisa de usuários no github.");
        System.out.println("Digite o nome do usuário que você quer pesquisar:");
        var nameUser = scanner.nextLine();

        try {
            GitHubUser user = gitHubService.gitHubSearch(nameUser);

            GitHubUserView view = new GitHubUserView();
            view.displayUser(user);
        } catch (UserDoesNotExistException e) {
            System.out.println(e.getMessage());
        } catch (IOException | InterruptedException e) {
            System.out.println("Erro de conexão. Verifique sua internet.");
        }
        scanner.close();
    }
}
