create table clientes(
    id serial primary key,
    nome varchar(255) not null,
    sobrenome varchar(255) not null,
    cpf varchar(255) not null,
    email varchar(255) not null
);