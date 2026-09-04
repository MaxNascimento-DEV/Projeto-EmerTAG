CREATE TABLE contato_emergencia (
    id_contato_emergencia BIGINT AUTO_INCREMENT PRIMARY KEY,
    id_pessoa BIGINT NOT NULL,
    nome_contato varchar(100) NOT NULL,
    telefone_contato VARCHAR(20) NOT NULL,
    parentesco_contato VARCHAR(50),
    prioridade_contato INT NOT NULL,
    CONSTRAINT fk_contato_pessoa FOREIGN KEY (id_pessoa) REFERENCES pessoa_protegida(id_pessoa)
);