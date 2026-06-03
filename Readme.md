# 🔍 GitHub User Search

Este é um projeto prático desenvolvido por mim como parte dos meus estudos na **Alura**. O objetivo principal do sistema é realizar consultas na API pública do GitHub para buscar informações de usuários diretamente pelo console.

Como um **estudante de Java**, utilizei este projeto para aplicar conceitos fundamentais de Orientação a Objetos, consumo de APIs HTTP, leitura e escrita de arquivos, manipulação de JSON e, acima de tudo, organização arquitetural de código (*Clean Code*).

---

## 🚀 Funcionalidades

- **Busca em tempo real:** Consulta diretamente a API pública do GitHub (`https://api.github.com/users/{usuario}`).
- **Exportação de Dados:** Após a busca, o usuário pode escolher salvar os resultados localmente em um arquivo de texto formatado (`.txt`) ou em formato `JSON`.
- **Tratamento de Erros Customizado:** Identifica se um usuário não existe (erro 404) e dispara uma exceção personalizada de forma amigável.
- **Tratamento de Quedas de Conexão e Disco:** Captura falhas de internet separadamente de erros de gravação no disco, sem derrubar o programa de forma abrupta.
- **Interface Limpa no Terminal:** Exibe os dados do usuário de forma organizada e legível no console.

---

## 🆕 Novas Adições da Versão Atual (v1.1)

Nesta última atualização do sistema, o foco foi a evolução da persistência de dados e a robustez do código:
- **Módulo de Gravação (`GitHubUserFileWriter`):** Nova classe dedicada exclusivamente a gerir a escrita de ficheiros, isolando esta lógica do serviço de pesquisa.
- **Ficheiros e JSON:** Agora o utilizador pode escolher exportar o resultado no formato tradicional `.txt` ou com a estrutura crua em `JSON` (formatada com *Pretty Printing* via Gson).
- **Tratamento de Exceções Separado:** Divisão clara entre falhas de rede (`IOException` no HttpClient) e falhas de escrita local (`IOException` no FileWriter).
- **Try-with-resources:** Implementação do fecho automático de recursos (como o `FileWriter`), garantindo que o sistema operativo liberte o ficheiro após o uso.
- **Repositório Protegido (.gitignore):** Configuração estratégica para impedir que ficheiros de teste `.txt` locais ou ficheiros de configuração da IDE subam para o GitHub.

---

## 🛠️ Tecnologias e Recursos Utilizados

- **Java 17+** (Aproveitando recursos modernos como `record`, `try-with-resources` e inferência de tipos com `var`).
- **Java HttpClient:** API nativa do Java para envio de requisições HTTP e recebimento de respostas de forma síncrona.
- **Java I/O:** API nativa (`FileWriter`) para a criação e manipulação de arquivos físicos locais.
- **Gson (Google):** Biblioteca externa utilizada para a serialização (geração) e desserialização (leitura) de objetos Java em formato JSON.

---

## 🏛️ Organização do Projeto (Arquitetura)

Buscando seguir as boas práticas de mercado e o princípio de **Separação de Responsabilidades**, o código foi dividido nos seguintes pacotes dentro de `br.com.fernando.githubsearch`:

1. **`main`**: Contém a classe `Main.java`, responsável por iniciar a aplicação, interagir com as entradas do usuário e orquestrar o fluxo principal dentro de blocos isolados de tratamento de erros.
2. **`services`**: É a camada de inteligência do sistema.
    - `GitHubService.java`: Sabe como construir a URL da API, disparar a requisição e converter o JSON recebido.
    - `GitHubUserFileWriter.java`: Responsável unicamente por lidar com o sistema de arquivos para salvar o resultado no formato desejado.
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