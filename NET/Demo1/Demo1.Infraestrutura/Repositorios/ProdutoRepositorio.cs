using Demo1.Dominio.Entidades;
using System;
using System.Collections.Generic;
using System.Data.SqlClient;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Demo1.Infraestrutura.Repositorios
{
    public class ProdutoRepositorio
    { 
        // estrutra conexão com banco https://www.connectionstrings.com/sqlconnection/
            string stringConexao =
                "Server=13.65.101.67;User Id=tais.silva;Password=123456;Database=aluno25db";

        public void Criar(Produto produto)
        {
           //Toda conexão que acessa dados precisa ser fechado. Pode ser feito isso com using.
            using (var conexao = new SqlConnection(stringConexao))
            {
                conexao.Open();
                using (var comando = conexao.CreateCommand())
                {
                    comando.CommandText =
                        @"INSERT INTO Produto (Nome, Preco, Estoque)
                        VALUES (@nome, @preco, @estoque)";
                    comando.Parameters.AddWithValue("@nome", produto.Nome);
                    comando.Parameters.AddWithValue("@preco", produto.Preco);
                    comando.Parameters.AddWithValue("@estoque", produto.Estoque);

                    // Execute o comando e...
                    // retorna o somente a quantidade de linhas afetadas
                    comando.ExecuteNonQuery();

                    // lê o resultado de um select
                    //comando.ExecuteReader();

                    // executa o comando e retorna o primeiro resultado.
                    //comando.ExecuteScalar();
                }

                using (var comando = conexao.CreateCommand())
                {
                    comando.CommandText = "SELECT @@IDENTITY";

                    // Executa o comando e retorna o primeiro resultado
                    var result = (decimal)comando.ExecuteScalar();
                    produto.Id = (int)result;
                }
            }
        }

        public List<Produto> Listar()
        {
            var produtos = new List<Produto>();

            using (var conexao = new SqlConnection(stringConexao))
            {
                conexao.Open();

                using (var comando = conexao.CreateCommand())
                {
                    comando.CommandText =
                        "SELECT Id, Nome, Preco, Estoque FROM Produto";

                    var dataReader = comando.ExecuteReader();
                    while (dataReader.Read())
                    {
                        var produto = new Produto();

                        produto.Id = (int)dataReader["Id"];
                        produto.Nome = (string)dataReader["Nome"];
                        produto.Preco = (decimal)dataReader["Preco"];
                        produto.Estoque = (int)dataReader["Estoque"];

                        produtos.Add(produto);
                    }
                }
            }

            return produtos;
        }
    }
}
