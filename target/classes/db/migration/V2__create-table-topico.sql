CREATE TABLE topicos (
    id BIGINT NOT NULL AUTO_INCREMENT,
    mensagem VARCHAR(1000),
    autor VARCHAR(100) NOT NULL,
    titulo VARCHAR(100) NOT NULL,
    curso VARCHAR(100),
    creation_date_time datetime,
    PRIMARY KEY (id)
);