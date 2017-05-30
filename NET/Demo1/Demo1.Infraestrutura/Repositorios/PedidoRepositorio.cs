using Demo1.Dominio.Entidades;
using System;
using System.Collections.Generic;
using System.Data.SqlClient;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Demo1.Infraestrutura.Repositorios
{
    public class PedidoRepositorio : IPedidoRepositorio
    {
        string stringConexao =
                        @"Server=13.65.101.67;
                        User Id=tais.silva;
                        Password=123456;
                        Database=aluno25db";

        public void Alterar(Pedido pedido)
        {
            using (var conexao = new SqlConnection(stringConexao))
            {
                conexao.Open();

                // Executa o UPDATE
                using (var comando = conexao.CreateCommand())
                {
                    comando.CommandText =
                        @"UPDATE PEDIDO SET NomeCliente = @nomeCliente, Itens = @itens WHERE Id = @id";

                    comando.Parameters.AddWithValue("@nomeCliente", pedido.NomeCliente);
                    comando.Parameters.AddWithValue("@itens", pedido.Itens);
                    comando.Parameters.AddWithValue("@id", pedido.Id);

                    // Executa o comando e 
                    // retorna somente a quantidade de linhas afetadas
                    comando.ExecuteNonQuery();
                }

                using (var comando = conexao.CreateCommand())
                {
                    // Executa o UPDATE o Estoque
                    foreach (ItemPedido item in pedido.Itens)
                    {
                        comando.CommandText =
                            @"UPDATE PRODUTO SET Estoque = @estoque WHERE Id = @id";

                        var estoqueProduto = "SELECT Estoque FROM Produto WHERE Id = item.ProcutoId";
                        var estoqueAtual = estoqueProduto - item.Quantidade;

                        comando.Parameters.AddWithValue("@estoque", estoqueAtual);
                        comando.Parameters.AddWithValue("@id", item.ProdutoId);

                        // Executa o comando e 
                        // retorna somente a quantidade de linhas afetadas
                        comando.ExecuteNonQuery();
                    }
                }     

            }   
            
        }

        public void Criar(Pedido pedido)
        {
            // realizar o insert do Pedido
            // obter o ultimo id do pedido (SELECT @@IDENTITY)

            // para cada item do pedido, realizar o insert do ItemPedido
            // obter o ultimo id do ItemPedido (SELECT @@IDENTITY)

            using (var conexao = new SqlConnection(stringConexao))
            {
                conexao.Open();

                // Executa o INSERT pedido
                using (var comando = conexao.CreateCommand())
                {
                    comando.CommandText =
                        @"INSERT INTO Pedido (NomeCliente, Itens) 
                        VALUES (@nomeCliente, @itens)";

                    comando.Parameters.AddWithValue("@nomeCliente", pedido.NomeCliente);
                    comando.Parameters.AddWithValue("@itens", pedido.Itens);

                    // Executa o comando e 
                    // retorna somente a quantidade de linhas afetads
                    comando.ExecuteNonQuery();
                }

                // Executa o INSERT de itens
                using (var comando = conexao.CreateCommand())
                {
                    foreach(ItemPedido item in pedido.Itens)
                    {
                    comando.CommandText =
                        @"INSERT INTO ItemPedido (ProdutoId, Quantidade) 
                        VALUES (@itensId, @quantidade)";

                    comando.Parameters.AddWithValue("@itemId", item.ProdutoId);
                    comando.Parameters.AddWithValue("@quantidade", item.Quantidade);

                    // Executa o comando e 
                    // retorna somente a quantidade de linhas afetads
                    comando.ExecuteNonQuery();
                    }
                }

                // Obtém o último ID criado
                using (var comando = conexao.CreateCommand())
                {
                    comando.CommandText = "SELECT @@IDENTITY";

                    // Executa o comando e retorna o primeiro resultado
                    var result = (decimal)comando.ExecuteScalar();
                    pedido.Id = (int)result;
                }


            }
        }

        public void Excluir(int id)
        {
            using (var conexao = new SqlConnection(stringConexao))
            {
                conexao.Open();

                // Executa o DELETE
                using (var comando = conexao.CreateCommand())
                {
                    comando.CommandText = @"DELETE Pedido WHERE Id = @id";

                    comando.Parameters.AddWithValue("@id", id);

                    // Executa o comando e 
                    // retorna somente a quantidade de linhas afetads
                    comando.ExecuteNonQuery();
                }
            }
        }

        public IEnumerable<Pedido> Listar()
        {
            var pedidos = new List<Produto>();

            using (var conexao = new SqlConnection(stringConexao))
            {
                conexao.Open();

                using (var comando = conexao.CreateCommand())
                {
                    comando.CommandText =
                        @"SELECT Id, NomeCliente, Itens FROM Pedido";

                    var dataReader = comando.ExecuteReader();
                    while (dataReader.Read())
                    {
                        var pedido = new Pedido();

                        pedido.Id = (int)dataReader["Id"];
                        pedido.NomeCliente = (string)dataReader["NomeCliente"];
                        pedido.Itens = (Array)dataReader["Itens"];

                        pedidos.Add(pedido);
                    }
                }
            }

            return pedidos;
        }

        public Pedido Obter(int id)
        {
            throw new NotImplementedException();
        }
    }
}
