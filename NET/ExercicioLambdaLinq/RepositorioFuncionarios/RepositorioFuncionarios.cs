using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Dynamic;
using System.Globalization;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;

namespace Repositorio
{
    public class RepositorioFuncionarios
    {
        public List<Funcionario> Funcionarios { get; private set; }
        
        public RepositorioFuncionarios()
        {
            CriarBase();
        }

        private void CriarBase()
        {
            Funcionarios = new List<Funcionario>();

            Cargo desenvolvedor1 = new Cargo("Desenvolvedor Júnior", 190);
            Cargo desenvolvedor2 = new Cargo("Desenvolvedor Pleno", 250);
            Cargo desenvolvedor3 = new Cargo("Desenvolvedor Sênior", 550.5);

            Funcionario lucasLeal = new Funcionario(1, "Marcelinho Carioca", new DateTime(1995, 01, 24));
            lucasLeal.Cargo = desenvolvedor1;
            lucasLeal.TurnoTrabalho = TurnoTrabalho.Manha;
            Funcionarios.Add(lucasLeal);

            Funcionario jeanPinzon = new Funcionario(2, "Mark Zuckerberg", new DateTime(1991, 04, 25));
            jeanPinzon.Cargo = desenvolvedor1;
            jeanPinzon.TurnoTrabalho = TurnoTrabalho.Tarde;
            Funcionarios.Add(jeanPinzon);

            Funcionario rafaelBenetti = new Funcionario(3, "Aioros de Sagitário", new DateTime(1991, 08, 15));
            rafaelBenetti.Cargo = desenvolvedor1;
            rafaelBenetti.TurnoTrabalho = TurnoTrabalho.Noite;
            Funcionarios.Add(rafaelBenetti);

            Funcionario mauricioBorges = new Funcionario(4, "Uchiha Madara", new DateTime(1996, 11, 30));
            mauricioBorges.Cargo = desenvolvedor1;
            mauricioBorges.TurnoTrabalho = TurnoTrabalho.Manha;
            Funcionarios.Add(mauricioBorges);

            Funcionario leandroAndreolli = new Funcionario(5, "Barack Obama", new DateTime(1990, 03, 07));
            leandroAndreolli.Cargo = desenvolvedor1;
            leandroAndreolli.TurnoTrabalho = TurnoTrabalho.Manha;
            Funcionarios.Add(leandroAndreolli);

            Funcionario felipeNervo = new Funcionario(6, "Whindersson  Nunes", new DateTime(1994, 01, 12));
            felipeNervo.Cargo = desenvolvedor1;
            felipeNervo.TurnoTrabalho = TurnoTrabalho.Tarde;
            Funcionarios.Add(felipeNervo);

            Funcionario lucasKauer = new Funcionario(7, "Optimus Prime", new DateTime(1997, 05, 10));
            lucasKauer.Cargo = desenvolvedor1;
            lucasKauer.TurnoTrabalho = TurnoTrabalho.Noite;
            Funcionarios.Add(lucasKauer);

            Funcionario eduardoArnold = new Funcionario(8, "Arnold Schwarzenegger", new DateTime(1989, 09, 16));
            eduardoArnold.Cargo = desenvolvedor1;
            eduardoArnold.TurnoTrabalho = TurnoTrabalho.Tarde;
            Funcionarios.Add(eduardoArnold);

            Funcionario gabrielAlboy = new Funcionario(9, "Bill Gates", new DateTime(1990, 02, 25));
            gabrielAlboy.Cargo = desenvolvedor2;
            gabrielAlboy.TurnoTrabalho = TurnoTrabalho.Manha;
            Funcionarios.Add(gabrielAlboy);

            Funcionario carlosHenrique = new Funcionario(10, "Linus Torvalds", new DateTime(1965, 12, 02));
            carlosHenrique.Cargo = desenvolvedor2;
            carlosHenrique.TurnoTrabalho = TurnoTrabalho.Tarde;
            Funcionarios.Add(carlosHenrique);

            Funcionario margareteRicardo = new Funcionario(11, "Dollynho Developer", new DateTime(1980, 10, 10));
            margareteRicardo.Cargo = desenvolvedor3;
            margareteRicardo.TurnoTrabalho = TurnoTrabalho.Manha;
            Funcionarios.Add(margareteRicardo);
        }

