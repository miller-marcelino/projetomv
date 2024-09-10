# Projeto MV Spring Boot - Sistema de Controle Financeiro Pessoal
Projeto MV Spring Boot é uma aplicação web desenvolvida para gerenciar finanças pessoais. Ele utiliza a arquitetura Model-View-Controller (MVC) e banco de dados relacional para armazenar dados de clientes, contas e movimentações financeiras.

# Funcionalidades:

* Cadastro de clientes : Permite o registro de novos clientes, incluindo informações como nome, endereço, telefone e tipo de cliente (pessoa física ou jurídica).

* Cadastro de contas : Possibilita o cadastro de contas bancárias vinculadas ao cliente, informando banco, agência e número da conta.
  
* Cadastro de movimentações : Permite o registro de movimentações financeiras (crédito ou débito), associadas a uma conta específica, informando data, valor e tipo da movimentação.
  
* Consulta de dados : A aplicação permite consultar dados de clientes, contas e movimentações através de endpoints RESTful.

* Exclusão de dados: A aplicação também permite a exclusão de clientes, contas e movimentações através de endpoints RESTFul.

# Tecnologias utilizadas:

Spring Boot,
Spring Data JPA,
MySQL,
Lombok (opcional),
Springdoc (opcional),
Hibernate Validator (opcional),

# Pré-requisitos:

Java 17,
Maven,
MySQL (ou banco de dados relacional equivalente)

# Documentação:

A aplicação roda na porta 8081 por padrão. Você pode acessar a documentação da API Swagger UI em http://localhost:8081/swagger-ui/. A documentação descreve os endpoints RESTful disponíveis para consulta e manipulação de dados.

# Licença:

Este projeto está licenciado sob a licença MIT.

# Documentação Complementar:

Spring Boot: https://start.spring.io/
Spring Data JPA: https://spring.io/projects/spring-data-jpa
Lombok: https://mvnrepository.com/artifact/org.projectlombok
Springdoc: https://github.com/springdoc/springdoc-openapi
Hibernate Validator: https://hibernate.org/validator/documentation/getting-started/

