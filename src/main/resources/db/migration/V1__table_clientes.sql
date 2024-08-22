create table Equipamentos(
    id serial primary key,
    nome varchar(255) not null,
    descricao TEXT,
    patrimonio varchar(255) not null,
    data_de_criacao varchar not null,
    ativo boolean not null
);

create table Usuarios(
    id serial primary key,
    nome varchar(255) not null,
    email varchar(255) not null,
    password varchar(255) not null
);