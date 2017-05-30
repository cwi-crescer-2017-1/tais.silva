using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Demo1.Dominio.Entidades
{
    public class Pedido
    {
        public int Id { get; set; }
        public string NomeCliente { get; set; }
        public List<ItemPedido> Itens { get; set; }

        public bool Validar(out List<string> mensagens)
        {
            mensagens = new List<string>();

            if (Estoque < 1)
                mensagens.Add("Estoque deve ser maior que zero.");

            if (Preco < 0.01M)
                mensagens.Add("Preço deve ser maior que zero.");

            if (string.IsNullOrWhiteSpace(Nome))
                mensagens.Add("Nome deve ser informado.");

            return mensagens.Count() == 0;
        }
    }
}
