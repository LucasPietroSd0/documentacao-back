package com.hojeonde.hoje.repositories;

import com.hojeonde.hoje.models.Ingressos;
import com.hojeonde.hoje.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngressosRepository extends JpaRepository<Ingressos, String> {
}

Visão Geral
O IngressosRepository é uma interface que provê acesso à tabela de ingressos da aplicação. Assim como o repositório de eventos, ele estende a interface JpaRepository, permitindo a execução automática de operações de banco de dados (CRUD) sobre a entidade Ingressos, sem a necessidade de escrever consultas SQL.

Declaração da Interface

package com.hojeonde.hoje.repositories;

import com.hojeonde.hoje.models.Ingressos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngressosRepository extends JpaRepository<Ingressos, String> {
}
Componentes Explicados
1. Importações
java
Copiar
Editar
import com.hojeonde.hoje.models.Ingressos;
import org.springframework.data.jpa.repository.JpaRepository;
Essas instruções trazem as definições necessárias para usar a entidade Ingressos e a funcionalidade do Spring Data JPA.

2. Estendendo JpaRepository
java
Copiar
Editar
public interface IngressosRepository extends JpaRepository<Ingressos, String> {
}
Com isso, o repositório herda métodos poderosos para manipulação de dados, como:

findAll() – Buscar todos os ingressos.

findById(String id) – Buscar um ingresso pelo ID.

save(Ingressos ingresso) – Salvar ou atualizar um ingresso.

deleteById(String id) – Deletar um ingresso pelo ID.

count() – Retornar a contagem total de ingressos.

Atenção: Tipo do ID
No seu modelo Ingressos, o identificador idIngresso é do tipo UUID, não String. Portanto, a interface deve refletir esse tipo corretamente para evitar problemas em tempo de execução:


import java.util.UUID;

public interface IngressosRepository extends JpaRepository<Ingressos, UUID> {
}
Expansão com Métodos Personalizados
Você pode adicionar métodos específicos ao repositório sem implementá-los manualmente. Por exemplo:


List<Ingressos> findByEventoId(UUID eventoId);
O Spring Data JPA irá gerar automaticamente a consulta SQL equivalente com base no nome do método.
