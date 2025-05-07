package com.hojeonde.hoje.models;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.UUID;

@Entity
@Table (name = "eventos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Evento {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)

    private UUID idEvento;
    private String nome;
    private String descricao;
    private String dataInicio;
    private String dataFim;
    private String idLocal;
    private String idOrganizador;

     @ManyToOne
    Local local;
}

Descrição Geral
O Evento é um modelo de dados representando os eventos no sistema. Ele mapeia uma tabela no banco de dados chamada eventos e contém informações cruciais sobre cada evento, como nome, descrição, datas, local e organizador. Esse modelo utiliza anotações do JPA (Java Persistence API) para mapeamento com o banco de dados, facilitando a persistência dos dados.

Estrutura do Código
O modelo Evento é anotado com @Entity, o que significa que ele será persistido em uma tabela do banco de dados. Ele mapeia a tabela eventos, com a chave primária idEvento sendo gerada automaticamente através da estratégia UUID. O modelo também utiliza o Lombok para geração automática de métodos getters, setters, construtores e outros.

Atributos do Modelo
1. idEvento (UUID)
Tipo: UUID
Descrição:
Representa o identificador único do evento. Ele é gerado automaticamente com base na estratégia de UUID. Cada evento possui um idEvento único, o que permite sua identificação no banco de dados.

Exemplo:


    
    private UUID idEvento;
2. nome (String)
Tipo: String
Descrição:
O nome do evento, como "Festa de Aniversário" ou "Show de Rock". Este é um atributo importante que identifica o evento de maneira amigável ao usuário.

Exemplo:



private String nome;
3. descricao (String)
Tipo: String
Descrição:
Uma descrição detalhada sobre o evento. Este atributo pode conter informações adicionais, como o que acontecerá durante o evento, horários e outras informações pertinentes.

Exemplo:


private String descricao;
4. dataInicio (String)
Tipo: String
Descrição:
A data de início do evento, representada como uma string. Idealmente, deveria ser um tipo Date ou LocalDate para melhor manipulação de datas, mas está definido como String.

Exemplo:


private String dataInicio;
5. dataFim (String)
Tipo: String
Descrição:
A data de término do evento, também representada como uma string. Similar ao atributo dataInicio, seria mais adequado utilizar tipos de dados específicos para manipulação de datas.

Exemplo:


private String dataFim;
6. idLocal (String)
Tipo: String
Descrição:
O identificador do local onde o evento será realizado. Este é um identificador de referência a outra entidade, que no caso é o Local.

Exemplo:


private String idLocal;
7. idOrganizador (String)
Tipo: String
Descrição:
O identificador do organizador do evento. Assim como o idLocal, é uma referência a outra entidade, o Organizador, que é responsável pelo evento.

Exemplo:


private String idOrganizador;
8. local (Local)
Tipo: Local
Descrição:
Este é um relacionamento ManyToOne com a entidade Local, o que significa que um evento pode ter um único local, mas um local pode ter muitos eventos associados a ele. Esse relacionamento é utilizado para obter informações sobre o local do evento de forma estruturada.

Exemplo:

@ManyToOne
Local local;
Anotações JPA e Lombok
@Entity: Marca a classe como uma entidade JPA, ou seja, ela será mapeada para uma tabela no banco de dados.

@Table(name = "eventos"): Define o nome da tabela no banco de dados que irá armazenar os dados da entidade. Nesse caso, a tabela será chamada eventos.

@Id: Marca o campo idEvento como a chave primária da tabela.

@GeneratedValue(strategy = GenerationType.UUID): Define a estratégia de geração do valor da chave primária como UUID, garantindo que o identificador seja único.

@Getter: Usado pelo Lombok para gerar automaticamente o método getter para os atributos.

@Setter: Usado pelo Lombok para gerar automaticamente o método setter para os atributos.

@AllArgsConstructor: Usado pelo Lombok para gerar um construtor com todos os parâmetros.

@NoArgsConstructor: Usado pelo Lombok para gerar um construtor sem parâmetros.

Exemplo de Fluxo de Uso
Criação de Evento:

Quando um novo evento é criado, um objeto Evento é instanciado com as informações como nome, descrição, datas, local e organizador.

O idEvento é automaticamente gerado como um UUID único para identificar o evento.

Salvar Evento:

Após criar o objeto Evento, ele pode ser salvo no banco de dados através de um repositório JPA, como eventoRepository.save(evento).

A entidade será persistida na tabela eventos, com os dados fornecidos.

Recuperar Evento:

O sistema pode buscar os eventos no banco de dados utilizando o ID ou outros critérios, e recuperar as informações completas sobre cada evento, incluindo o local associado.
