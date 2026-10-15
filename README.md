# Recomendador de Animes

Aplicação em **Spring Boot** que, a partir de um anime pesquisado, indica outros animes parecidos. Os dados vêm da API pública da [AniList](https://anilist.co) e ficam guardados em um banco **PostgreSQL**, onde a comparação é feita.

> **Status:** etapa 2 concluída (entidades e repositories). Próxima etapa: client da AniList e DTOs.

## Objetivo

O usuário pesquisa um anime e recebe uma lista de outros parecidos, comparando características como **tema, gênero, demografia e nota**. O projeto também serve como estudo de uma arquitetura em camadas com Spring Boot.

**Escopo atual:** apenas animes, sem usuário.

**Ideias futuras:**

- Filtro de franquia, para não recomendar continuações do anime pesquisado
- Perfil do usuário com lista de animes "assistido" e "quero assistir"
- Escolha inicial de gostos, ao estilo do onboarding do Spotify

## Tecnologias

- Java 17 ou superior e Spring Boot (Maven)
- Spring Data JPA
- PostgreSQL e Flyway
- API GraphQL da AniList
- JUnit para testes

## Etapas

- [x] **1.** Criar o projeto, conectar ao PostgreSQL e configurar as migrações
- [x] **2.** Entidades e repositories
- [ ] **3.** Client da AniList e DTOs
- [ ] **4.** Importação de animes (carga inicial e sob demanda)
- [ ] **5.** Endpoints de busca e detalhe
- [ ] **6.** Cálculo de similaridade

## Como executar

### Pré-requisitos

- JDK 17 ou superior
- PostgreSQL, com o `psql` disponível no terminal
- Git

### 1. Clonar o repositório

```
git clone <url-do-repositorio>
cd <pasta-do-projeto>
```

### 2. Criar o banco

Entre no `psql` como administrador (`psql -U postgres`) e execute:

```sql
CREATE USER anime_user WITH PASSWORD 'escolha_uma_senha';
CREATE DATABASE anime_recommender OWNER anime_user;
```

### 3. Definir a senha por variável de ambiente

A aplicação lê a senha do banco da variável `DB_PASSWORD`. Use a mesma senha do passo anterior.

```
# Windows (CMD)
set DB_PASSWORD=sua_senha

# Linux / macOS
export DB_PASSWORD=sua_senha
```

Se você roda pela IDE, defina a variável na configuração de execução.

### 4. Rodar a aplicação

```
# Windows (CMD)
mvnw spring-boot:run

# Linux / macOS
./mvnw spring-boot:run
```

As tabelas são criadas automaticamente na primeira execução.

### 5. Rodar os testes

Com a variável `DB_PASSWORD` definida:

```
# Windows (CMD)
mvnw test

# Linux / macOS
./mvnw test
```

Os testes usam o banco local configurado acima, e as alterações feitas por eles são desfeitas ao final de cada teste.

## Créditos

Dados fornecidos pela [AniList](https://anilist.co).
