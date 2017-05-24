using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Demo1
{
    public class Pessoa
    {
        public const double PI = 3.14;
        public readonly double PIreadonly = 3.14;

        /*internal 
        private 
        protected 
        readonly*/

        public string Nome { get; set; }
        public int? Id { get; set; }

        public DateTime Nascimento { get; set; }
    }
}
