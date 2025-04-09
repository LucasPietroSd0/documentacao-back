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

