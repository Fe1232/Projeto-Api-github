package br.com.fernando.githubsearch.ui;

import br.com.fernando.githubsearch.models.GitHubUser;

public class GitHubUserView {
    public void displayUser(GitHubUser user) {
        System.out.println("\n===================================");
        System.out.println("        Usuário encontrado");
        System.out.println("===================================");
        System.out.println("Nome do usuário: " + user.login());
        System.out.println("Id do usuário:   " + user.id());
        System.out.println("Tipo de usuário: " + user.userViewType());
        System.out.println("Repositórios:    " + user.publicRepos());
        System.out.println("\n\nVocê gostaria de salvar os dados em um arquivo .txt? (Sim/Não)");
    }
}
