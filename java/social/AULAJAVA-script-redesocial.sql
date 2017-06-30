CREATE TABLE usuario (
	id integer not null,
	email varchar2(100) not null,
	nome varchar2(100) not null,
	sexo char(1) not null,
	data_nascimento DATE not null,
	senha varchar2(100) not null,
	constraint USUARIO_PK PRIMARY KEY (id));
    
CREATE sequence USUARIO_SEQ
/
CREATE trigger BI_USUARIO
  before insert on USUARIO
  for each row
begin
  select USUARIO_SEQ.nextval into :NEW.id from dual;
end;
/


/
CREATE TABLE post (
	id integer not null,
	data DATE not null,
	usuario integer not null,
	texto varchar2(2000) not null,
	imagem varchar2(500),
	constraint POST_PK PRIMARY KEY (id));

CREATE sequence POST_SEQ
/
CREATE trigger BI_POST
  before insert on POST
  for each row
begin
  select POST_SEQ.nextval into :NEW.id from dual;
end;
/


/
CREATE TABLE amizade (
	id integer not null,
	data DATE not null,
	solicitante integer not null,
	solicitado integer not null,
	situacao char(1) not null,
	constraint AMIZADE_PK PRIMARY KEY (id));

CREATE sequence AMIZADE_SEQ
/
CREATE trigger BI_AMIZADE
  before insert on AMIZADE
  for each row
begin
  select AMIZADE_SEQ.nextval into :NEW.id from dual;
end;
/


/
CREATE TABLE comentario (
	id integer not null,
	data DATE not null,
	post integer not null,
	usuario integer not null,
	texto varchar2(150) not null,
	constraint COMENTARIO_PK PRIMARY KEY (id));

CREATE sequence COMENTARIO_SEQ
/
CREATE trigger BI_COMENTARIO
  before insert on COMENTARIO
  for each row
begin
  select COMENTARIO_SEQ.nextval into :NEW.id from dual;
end;
/


/
CREATE TABLE reacao (
	id integer not null,
	data DATE not null,
	post integer not null,
	usuario integer not null,
	constraint REACAO_PK PRIMARY KEY (id));

CREATE sequence REACAO_SEQ
/
CREATE trigger BI_REACAO
  before insert on REACAO
  for each row
begin
  select REACAO_SEQ.nextval into :NEW.id from dual;
end;
/


/

ALTER TABLE post ADD CONSTRAINT post_fk0 FOREIGN KEY (usuario) REFERENCES usuario(id);

ALTER TABLE amizade ADD CONSTRAINT amizade_fk0 FOREIGN KEY (solicitante) REFERENCES usuario(id);
ALTER TABLE amizade ADD CONSTRAINT amizade_fk1 FOREIGN KEY (solicitado) REFERENCES usuario(id);

ALTER TABLE comentario ADD CONSTRAINT comentario_fk0 FOREIGN KEY (post) REFERENCES post(id);
ALTER TABLE comentario ADD CONSTRAINT comentario_fk1 FOREIGN KEY (usuario) REFERENCES usuario(id);

ALTER TABLE reacao ADD CONSTRAINT reacao_fk0 FOREIGN KEY (post) REFERENCES post(id);
ALTER TABLE reacao ADD CONSTRAINT reacao_fk1 FOREIGN KEY (usuario) REFERENCES usuario(id);


drop table comentario;
drop table reacao;
drop table post;
drop table amizade;
drop table usuario;