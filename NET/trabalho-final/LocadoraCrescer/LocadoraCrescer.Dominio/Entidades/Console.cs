﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LocadoraCrescer.Dominio.Entidades
{
    public class Console
    {
        public int Id { get; set; }
        public string Nome { get; set; }
        public decimal Decimal { get; set; }
        public int Quantidade { get; set; }

        public Console()
        { }
    }
}
