create table Equipamentos(
    id serial primary key,
    nome varchar(255) not null,
    descricao TEXT,
    patrimonio varchar(255) not null,
    data_de_criacao varchar not null,
    ativo boolean not null
);