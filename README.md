# BIKE-FACTORY

## Descrição
  Esta API foi construida com intuito de consumir dados carregados em uma núvem pública a partir de arquivos .csv

## API
  A arquitetura REST foi escolhida em razões de alguns pontos chave:
* Gestão de dependências que garante uma metodologia de desenvolvimento àgil permitindo maior preocupação com a qualidade do código sem ser necessário grande quantidade de tempo para lhe dar com as configurações infraestruturais.
* Flexibilidade, durante o desenvolvimento foram necessárias algumas tomadas de decisões (incluir atributos em algumas entidades, alterar lógica de busca, tipos inseridos pelo usuários e tratados pelo sistema e por ultimo mas não menos importante as personalizações das excessões) e o casamento entre o springboot e a arquitetura REST torna essa experiência bem mais simples.
* Organização que permite delegar responsabilidades, prestar manutenção, identificar e corrigir problemas derivados de casos não previamente pensados com bastante facilidade.
* Maior experiência e conforto do desenvolvedor que vos escreve com todo o ambiente spring.


## Modelagem Conceitual
  Dadas as tabelas em formato .csv o primeiro passo foi fazer uma análise detalhadas de todos os atributos do header, buscando identificar num primeiro momento as possiveis associações, identificadores únicos, relacionamentos, entidades fracas e fortes, etc. Num segundo momento foi impresindível o mapeamento para um diagrama que se assemelha ao de classes (não foi feito dentro dos padrões técnicos academicos mas foi importante para a compreensão do problema). Este artificio possibilitou uma grande compreensão do escopo do problema e a partir daí então o pensamento mais técnico das criações das tabelas para popular o banco de dados foi iniciado.

  O Sistema de gerenciamento de banco de dados escolhido foi o PostgreSQL dada a ambientação prévia que tnha com o mesmo e por nunca ter tido problemas de desempenho por lá.
Link do diagrama citado anteriormente: (https://github.com/PabloPorto/bike-factory/files/6875239/UML.-.Seletiva-Final.pdf)

  Enfrentei problemas de configuração com meu acesso à nuvem, as minhas requisições à aws pelo postman só me retornavam bad request (quando eu errava de propósito algum parametro) ou timeout, o lado negativo de se ter pouco tempo (haja vista que as atividades do cotidiano não permitiram uma liberdade maior) é a dificuldade ao enfrentar tais problemas de configuração de ambiente.

## Considerações Finais

  Caso quem for avaliar estiver disposto a fazer alguns testes locais, eu inclui o swagger-ui nas dependências maven, então lá vai ficar intuitivo todos os endpoints, parametros requeridos, corpos de resposta e até interativo, o portal serve como uma ferramenta para fazer alguns testes locais, basta startar a aplicação e acessar: http://localhost:8080/swagger-ui/index.html?configUrl=/v3/api-docs/swagger-config. Os testes com MockMvc foram um complemento para mostrar alguns artificios dessa poderosa ferramenta, num ambiente de trabalho onde a qualidade contínua é sempre determinante poder dinamizar a construção dos testes unitários se mostra muito útil e poderosa. As tabelas .csv foram integradas no Amazon Relational Databases da AWS, a aplicação foi feita deploy no ambiente beanstalk que normamente garante um bom serviço, sendo àgil e escalonável (há sempre um momento oportuno para se ter problemas de configuração), o versionamento foi feito aqui no girHub sempre integrado com a IDE intellij, uma combinação muito boa pra quem precisa de praticidade. No mais, me coloco a disposição da equipe, agradeço o tempo dedicado a mim e o desafio prazeroso que me foi passado.
