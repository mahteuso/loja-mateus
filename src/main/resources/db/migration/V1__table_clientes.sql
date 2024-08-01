create table Equipamentos(
    id serial primary key,
    nome varchar(255) not null,
    descricao TEXT,
    patrimonio varchar(255) not null,
    criacao date not null,
    ativo boolean not null,
    imagemArquivo varchar(255)
);