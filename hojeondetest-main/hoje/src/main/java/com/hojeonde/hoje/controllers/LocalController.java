package com.hojeonde.hoje.controllers;

import com.hojeonde.hoje.models.Local;
import com.hojeonde.hoje.services.LocalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/local")
public class LocalController {
    @Autowired
    private LocalService localService;

    @GetMapping
    public List<Local> getAllLocais() {
        return localService.findAll();
    }

    @GetMapping("/{id}")
    public Local getLocalById(@PathVariable String id) {
        return localService.findById(id);
    }

    @PostMapping
    public Local createLocal(@RequestBody Local local) {
        return localService.save(local);
    }

    @DeleteMapping("/{id}")
    public void deleteLocal(@PathVariable String id) {
        localService.delete(id);
    }
}

Descrição Geral
O LocalController é um controlador REST que fornece endpoints para gerenciar locais dentro de um sistema de eventos. Ele permite que os clientes consultem, criem e excluam locais registrados, todos acessíveis via API. Esse controlador interage com a camada de serviço LocalService, responsável por manipular a lógica de negócios dos locais.

Estrutura do Código
O controlador LocalController está mapeado para o caminho base /local, e dentro dele, possui quatro endpoints principais:

Listar todos os locais

Buscar um local pelo ID

Criar um novo local

Deletar um local pelo ID

Endpoints Disponíveis
1. GET /local - Listar Todos os Locais
Objetivo:
Este endpoint permite que o cliente recupere uma lista completa de todos os locais registrados no sistema.

Descrição:
Quando a requisição é feita para o endpoint /local, a aplicação retorna uma lista de objetos Local, contendo todos os locais disponíveis no banco de dados. Este é o método ideal para visualizar todos os locais cadastrados no sistema.

Resposta Esperada:
Em caso de sucesso, o servidor retorna uma lista de objetos Local no formato JSON.

Exemplo de Resposta:

json
[
  {
    "id": "1",
    "nome": "Centro de Convenções",
    "endereco": "Rua Principal, 123",
    "capacidade": 500
  },
  {
    "id": "2",
    "nome": "Teatro Municipal",
    "endereco": "Avenida das Artes, 456",
    "capacidade": 300
  }
]
Código de Resposta:

200 OK: Lista de locais com sucesso.

2. GET /local/{id} - Buscar Local pelo ID
Objetivo:
Este endpoint permite que o cliente consulte os detalhes de um local específico, fornecendo o ID do local na URL.

Descrição:
Quando uma requisição é feita para o endpoint /local/{id}, a aplicação retorna os dados detalhados de um local único, identificando-o pelo ID fornecido na URL. Caso o local com o ID informado não seja encontrado, o servidor retorna um erro.

Resposta Esperada:
Em caso de sucesso, o servidor retorna os dados de um único local, conforme solicitado. Caso o local não seja encontrado, a resposta será um erro 404.

Exemplo de Resposta:

json
{
  "id": "1",
  "nome": "Centro de Convenções",
  "endereco": "Rua Principal, 123",
  "capacidade": 500
}
Código de Resposta:

200 OK: Local encontrado com sucesso.

404 Not Found: O local com o ID especificado não foi encontrado.

3. POST /local - Criar Novo Local
Objetivo:
Este endpoint permite que um novo local seja criado no sistema. A requisição deve conter um objeto Local no corpo da mensagem, com os dados necessários para o novo local.

Descrição:
Ao realizar uma requisição POST para o endpoint /local, o servidor cria um novo local com os dados fornecidos. O cliente deve enviar um objeto Local no corpo da requisição, incluindo informações como nome, endereço e capacidade do local. O servidor retorna os dados do novo local, incluindo o ID gerado.

Corpo da Requisição (JSON):

json
{
  "nome": "Auditório da Universidade",
  "endereco": "Rua da Educação, 789",
  "capacidade": 200
}
Resposta Esperada:
Em caso de sucesso, o servidor retorna o objeto Local criado com sucesso, incluindo o ID gerado.

Exemplo de Resposta:

json
{
  "id": "3",
  "nome": "Auditório da Universidade",
  "endereco": "Rua da Educação, 789",
  "capacidade": 200
}
Código de Resposta:

201 Created: Local criado com sucesso.

4. DELETE /local/{id} - Deletar Local pelo ID
Objetivo:
Este endpoint permite que um local seja excluído do sistema com base no seu ID.

Descrição:
Ao fazer uma requisição DELETE para o endpoint /local/{id}, o servidor exclui o local com o ID especificado. Caso o local seja encontrado e excluído com sucesso, o servidor retorna um código de resposta 204 No Content, indicando que a operação foi concluída com êxito, mas sem dados adicionais na resposta. Se o local não for encontrado, um erro 404 Not Found será retornado.

Código de Resposta:

204 No Content: Local excluído com sucesso.

404 Not Found: Local não encontrado com o ID fornecido.

Estrutura do Código
Classe: LocalController
Pacote: com.hojeonde.hoje.controllers

Dependências Injetadas:

LocalService: Serviço responsável pela lógica de negócios dos locais.

Métodos:

getAllLocais(): Retorna uma lista de todos os locais.

getLocalById(String id): Retorna um local específico pelo ID.

createLocal(Local local): Cria um novo local com base nos dados fornecidos.

deleteLocal(String id): Exclui um local com o ID fornecido.

Exemplo de Fluxo de Uso
Criar Local:

Enviar um POST para /local com os dados de um novo local no corpo da requisição.

Resposta: Local criado com sucesso.

Listar Locais:

Enviar um GET para /local para obter todos os locais.

Resposta: Lista de locais.

Buscar Local por ID:

Enviar um GET para /local/{id} para obter os detalhes de um local específico.

Resposta: Dados do local.

Excluir Local:

Enviar um DELETE para /local/{id} para excluir um local.

Resposta: Código 204 No Content se excluído com sucesso.

