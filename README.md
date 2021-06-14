# Sobre o projeto
API REST de gerenciamento de um estacionamento de carros e motos.

## Tecnologias utilizadas

- Java
- Spring Boot
- Maven
- Hibernate
- Banco de dados H2
- JPA
- RESTful
- Scrum
- JUnit
- JSON e XML

## Dependências

- Java Runtime Environment (JRE) >= 11.0.11
- Java Development Kit (JDK) >= 11.0.11
- Maven >= 3.8.1

## Links Úteis
- Trello do projeto: https://trello.com/b/WGQ4fiWC/teste-backend-java
- Instalação JRE e JDK: https://www.digitalocean.com/community/tutorials/how-to-install-java-with-apt-on-ubuntu-20-04-pt

## Instruções:
-Após instalar todas as dependências requeridas, importe o projeto em sua IDE preferida (recomenda-se a utilização de IntelliJ). 

- Em seguida, execute o arquivo "pom.xml" (exemplo no IntelliJ):

![Atualizando dependencias maven](https://lh3.googleusercontent.com/fife/AAWUweVB7JfSoZ_SiFaO9897MrrH2_6BSXfiqWPuIn6tAOgff0iV6hGTTJ2TxipF0GYrC38TxxNzDIzUbl8lb89fK-VgE7E7iJFc8q6XC5EtCqdhHZwB9SCqaXqsoy9sWuElk8FplrCGhc6DhqLXO2ICZOHiESXx0ylvips2zicrCfLbVhfAexA5Z98k_tLFJLbsTnBbjz6PM7P5_FMRfk3oMhJpE9fbpQxCtDS3Z8lnXH4JFeSycPMUEUQv5ox_QCrc7fDMsswfjlfQRqtNRHqS496nRiYlja9Epk_dx8bOqT_Zpqe_IjNIJ-YclJQxL4VCzn5I4yBALN2H9gr9KbpxA0TFUOVVpd2mg3S5CShCF9yJzwcGhCNoRN4Awqdsz6A-DOTSPFqfz9Da5tcZglDEkFGI8wvpNwEQabCrBfv74fItDDwapz7SSwOaHh6gvslCpHUlSoi0gIm9YiM8jO0VqFcffu-Sqs5F7NPN6-D-_vkkh1qhoxmcuS4jd2CWSy56C789skN7OjVokc_j6M844bmu0KM25NHA1Vjv3U6lbjGqhWzPbhHekVzBMxG5TElh3ufIEYysFR5gVu5LHQ39_ksvrhUNqIJhS2A08rEjUz9yyzEpJALJ531XXa7uPm5q8zDmvNFfFKNtlKv9walq38NZmLorcSMnF3GGXxiGRcwfBlwj1BndB6orbaQorjiTEUTWcntO5iwn3NKW8LdJj_cePGUuHvHUVzk=w1920-h856-ft)
- Caso deseje executar o projeto com profile de desenvolvimento ou produção execute com a tag: 
`-Dspring.profiles.active=prod` ou `-Dspring.profiles.active=`
Exemplo com IntelliJ:

![Modificando profile IntelliJ](https://lh3.googleusercontent.com/fife/AAWUweUy6ZkrUsjuGX-isdADtUrmbOgFaGjnYhBnmTg-YghUN7t3M4AuYKswSSg_RdFNzdSLR1oPIBxfVrmi4FaqFY8kaoM0LAelOjqeTvRETHXUKN8QX3AMn-1CYN0GeLstcRnpMbkcxB4ROyx0ZeY475CF6_DLW_YpktxwqnJTNve4VEpMwIzAzbFIf9wMa1_tjYx9hPJbnhBvKTS5xWY6ERhYZo5YbsxFGMOJ8i-t_cicilxW5NJ_4waQbx2MvMieoBhhrx24MgahS52aL9P91Gqr5g_DoGK3z7eM_rtYEYirK0TCi_5Qmf6CdvKfLWRtRyG4cBSUYm5nXwAVt3cwh1OY8fCxs_cPwSoazguq2V8HHbhGukwMCCPGtAsaJzbAr1vPj65RLqUKJfKCfyDuULKS2SDmD_dQZ3epN38PaZrvqu2WNp8vN5boLC6TUic8FcACIwOrmsyVdNgat-E3upa8nUrXTQnomZtKVxr0EYF-ivXi25bk61ZGB1Y9nN7xZ2ZQAgg-v-54wrMj16sdL1L4QJAuAB-cTbBiG_DBvLu1Pnc3JNag4MhylZMfnPyQi8aEqJTWxgL5MqZQ2DAXoxJrxuugWqJukVWgnDt8hIv83owWqLElPb-Jigbt2yTq4p7HrgKXtvbh-NxtWQeDnjLW0ZTVPcj555RqyEv-SL2VU4IkA98lFzsRoEt0aVLoZD_nlso3tczlwkUMPEiW_qC7yYLIjuRi5bg=w1365-h856-ft)

## Banco de dados
O teste foi feito utilizando o banco de dados H2, que pode ser manipulado utilizando o profile `dev` na rota:
http://localhost:8080/h2-console/login.jsp?jsessionid=7778c3126ee44605141d84c10c1d89a9

## Rotas
Todas as rotas podem ser visualizadas ao executar o projeto na rota da documentação com Swagger: 
http://localhost:8080/swagger-ui.html

## Retorno em JSON e XML
- Para retornar as requisições em JSON ou XML basta inserir no header da requisição a tag `Accept` com o conteúdo `application/json` ou `application/xml`;

## Funcionalidades realizadas
-   Estabelecimento:**  CRUD; `:heavy_check_mark:`
-   Veículos:  CRUD; `:heavy_check_mark:`
- Todos os campos são de preenchimento obrigatório. `:heavy_check_mark:`
-   Controle de entrada e saída de veículos. `:heavy_check_mark:`
-   Modelagem de dados; `:heavy_check_mark:`
-   O retorno deverá ser em formato JSON e XML; `:heavy_check_mark:`
-   Requisições GET, POST, PUT ou DELETE, conforme a melhor prática; `:heavy_check_mark:`
-   Desenvolver utilizando TDD; `:heavy_check_mark:`
-   Criar API de relatório; `:heavy_check_mark:`
-   Sumário da quantidade de entrada e saída; `:heavy_check_mark:`
-   Sumário da quantidade de entrada e saída de veículos por hora; `:heavy_check_mark:`
-   Criar uma solução de autenticação. `:heavy_check_mark:`
-  Criar README do projeto descrevendo as tecnologias utilizadas, chamadas dos serviços e configurações necessário para executar a aplicação. `:heavy_check_mark:`

# Participante:

Luiz Ricardo Soares dos Santos - [![Linkedin Badge](https://camo.githubusercontent.com/1c23f7895aa673fa701bca3fa0253dd7d17a8a2d2b3ba23571e712a93ddb5db7/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f2d4c696e6b6564496e2d626c75653f7374796c653d666c61742d737175617265266c6f676f3d4c696e6b6564696e266c6f676f436f6c6f723d7768697465266c696e6b3d68747470733a2f2f7777772e6c696e6b6564696e2e636f6d2f696e2f6c75697a2d7269636172646f2d736f617265732d646f732d73616e746f732d3038353830383137622f)](https://www.linkedin.com/in/luiz-ricardo-soares-dos-santos-08580817b/)

## Obrigado!
Obrigado pela oportunidade, foi muito divertido! 🚀
