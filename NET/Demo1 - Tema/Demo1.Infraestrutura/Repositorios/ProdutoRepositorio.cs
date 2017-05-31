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
        /*
         * https://www.connectionstrings.com/sqlconnection/
        * Server=myServerAddress;
        * Database=myDataBase;
        * User Id = myUsername;
        * Password=myPassword;
        */
        string stringConexao =
                        @"Server=13.65.101.67;
                        User Id=giovani;
                        Password=123456;
                        Database=aluno26db";

        public void Criar(Produto produto)
        {
            using (var conexao = new SqlConnection(stringConexao))
            {
                conexao.Open();

                // Executa o INSERT
                using (var comando = conexao.CreateCommand())
                {
                    comando.CommandText =
                        @"INSERT INTO Produto (Nome, Preco, Estoque) 
                        VALUES (@nome, @preco, @estoque)";

                    comando.Parameters.AddWithValue("@nome", produto.Nome);
                    comando.Parameters.AddWithValue("@preco", produto.Preco);
                    comando.Parameters.AddWithValue("@estoque", produto.Estoque);

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

        public void Alterar(Produto produto)
        {
            using (var conexao = new SqlConnection(stringConexao))
            {
                conexao.Open();

                // Executa o INSERT
                using (var comando = conexao.CreateCommand())
                {
                    comando.CommandText =
                        @"UPDATE PRODUTO SET Nome = @nome, Preco = @preco, Estoque = @estoque WHERE Id = @id";

                    comando.Parameters.AddWithValue("@nome", produto.Nome);
                    comando.Parameters.AddWithValue("@preco", produto.Preco);
                    comando.Parameters.AddWithValue("@estoque", produto.Estoque);
                    comando.Parameters.AddWithValue("@id", produto.Id);

                    // Executa o comando e 
                    // retorna somente a quantidade de linhas afetads
                    comando.ExecuteNonQuery();
                }
            }
        }

        public void Excluir(int id)
        {
            using (var conexao = new SqlConnection(stringConexao))
            {
                conexao.Open();

                // Executa o INSERT
                using (var comando = conexao.CreateCommand())
                {
                    comando.CommandText = "DELETE Produto WHERE Id = @id";

                    comando.Parameters.AddWithValue("@id", id);

                    // Executa o comando e 
                    // retorna somente a quantidade de linhas afetads
                    comando.ExecuteNonQuery();
                }
            }
        }

        public Produto Obter(int id)
        {
            Produto produto = null;

            using (var conexao = new SqlConnection(stringConexao))
            {
                conexao.Open();

                using (var comando = conexao.CreateCommand())
                {
                    comando.CommandText =
                        "SELECT Id, Nome, Preco, Estoque FROM Produto WHERE Id = @id";

                    comando.Parameters.AddWithValue("@id", id);

                    var dataReader = comando.ExecuteReader();
                    while (dataReader.Read())
                    {
                        produto = new Produto();
                        produto.Id = (int)dataReader["Id"];
                        produto.Nome = (string)dataReader["Nome"];
                        produto.Preco = (decimal)dataReader["Preco"];
                        produto.Estoque = (int)dataReader["Estoque"];
                        return produto;
                    }
                }
            }

            return produto;
        }
    }
}
