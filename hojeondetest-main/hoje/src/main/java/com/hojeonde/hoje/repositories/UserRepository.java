package com.hojeonde.hoje.repositories;

import com.hojeonde.hoje.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
     Optional<User> findByEmail(String email);
}

Visão Geral
O UserRepository é a interface que faz a ponte entre a aplicação e o banco de dados para operações relacionadas à entidade User. Por meio da extensão da interface JpaRepository, o Spring Data JPA provê automaticamente os métodos básicos de CRUD. Além disso, este repositório contém um método customizado para buscar usuários pelo campo de e-mail, um exemplo claro do poder da convenção sobre configuração.

Declaração da Interface

package com.hojeonde.hoje.repositories;

import com.hojeonde.hoje.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
     Optional<User> findByEmail(String email);
}
Análise Técnica
Importações

import com.hojeonde.hoje.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
Essas importações fornecem acesso:

À entidade User, que representa os dados de usuários da aplicação.

À interface JpaRepository, que oferece os métodos de persistência já implementados.

Extensão de JpaRepository

public interface UserRepository extends JpaRepository<User, Long> {
Este trecho indica que a interface irá manipular a entidade User e que o tipo da chave primária é Long.
No entanto, segundo o modelo User, o identificador é:


@Id
@GeneratedValue(strategy = GenerationType.UUID)
private UUID idUser;
Ou seja, o tipo correto da chave primária é UUID, não Long.

🛠️ Correção recomendada:


import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
Método Customizado: findByEmail
java
Copiar
Editar
Optional<User> findByEmail(String email);
Este método é uma das vantagens do Spring Data JPA: apenas declarando o nome do método com base no campo email, 
o Spring já gera a consulta SQL correspondente automaticamente. Ele retorna um Optional<User>, 
que evita NullPointerExceptions e obriga o tratamento da ausência de resultados.
