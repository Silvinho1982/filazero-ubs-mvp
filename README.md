# Fila Zero - UBS MVP

MVP simples para demonstração acadêmica de agendamento de atendimento em Unidade Básica de Saúde (UBS).

## Stack

- Java 21
- Spring Boot 4.1.1
- Spring Web
- Spring Data JPA / Hibernate
- Bean Validation
- H2 para desenvolvimento e testes
- PostgreSQL para produção
- Springdoc OpenAPI / Swagger UI
- HTML, CSS e JavaScript puro no frontend

## Fluxo demonstrável

Login → Boas-vindas → Escolha da UBS (1 a 33) → Especialidade → Agendamento → Confirmação.

Também há telas de cadastro e recuperação de acesso.

## Credencial de demonstração

CPF: `12345678900`
Senha: `123456`

## Executar localmente

Pré-requisito: JDK 21 e Maven instalados.

```bash
mvn spring-boot:run
```

Acesse:

- Aplicação: http://localhost:8080
- Swagger UI: http://localhost:8080/swagger-ui.html
- H2 Console: http://localhost:8080/h2-console

Para H2:

- JDBC URL: `jdbc:h2:mem:filazero`
- Usuário: `sa`
- Senha: vazio

## Docker

```bash
docker compose up --build
```

## Endpoints exigidos pela atividade

### Profiles

`POST /api/profiles`

```json
{
  "name": "Silvio Rangel",
  "email": "silvio@example.com",
  "bio": "Desenvolvedor e professor"
}
```

`GET /api/profiles/{id}`

### Technologies

`POST /api/technologies`

```json
{
  "name": "Java",
  "category": "Backend"
}
```

`GET /api/technologies`

### Projects

`POST /api/projects`

```json
{
  "title": "Fila Zero UBS",
  "description": "MVP de agendamento em UBS",
  "repositoryUrl": "https://github.com/exemplo/filazero-ubs-api",
  "profileId": 1,
  "technologyIds": [1]
}
```

`GET /api/projects`

## Endpoints adicionais do MVP

- `POST /api/auth/login`
- `POST /api/auth/register`
- `POST /api/auth/recovery`
- `GET /api/ubs`
- `GET /api/specialties`
- `POST /api/appointments`
- `GET /api/appointments/user/{userId}`
- `GET /api/health`

## Entidades relacionais da atividade

- `Profile 1:N Project`
- `Project N:N Technology`
- `Project 1:N Feedback`

O MVP também inclui as entidades de domínio necessárias para a demonstração de agendamento: `UserAccount`, `Ubs`, `Specialty` e `Appointment`.

## Publicar no GitHub

```bash
git init
git add .
git commit -m "feat: cria MVP Fila Zero UBS"
git branch -M main
git remote add origin https://github.com/SEU_USUARIO/filazero-ubs-mvp.git
git push -u origin main
```

> Observação: o login deste MVP é propositalmente simples para fins de apresentação acadêmica. Em produção, a autenticação deve usar hash seguro de senha, sessão/JWT, MFA e controles de acesso.
