package br.com.fernando.githubsearch.models;

import com.google.gson.annotations.SerializedName;

public record GitHubUser(
        String login,
        int id,

        @SerializedName("user_view_type")
        String userViewType,

        @SerializedName("public_repos")
        int publicRepos
) {
}
