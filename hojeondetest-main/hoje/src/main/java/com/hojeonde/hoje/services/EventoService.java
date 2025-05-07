package com.hojeonde.hoje.services;

import com.hojeonde.hoje.models.Evento;
import com.hojeonde.hoje.repositories.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@service
public class EventoService {
    @Autowired
    private EventoRepository eventoRepository;
    public List<Evento> findAll() {
        return eventoRepository.findAll();
    }

    public Evento findById(String id) {
         if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("ID não pode ser nulo ou vazio");
        }

        Optional<Evento> evento = eventoRepository.findById(id);
        if (evento.isEmpty()) {
            throw new IllegalArgumentException("Evento com ID " + id + " não encontrado");
        }
        return evento.get();
    }

    public Evento save(Evento evento) {
          // Validação de evento não nulo
        if (evento == null) {
            throw new IllegalArgumentException("Evento não pode ser nulo");
        }

        // Validação de campos essenciais no evento (supondo que um campo como 'nome' seja obrigatório)
        if (evento.getNome() == null || evento.getNome().trim().isEmpty()) {
            throw new IllegalArgumentException("O nome do evento não pode ser vazio");
        }

        // Adicionar outras validações de campos do evento conforme necessário
 // Verificação se já existe um evento com o mesmo nome e data (ajustar conforme necessário)
        if (eventoRepository.existsByNomeAndData(evento.getNome(), evento.getData())) {
            throw new IllegalArgumentException("Já existe um evento com o nome '" + evento.getNome() + "' e data '" + evento.getData() + "'");
        }
        return eventoRepository.save(evento);
    }

    public void delete(String id) {
         // Validação de ID não nulo ou vazio
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("ID não pode ser nulo ou vazio");
        }

        // Verifica se o evento existe antes de tentar excluir
        if (!eventoRepository.existsById(id)) {
            throw new IllegalArgumentException("Evento com ID " + id + " não encontrado para exclusão");
        }

        eventoRepository.deleteById(id);
    }
}


O serviço EventoService é o componente da camada de negócio responsável por gerenciar a lógica associada à entidade Evento. Este serviço atua como intermediário entre os controladores REST e o repositório, assegurando a integridade dos dados e aplicando regras de negócio antes de persistir ou consultar informações no banco de dados.

🔍 Código-Fonte

@service
public class EventoService {
🛠️ Correção necessária: A anotação @service está incorreta. O correto é @Service (com S maiúsculo), que informa ao Spring que esta classe é um bean de serviço.

📦 Injeção de Dependência
java
Copiar
Editar
@Autowired
private EventoRepository eventoRepository;
Utiliza a anotação @Autowired para injetar o repositório EventoRepository, permitindo acesso às operações de persistência sem precisar instanciar manualmente o repositório.

📚 Métodos e Regras de Negócio
🔁 findAll()

public List<Evento> findAll() {
    return eventoRepository.findAll();
}
Retorna todos os eventos cadastrados no banco de dados. Nenhuma validação é necessária aqui, pois se trata de uma leitura aberta.

🔍 findById(String id)

public Evento findById(String id) {
    if (id == null || id.trim().isEmpty()) {
        throw new IllegalArgumentException("ID não pode ser nulo ou vazio");
    }

    Optional<Evento> evento = eventoRepository.findById(id);
    if (evento.isEmpty()) {
        throw new IllegalArgumentException("Evento com ID " + id + " não encontrado");
    }
    return evento.get();
}
Este método realiza:

Validação do ID;

Verificação da existência do evento;

Retorno do evento, se encontrado.

O uso de Optional previne NullPointerException e oferece uma forma mais segura de acessar valores retornados do banco.

💾 save(Evento evento)

public Evento save(Evento evento) {
    if (evento == null) {
        throw new IllegalArgumentException("Evento não pode ser nulo");
    }

    if (evento.getNome() == null || evento.getNome().trim().isEmpty()) {
        throw new IllegalArgumentException("O nome do evento não pode ser vazio");
    }

    if (eventoRepository.existsByNomeAndData(evento.getNome(), evento.getData())) {
        throw new IllegalArgumentException("Já existe um evento com o nome '" + evento.getNome() + "' e data '" + evento.getData() + "'");
    }

    return eventoRepository.save(evento);
}
Este método é o mais robusto em termos de validação:

Garante que o objeto não seja nulo;

Valida campos obrigatórios;

Impede duplicações de eventos com mesmo nome e data (nota: existsByNomeAndData() deve existir no repositório);

Persiste o evento se todas as validações forem satisfeitas.

🛠️ Atenção: os campos getData() e getNome() precisam existir na entidade Evento. No seu código atual, esses campos estão como dataInicio, dataFim, e nome. Logo, o método existsByNomeAndData() precisa ser ajustado ou implementado corretamente no repositório com base nesses campos.

🗑️ delete(String id)

public void delete(String id) {
    if (id == null || id.trim().isEmpty()) {
        throw new IllegalArgumentException("ID não pode ser nulo ou vazio");
    }

    if (!eventoRepository.existsById(id)) {
        throw new IllegalArgumentException("Evento com ID " + id + " não encontrado para exclusão");
    }

    eventoRepository.deleteById(id);
}
Este método:

Valida a entrada;

Garante que o evento existe antes de tentar deletá-lo;

Executa a exclusão com segurança.

📌 Considerações Finais
A classe EventoService demonstra boas práticas de validação e responsabilidade de negócio. No entanto, é necessário:

Corrigir a anotação @service para @Service.

Confirmar ou implementar o método existsByNomeAndData() no repositório.

Garantir que os nomes dos métodos e atributos usados em validações correspondam à entidade Evento.

