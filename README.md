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

