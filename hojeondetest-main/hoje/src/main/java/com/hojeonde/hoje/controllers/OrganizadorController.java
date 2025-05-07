package com.hojeonde.hoje.controllers;

import com.hojeonde.hoje.models.Organizador;
import com.hojeonde.hoje.services.OrganizadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/organizadores")
public class OrganizadorController {
    @Autowired
    private OrganizadorService organizadorService;

    @GetMapping
    public List<Organizador> getAllOrganizadores() {
        return organizadorService.findAll();
    }

    @GetMapping("/{id}")
    public Organizador getOrganizadorById(@PathVariable String id) {
        return organizadorService.findById(id);
    }

    @PostMapping
    public Organizador createOrganizador(@RequestBody Organizador organizador) {
        return organizadorService.save(organizador);
    }

    @DeleteMapping("/{id}")
    public void deleteOrganizador(@PathVariable String id) {
        organizadorService.delete(id);
    }
}

Descrição Geral
O OrganizadorController é um controlador REST que oferece endpoints para gerenciar organizadores no sistema. Ele interage com a camada de serviço OrganizadorService para fornecer operações de criação, listagem, busca e exclusão de organizadores. Esse controlador é essencial para o gerenciamento de usuários responsáveis pela organização de eventos dentro do sistema.

Estrutura do Código
O controlador OrganizadorController mapeia a base /organizadores e contém os seguintes endpoints:

Listar todos os organizadores.

Buscar um organizador pelo ID.

Criar um novo organizador.

Deletar um organizador pelo ID.

Endpoints Disponíveis
1. GET /organizadores - Listar Todos os Organizadores
Objetivo:
Este endpoint permite que o cliente recupere uma lista completa de todos os organizadores registrados no sistema.

Descrição:
Quando a requisição é feita para o endpoint /organizadores, o servidor retorna uma lista de objetos Organizador, representando todos os organizadores cadastrados. Esse método é útil para visualizar todos os organizadores que estão cadastrados na plataforma.

Resposta Esperada:
Em caso de sucesso, o servidor retorna uma lista de objetos Organizador no formato JSON.

Exemplo de Resposta:

json
[
  {
    "id": "1",
    "nome": "Lucas Pietra",
    "email": "lucas@empresa.com",
    "telefone": "(11) 12345-6789"
  },
  {
    "id": "2",
    "nome": "Ana Souza",
    "email": "ana@empresa.com",
    "telefone": "(11) 98765-4321"
  }
]
Código de Resposta:

200 OK: Lista de organizadores retornada com sucesso.

2. GET /organizadores/{id} - Buscar Organizador pelo ID
Parâmetros:

id (String): O ID do organizador que você deseja consultar.

Objetivo:
Este endpoint permite que o cliente recupere os detalhes de um organizador específico, fornecendo o ID do organizador na URL.

Descrição:
Quando a requisição é feita para o endpoint /organizadores/{id}, o servidor retorna os dados detalhados de um organizador, identificando-o pelo ID fornecido. Se o organizador com o ID informado não for encontrado, o servidor retornará um erro de "não encontrado".

Resposta Esperada:
Em caso de sucesso, o servidor retorna os dados de um único organizador. Caso o organizador não seja encontrado, um erro 404 será retornado.

Exemplo de Resposta:

json
{
  "id": "1",
  "nome": "Lucas Pietra",
  "email": "lucas@empresa.com",
  "telefone": "(11) 12345-6789"
}
Código de Resposta:

200 OK: Organizador encontrado com sucesso.

404 Not Found: O organizador com o ID especificado não foi encontrado.

3. POST /organizadores - Criar Novo Organizador
Objetivo:
Este endpoint permite que o cliente crie um novo organizador no sistema. A requisição deve incluir um objeto Organizador no corpo da mensagem, com os dados necessários para o novo organizador.

Descrição:
Ao enviar uma requisição POST para o endpoint /organizadores, o servidor cria um novo organizador com base nas informações fornecidas. O cliente precisa enviar um objeto Organizador com dados como nome, e-mail e telefone. O servidor retornará os dados do novo organizador, incluindo o ID gerado.

Corpo da Requisição (JSON):

json
{
  "nome": "Carlos Silva",
  "email": "carlos@empresa.com",
  "telefone": "(11) 11223-4455"
}
Resposta Esperada:
Em caso de sucesso, o servidor retorna os dados do organizador criado, incluindo o ID gerado.

Exemplo de Resposta:

json
{
  "id": "3",
  "nome": "Carlos Silva",
  "email": "carlos@empresa.com",
  "telefone": "(11) 11223-4455"
}
Código de Resposta:

201 Created: Organizador criado com sucesso.

4. DELETE /organizadores/{id} - Deletar Organizador pelo ID
Parâmetros:

id (String): O ID do organizador que você deseja excluir.

Objetivo:
Este endpoint permite que um organizador seja excluído do sistema, utilizando seu ID.

Descrição:
Quando uma requisição DELETE é feita para o endpoint /organizadores/{id}, o servidor exclui o organizador com o ID fornecido. Caso o organizador seja excluído com sucesso, o servidor retorna um código de resposta 204 No Content. Caso o organizador não seja encontrado, o servidor retorna um erro 404.

Código de Resposta:

204 No Content: Organizador excluído com sucesso.

404 Not Found: Organizador não encontrado com o ID fornecido.

Estrutura do Código
Classe: OrganizadorController
Pacote: com.hojeonde.hoje.controllers

Dependências Injetadas:

OrganizadorService: Serviço responsável pela lógica de negócios dos organizadores.

Métodos:

getAllOrganizadores(): Retorna uma lista de todos os organizadores.

getOrganizadorById(String id): Retorna um organizador específico pelo ID.

createOrganizador(Organizador organizador): Cria um novo organizador com base nos dados fornecidos.

deleteOrganizador(String id): Exclui um organizador com o ID fornecido.

Exemplo de Fluxo de Uso
Criar Organizador:

Enviar um POST para /organizadores com os dados de um novo organizador no corpo da requisição.

Resposta: Organizador criado com sucesso.

Listar Organizadores:

Enviar um GET para /organizadores para obter todos os organizadores.

Resposta: Lista de organizadores.

Buscar Organizador por ID:

Enviar um GET para /organizadores/{id} para obter os detalhes de um organizador específico.

Resposta: Dados do organizador.

Excluir Organizador:

Enviar um DELETE para /organizadores/{id} para excluir um organizador.

Resposta: Organizador excluído com sucesso e código 204.
