using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace TaisSIlva
{
    public class FolhaPagamento : IFolhaPagamento
    {
        public Demonstrativo GerarDemonstrativo(int horasCategoria, double salarioBase, double horasExtras, double horasDescontadas)
        {
            double valorHora = arredondarValor(salarioBase / horasCategoria);
            double totalHorasExtras = arredondarValor(horasExtras * valorHora);
            double totalHorasDescontadas = arredondarValor(horasDescontadas * valorHora);
            double totalProventos = salarioBase + totalHorasExtras - totalHorasDescontadas;
            var totalDescontos = calcularIrrf(totalProventos).Valor + calcularInss(totalProventos).Valor;
            var salarioLiquido = arredondarValor(totalProventos - totalDescontos);
            var fgts = new Desconto(0.11, arredondarValor(salarioBase * 0.11));            

            return new Demonstrativo(salarioBase, horasCategoria, new HorasCalculadas(horasExtras, totalHorasExtras), new HorasCalculadas(horasDescontadas, totalHorasDescontadas), totalProventos, calcularInss(totalProventos), calcularIrrf(totalProventos), totalDescontos,
           salarioLiquido, fgts);

        }

        
        private double arredondarValor(double valor)
        {
            return Math.Truncate(valor * 100) / 100;
        }

        private Desconto calcularInss(double totalProventos)
        {
            var aliquota = 0.0;

            if (totalProventos <= 1000)
            {
                aliquota = 0.08;
            }
            else if (totalProventos <= 1500)
            {
                aliquota = 0.09;
            }
            else
            {
                aliquota = 0.1;
            }

            var inss = totalProventos * aliquota;
            return new Desconto(aliquota, arredondarValor(inss));
        }

        private Desconto calcularIrrf(double totalProventos)
        {
            var valorBase = (totalProventos - calcularInss(totalProventos).Valor);
            var aliquota = 0.0;

            if (valorBase <= 1710.78)
            {
                aliquota = 0.0;
            }
            else if(valorBase <= 2563.91)
            {
                aliquota = 0.075;
            }
            else if(valorBase <= 3418.59)
            {
                aliquota = 0.15;
            }
            else if(valorBase <= 4271.59)
            {
                aliquota = 0.225;
            }
            else
            {
                aliquota = 0.275;
            }

            var irrf = arredondarValor(valorBase * aliquota);
            return new Desconto(aliquota, irrf);

        }
    }
}

