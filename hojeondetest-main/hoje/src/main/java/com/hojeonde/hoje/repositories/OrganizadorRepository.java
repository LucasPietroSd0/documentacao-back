package com.hojeonde.hoje.repositories;

import com.hojeonde.hoje.models.Organizador;
import com.hojeonde.hoje.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrganizadorRepository extends JpaRepository<Organizador, String> {
}


Visão Geral
O OrganizadorRepository é uma interface que provê acesso à base de dados para manipulação da entidade Organizador, que representa os responsáveis pela organização dos eventos. Esta interface estende JpaRepository, o que a torna capaz de executar operações básicas de persistência (CRUD) com simplicidade e eficácia, usando o poder do Spring Data JPA.

Declaração da Interface
java
Copiar
Editar
package com.hojeonde.hoje.repositories;

import com.hojeonde.hoje.models.Organizador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrganizadorRepository extends JpaRepository<Organizador, String> {
}
Componentes Explicados
1. Importações

import com.hojeonde.hoje.models.Organizador;
import org.springframework.data.jpa.repository.JpaRepository;
Essas linhas trazem os elementos necessários:

A entidade Organizador, usada para mapear os dados da tabela correspondente.

A interface JpaRepository, que oferece uma variedade de métodos prontos para uso.

2. Extensão da Interface

public interface OrganizadorRepository extends JpaRepository<Organizador, String> {
}
Ao estender JpaRepository, herdam-se métodos como:

save(Organizador organizador) – salva ou atualiza um organizador.

findById(String id) – busca por um organizador usando seu ID.

findAll() – lista todos os organizadores.

deleteById(String id) – remove um organizador pelo ID.

⚠️ Correção Necessária: Tipo da Chave Primária
No modelo Organizador, o ID é do tipo UUID:


@Id
@GeneratedValue(strategy = GenerationType.UUID)
private UUID idOrganizador;
Portanto, o tipo genérico passado para o JpaRepository deve ser UUID, não String. O correto seria:


import java.util.UUID;

public interface OrganizadorRepository extends JpaRepository<Organizador, UUID> {
}
Exemplo de Expansão
Você pode criar métodos personalizados como:

Optional<Organizador> findByEmail(String email);
Isso permite encontrar organizadores pelo campo email automaticamente, sem precisar escrever SQL.
