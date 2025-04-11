# 🚚 Gestão de Entregadores - Back-End

API REST com Spring Boot e MySQL para gerenciamento de entregadores, rotas e checkpoints.

## 🚀 Tecnologias
- Java 21 + Spring Boot
- Spring Web + Spring Data JPA
- Lombok
- MySQL
- Swagger (OpenAPI)

## ✅ Funcionalidades
- Cadastro de entregadores
- Criação de rotas e checkpoints
- Associação entre entregador e rota
- Busca completa de entregador com rota
- Status: Ativo/Inativo
- Integração com front-end em tempo real
- Documentação via Swagger

## 🔗 Endpoints principais
- `GET /api/entregadores`
- `GET /api/entregadores/{id}`
- `POST /api/entregadores`
- `PUT /api/entregadores/{id}/rota/{rotaId}`
- `GET /swagger-ui.html`

## 🛠️ Como rodar
```bash
git clone https://github.com/seu-usuario/gestaoentregadores-backend.git
cd backend
./mvnw spring-boot:run
