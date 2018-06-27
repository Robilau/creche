DROP TABLE TBCrianca;
DROP TABLE TBTurma;
DROP TABLE TBCuidador;
DROP TABLE TBRpc;
DROP TABLE TBRelatorio;

Create table TBCuidador (id_cuidador serial primary key not null, nome_cuidador text not null, telefone_cuidador text not null, rg_cuidador text not null, cpf_cuidador text not null, login_cuidador text not null, senha_cuidador text not null);
INSERT INTO TBCuidador (nome_cuidador, rg_cuidador, telefone_cuidador, cpf_cuidador, login_cuidador, senha_cuidador) VALUES ('Lucas Chaves', '78965412', '(48)99987-1236', '23649826518', 'login', 'senha');

CREATE TABLE TBRpc (id_rpc serial primary key not null, nome_rpc text not null, rg_rpc text not null, cpf_rpc text not null, telefone_rpc text not null, endereco_rpc text not null);
INSERT INTO TBRpc (nome_rpc, rg_rpc, cpf_rpc, endereco_rpc, telefone_rpc) VALUES ('Gabriel Celestino', '4567892', '08134527956', 'Avenida Brasil', '(49)99956-7898');

CREATE TABLE TBTurma (id_turma serial primary key not null, cuidador_id integer not null, nome_turma text not null, turno_turma text not null, FOREIGN KEY (cuidador_id) REFERENCES TBCuidador (id_cuidador));
INSERT INTO TBTurma (nome_turma, turno_turma, cuidador_id) VALUES ('maternal II', 'Matutino', 1);

Create table TBCrianca (id_crianca serial primary key not null, nome_crianca text not null, rg_crianca text not null, dataNascimento_crianca Date not null, rpc_id integer not null, turma_id integer not null, FOREIGN KEY (rpc_id) REFERENCES TBRpc(id_rpc), FOREIGN KEY (turma_id) REFERENCES TBTurma(id_turma));
INSERT INTO TBCrianca (nome_crianca, rg_crianca, dataNascimento_crianca, rpc_id, turma_id) VALUES ('Letícia Ventura','5648789', '1996-08-12', 1, 1);

Create table TBRelatorio (id_relatorio serial primary key not null, texto_relatorio text, ausente_relatorio boolean not null,  data_relatorio date not null, crianca_id integer not null, FOREIGN KEY (crianca_id) REFERENCES TBCrianca (id_crianca));
INSERT INTO TBRelatorio (texto_relatorio, ausente_relatorio, data_relatorio, crianca_id) VALUES ('texxxxxtttttoooooooo', false, now(), '1')
