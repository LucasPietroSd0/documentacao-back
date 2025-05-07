package com.hojeonde.hoje.controllers;

import com.hojeonde.hoje.models.Evento;
import com.hojeonde.hoje.services.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/eventos")
public class EventoController {
    @Autowired
    private EventoService eventoService;

    @GetMapping
    public List<Evento> getAllEventos() {
        return eventoService.findAll();
    }

    @GetMapping("/{id}")
    public Evento getEventoById(@PathVariable String id) {
        return eventoService.findById(id);
    }

    @PostMapping
    public Evento createEvento(@RequestBody Evento evento) {
        return eventoService.save(evento);
    }

    @DeleteMapping("/{id}")
    public void deleteEvento(@PathVariable String id) {
        eventoService.delete(id);
    }
}

Descrição:
Controlador REST responsável por gerenciar eventos no sistema. Ele fornece endpoints para listar, buscar, criar e excluir eventos. A camada de serviço EventoService é responsável pela lógica de negócios.

📍 Base Path: /eventos
🔹 GET /eventos
Descrição:
Retorna todos os eventos registrados no sistema.

Resposta:

200 OK: Uma lista de objetos Evento no formato JSON.

Exemplo de Resposta:

json
[
  {
    "id": "1",
    "nome": "Evento A",
    "descricao": "Descrição do Evento A",
    "data": "2025-05-07T10:00:00",
    "local": "Local A"
  },
  {
    "id": "2",
    "nome": "Evento B",
    "descricao": "Descrição do Evento B",
    "data": "2025-05-08T15:00:00",
    "local": "Local B"
  }
]
🔹 GET /eventos/{id}
Parâmetros:

id (String): ID do evento que você deseja buscar.

Descrição:
Retorna os detalhes de um evento específico baseado no ID fornecido.

Resposta:

200 OK: Objeto Evento correspondente ao ID.

404 Not Found: Caso o evento não seja encontrado.

Exemplo de Resposta:

json
{
  "id": "1",
  "nome": "Evento A",
  "descricao": "Descrição do Evento A",
  "data": "2025-05-07T10:00:00",
  "local": "Local A"
}
🔹 POST /eventos
Descrição:
Cria um novo evento com os dados fornecidos no corpo da requisição.

Corpo da Requisição (JSON):

json

{
  "nome": "Evento C",
  "descricao": "Descrição do Evento C",
  "data": "2025-05-09T18:00:00",
  "local": "Local C"
}
Resposta:

201 Created: O evento foi criado com sucesso. Retorna o evento criado.

400 Bad Request: Caso os dados enviados sejam inválidos ou não estejam completos.

Exemplo de Resposta:

json

{
  "id": "3",
  "nome": "Evento C",
  "descricao": "Descrição do Evento C",
  "data": "2025-05-09T18:00:00",
  "local": "Local C"
}
🔹 DELETE /eventos/{id}
Parâmetros:

id (String): ID do evento que você deseja excluir.

Descrição:
Deleta um evento do sistema com base no ID informado.

Resposta:

204 No Content: O evento foi excluído com sucesso.

404 Not Found: Caso o evento não seja encontrado.

💡 Possíveis Códigos de Resposta:
200 OK: A requisição foi bem-sucedida (usado em GETs).

201 Created: O recurso foi criado com sucesso (usado em POST).

204 No Content: O recurso foi deletado com sucesso (usado em DELETE).

400 Bad Request: A requisição foi malformada ou faltando dados necessários (geralmente em POST).

404 Not Found: O recurso solicitado não foi encontrado (geralmente em GET ou DELETE).

Exemplo de Fluxo de Uso:
Criar Evento:

Enviar um POST para /eventos com um objeto Evento no corpo.

Resposta: Evento criado com sucesso e código 201.

Listar Eventos:

Enviar um GET para /eventos.

Resposta: Lista de todos os eventos no formato JSON.

Buscar Evento por ID:

Enviar um GET para /eventos/{id}.

Resposta: Detalhes do evento correspondente ao ID fornecido.

Excluir Evento:

Enviar um DELETE para /eventos/{id}.

Resposta: Evento excluído com sucesso e código 204.



