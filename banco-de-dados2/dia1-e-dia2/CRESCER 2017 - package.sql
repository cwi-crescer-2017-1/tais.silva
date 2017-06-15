create or replace package pck_cidades as
  procedure eliminar_duplicadas;
end;

create or replace package body pck_cidades as
  --------------------------------------------------------------------------------- 
  procedure eliminar_duplicadas is
        cursor c_cidades is
             select Nome, UF, MIN(IDCidade) as MenorId
             from   Cidade
             group  by Nome, UF
             having count(1) >1;
        ---------------------------------------------------------
        cursor c_clientes (pNome in varchar2, pUF   in varchar2) is
           select cli.IDCliente,
                  cli.Nome as Nome_Cliente,
                  cid.Nome as Nome_Cidade,
                  cid.UF
           from   Cliente cli
            inner join Cidade cid on cid.IDCidade = cli.IDCidade
           where  cid.Nome = pNome
           and    cid.UF   = pUF;
        ----------------------------------------------------------
      begin
      
        FOR c in c_cidades LOOP            
            FOR i in c_clientes (c.Nome, c.UF) LOOP
                 update cliente
                 set IDCidade = c.MenorId
                 where IDCliente = i.IDCliente;
            END LOOP;
            delete cidade
            where IDCidade != c.MenorId;
        END LOOP;             
      
      end;
      
    end eliminar_duplicadas; 
  ---------------------------------------------------------------------------------
end;


begin
  pck_cidades.eliminar_duplicadas;  
end;