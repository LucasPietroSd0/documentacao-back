package com.hojeonde.hoje.services;

import com.hojeonde.hoje.models.Ingressos;
import com.hojeonde.hoje.repositories.IngressosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngressosService {
    @Autowired
    private IngressosRepository ingressosRepository;

    public List<Ingressos> findAll() {
        return ingressosRepository.findAll();
    }

    public Ingressos findById(String id) {
        return ingressosRepository.findById(id).orElse(null);
    }

    public Ingressos save(Ingressos ingresso) {
        return ingressosRepository.save(ingresso);
    }

    public void delete(String id) {
        ingressosRepository.deleteById(id);
    }
}


O serviço IngressosService gerencia as operações de negócio relacionadas aos objetos do tipo Ingressos, como criação, consulta, listagem e exclusão. Ele atua como uma ponte entre o controlador REST (IngressosController) e a camada de persistência (IngressosRepository), centralizando as regras de lógica de negócio.

📦 Estrutura da Classe

@Service
public class IngressosService {
A anotação @Service indica ao Spring que esta classe é um componente de serviço. O Spring gerencia sua instância automaticamente e a torna disponível para injeção em outras partes da aplicação.

💉 Injeção de Dependência

@Autowired
private IngressosRepository ingressosRepository;
Aqui, o repositório IngressosRepository é injetado automaticamente pelo Spring, o que permite que a classe acesse métodos prontos como findAll, findById, save e deleteById.

🔁 findAll()

public List<Ingressos> findAll() {
    return ingressosRepository.findAll();
}
Este método busca todos os registros de ingressos no banco de dados. Ele retorna uma lista de objetos Ingressos, representando todos os ingressos cadastrados.

🔍 findById(String id)

public Ingressos findById(String id) {
    return ingressosRepository.findById(id).orElse(null);
}
Busca um ingresso por seu ID. Usa Optional e retorna o ingresso, se encontrado, ou null, se não existir.

📌 Melhoria sugerida: lançar uma exceção personalizada em vez de retornar null, para tratar erros de forma mais clara e segura.

💾 save(Ingressos ingresso)

public Ingressos save(Ingressos ingresso) {
    return ingressosRepository.save(ingresso);
}
Salva um novo ingresso ou atualiza um já existente. O Spring Data JPA identifica se é uma inserção ou atualização com base no ID do objeto.

📌 Sugestão de melhoria: adicionar validações no ingresso antes de salvar (ex.: verificar se os campos tipo, valor, ou evento estão preenchidos corretamente).

🗑️ delete(String id)

public void delete(String id) {
    ingressosRepository.deleteById(id);
}
Exclui um ingresso do banco de dados com base no ID fornecido. Se o ID não existir, o Spring lançará uma exceção.

📌 Melhoria sugerida: verificar se o ingresso existe antes de deletar, evitando falhas inesperadas.
