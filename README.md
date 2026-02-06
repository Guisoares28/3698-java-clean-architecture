# Clean Architecture
Este repositório é voltado ao aprendizado de como transformar um projeto **CRUD** padrão em um projeto voltado a arquitetura **Clean Architecture**.

## Sobre Clean Architecture
Tudo é criado com base em algum problema existente, então na minha concepção para se entender algo é preciso entender qual problema ele resolve.

Pensando desta maneira vamos pensar, qual problema a Arquitetura Limpa (Clean Architecture) resolve?.
* Desacoplamento.
* Testabilidade.
* Fácil manutenção e mudanças no código, framework, banco de dados e etc.

Pense em um sistema onde tudo é acoplado. A sua classe de Entidade depende exclusivamente do Spring JPA, se por algum momento sua classe anotada com @Entity e todas as anotações do JPA precisar passar por alguma mudança, e por algum motivo você precisa mudar o ORM que está nela para outro. Quando tudo está acoplado você teria que criar totalmente a classe novamente, e por consequência a sua classe **Service** também estaria acoplada a sua Entidade, e o seu **Controller** acoplado a sua **Service** gerando assim uma mudança totalmente drástica somente para mudar um ORM, e por esse problema nasceu a arquitetura limpa.

Leia Mais: [Arquitetura Limpa](https://zup.com.br/blog/clean-architecture-arquitetura-limpa/)

# Estrutura deste repositório
O pacote criado **naousar** está armazenando todo nosso projeto, porém criado da forma padrão, um CRUD padrão, e a nossa missão é transformar este projeto em um projeto com arquitetura limpa, então iremos utilizar ela somente para fins de comparação.

#ValueObject
Nosso usuário terá um atributo chamado **Endereco** este atributo é considerado um **ValueObject**.
um ValueObject é um objeto que não precisa ter um identificador único, isso significa que se um dois objetos Endereco criados com os valores dos atributos iguais, então eles podem ser considerados o mesmo objeto.

Vamos criar este objeto dentro do nosso pacote de dominio. E criaremos uma fábrica para simplificar a criação dos nossos objetos.

A fábrica terá todas as funções para criar o nosso objeto User, sem precisarmos ficar dando new User, new Endereco e etc.
isso facilita muito em questões de testes.





