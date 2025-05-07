package com.hojeonde.hoje.services;

import com.hojeonde.hoje.models.Local;
import com.hojeonde.hoje.repositories.LocalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocalService {
    @Autowired
    private LocalRepository localRepository;

    public List<Local> findAll() {
        return localRepository.findAll();
    }

    public Local findById(String id) {
        return localRepository.findById(id).orElse(null);
    }

    public Local save(Local local) {
        return localRepository.save(local);
    }

    public void delete(String id) {
        localRepository.deleteById(id);
    }
}


A classe LocalService é responsável por encapsular toda a lógica de negócio referente à entidade Local. 
Ela intermedia as chamadas entre o controlador REST e o repositório de dados, garantindo que o acesso ao banco 
seja feito de forma organizada e, futuramente, validada.

📦 Estrutura da Classe

@Service
public class LocalService {
A anotação @Service define esta classe como um Spring Bean do tipo service. Isso significa que o Spring irá gerenciar
sua instância e torná-la disponível para injeção de dependência onde for necessária.

🧩 Injeção do Repositório

@Autowired
private LocalRepository localRepository;
Por meio da anotação @Autowired, o repositório LocalRepository é injetado automaticamente na classe. 
Isso permite que métodos do JPA como findAll, findById, save e deleteById sejam utilizados diretamente.

📄 Método: findAll()

public List<Local> findAll() {
    return localRepository.findAll();
}
Este método retorna todos os registros da tabela Locais do banco de dados.

📝 Uso típico: exibir uma lista de locais em um painel de administração ou no frontend do sistema.

🔍 Método: findById(String id)

public Local findById(String id) {
    return localRepository.findById(id).orElse(null);
}
Busca um local pelo seu ID. Caso não exista, retorna null.

💡 Melhoria recomendada: usar uma exceção personalizada ao invés de retornar null para evitar problemas de NullPointerException.

📝 Método: save(Local local)

public Local save(Local local) {
    return localRepository.save(local);
}
Este método salva (ou atualiza, se já existir) um registro de local. O Spring Data JPA decide se é inserção ou atualização 
baseado no ID da entidade.

📌 Recomendação: validar campos obrigatórios como nome, endereco ou capacidade antes de salvar.

🗑️ Método: delete(String id)

public void delete(String id) {
    localRepository.deleteById(id);
}
Remove um local do banco de dados usando o ID fornecido. Se o ID não existir, o Spring poderá lançar uma exceção.

📌 Melhoria: checar se o local existe antes de tentar deletar, para maior segurança.
