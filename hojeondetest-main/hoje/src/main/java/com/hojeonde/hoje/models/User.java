package com.hojeonde.hoje.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table (name = "Users")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
 @GeneratedValue(strategy = GenerationType.UUID)
    private UUID idUser;
    private String cpf;
    private String nome;
    private String email;
    private String telefone;

      @OneToMany
    Ingressos ingressos;
}

Visão Geral
A entidade User representa os usuários finais da plataforma "Hoje Onde". São essas pessoas que irão interagir com os eventos disponíveis, visualizar ingressos e realizar compras ou reservas. Este modelo define os principais dados pessoais e estabelece um relacionamento com os ingressos associados ao usuário.

Análise Detalhada da Classe
Vamos explorar cada parte da classe User, entendendo sua função dentro da aplicação e sua estrutura no banco de dados.

1. Anotações de Entidade e Tabela

@Entity
@Table(name = "Users")
Essas anotações informam ao JPA que a classe User será mapeada para uma tabela chamada Users no banco de dados. Cada instância desta classe corresponderá a uma linha na tabela.

2. Lombok – Geração Automática de Código

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Getter e @Setter: geram automaticamente os métodos get e set para todos os atributos.

@AllArgsConstructor: cria um construtor que exige todos os campos como parâmetros.

@NoArgsConstructor: gera um construtor sem argumentos — necessário para operações com frameworks como JPA/Hibernate.

3. Atributos do Usuário

@Id
@GeneratedValue(strategy = GenerationType.UUID)
private UUID idUser;
idUser: identificador único do usuário, gerado automaticamente como UUID. Serve como chave primária da tabela.



private String cpf;
private String nome;
private String email;
private String telefone;
cpf: Cadastro de Pessoa Física – identificador nacional único no Brasil.

nome: nome completo do usuário.

email: e-mail para login ou comunicação.

telefone: número de telefone do usuário.

Esses dados permitem identificar e contatar os usuários de forma precisa, além de possibilitar autenticação e personalização da experiência.

4. Relacionamento com Ingressos

@OneToMany
Ingressos ingressos;
Esta anotação tenta definir um relacionamento um-para-muitos entre um usuário e os ingressos.

Porém, há um problema técnico: o campo ingressos está declarado como um único objeto da classe Ingressos, quando o correto seria uma lista de ingressos:


@OneToMany(mappedBy = "user")
private List<Ingressos> ingressos;
Além disso, é necessário que a entidade Ingressos tenha um campo como:


@ManyToOne
private User user;
Esse mapeamento bidirecional permitirá que o JPA saiba como relacionar as tabelas Users e Ingressos.

Exemplo de Uso na Aplicação
Um usuário acessa a plataforma, visualiza eventos e adquire ingressos.

Cada ingresso comprado é associado ao seu idUser.

A plataforma pode exibir a lista de ingressos adquiridos por um usuário autenticado.

Melhoria Recomendável
Para tornar o modelo mais coerente e funcional:

Altere o campo ingressos para:


@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
private List<Ingressos> ingressos;
No modelo Ingressos, adicione:


@ManyToOne
@JoinColumn(name = "user_id")
private User user;
