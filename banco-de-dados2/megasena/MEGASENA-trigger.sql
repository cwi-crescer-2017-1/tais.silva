Create table LogAposta_Operacao (  
  IDLogAposta             number not null,
  IdApostaAntigo          number,
  IdApostaNovo            number,
  IdConcursoAntigo        number,
  IdConcursoNovo          number,
  IdCidadeAntigo          number,
  IdCidadeNovo            number,
  DataAntigo              date default sysdate,
  DataNovo                date default sysdate,
  QuantidadeNumerosAntigo number,
  QuantidadeNumerosNovo   number,
  ValorAntigo             number,
  ValorNovo               number,
  BolaoAntigo             number,
  BolaoNovo               number,
  Operacao                char(1),
    constraint PK_LogAposta_Operacao 
       primary key (IDLogAposta)
);

Create sequence sqLogAposta_Operacao;

  create or replace
trigger TR_MONITORAR_APOSTA
    after insert or update or delete on APOSTA
Declare
  IDLogAposta             number;
  IdApostaAntigo          number;
  IdApostaNovo            number;
  IdConcursoAntigo        number;
  IdConcursoNovo          number;
  IdCidadeAntigo          number;
  IdCidadeNovo            number;
  DataAntigo              date;
  DataNovo                date;
  QuantidadeNumerosAntigo number;
  QuantidadeNumerosNovo   number;
  ValorAntigo             number;
  ValorNovo               number;
  BolaoAntigo             number;
  BolaoNovo               number;
  v_operacao              char(1);
  
Begin
  if INSERTING then
    v_operacao := 'I';
    v_IdApostaAntigo := null;
    v_IdApostaNovo := :new.IdApostaNovo;
    v_IdConcursoAntigo := null;
    v_IdConcursoNovo := :new.IdConcursoNovo;
    v_IdCidadeAntigo := null;
    v_IdCidadeNovo := :new.IdCidadeNovo;
    v_DataAntigo := null;
    v_DataNovo := :new.DataNovo;
    v_QuantidadeNumeroAntigo := null;
    v_QuantidadeNumeroNovo := :new.QuantidadeNumero;
    v_ValorAntigo := null;
    v_ValorNovo := :new.ValorNovo;
    v_BolaoAntigo := null;
    v_BolaoNovo := :new.BolaoNovo;     
  elsif UPDATING then
    v_operacao := 'U';
    v_IdApostaAntigo := :old.IdApostaAntigo;
    v_IdApostaNovo := :new.IdApostaNovo;
    v_IdConcursoAntigo := :old.IdConcursoAntigo;
    v_IdConcursoNovo := :new.IdConcursoNovo;
    v_IdCidadeAntigo := :old.IdCidadeAntigo;
    v_IdCidadeNovo := :new.IdCidadeNovo;
    v_DataAntigo := :old.DataAntigo;
    v_DataNovo := sysdate;
    v_QuantidadeNumeroAntigo := :old.QuantidadeNumero;
    v_QuantidadeNumeroNovo := :new.QuantidadeNumero;
    v_ValorAntigo := :old.ValorAntigo;
    v_ValorNovo := :new.ValorNovo;
    v_BolaoAntigo := :old.BolaoAntigo;
    v_BolaoNovo := :new.BolaoNovo;
  else
    v_operacao := 'D';
    v_IdApostaAntigo := :old.IdApostaAntigo;
    v_IdApostaNovo := null;
    v_IdConcursoAntigo := :old.IdConcursoAntigo;
    v_IdConcursoNovo := null;
    v_IdCidadeAntigo := :old.IdCidadeAntigo;
    v_IdCidadeNovo := null;
    v_DataAntigo := :old.DataAntigo;
    v_DataNovo := null;
    v_QuantidadeNumeroAntigo := :old.QuantidadeNumero;
    v_QuantidadeNumeroNovo := null;
    v_ValorAntigo := :old.ValorAntigo;
    v_ValorNovo := null;
    v_BolaoAntigo := :old.BolaoAntigo;
    v_BolaoNovo := null;
  end if;

  Insert into LogAposta_Operacao (idlogaposta, IdApostaAntigo, IdApostaNovo, IdConcursoAntigo, IdConcursoNovo, IdCidadeAntigo, IdCidadeNovo, DataAntigo, DataNovo, QuantidadeNumeroAntigo, QuantidadeNumeroNovo, ValorAntigo, ValorNovo, BolaoAntigo, BolaoNovo, operacao)
      values (sqlogaposta_operacao.nextval, v_IdApostaAntigo, v_IdApostaNovo, v_IdConcursoAntigo, v_IdConcursoNovo, v_IdCidadeAntigo, v_IdCidadeNovo, v_DataAntigo, v_DataNovo, v_QuantidadeNumeroAntigo, v_QuantidadeNumeroNovo, v_ValorAntigo, v_ValorNovo, v_BolaoAntigo, v_BolaoNovo, v_operacao);

End TR_MONITORAR_APOSTA;


Create table Log_Numero_Operacao (
  IdLogNumero       number not null,
  IdNumeroAntigo    number,
  IdNumeroNovo      number,
  IdApostaAntigo    number,
  IdApostaNovo      number,
  DataAntigo        date default sysdate,
  DataNovo          date default sysdate,
  Operacao          char(1),
    constraint PK_LogNumero_Operacao
       primary key (IdLogNumero)
);

Create sequence sqLogNumero_Operacao;

  create or replace
trigger TR_MONITORAR_NUMERO
    after insert or update or delete on NUMERO
Declare
  v_IdLogNumero       number;
  v_IdNumeroAntigo    number;
  v_IdNumeroNovo      number;
  v_IdApostaAntigo    number;
  v_IdApostaNovo      number;
  v_DataAntigo        date;
  v_DataNovo          date;
  v_operacao          char(1);
  
Begin
  if INSERTING then
    v_operacao := 'I';    
    v_IdNumeroAntigo := null;
    v_IdNumeroNovo := :new.IdNumeroNovo;
    v_IdApostaAntigo := null;
    v_IdApostaNovo := :new.IdApostaNovo;
    v_DataAntigo := null;
    v_DataNovo := sysdate;
  elsif UPDATING then
    v_operacao := 'U';
    v_IdNumeroAntigo := :old.IdNumeroAntigo;
    v_IdNumeroNovo := :new.IdNumeroNovo;
    v_IdApostaAntigo := :old.IdApostaAntigo;
    v_IdApostaNovo := :new.IdApostaNovo;
    v_DataAntigo := :old.DataAntigo;
    v_DataNovo := sysdate;
  else
    v_operacao := 'D';
    v_IdNumeroAntigo := :old.IdNumeroAntigo;
    v_IdNumeroNovo := null;
    v_IdApostaAntigo := :old.IdApostaAntigo;
    v_IdApostaNovo := null;
    v_DataAntigo := :old.DataAntigo;
    v_DataNovo := null;
  end if;

  Insert into LogNumero_Operacao (IdLogNumero, IdNumeroAntigo, IdNumeroNovo, IdApostaAntigo, IdApostaNovo, DataAntigo, DataNovo, Operacao)  
      values (sqlognumero_operacao.nextval, v_IdNumeroAntigo, v_IdNumeroNovo, v_IdApostaAntigo, v_IdApostaNovo, v_DataAntigo, v_DataNovo, v_Operacao);

End TR_MONITORAR_NUMERO;

