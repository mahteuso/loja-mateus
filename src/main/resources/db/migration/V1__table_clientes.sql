create table Equipamentos(
    id serial primary key,
    nome varchar(255) not null,
    descricao varchar not null,
    patrimonio varchar(255) not null,
    criacao date not null
);