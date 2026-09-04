CREATE TABLE pessoa_protegida (
    id_pessoa BIGINT AUTO_INCREMENT PRIMARY KEY,
    id_usuario_criador BIGINT NOT NULL,
    nome VARCHAR(100) NOT NULL,
    data_nascimento DATE NOT NULL,
    telefone VARCHAR(20) NOT NULL,
    observacoes TEXT,
    data_cadastro DATE NOT NULL,
    data_atualizacao DATETIME,
    CONSTRAINT fk_pessoa_usuario_criador
        FOREIGN KEY (id_usuario_criador) REFERENCES usuario(id_usuario)
);