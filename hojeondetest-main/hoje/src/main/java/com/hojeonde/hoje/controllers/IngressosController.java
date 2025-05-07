package com.hojeonde.hoje.controllers;

import com.hojeonde.hoje.models.Ingressos;
import com.hojeonde.hoje.services.IngressosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ingressos")
public class IngressosController {
    @Autowired
    private IngressosService ingressosService;

    @GetMapping
    public List<Ingressos> getAllIngressos() {
        return ingressosService.findAll();
    }

    @GetMapping("/{id}")
    public Ingressos getIngressoById(@PathVariable String id) {
        return ingressosService.findById(id);
    }

    @PostMapping
    public Ingressos createIngresso(@RequestBody Ingressos ingresso) {
        return ingressosService.save(ingresso);
    }

    @DeleteMapping("/{id}")
    public void deleteIngresso(@PathVariable String id) {
        ingressosService.delete(id);
    }
}

Descrição:
Controlador REST responsável por gerenciar ingressos no sistema. Ele fornece endpoints para listar, buscar, criar e excluir ingressos. A camada de serviço IngressosService é responsável pela lógica de negócios.

📍 Base Path: /ingressos
🔹 GET /ingressos
Descrição:
Retorna todos os ingressos cadastrados no sistema.

Resposta:

200 OK: Lista de objetos Ingressos no formato JSON.

Exemplo de Resposta:

json
[
  {
    "id": "1",
    "eventoId": "123",
    "preco": 50.0,
    "quantidade": 100
  },
  {
    "id": "2",
    "eventoId": "124",
    "preco": 75.0,
    "quantidade": 150
  }
]
🔹 GET /ingressos/{id}
Parâmetros:

id (String): ID do ingresso que você deseja buscar.

Descrição:
Retorna os detalhes de um ingresso específico baseado no ID fornecido.

Resposta:

200 OK: Objeto Ingressos correspondente ao ID.

404 Not Found: Caso o ingresso não seja encontrado.

Exemplo de Resposta:

json

{
  "id": "1",
  "eventoId": "123",
  "preco": 50.0,
  "quantidade": 100
}
🔹 POST /ingressos
Descrição:
Cria um novo ingresso com os dados fornecidos no corpo da requisição.

Corpo da Requisição (JSON):

json

{
  "eventoId": "125",
  "preco": 60.0,
  "quantidade": 200
}
Resposta:

201 Created: O ingresso foi criado com sucesso. Retorna o ingresso criado.

400 Bad Request: Caso os dados enviados sejam inválidos ou não estejam completos.

Exemplo de Resposta:

json

{
  "id": "3",
  "eventoId": "125",
  "preco": 60.0,
  "quantidade": 200
}
🔹 DELETE /ingressos/{id}
Parâmetros:

id (String): ID do ingresso que você deseja excluir.

Descrição:
Deleta um ingresso do sistema com base no ID informado.

Resposta:

204 No Content: O ingresso foi excluído com sucesso.

404 Not Found: Caso o ingresso não seja encontrado.

💡 Possíveis Códigos de Resposta:
200 OK: A requisição foi bem-sucedida (usado em GETs).

201 Created: O recurso foi criado com sucesso (usado em POST).

204 No Content: O recurso foi deletado com sucesso (usado em DELETE).

400 Bad Request: A requisição foi malformada ou faltando dados necessários (geralmente em POST).

404 Not Found: O recurso solicitado não foi encontrado (geralmente em GET ou DELETE).

Exemplo de Fluxo de Uso:
Criar Ingresso:

Enviar um POST para /ingressos com um objeto Ingressos no corpo.

Resposta: Ingresso criado com sucesso e código 201.

Listar Ingressos:

Enviar um GET para /ingressos.

Resposta: Lista de todos os ingressos no formato JSON.

Buscar Ingresso por ID:

Enviar um GET para /ingressos/{id}.

Resposta: Detalhes do ingresso correspondente ao ID fornecido.

Excluir Ingresso:

Enviar um DELETE para /ingressos/{id}.

Resposta: Ingresso excluído com sucesso e código 204.

