CREATE TABLE topicos (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(255) NOT NULL,
    mensagem TEXT NOT NULL,
    data_criacao TIMESTAMP NOT NULL,
    status BOOLEAN NOT NULL,
    autor_id BIGINT NOT NULL,
    curso VARCHAR(255) NOT NULL,
    FOREIGN KEY (autor_id) REFERENCES usuarios(id)
);
