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
                    foreach (var item in pedido.Itens)
                    {
                        comando.CommandText =
                            @"UPDATE PRODUTO SET Estoque = Estoque - @quantidade WHERE Id = @id";

                        comando.Parameters.AddWithValue("@quantidade", item.Quantidade);
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
                        @"INSERT INTO Pedido (NomeCliente) 
                        VALUES (@nomeCliente)";

                    comando.Parameters.AddWithValue("@nomeCliente", pedido.NomeCliente);

                    // Executa o comando e 
                    // retorna somente a quantidade de linhas afetads
                    comando.ExecuteNonQuery();
                }

                // Obtém o último ID criado
                using (var comando = conexao.CreateCommand())
                {
                    comando.CommandText = "SELECT @@IDENTITY";

                    // Executa o comando e retorna o primeiro resultado
                    var result = (decimal)comando.ExecuteScalar();
                    pedido.Id = (int)result;
                }

                // Executa o INSERT de itens
                using (var comando = conexao.CreateCommand())
                {
                    foreach (var item in pedido.Itens)
                    {
                        comando.CommandText =
                            @"INSERT INTO ItemPedido (PedidoId, ProdutoId, Quantidade) VALUES (@pedidoId, @produtoId, @quantidade)";

                        comando.Parameters.AddWithValue("@pedidoId", pedido.Id);
                        comando.Parameters.AddWithValue("@produtoId", item.ProdutoId);
                        comando.Parameters.AddWithValue("@quantidade", item.Quantidade);
                        comando.ExecuteNonQuery();
                    }


                }
            }
        }
        
        public void Excluir(int id)
        {
            using (var conexao = new SqlConnection(stringConexao))
            {
                conexao.Open();

                using (var comando = conexao.CreateCommand())
                {
                    comando.CommandText = "DELETE Pedido WHERE Id = @id";

                    comando.Parameters.AddWithValue("@id", id);

                    comando.ExecuteNonQuery();
                }
              
                // executa o delete
                using (var comando = conexao.CreateCommand())
                {
                    var pedidoItens = Obter(id);

                    foreach (var item in pedidoItens.Itens)
                    {
                        comando.CommandText =
                            @"update produto set Estoque = Estoque + @quantidade where id = @id";

                        comando.Parameters.AddWithValue("@quantidade", item.Quantidade);
                        comando.Parameters.AddWithValue("@id", item.ProdutoId);
                        
                        comando.ExecuteNonQuery();
                    }
                }
            }
        }

        public IEnumerable<Pedido> Listar()
        {
            var pedidos = new List<Pedido>();

            using (var conexao = new SqlConnection(stringConexao))
            {
                conexao.Open();

                using (var comando = conexao.CreateCommand())
                {                   
                    comando.CommandText =
                        @"SELECT Id, NomeCliente FROM Pedido";

                    var dataReader = comando.ExecuteReader();
                    while (dataReader.Read())
                    {
                        var pedido = new Pedido();
                        var idPedido = (int)dataReader["Id"];
                        var obterpedidos = Obter(idPedido);

                        //pedido.Id = (int)dataReader["Id"];
                        //pedido.NomeCliente = (string)dataReader["NomeCliente"];
                        //pedido.Itens = (Array)dataReader["Itens"];

                        pedidos.Add(obterpedidos);
                    }
                }
            }

            return pedidos;
        }

        public Pedido Obter(int id)
        {
            Pedido pedido = null;

            using (var conexao = new SqlConnection(stringConexao))
            {
                conexao.Open();

                using (var comando = conexao.CreateCommand())
                {
                    comando.CommandText =
                        "SELECT Id, NomeCliente FROM Pedido WHERE Id = @id";

                    comando.Parameters.AddWithValue("@id", id);

                    var dataReader = comando.ExecuteReader();
                    while (dataReader.Read())
                    {
                        pedido = new Pedido();
                        pedido.Id = (int)dataReader["Id"];
                        pedido.NomeCliente = (string)dataReader["NomeCliente"];
                        pedido.Itens = ObterItens((int)dataReader["Id"]);
                                                
                        return pedido;
                    }
                }
            }

            return pedido;
        }


        public List<ItemPedido> ObterItens(int id)
        {
            var itensLista = new List<ItemPedido>();

            using (var conexao = new SqlConnection(stringConexao))
            {
                conexao.Open();

                using (var comando = conexao.CreateCommand())
                {
                    comando.CommandText =
                         @"SELECT Id, ProdutoId, Quantidade FROM ItemPedido WHERE PedidoId = @id";

                    comando.Parameters.AddWithValue("@id", id);

                    var dataReader = comando.ExecuteReader();
                    while (dataReader.Read())
                    {
                        var itens = new ItemPedido();
                        itens.Id = (int)dataReader["Id"];
                        //itens.PedidoId = (int)dataReader["PedidoId"];
                        itens.ProdutoId = (int)dataReader["ProdutoId"];
                        itens.Quantidade = (int)dataReader["Quantidade"];

                        itensLista.Add(itens);
                    }
                }
            }

            return itensLista;
        }
    }
}
