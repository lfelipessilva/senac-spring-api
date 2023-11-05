CREATE TABLE
    users (
        id INT PRIMARY KEY UNIQUE NOT NULL,
        nome VARCHAR(60) NOT NULL,
        email VARCHAR(80) NOT NULL,
        senha VARCHAR(60) NOT NULL,
        cpf VARCHAR(13) NOT NULL,
        dataNascimento DATE,
        endereco VARCHAR(255),
        telefone VARCHAR(15),
    );