-- Liste os estados com maior número de apostas, e maior valor arrecadado em cada concurso.
-- Adicionalmente também deve ser exibido o total de acertadores e o valor da premiação em cada estado.

-- As ufs com mais apostas
CREATE OR REPLACE VIEW vwTop_Uf_Apostas AS
    select cid.Uf
    from aposta apo
    inner join cidade cid on apo.IDCIDADE = cid.IDCIDADE
    group by cid.UF
    order by count(1) desc;
 
--    
CREATE OR REPLACE VIEW vwTop_Uf_Arrecadado AS
    select cid.Uf
    from aposta apo
    inner join cidade cid on apo.IDCIDADE = cid.IDCIDADE
    group by cid.UF
    order by count(1) desc;

select * from vwTop_uf