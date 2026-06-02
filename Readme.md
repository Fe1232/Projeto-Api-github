# 🔍 GitHub User Search

Este é um projeto prático desenvolvido por mim como parte dos meus estudos na **Alura**. O objetivo principal do sistema é realizar consultas na API pública do GitHub para buscar informações de usuários diretamente pelo console.

Como um **estudante de Java**, utilizei este projeto para aplicar conceitos fundamentais de Orientação a Objetos, consumo de APIs HTTP, manipulação de arquivos JSON e, acima de tudo, organização arquitetural de código (*Clean Code*).

---

## 🚀 Funcionalidades

- **Busca em tempo real:** Consulta diretamente a API pública do GitHub (`https://api.github.com/users/{usuario}`).
- **Tratamento de Erros Customizado:** Identifica se um usuário não existe (erro 404) e dispara uma exceção personalizada de forma amigável.
- **Tratamento de Quedas de Conexão:** Captura falhas de internet ou interrupções na requisição sem derrubar o programa de forma abrupta.
- **Interface Limpa no Terminal:** Exibe os dados do usuário de forma organizada e legível no console.

---

## 🛠️ Tecnologias e Recursos Utilizados

- **Java 17+** (Aproveitando recursos modernos como `record` e inferência de tipos com `var`).
- **Java HttpClient:** API nativa do Java para envio de requisições HTTP e recebimento de respostas de forma síncrona.
- **Gson (Google):** Biblioteca externa utilizada para a desserialização do JSON para o objeto Java.
- **Try-with-resources:** Garantia de gerenciamento e fechamento automático de recursos de entrada (`Scanner`).

---

## 🏛️ Organização do Projeto (Arquitetura)

Buscando seguir as boas práticas de mercado e o princípio de **Separação de Responsabilidades**, o código foi dividido nos seguintes pacotes dentro de `br.com.fernando.githubsearch`:

1. **`main`**: Contém a classe `Main.java`, responsável por iniciar a aplicação, interagir com as entradas do usuário e orquestrar o fluxo principal dentro de um bloco de tratamento de erros.
2. **`services`**: Contém o `GitHubService.java`. É a camada de negócio que sabe como construir a URL da API, disparar a requisição HTTP e converter o JSON recebido em um objeto Java.
3. **`models`**: Contém o `GitHubUser.java` estruturado como um `record`. Utiliza a anotação `@SerializedName` do Gson para mapear as chaves em *snake_case* do JSON (ex: `user_view_type`) para o padrão *camelCase* do Java (`userViewType`), mantendo as convenções da linguagem.
4. **`exceptions`**: Contém a `UserDoesNotExistException.java`, uma exceção customizada que estende `RuntimeException` para isolar a lógica de erro de negócio (usuário inexistente).
5. **`ui`**: Contém a classe `GitHubUserView.java`, responsável unicamente pela formatação visual e exibição dos dados obtidos para o usuário final no console.

---

## ⚙️ Como Executar o Projeto

### Pré-requisitos
- Ter o **JDK 17** (ou superior) instalado em sua máquina.
- Ter a biblioteca **Gson** configurada no seu projeto (via Maven, Gradle ou adicionando o `.jar` manualmente às dependências do projeto).

### Passo a Passo

1. **Clonar o repositório:**
   ```bash
   git clone [https://github.com/seu-usuario/seu-repositorio.git](https://github.com/seu-usuario/seu-repositorio.git)