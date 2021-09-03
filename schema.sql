drop table if exists tb_usuario

CREATE TABLE tb_usuario{
    id varchar(100) PRIMARY KEY NOT NULL,
    nome varchar(100) NOT NULL,
    idade integer NOT NULL
}