        public IList<Funcionario> BuscarPorCargo(Cargo cargo)
        {
            var funcionariosDesseCargo = 
                Funcionarios
                .Where(f => f.Cargo.Equals(cargo))
                .ToList();
            return funcionariosDesseCargo;
        }

        public IList<Funcionario> OrdenadosPorCargo()
        {   
            var funcionariosOrdenosPorCargo =
                Funcionarios
                .OrderBy(f => f.Cargo.Titulo)
                .ThenBy(f => f.funcionario.Nome)
                .ToList(); 
            return funcionariosOrdenosPorCargo;
        }

        public IList<Funcionario> BuscarPorNome(string nome)
        {   
            Regex padraoNome = new Regex(nome, RegexOptions.IgnoreCase | RegexOptions.CultureInvariant);
            var funcionariosComEsseNome =
                Funcionarios
                .Where(f => padraoNome.IsMatch(f.Funcionario.Nome));
            return funcionariosComEsseNome;
        }        

        public IList<Funcionario> BuscarPorTurno(params TurnoTrabalho[] turnos)
        {   
            var funcionariosDesseTurno =
                Funcionarios
                .Where(f => f.TurnoTrabalho.Contains(turnos))
                .ToList();
            return funcionariosDesseTurno ? funcionariosDesseTurno : Funcionarios;
        }        

        public IList<Funcionario> FiltrarPorIdadeAproximada(int idade)
        {   
            int idadeMenos5 = idade - 5;
            int idadeMais5 = idade + 5;
            var funcionariosFaixaEtaria = 
                Funcionarios
                .Where(f => calcularIdade(f.DataNascimento) > idadeMenos5 && calcularIdade(f.DataNascimento) < idadeMais5) 
                .ToList();
            return funcionariosFaixaEtaria;
        }

        private int CalcularIdade(DateTime dataNascimento)
        {
            var hoje = new DateTime.Now;
            int idade = hoje.Year - dataNascimento.Year;
            var compararMes = hoje.Month > dataNascimento.Month;
			var compararDia = hoje.Month == dataNascimento.Month 
				&& hoje.Day > dataNascimento.Day;
            return idadecompararDia || compararMes ? idade-1: idade;;
        }

        public double SalarioMedio(TurnoTrabalho? turno = null)
        {   
            var salarioMedio = Funcionarios;
			
            if(!turno.Equals(null))
            {
               salarioMedio = 
                    salarioMedio
                    .Where(f => f.TurnoTrabalho.Equals(turno));
			}       
            return salarioMedio.Average(f => f.Cargo.Salario);
        }

        public IList<Funcionario> AniversariantesDoMes()
        {
            var dataAtual = new DateTime.Now;
            var aniversariantesDoMesAtual =
                Funcionarios
                .Where(f => f.DataNascimento.Month.Equals(dataAtual.Month))
                .ToList();

            return aniversariantesDoMesAtual;
        }

        public IList<dynamic> BuscaRapida()
        {   
            var listaDeTodosFuncionarios = 
                Funcionarios
                .Select(f => (dynamic) new { 
                NomeFuncionario = f.Nome,
                TituloCargo = f.Cargo.Titulo
                })
                .ToList();

            return listaDeTodosFuncionarios;
        }

        public IList<dynamic> QuantidadeFuncionariosPorTurno()
        {   
            var turnos = [TurnoTrabalho.Manha, TurnoTrabalho.Tarde, TurnoTrabalho.Noite];
            var listaDeTodosFuncionarios;
            foreach (TurnoTrabalho turno in turnos) {
            var lista = 
             Funcionarios 
            .Where(f => f.TurnoTrabalho.Equals(turno))
            .Select(f => (dynamic) new { 
                Turno = turno,
                Quantidade = f.Count()
                })
                .ToList();
                listaDeTodosFuncionarios.Add(lista)
            }

            return listaDeTodosFuncionarios;
        }

        public dynamic FuncionarioMaisComplexo()
        {
            throw new NotImplementedException();
        }
    }
}
