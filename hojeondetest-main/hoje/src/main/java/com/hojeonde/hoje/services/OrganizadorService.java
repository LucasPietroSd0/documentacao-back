package com.hojeonde.hoje.services;

import com.hojeonde.hoje.models.Organizador;
import com.hojeonde.hoje.repositories.OrganizadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrganizadorService {
    @Autowired
    private OrganizadorRepository organizadorRepository;

    public List<Organizador> findAll() {
        return organizadorRepository.findAll();
    }

    public Organizador findById(String id) {
        return organizadorRepository.findById(id).orElse(null);
    }

    public Organizador save(Organizador organizador) {
        return organizadorRepository.save(organizador);
    }

    public void delete(String id) {
        organizadorRepository.deleteById(id);
    }
}


A classe OrganizadorService encapsula a lógica de negócio relacionada à entidade Organizador. Ela atua como um intermediário entre o controlador REST e o repositório de dados, gerenciando as operações de consulta, persistência e exclusão de organizadores.

📦 Estrutura da Classe

@Service
public class OrganizadorService {
A anotação @Service indica que esta classe é um Spring Bean do tipo service, o que permite ao Spring gerenciar sua instância e injetá-la automaticamente onde for necessário.

🧩 Injeção do Repositório

@Autowired
private OrganizadorRepository organizadorRepository;
A injeção do repositório OrganizadorRepository permite que a classe OrganizadorService utilize as operações básicas do JPA, como findAll(), findById(), save() e deleteById().

📄 Método: findAll()

public List<Organizador> findAll() {
    return organizadorRepository.findAll();
}
Este método retorna todos os organizadores cadastrados no banco de dados.

📝 Uso típico: exibir uma lista de organizadores em uma tela administrativa ou no frontend do sistema.

🔍 Método: findById(String id)

public Organizador findById(String id) {
    return organizadorRepository.findById(id).orElse(null);
}
Busca um organizador pelo seu ID. Se o organizador não for encontrado, o método retorna null.

💡 Melhoria recomendada: ao invés de retornar null, considere lançar uma exceção personalizada para melhorar o tratamento de erros.

📝 Método: save(Organizador organizador)

public Organizador save(Organizador organizador) {
    return organizadorRepository.save(organizador);
}
Salva um novo organizador ou atualiza um já existente, dependendo de seu estado no banco de dados.

📌 Recomendação: validar campos obrigatórios antes de salvar a entidade, como o nome, email e telefone.

🗑️ Método: delete(String id)

public void delete(String id) {
    organizadorRepository.deleteById(id);
}
Este método deleta um organizador baseado no ID fornecido. Se o ID não existir, o Spring pode lançar uma exceção.

📌 Melhoria: verifique se o organizador existe antes de tentar excluir, para evitar exceções desnecessárias.

