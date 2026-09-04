CREATE TABLE qr_code (
    id_qr_code BIGINT AUTO_INCREMENT PRIMARY KEY,
    id_pessoa BIGINT NOT NULL UNIQUE,
    codigo VARCHAR(255) NOT NULL UNIQUE,
    url_acesso VARCHAR(255) NOT NULL,
    data_gerada DATETIME NOT NULL,
    ativo BOOLEAN NOT NULL,
    CONSTRAINT fk_qrcode_pessoa
        FOREIGN KEY (id_pessoa) REFERENCES pessoa_protegida(id_pessoa)
);