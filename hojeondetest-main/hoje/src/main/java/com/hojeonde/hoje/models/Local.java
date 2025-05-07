package com.hojeonde.hoje.models;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.UUID;

@Entity
@Table (name = "Locais")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Local {
    @Id
 @GeneratedValue(strategy = GenerationType.UUID)
    private UUID idLocal;
    private String nome;
    private String endereco;
    private String capacidade;

     @OneToMany
    Evento evento;
}


Descrição Geral
O modelo Local representa os locais onde os eventos são realizados. Ele é mapeado para a tabela Locais no banco de dados e contém informações como o nome do local, seu endereço, a capacidade e uma relação com os eventos que acontecem nesse local. Este modelo é importante para associar um evento a um local específico e permitir a gestão dos locais onde as atividades serão realizadas.

Estrutura do Código
O modelo Local é anotado com @Entity e @Table para que seja persistido corretamente no banco de dados. A classe também utiliza as anotações do Lombok para a geração automática de métodos utilitários, como getters, setters e construtores.

Atributos do Modelo
1. idLocal (UUID)
Tipo: UUID
Descrição:
Este é o identificador único de cada local, gerado automaticamente através da estratégia UUID. O idLocal serve como chave primária para identificar de maneira única um local dentro do banco de dados.

Exemplo:

private UUID idLocal;
2. nome (String)
Tipo: String
Descrição:
Este atributo armazena o nome do local, como "Estádio Maracanã", "Teatro Municipal", "Centro de Convenções", etc. O nome é fundamental para identificar o local em que o evento será realizado.

Exemplo:


private String nome;
3. endereco (String)
Tipo: String
Descrição:
Este campo armazena o endereço físico do local, incluindo informações como rua, número, bairro e cidade, fornecendo os detalhes necessários para que os participantes possam encontrar o local do evento.

Exemplo:


private String endereco;
4. capacidade (String)
Tipo: String
Descrição:
A capacidade do local, ou seja, quantas pessoas o local pode acomodar. Esse campo pode ser importante para controle de público e para planejamento de eventos.

Exemplo:


private String capacidade;
5. evento (Evento)
Tipo: Evento
Descrição:
Este é um relacionamento OneToMany com a entidade Evento. Isso significa que um local pode abrigar vários eventos, mas cada evento é associado a um único local. Este relacionamento facilita a organização de eventos em diferentes locais e garante que um evento tenha um local associado para sua realização.

Exemplo:


@OneToMany
Evento evento;
Anotações JPA e Lombok
@Entity: Marca a classe Local como uma entidade JPA, indicando que ela será mapeada para uma tabela no banco de dados.

@Table(name = "Locais"): Define o nome da tabela no banco de dados que armazenará os dados dos locais. Neste caso, a tabela será chamada Locais.

@Id: Marca o campo idLocal como a chave primária da tabela.

@GeneratedValue(strategy = GenerationType.UUID): Define que o identificador do local será gerado automaticamente com a estratégia UUID, garantindo que o ID seja único.

@OneToMany: Define que um local pode ter muitos eventos associados a ele, permitindo a associação de vários eventos a um único local.

@Getter: Usado pelo Lombok para gerar automaticamente os métodos getters para todos os atributos da classe.

@Setter: Usado pelo Lombok para gerar automaticamente os métodos setters para todos os atributos da classe.

@AllArgsConstructor: Usado pelo Lombok para gerar automaticamente um construtor com todos os parâmetros.

@NoArgsConstructor: Usado pelo Lombok para gerar automaticamente um construtor sem parâmetros.

Exemplo de Fluxo de Uso
Criação de Local:

Quando um local é criado, um objeto Local é instanciado com as informações sobre o nome, endereço e capacidade do local.

O idLocal é automaticamente gerado como um UUID único para identificar o local de maneira exclusiva.

Salvar Local:

Após a criação do objeto Local, ele pode ser salvo no banco de dados através de um repositório JPA, como localRepository.save(local). O local será persistido na tabela Locais, com os dados fornecidos.

Recuperar Local:

O sistema pode buscar os locais existentes e retornar as informações relacionadas a eles, incluindo os eventos associados. O relacionamento OneToMany permite acessar os eventos associados a um local de forma eficiente.


