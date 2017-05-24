using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Demo1
{
    class Programa
    {
        static void Main(string[] args)
        {
            //public const double 
            //int valorPodeSerNull = null;
            //Pessoa pessoa = new Pessoa();
            //pessoa.Id = null;
            //pessoa.Nascimento = new DateTime(1982, 10, 29);
            //pessoa.Nome = $"Giovani Decusati {pessoa.Id}";
            ////if (pessoa.Id.HasValue)
            //Console.WriteLine(pessoa.Nome);
            bool continua = true;
            var entradas = new int[] { };
            Console.WriteLine("Digite um valor:");

            while (continua)
            {
                var entrada = Console.ReadLine();
                if (entrada == "exist")
                {
                    break;
                }

                var nEntradas = entradas.Length;

                var novaEntrada = new int[nEntradas.Length + 1];                

                for (int i = 0; i < novaEntrada.Length; i++)
                {
                    novaEntrada[i] = entradas[i];
                }

                novaEntrada[nEntradas] = int.Parse(entrada);

                entradas = novaEntrada;
            }
            Console.ReadKey();
        }
    }
}
