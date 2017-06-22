create or replace package body pck_megasena is

  /* Busca valores percentuais conforme regra definida na tabela 'Regra_Rateio_Premio' */
  function buscaPercentual(pIdentificador in varchar2) return number as
        -- 
        v_percentual  regra_rateio_premio.percentual%type; -- herdará as propriedades do campo percentual
      begin
        
        -- busca percentual conforme parametro de entrada
        select percentual
        into   v_percentual   -- atribuí valor para a variavel
        from   regra_rateio_premio
        where  identificador = lower(pIdentificador);
        
        return v_percentual;
      exception
        when no_data_found then
          dbms_output.put_line('Erro: '||pIdentificador);
          raise_application_error(-20002, sqlerrm);
      end buscaPercentual;
  ---------------------------------------------------------------------------------------------------------------------------------------
  /* Executa o rateio dos premios conforme definção das regras */
  procedure defineRateioPremio (pPremio in number) as
    begin
    
       gPremio_sena          := buscaPercentual('premio_sena') * pPremio;
       gPremio_quina         := buscaPercentual('premio_quina') * pPremio;
       gPremio_quadra        := buscaPercentual('premio_quadra') * pPremio;
       gAcumulado_proximo_05 := buscaPercentual('acumulado_05') * pPremio;
       gAcumulado_final_ano  := buscaPercentual('acumulado_final_ano') * pPremio;
  
    end defineRateioPremio;

  ---------------------------------------------------------------------------------------------------------------------------------------
  /* Salva o registro referente ao concurso */
  procedure salvaConcurso (pConcurso in integer,
                           pData     in date,
                           pPremio   in number) as
    begin

       defineRateioPremio(pPremio);
       
       --insereConcurso( pConcurso, pData, gPremio_Sena, gPremio_Quina, gPremio_Quadra, gAcumulado_proximo_05, gAcumulado_final_ano );
       
       Insert into Concurso 
           (Idconcurso, Data_Sorteio, Premio_Sena, Premio_Quina, Premio_Quadra, Acumulado_Proximo_05, Acumulado_Final_Ano)
       Values 
           (pConcurso, pData, gPremio_Sena, gPremio_Quina, gPremio_Quadra, gAcumulado_proximo_05, gAcumulado_final_ano);
    end salvaConcurso;
  ---------------------------------------------------------------------------------------------------------------------------------------
    /* Busca o id do último concurso (maior ID)*/
  function buscaMaiorId return number as
        -- 
        v_id  concurso.IdConcurso%type; 
      begin        
        -- busca id na tabela de concurso
        select IdConcurso
        into   v_id   -- atribuí valor para a variavel
        from   concurso
        where  rownum = 1
        Order By IdConcurso DESC;
        
        return v_id;
      exception
        when no_data_found then
          dbms_output.put_line('Erro ao encontrar maior IdConcurso de concurso');
          raise_application_error(-20002, sqlerrm);
      end buscaMaiorId;
  ---------------------------------------------------------------------------------------------------------------------------------------
    /* Verifica se há valor acumulado no último concurso*/
  function verificaSeAcumulou(pIdConcurso in number) return number as
        v_acumulou concurso.acumulou%type;
        begin
            select acumulou into v_acumulou 
            from concurso 
            where idconcurso = pIdConcurso;
            return v_acumulou;
        end verificaSeAcumulou;
  ---------------------------------------------------------------------------------------------------------------------------------------  
      /* Busca valor acumulado no último concurso*/
  function buscaValorAcumulado(pIdConcurso in number) return number as
        v_acumulou concurso.acumulado_proximo_05%type;
        begin
            select acumulado_proximo_05 into v_acumulou 
            from concurso 
            where idconcurso = pIdConcurso;
            return v_acumulou;
        end buscaValorAcumulado;
  --------------------------------------------------------------------------------------------------------------------------------------- 
    /* Busca valor arrecadado no último concurso*/
  function buscaValorArrecadado(pIdConcurso in number)return number as 
        v_valorArrecadado number;
        begin
            select sum(valor) into v_valorArrecadado
            from aposta
            where IdConcurso = pIdConcurso;
            
            v_valorArrecadado := v_valorArrecadado * 0.435;
            
            if(verificaSeAcumulou(pIdConcurso) != 0) then
                 v_valorArrecadado := v_valorArrecadado + buscaValorAcumulado(pIdConcurso);
            end if;
            
            return v_valorArrecadado;
        end buscaValorArrecadado;  
  ---------------------------------------------------------------------------------------------------------------------------------------
    /*
     Questão "A" - implementar rotina que irá inserir um novo concurso
    */
  procedure geraProximoConcurso as
   begin
      -- Chama procedure que inclui nas tabelas o novo concurso.
      salvaConcurso(buscaMaiorId+1, sysdate, buscaValorArrecadado(buscaMaiorId)); 
      
   end geraProximoConcurso;
  ---------------------------------------------------------------------------------------------------------------------------------------
    /*
     Questão "B" - implementar rotina que irá inserir todos os acertadores de um determinado concurso
    */
  procedure atualizaAcertadores (pConcurso in integer) as
        CURSOR c_apostasConcurso(pConcurso in number) is
            select IdAposta
            from aposta
            where IdConcurso = pConcurso;   
        ------------------------------------------------------------------------        
         CURSOR c_numero_Aposta (pIdAposta in number) is
            select IdNumero_Aposta, numero 
            from numero_aposta
            where IdAposta = pIdAposta;
        ------------------------------------------------------------------------        
         CURSOR c_tabelaPremiada (pConcurso in number) is
            select app.acertos as tipoAcerto, COUNT(1) as total
            from aposta_premiada app
            inner join aposta apo on app.IdAposta = apo.IdAposta
            where apo.IdConcurso = pConcurso
            group by app.acertos;
         ------------------------------------------------------------------------       
         CURSOR c_tabelaPremiadaAposta (pConcurso in number) is
            select app.IdAposta as IdAposta
            from aposta_premiada app
            inner join aposta apo on app.IdAposta = apo.IdAposta
            where apo.IdConcurso = pConcurso;   
        ------------------------------------------------------------------------    
        /* Valores dos Prêmios */
        vPremio NUMBER;
        vPremio_Sena NUMBER;
        vPremio_Quina NUMBER;
        vPremio_Quadra NUMBER;
        
        /* Valores das Dezenas */
        vPrimeira_Dezena NUMBER;
        vSegunda_Dezena NUMBER;
        vTerceira_Dezena NUMBER;
        vQuarta_Dezena NUMBER;
        vQuinta_Dezena NUMBER;
        vSexta_Dezena NUMBER;
        
        /* Apostas Premiadas */
        vIdAposta NUMBER;
        vAcertos NUMBER;
        vValor NUMBER;
                
        /* Verificação se Acumulou */
        vAcumulou NUMBER;
        
    begin
    -- limpa tabela aposta_premiada para passar nos testes
        delete aposta_premiada
        where EXISTS
            (select *
            from aposta_premiada app
            inner join aposta apo on app.IdAposta = apo.IdAposta
            where apo.IdConcurso = pConcurso);
        
        select Premio_Sena, Premio_Quina, Premio_Quadra, Primeira_Dezena, Segunda_Dezena, Terceira_Dezena, Quarta_Dezena, Quinta_Dezena, Sexta_Dezena
        into vPremio_Sena, vPremio_Quina, vPremio_Quadra, vPrimeira_Dezena, vSegunda_Dezena, vTerceira_Dezena, vQuarta_Dezena, vQuinta_Dezena, vSexta_Dezena
        from concurso 
        where IdConcurso = pConcurso;
     
        vAcumulou := 1;
      
        FOR apo in c_apostasConcurso(pConcurso) LOOP
            vAcertos := 0;
            FOR num in c_numero_aposta (apo.IdAposta) LOOP
                IF(num.numero = vPrimeira_Dezena) THEN 
                    vAcertos := vAcertos + 1;
                ELSIF(num.numero = vPrimeira_Dezena) THEN
                    vAcertos := vAcertos + 1;
                ELSIF(num.numero = vSegunda_Dezena) THEN
                    vAcertos := vAcertos + 1;
                ELSIF(num.numero = vTerceira_Dezena) THEN
                    vAcertos := vAcertos + 1;
                ELSIF(num.numero = vQuarta_Dezena) THEN
                    vAcertos := vAcertos + 1;
                ELSIF(num.numero = vQuinta_Dezena) THEN
                    vAcertos := vAcertos + 1;
                ELSIF(num.numero = vSexta_Dezena) THEN
                    vAcertos := vAcertos + 1;
                END IF;               
            END LOOP;

            IF(vAcertos = 6) THEN
                   insert into aposta_premiada (IdAposta, Acertos, Valor) values (apo.IdAposta, vAcertos, 0.0);
                   vAcumulou := 0;
                ELSIF(vAcertos = 5) THEN
                   insert into aposta_premiada (IdAposta, Acertos, Valor) values (apo.IdAposta, vAcertos, 0.0);
                ELSIF(vAcertos = 4) THEN
                   insert into aposta_premiada (IdAposta, Acertos, Valor) values (apo.IdAposta, vAcertos, 0.0);
            END IF;
        END LOOP;  

       FOR pre in c_tabelaPremiada(pConcurso) LOOP
            vPremio := 0;
            vValor := 0;
            
            IF(pre.tipoAcerto = 6) THEN 
                vPremio := vPremio_Sena;
            ELSIF(pre.tipoAcerto = 5) THEN
                vPremio := vPremio_Quina;
            ELSIF(pre.tipoAcerto = 4) THEN
                vPremio := vPremio_Quadra;
            END IF;

            vValor :=  vPremio / pre.total;

            FOR preAposta in c_tabelaPremiadaAposta(pConcurso) LOOP
                update aposta_premiada
                set valor = vValor
                where IdAposta = preAposta.IdAposta and acertos = pre.tipoAcerto;
            END LOOP;
            
            update concurso set acumulou = vAcumulou WHERE IdConcurso = pConcurso;            
              
        END LOOP;
   end atualizaAcertadores;
   
begin
  -- Initialization
  null; --<Statement>;
end pck_megasena;