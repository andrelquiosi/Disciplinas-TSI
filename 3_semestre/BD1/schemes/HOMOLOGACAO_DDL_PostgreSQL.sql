CREATE TABLE IF NOT EXISTS pessoa (
    pessoa_id NUMERIC(10),
    nome_Pessoa CHAR(80) NOT NULL,
    cpfcnpj CHAR(14),
    email varchar(80),
    website varchar(80),
    observacao varchar(256),
    tipo_pessoa CHAR(1),
    situacao CHAR(1) NOT NULL,
    CONSTRAINT pessoa_pk PRIMARY KEY (pessoa_id),
    CONSTRAINT cpfcnpj_uk UNIQUE (cpfcnpj)
);

CREATE TABLE IF NOT EXISTS endereco(
    endereco_id NUMERIC(10),
    pessoa_id NUMERIC(10) not NULL,
    logradouro varchar(120) not NULL,
    nr NUMERIC(10),
    cep NUMERIC(8) NOT null,
    CONSTRAINT endereco_pk PRIMARY KEY (endereco_id),
    CONSTRAINT pes_end_fk FOREIGN KEY (pessoa_id) REFERENCES pessoa (pessoa_id)
);

CREATE TABLE IF NOT EXISTS cliente(
    cliente_id NUMERIC(10),
    endereco_cobranca_id NUMERIC(10),
    endereco_entrega_id NUMERIC(10),
    CONSTRAINT cliente_pk PRIMARY KEY (cliente_id),
    CONSTRAINT cli_end_cob_fk FOREIGN KEY (endereco_cobranca_id) REFERENCES endereco (endereco_id),
    CONSTRAINT cli_end_ent_fk FOREIGN KEY (endereco_entrega_id) REFERENCES endereco (endereco_id),
    CONSTRAINT pes_cli_fk FOREIGN KEY (cliente_id) REFERENCES pessoa (pessoa_id)
);

CREATE TABLE IF NOT EXISTS fornecedor(
    fornecedor_id NUMERIC(10),
    CONSTRAINT fornecedor_pk PRIMARY KEY (fornecedor_id),
    CONSTRAINT pes_for_fk FOREIGN KEY (fornecedor_id) REFERENCES pessoa (pessoa_id)
);

CREATE TABLE IF NOT EXISTS representante(
    representante_id NUMERIC(10),
    CONSTRAINT representante_pk PRIMARY KEY (representante_id),
    CONSTRAINT rep_pes_id FOREIGN KEY (representante_id) REFERENCES pessoa (pessoa_id)
);

CREATE TABLE IF NOT EXISTS usuario(
    usuario_id NUMERIC(10),
    login CHAR(10) NOT NULL,
    senha CHAR(10) NOT NULL,
    situacao CHAR(1) NOT NULL,
    CONSTRAINT usuario_pk PRIMARY KEY (usuario_id),
    CONSTRAINT login_uk UNIQUE (login),
    CONSTRAINT pes_usu_fk FOREIGN KEY (usuario_id) REFERENCES pessoa (pessoa_id)
);

CREATE TABLE IF NOT EXISTS empresa(
    empresa_id NUMERIC(10),
    nome_principal varchar(80),
    situacao CHAR(1) NOT NULL,
    CONSTRAINT empresa_pk PRIMARY KEY(empresa_id)
);

CREATE TABLE IF NOT EXISTS filial(
    empresa_id NUMERIC(10),
    filial_id NUMERIC(10),
    razao_social varchar(80),
    insc_estadual integer,
    situacao CHAR(1) NOT NULL,
    CONSTRAINT filal_pk PRIMARY KEY (empresa_id, filial_id),
    CONSTRAINT razao_social_uk UNIQUE (razao_social),
    CONSTRAINT emp_id_fk FOREIGN KEY (empresa_id) REFERENCES empresa(empresa_id)
);

CREATE TABLE IF NOT EXISTS acesso_usuario(
    empresa_id NUMERIC(10),
    filial_id NUMERIC(10),
    usuario_id NUMERIC(10),
    CONSTRAINT acesso_usu_pk PRIMARY KEY (empresa_id, filial_id, usuario_id),
    CONSTRAINT acess_fil_fk FOREIGN KEY (empresa_id, filial_id) REFERENCES filial (empresa_id, filial_id),
    CONSTRAINT acess_uso_fk FOREIGN KEY (usuario_id) REFERENCES usuario (usuario_id)
);