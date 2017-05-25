using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace TaisSIlva
{
    class FolhaPagamento : IFolhaPagamento
    {
        public Demonstrativo GerarDemonstrativo(int horasCategoria, double salarioBase, double horasExtras, double horasDescontadas)
        {
            double valorHora = salarioBase / horasCategoria;
            double totalHorasExtras = horasExtras * valorHora;
            double totalHorasDescontadas = horasDescontadas * valorHora;
            double totalProventos = salarioBase + totalHorasExtras - totalHorasDescontadas;
            var TotalDescontos = calcularIrrf(totalProventos).Valor + calcularInss(totalProventos).Valor;
            var salarioLiquido = totalProventos - totalDescontos;
            var salarioLiquido = totalProventos - totalDescontos;
            var fgts = new Desconto(0.11, salarioBase * 0.11);


        private double arredondarValor(double valor)
        {
            return Math.round(valor, 2);
        }

        private Desconto calcularInss(double totalProventos)
        {
            var aliquota = 0.0;

            if (totalProventos <= 1000)
            {
                aliquota = 0.08;
            }
            if (totalProventos <= 1500)
            {
                aliquota = 0.09;
            }
            else
            {
                aliquota = 0.10;
            }

            var inss = totalProventos * aliquota;
            arredondarValor(inss);
            return new Desconto(aliquota, inss);
        }
                    
            private Desconto calcularIRRF(double totalProventos)
        {
            var aliquota = 0.0;

            if (totalProventos <= 1710.78)
            {
                aliquota = 0.0;
            }if(totalProventos <= 2563.91)
            {
                aliquota = 0.075;
            }if (totalProventos <= 3418.59)
            {
                aliquota = 0.15;
            }if (totalProventos <= 4271.59)
            {
                aliquota = 0.225;
            }
            else
            {
                aliquota = 0.275;
            }

            var irrf = totalProventos - inss * aliquota;
            arredondarValor(irrf);
            return new Desconto(aliquota, irrf);

    }    
            return new Demonstrativo(salarioBase, horasCategoria, new HorasCalculadas(horasExtras, valorHorasExtras), new HorasCalculadas(horasDescontadas, valorHora), totalProventos, inss, calcularIrrf(valorProventos), totalDescontos,
            double totalLiquido, Desconto fgts) );
            // throw new NotImplementedException();
    }
}
}
