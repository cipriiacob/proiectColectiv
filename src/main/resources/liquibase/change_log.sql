--liquibase formatted sql

--changeset cipri:1
CREATE TABLE user(
    id INT NOT NULL auto_increment,
    id_rol INT,
    name NVARCHAR(50),
    username NVARCHAR(50),
    password NVARCHAR(50),
    PRIMARY KEY(id)
    );
--rollback drop table user


--changeset cipri:2
CREATE TABLE rol
(
    id INT NOT NULL auto_increment,
    name NVARCHAR(50),
    description NVARCHAR(50),
    PRIMARY KEY(id)
);
--rollback drop table rol

--changeset cipri:3
CREATE TABLE grup_user
(
    id INT NOT NULL auto_increment,
    id_user INT,
    id_grup INT,
    PRIMARY KEY(id)
);
--rollback drop table grup_user

--changeset cipri:4
CREATE TABLE grup
(
    id INT NOT NULL auto_increment,
    name NVARCHAR(50),
    description NVARCHAR(50),
    PRIMARY KEY(id)
);
--rollback drop table grup

--changeset cipri:5
CREATE TABLE document
(
    id INT NOT NULL auto_increment,
    NAME NVARCHAR(50),
    VERSION NVARCHAR(50),
    AUTOR INT,
    created_at TIMESTAMP,
    updated_at TIMESTAMP DEFAULT NOW(),
    abstract NVARCHAR(100),
    key_words NVARCHAR(100),
    id_template INT,
    PRIMARY KEY(id)
);
--rollback drop table document

--changeset cipri:6
CREATE TABLE document_status
(
    id INT NOT NULL auto_increment ,
    id_doc INT,
    id_status INT,
    PRIMARY KEY(id)
);
--rollback drop table document_status

--changeset cipri:7
CREATE TABLE flux
(
    id INT NOT NULL auto_increment,
    id_doc_status INT,
    details NVARCHAR(100),
    PRIMARY KEY(id)
);
--rollback drop table flux

--changeset cipri:8
CREATE TABLE status
(
    id INT NOT NULL,
    name NVARCHAR(50),
    PRIMARY KEY(id)
);
--rollback drop table status

--changeset cipri:9
CREATE TABLE template
(
    id INT NOT NULL auto_increment,
    name NVARCHAR(50),
    PRIMARY KEY(id)
);
--rollback drop table template

--changeset cipri:10
ALTER TABLE user
    ADD CONSTRAINT fk_user_rol FOREIGN KEY (id_rol)
    REFERENCES rol(id)
;
--rollback ALTER TABLE user DROP FOREIGN KEY fk_user_rol

--changeset cipri:11
ALTER TABLE grup_user
    ADD CONSTRAINT fk_grup_user_user FOREIGN KEY (id_user)
    REFERENCES user(id)
;
--rollback ALTER TABLE grup_user DROP FOREIGN KEY fk_grup_user_user

--changeset cipri:12
ALTER TABLE grup_user
    ADD CONSTRAINT fk_grup_user_grup FOREIGN KEY (id_grup)
    REFERENCES grup(id)
;
--rollback ALTER TABLE grup_user DROP FOREIGN KEY fk_grup_user_grup

--changeset cipri:13
ALTER TABLE document
    ADD CONSTRAINT fk_document_user FOREIGN KEY (autor)
    REFERENCES user(id)
;
--rollback ALTER TABLE document DROP FOREIGN KEY fk_document_user

--changeset cipri:14
ALTER TABLE document_status
    ADD CONSTRAINT fk_document_status_document FOREIGN KEY (id_doc)
    REFERENCES document(id)
;
--rollback ALTER TABLE document_status DROP FOREIGN KEY fk_document_status_document

--changeset cipri:16
ALTER TABLE document_status
    ADD CONSTRAINT fk_document_status_status FOREIGN KEY (id_status)
    REFERENCES status(id)
;
--rollback ALTER TABLE document_status DROP FOREIGN KEY fk_document_status_status

--changeset cipri:17
ALTER TABLE document
    ADD CONSTRAINT fk_document_template FOREIGN KEY (id_template)
    REFERENCES template(id)
;
--rollback ALTER TABLE document DROP FOREIGN KEY fk_document_template
