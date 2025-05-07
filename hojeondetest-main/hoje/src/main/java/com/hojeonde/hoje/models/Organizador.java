package com.hojeonde.hoje.models;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "organizadores")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Organizador {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID idOrganizador;
    private String nome;
    private String email;
    private String telefone;

     @OneToOne
    Evento evento;
    
}

Visão Geral
O modelo Organizador representa as pessoas ou entidades responsáveis por organizar eventos. Esta classe é essencial dentro do domínio da aplicação, pois define os dados básicos de contato de um organizador e mantém uma relação direta com um evento. Mapeado para a tabela organizadores no banco de dados, o modelo possibilita armazenar e acessar informações que são vitais para a administração e comunicação dos eventos realizados na plataforma.

Análise Estrutural da Classe
Abaixo está o detalhamento de cada parte da classe Organizador, com explicações sobre suas funções e seu papel na aplicação.

1. Anotações e Mapeamento

@Entity
@Table(name = "organizadores")
Essas anotações informam ao Spring Data JPA que esta classe representa uma entidade de banco de dados, associada à tabela chamada organizadores.

2. Lombok – Código Reduzido com Eficiência

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
Estas anotações da biblioteca Lombok automatizam a geração de métodos úteis:

@Getter e @Setter: criam automaticamente os métodos de acesso para os atributos.

@AllArgsConstructor: gera um construtor com todos os campos como parâmetros.

@NoArgsConstructor: gera um construtor sem argumentos (necessário para frameworks como JPA).

3. Atributos do Organizador

@Id
@GeneratedValue(strategy = GenerationType.UUID)
private UUID idOrganizador;
idOrganizador: identificador único para cada organizador, gerado automaticamente como um UUID. Este campo é a chave primária da tabela.


private String nome;
private String email;
private String telefone;
nome: nome completo do organizador.

email: endereço de e-mail de contato do organizador.

telefone: número de telefone do organizador para comunicações diretas.

Esses atributos são essenciais para identificar e se comunicar com o responsável por cada evento.

4. Relacionamento com a Entidade Evento

@OneToOne
Evento evento;
Esta anotação define um relacionamento um-para-um entre o organizador e o evento.

Cada organizador está associado diretamente a um único evento, e vice-versa.

Nota importante: Em um sistema real, é comum que um organizador possa gerenciar vários eventos. Se essa for a intenção, o relacionamento deveria ser alterado para @OneToMany.

Exemplo de Uso na Aplicação
Um organizador é criado com informações de contato e vinculado a um evento específico.

Quando um usuário visualiza os detalhes de um evento, os dados do organizador podem ser apresentados para contato ou suporte.

A plataforma pode permitir que organizadores editem os eventos que estão associados a eles.

Possível Ajuste Futuro
Se houver necessidade de expandir a aplicação para permitir que um organizador tenha múltiplos eventos, o relacionamento deve ser alterado:

java
Copiar
Editar
@OneToMany(mappedBy = "organizador")
private List<Evento> eventos;
E no modelo Evento, o campo Organizador organizador receberia um @ManyToOne.
