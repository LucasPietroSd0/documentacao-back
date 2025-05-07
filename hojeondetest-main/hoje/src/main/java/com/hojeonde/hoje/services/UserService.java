package com.hojeonde.hoje.services;

import com.hojeonde.hoje.models.User;
import com.hojeonde.hoje.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            return user.get();
        } else {
            throw new IllegalArgumentException("Usuário com ID " + id + " não encontrado.");
        }
    }

    public User save(User user) {
        // Verifica se já existe um usuário com mesmo email
        Optional<User> existingUser = userRepository.findByEmail(user.getEmail());

        if (existingUser.isPresent()) {
            throw new IllegalArgumentException("Já existe um usuário com o e-mail: " + user.getEmail());
        }

        return userRepository.save(user);
    }

    public void delete(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            userRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("Não é possível deletar. Usuário com ID " + id + " não encontrado.");
        }
    }
}

A classe UserService contém a lógica de negócios relacionada aos usuários do sistema. Ela interage com o repositório UserRepository para fornecer operações de consulta, persistência e exclusão de usuários. Além disso, realiza validações, como verificar se um e-mail já está registrado, ou se o usuário existe antes de realizar a exclusão.

📦 Estrutura da Classe

@Service
public class UserService {
A anotação @Service é usada para indicar que a classe é um componente do Spring, responsável por encapsular a lógica de negócios. O Spring gerencia a instância dessa classe, permitindo que seja injetada automaticamente onde necessário.

🧩 Injeção do Repositório

@Autowired
private UserRepository userRepository;
A injeção do repositório UserRepository permite que a classe UserService interaja com o banco de dados, utilizando as operações básicas do Spring Data JPA para recuperar, salvar e excluir usuários.

📄 Método: findAll()

public List<User> findAll() {
    return userRepository.findAll();
}
Este método retorna todos os usuários registrados no sistema. Ele retorna uma lista de objetos User.

📝 Uso típico: exibir todos os usuários cadastrados em uma interface administrativa ou página de relatórios.

🔍 Método: findById(Long id)

public User findById(Long id) {
    Optional<User> user = userRepository.findById(id);
    if (user.isPresent()) {
        return user.get();
    } else {
        throw new IllegalArgumentException("Usuário com ID " + id + " não encontrado.");
    }
}
Este método recupera um usuário pelo seu ID. Se o usuário for encontrado, ele é retornado. Caso contrário, uma exceção IllegalArgumentException é lançada com uma mensagem informando que o usuário não foi encontrado.

📌 Melhoria sugerida: para uma melhor experiência do usuário, poderia ser lançada uma exceção personalizada, como UserNotFoundException, em vez de IllegalArgumentException.

📝 Método: save(User user)

public User save(User user) {
    // Verifica se já existe um usuário com mesmo email
    Optional<User> existingUser = userRepository.findByEmail(user.getEmail());

    if (existingUser.isPresent()) {
        throw new IllegalArgumentException("Já existe um usuário com o e-mail: " + user.getEmail());
    }

    return userRepository.save(user);
}
Este método salva um novo usuário no banco de dados, após validar se já existe um usuário com o mesmo e-mail. Caso exista, uma exceção IllegalArgumentException é lançada, informando que o e-mail já está em uso.

📌 Sugestão de melhoria: poderia ser considerado o uso de uma exceção personalizada para o caso de e-mail duplicado.

🗑️ Método: delete(Long id)

public void delete(Long id) {
    Optional<User> user = userRepository.findById(id);
    if (user.isPresent()) {
        userRepository.deleteById(id);
    } else {
        throw new IllegalArgumentException("Não é possível deletar. Usuário com ID " + id + " não encontrado.");
    }
}
Este método deleta um usuário pelo ID. Se o usuário for encontrado, ele será removido do banco de dados. Caso contrário, uma exceção IllegalArgumentException é lançada, indicando que o usuário não foi encontrado.

📌 Melhoria possível: em vez de lançar uma exceção IllegalArgumentException, poderia ser utilizada uma exceção específica para a operação de exclusão, como UserNotFoundException.
