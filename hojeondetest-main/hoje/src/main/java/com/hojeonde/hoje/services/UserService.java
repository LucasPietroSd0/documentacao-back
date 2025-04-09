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
