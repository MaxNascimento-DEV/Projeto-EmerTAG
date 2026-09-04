CREATE TABLE informacao_medica (
    id_informacao BIGINT AUTO_INCREMENT PRIMARY KEY,
    id_pessoa BIGINT NOT NULL,
    alergias VARCHAR(255),
    doencas_cronicas VARCHAR(255),
    medicamentos_de_uso_continuo VARCHAR(255),
    historico_cirurgico TEXT,
    grupo_sanguineo VARCHAR(2),
    fator_rh VARCHAR(10),
    condicao_biosseguranca VARCHAR(50),
    descricao_informacao_adicional TEXT,
    data_cadastro DATETIME NOT NULL,
    data_atualizacao DATETIME,
    CONSTRAINT fk_informacao_pessoa
        FOREIGN KEY (id_pessoa) REFERENCES pessoa_protegida(id_pessoa)
);