--liquibase formatted sql

--changeset cipri:1
CREATE TABLE users(
    id INT NOT NULL auto_increment,
    id_role INT,
    name NVARCHAR(50),
    username NVARCHAR(50),
    password NVARCHAR(50),
    PRIMARY KEY(id)
    );
--rollback drop table users


--changeset cipri:2
CREATE TABLE roles
(
    id INT NOT NULL auto_increment,
    name NVARCHAR(50),
    description NVARCHAR(50),
    PRIMARY KEY(id)
);
--rollback drop table roles

--changeset cipri:3
CREATE TABLE groups_users
(
    id INT NOT NULL auto_increment,
    id_user INT,
    id_group INT,
    PRIMARY KEY(id)
);
--rollback drop table groups_users

--changeset cipri:4
CREATE TABLE groups
(
    id INT NOT NULL auto_increment,
    name NVARCHAR(50),
    description NVARCHAR(50),
    PRIMARY KEY(id)
);
--rollback drop table groups

--changeset cipri:5
CREATE TABLE documents
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
--rollback drop table documents

--changeset cipri:6
CREATE TABLE documents_statuses
(
    id INT NOT NULL auto_increment ,
    id_doc INT,
    id_status INT,
    PRIMARY KEY(id)
);
--rollback drop table documents_statuses

--changeset cipri:7
CREATE TABLE fluxes
(
    id INT NOT NULL auto_increment,
    id_doc_status INT,
    details NVARCHAR(100),
    PRIMARY KEY(id)
);
--rollback drop table flux

--changeset cipri:8
CREATE TABLE statuses
(
    id INT NOT NULL,
    name NVARCHAR(50),
    PRIMARY KEY(id)
);
--rollback drop table statuses

--changeset cipri:9
CREATE TABLE templates
(
    id INT NOT NULL auto_increment,
    name NVARCHAR(50),
    PRIMARY KEY(id)
);
--rollback drop table templates

--changeset cipri:10
ALTER TABLE users
    ADD CONSTRAINT fk_users_roles FOREIGN KEY (id_role)
    REFERENCES roles(id)
;
--rollback ALTER TABLE users DROP FOREIGN KEY fk_users_roles

--changeset cipri:11
ALTER TABLE groups_users
    ADD CONSTRAINT fk_groups_users_users FOREIGN KEY (id_user)
    REFERENCES users(id)
;
--rollback ALTER TABLE groups_users DROP FOREIGN KEY fk_groups_users_users

--changeset cipri:12
ALTER TABLE groups_users
    ADD CONSTRAINT fk_groups_users_groups FOREIGN KEY (id_group)
    REFERENCES groups(id)
;
--rollback ALTER TABLE groups_users DROP FOREIGN KEY fk_groups_users_groups

--changeset cipri:13
ALTER TABLE documents
    ADD CONSTRAINT fk_documents_users FOREIGN KEY (autor)
    REFERENCES users(id)
;
--rollback ALTER TABLE documents DROP FOREIGN KEY fk_documents_users

--changeset cipri:14
ALTER TABLE documents_statuses
    ADD CONSTRAINT fk_documents_statuses_documents FOREIGN KEY (id_doc)
    REFERENCES documents(id)
;
--rollback ALTER TABLE documents_statuses DROP FOREIGN KEY fk_documents_statuses_documents

--changeset cipri:16
ALTER TABLE documents_statuses
    ADD CONSTRAINT fk_documents_statuses_statuses FOREIGN KEY (id_status)
    REFERENCES statuses(id)
;
--rollback ALTER TABLE documents_statuses DROP FOREIGN KEY fk_documents_statuses_statuses

--changeset cipri:17
ALTER TABLE documents
    ADD CONSTRAINT fk_documents_templates FOREIGN KEY (id_template)
    REFERENCES templates(id)
;
--rollback ALTER TABLE documents DROP FOREIGN KEY fk_documents_templates
