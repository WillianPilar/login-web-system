# login-web-system
Sistema Web responsável por validar o login de usuários.

Criada por: Willian Araujo Pilar 
Contatos: 
    Email - willianpilar@hotmail.com 
    Celular - 11 949096639
    Linkedin - https://www.linkedin.com/in/willian-pilar-ar/

# FRONT END #
    Desenvolvido em Angular 11

    Sistema web com tela de Login, cadastro e home.
    Ao inicializar a aplicação, abrir no seu navegador de preferência a seguinte url: http://localhost:4200/login
    Caso abra a URL: http://localhost:4200 dê um refresh (F5) na tela


# BACK END #
    validate-login-api-v1 - /validate-login/api/v1
    Desenvolvido em Java 11 - Spring Boot

    API responsável pelo cadastro e controle de Login dos usuários.
    Possui dois endpoints:

        POST - /registration
            Objetivo: Endpoint responsável por realizar o cadastro dos usuários.
            Entrada: JSON 
                {
                    "name" : {
                        "first" : "Willian",
                        "last" : "Pilar"
                    },
                    "email" : "willian1pilar@hotmail.com",
                    "key" : "123"
                } 
            Resposta sucesso: 
                Código: 201 Created
            
            Respostas erro:
                1 - Código: 400 Bad Request
                    Mensagem: "Email is already in use"
                2 - Código: 500 Internal Server Error
        
        GET - /login
            Objetivo: Controle de login dos usuários no sistema
            Entrada: Dois parâmetros no Header
                1 - email: Parâmetro onde deve ser passado o email cadastrado
                2 - key: Parâmetro onde deve ser passado a senha do usuário
            
            Resposta sucesso:
                Código: 200 Ok
                    JSON: 
                        {
                            "message": "Login successfully"
                        }
            
            Respostas erro:
                1 - Código: 400 Bad Request
                    Mensagem: "User not registered" / "Incorrect password" / "Error trying to login"
                2 - Código: 500 Internal Server Error

# DATABASE #
    Banco de dados em memória H2 - Gerado automáticamente ao iniciar a API
    Tabela: TB_CREDENTIALS

    Para acessar o banco de dados abrir no seu navegador de preferência a seguinte URL:
    http://localhost:7080/h2-console

    Na autenticação colocar as seguintes informações:
    Driver Class: org.h2.Driver
    JDBC URL: jdbc:h2:mem:testdb
    User Name: sa
    Password:

    Query para consultar informações gravadas:
    SELECT * FROM TB_CREDENTIALS

Qulquer dúvida entrar em contato:
    Contatos: 
        Email - willianpilar@hotmail.com 
        Celular - 11 949096639
        Linkedin - https://www.linkedin.com/in/willian-pilar-ar/

    