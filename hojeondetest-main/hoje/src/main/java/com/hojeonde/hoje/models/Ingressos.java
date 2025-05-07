package com.hojeonde.hoje.models;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.UUID;

@Entity
@Table (name = "Ingressos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Ingressos {
    @Id
  @GeneratedValue(strategy = GenerationType.UUID)
    private UUID idIngresso;
    private String Tipo;
    private String valor;
    private String quantidade;
    private String lote;

  @ManyToOne
    Evento evento;
    
}


Descrição Geral
O modelo Ingressos é uma entidade que representa as informações relacionadas aos ingressos de um evento dentro do sistema. Ele mapeia uma tabela chamada Ingressos no banco de dados e contém atributos como o tipo de ingresso, valor, quantidade disponível e o lote ao qual o ingresso pertence. Além disso, a classe estabelece uma relação com a entidade Evento, associando um ingresso a um evento específico.

Estrutura do Código
O modelo Ingressos é anotado com @Entity e @Table para garantir que seja persistido corretamente no banco de dados. Ele contém os atributos necessários para caracterizar um ingresso, como tipo, valor e quantidade. Além disso, ele usa o Lombok para a geração automática de métodos úteis, como getters, setters e construtores.

Atributos do Modelo
1. idIngresso (UUID)
Tipo: UUID
Descrição:
Este é o identificador único de cada ingresso, gerado automaticamente com o uso da estratégia UUID. Ele serve para garantir que cada ingresso seja único e facilmente referenciável.

Exemplo:


private UUID idIngresso;
2. Tipo (String)
Tipo: String
Descrição:
Este atributo armazena o tipo de ingresso, como "VIP", "Pista", "Camarote", etc. Ele serve para diferenciar as categorias de ingressos disponíveis para um evento.

Exemplo:


private String Tipo;
3. valor (String)
Tipo: String
Descrição:
Armazena o valor do ingresso. A escolha de tipo String é comum quando o valor é armazenado em formatos como moeda (por exemplo, "R$ 50,00"). Seria possível também utilizar BigDecimal para valores monetários, mas neste caso, está sendo tratado como texto.

Exemplo:

private String valor;
4. quantidade (String)
Tipo: String
Descrição:
A quantidade de ingressos disponíveis. Este atributo especifica quantos ingressos estão disponíveis para um determinado tipo, lote ou evento.

Exemplo:


private String quantidade;
5. lote (String)
Tipo: String
Descrição:
Indica o lote ao qual o ingresso pertence. Por exemplo, um evento pode ter vários lotes de ingressos com preços diferentes, e esse campo ajudaria a identificar a qual lote o ingresso pertence.

Exemplo:


private String lote;
6. evento (Evento)
Tipo: Evento
Descrição:
Este é um relacionamento ManyToOne com a entidade Evento. Isso significa que cada ingresso está associado a um único evento, mas um evento pode ter vários ingressos diferentes (por exemplo, ingressos para diferentes tipos de acesso). Através deste relacionamento, o sistema consegue vincular um ingresso a um evento específico.

Exemplo:


@ManyToOne
Evento evento;
Anotações JPA e Lombok
@Entity: Marca a classe Ingressos como uma entidade JPA, indicando que ela será mapeada para uma tabela no banco de dados.

@Table(name = "Ingressos"): Define o nome da tabela no banco de dados que armazenará os dados dos ingressos. Neste caso, a tabela será chamada Ingressos.

@Id: Marca o campo idIngresso como a chave primária da tabela.

@GeneratedValue(strategy = GenerationType.UUID): Define que o identificador do ingresso será gerado automaticamente com a estratégia UUID, garantindo que o ID seja único.

@ManyToOne: Define que cada ingresso está associado a um único evento, criando um relacionamento de muitos ingressos para um evento.

@Getter: Usado pelo Lombok para gerar automaticamente os métodos getters para todos os atributos da classe.

@Setter: Usado pelo Lombok para gerar automaticamente os métodos setters para todos os atributos da classe.

@AllArgsConstructor: Usado pelo Lombok para gerar automaticamente um construtor com todos os parâmetros.

@NoArgsConstructor: Usado pelo Lombok para gerar automaticamente um construtor sem parâmetros.

Exemplo de Fluxo de Uso
Criação de Ingresso:

Quando um ingresso é criado, um objeto Ingressos é instanciado com as informações sobre o tipo, valor, quantidade e lote do ingresso, e também com a associação a um Evento específico.

Salvar Ingresso:

Após a criação do objeto Ingressos, ele pode ser salvo no banco de dados através de um repositório JPA, como ingressoRepository.save(ingresso). O ingresso será persistido na tabela Ingressos, com os dados fornecidos.

Recuperar Ingresso:

O sistema pode buscar ingressos associados a eventos específicos, utilizando o ID do evento ou outros critérios, como o tipo de ingresso ou o lote, para recuperar as informações dos ingressos.
