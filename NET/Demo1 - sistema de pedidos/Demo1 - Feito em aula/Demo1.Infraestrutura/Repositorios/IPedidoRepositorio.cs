using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Demo1.Dominio.Entidades;

namespace Demo1.Infraestrutura.Repositorios
{
    public interface IPedidoRepositorio
    {
        void Alterar(Pedido pedido);
        void Criar(Pedido pedido);
        void Excluir(int id);
        IEnumerable<Pedido> Listar();
        Pedido Obter(int id);
    }
}
