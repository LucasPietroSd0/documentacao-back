package com.hojeonde.hoje.controllers;

import com.hojeonde.hoje.models.User;
import com.hojeonde.hoje.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAllUsers() {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.findById(id);
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.save(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.delete(id);
    }
}


Descrição Geral
O UserController é um controlador REST responsável por gerenciar as operações de usuários dentro do sistema. Ele interage com o serviço UserService para realizar operações essenciais como a criação, listagem, busca e exclusão de usuários. Este controlador é fundamental para o gerenciamento dos dados de usuários em um sistema de eventos ou qualquer aplicação que envolva autenticação e autorização.

Estrutura do Código
O controlador UserController mapeia a base /users e contém os seguintes endpoints principais:

Listar todos os usuários.

Buscar um usuário pelo ID.

Criar um novo usuário.

Deletar um usuário pelo ID.

Endpoints Disponíveis
1. GET /users - Listar Todos os Usuários
Objetivo:
Este endpoint permite que o cliente recupere uma lista completa de todos os usuários registrados no sistema.

Descrição:
Quando a requisição é feita para o endpoint /users, o servidor retorna uma lista de objetos User, representando todos os usuários registrados na plataforma. Este é o método ideal para visualizar todos os usuários.

Resposta Esperada:
Em caso de sucesso, o servidor retorna uma lista de objetos User no formato JSON.

Exemplo de Resposta:

json
[
  {
    "id": 1,
    "nome": "Lucas Pietra",
    "email": "lucas@empresa.com",
    "telefone": "(11) 12345-6789"
  },
  {
    "id": 2,
    "nome": "Ana Souza",
    "email": "ana@empresa.com",
    "telefone": "(11) 98765-4321"
  }
]
Código de Resposta:

200 OK: Lista de usuários retornada com sucesso.

2. GET /users/{id} - Buscar Usuário pelo ID
Parâmetros:

id (Long): O ID do usuário que você deseja consultar.

Objetivo:
Este endpoint permite que o cliente recupere os dados de um usuário específico, fornecendo o ID do usuário na URL.

Descrição:
Quando uma requisição é feita para o endpoint /users/{id}, o servidor retorna os dados detalhados de um usuário identificado pelo ID fornecido. Se o usuário com o ID informado não for encontrado, o servidor retorna um erro de "não encontrado".

Resposta Esperada:
Em caso de sucesso, o servidor retorna os dados de um único usuário. Caso o usuário não seja encontrado, um erro 404 será retornado.

Exemplo de Resposta:

json
{
  "id": 1,
  "nome": "Lucas Pietra",
  "email": "lucas@empresa.com",
  "telefone": "(11) 12345-6789"
}
Código de Resposta:

200 OK: Usuário encontrado com sucesso.

404 Not Found: O usuário com o ID especificado não foi encontrado.

3. POST /users - Criar Novo Usuário
Objetivo:
Este endpoint permite que um novo usuário seja criado no sistema. A requisição deve incluir um objeto User no corpo da mensagem, com os dados necessários para o novo usuário.

Descrição:
Quando o cliente envia uma requisição POST para o endpoint /users, o servidor cria um novo usuário com os dados fornecidos. O cliente deve enviar um objeto User contendo informações como nome, e-mail e telefone. O servidor então retorna os dados do novo usuário, incluindo o ID gerado.

Corpo da Requisição (JSON):

json
{
  "nome": "Carlos Silva",
  "email": "carlos@empresa.com",
  "telefone": "(11) 11223-4455"
}
Resposta Esperada:
Em caso de sucesso, o servidor retorna os dados do usuário criado, incluindo o ID gerado.

Exemplo de Resposta:

json
{
  "id": 3,
  "nome": "Carlos Silva",
  "email": "carlos@empresa.com",
  "telefone": "(11) 11223-4455"
}
Código de Resposta:

201 Created: Usuário criado com sucesso.

4. DELETE /users/{id} - Deletar Usuário pelo ID
Parâmetros:

id (Long): O ID do usuário que você deseja excluir.

Objetivo:
Este endpoint permite que um usuário seja excluído do sistema, utilizando seu ID.

Descrição:
Quando uma requisição DELETE é feita para o endpoint /users/{id}, o servidor exclui o usuário com o ID fornecido. Caso o usuário seja excluído com sucesso, o servidor retorna um código de resposta 204 No Content. Se o usuário não for encontrado, o servidor retorna um erro 404.

Código de Resposta:

204 No Content: Usuário excluído com sucesso.

404 Not Found: Usuário não encontrado com o ID fornecido.

Estrutura do Código
Classe: UserController
Pacote: com.hojeonde.hoje.controllers

Dependências Injetadas:

UserService: Serviço responsável pela lógica de negócios dos usuários.

Métodos:

getAllUsers(): Retorna uma lista de todos os usuários.

getUserById(Long id): Retorna um usuário específico pelo ID.

createUser(User user): Cria um novo usuário com base nos dados fornecidos.

deleteUser(Long id): Exclui um usuário com o ID fornecido.

Exemplo de Fluxo de Uso
Criar Usuário:

Enviar um POST para /users com os dados de um novo usuário no corpo da requisição.

Resposta: Usuário criado com sucesso.

Listar Usuários:

Enviar um GET para /users para obter todos os usuários.

Resposta: Lista de usuários.

Buscar Usuário por ID:

Enviar um GET para /users/{id} para obter os detalhes de um usuário específico.

Resposta: Dados do usuário.

Excluir Usuário:

Enviar um DELETE para /users/{id} para excluir um usuário.

Resposta: Usuário excluído com sucesso e código 204.
