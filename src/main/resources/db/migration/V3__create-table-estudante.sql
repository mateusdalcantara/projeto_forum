CREATE TABLE estudante (
    id BIGINT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    cpf VARCHAR(100) NOT NULL,
    curso VARCHAR(100) NOT NULL,
    matricula VARCHAR(100) NOT NULL,
    celular VARCHAR(100) NOT NULL,
    ativo TINYINT NOT NULL,
    usuario_id BIGINT,
    PRIMARY KEY (id),
    FOREIGN KEY (usuario_id) REFERENCES usuario(id)
);
