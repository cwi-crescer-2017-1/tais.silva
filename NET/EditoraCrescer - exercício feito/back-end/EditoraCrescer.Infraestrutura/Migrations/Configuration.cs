﻿namespace EditoraCrescer.Infraestrutura.Migrations
{
    using EditoraCrescer.Dominio.Entidades;
    using EditoraCrescer.Infraestrutura.Entidades;
    using System;
    using System.Collections.Generic;
    using System.Data.Entity;
    using System.Data.Entity.Migrations;
    using System.Linq;

    internal sealed class Configuration : DbMigrationsConfiguration<EditoraCrescer.Infraestrutura.Contexto>
    {
        public Configuration()
        {
            AutomaticMigrationsEnabled = false;
        }

        protected override void Seed(EditoraCrescer.Infraestrutura.Contexto context)
        {
            //  This method will be called after migrating to the latest version.

            //  You can use the DbSet<T>.AddOrUpdate() helper extension method 
            //  to avoid creating duplicate seed data. E.g.
            //
            //    context.People.AddOrUpdate(
            //      p => p.FullName,
            //      new Person { FullName = "Andrew Peters" },
            //      new Person { FullName = "Brice Lambson" },
            //      new Person { FullName = "Rowan Miller" }
            //    );
            //
            //Adiciona Permissões
            var permissao1 = new Permissao() { Nome = "Contribuidor" };
            var permissao2 = new Permissao() { Nome = "Revisor" };
            var permissao3 = new Permissao() { Nome = "Publicador" };

            context.Permissao.AddOrUpdate(permissao1, permissao2, permissao3);

            //Adiciona Usuários
            var usuario1 = new Usuario("Tais Jaques", "tais.silva@cwi.com.br", "123456", new List<Permissao>() { permissao1, permissao2, permissao3 });
            var usuario2 = new Usuario("Lu R.", "jaquestais@gmail.com", "123456", new List<Permissao>() { permissao1, permissao2 });
            var usuario3 = new Usuario("Tiago R.", "tfuelber@gmail.com", "123456", new List<Permissao>() { permissao1, permissao2 });
            var usuario4 = new Usuario("Tais P.", "taiscomunic@gmail.com", "123456", new List<Permissao>() { permissao1, permissao3 });

            context.Usuario.AddOrUpdate(usuario1, usuario2, usuario3, usuario4);

            //Adiciona Autores
            var autor1 = new Autor() { Nome = "Ludwig Von Mises" };
            var autor2 = new Autor() { Nome = "Augusto Comte" };
            var autor3 = new Autor() { Nome = "George R. R. Martin" };
            var autor4 = new Autor() { Nome = "Rodrigo Constantino" };
            var autor5 = new Autor() { Nome = "Jennifer L. Armentrout" };
            var autor6 = new Autor() { Nome = "Neil Gailman" };
            var autor7 = new Autor() { Nome = "Sara Shepard" };
            var autor8 = new Autor() { Nome = "Carlos Ruiz Zafón" };
            var autor9 = new Autor() { Nome = "Marie Kondo" };
            var autor10 = new Autor() { Nome = "Victor Hugo" };
            var autor11 = new Autor() { Nome = "Fiona Barton" };
            var autor12 = new Autor() { Nome = "Donna Leon" };
            var autor13 = new Autor() { Nome = "J. R. R. Tolkien" };
            var autor14 = new Autor() { Nome = "John Darwin" };
            var autor15 = new Autor() { Nome = "Gayle Forman" };
            var autor16 = new Autor() { Nome = "Jean Paul Sartre" };
            var autor17 = new Autor() { Nome = "J. R. Ward" };
            var autor18 = new Autor() { Nome = "Harlan Coben" };
            var autor19 = new Autor() { Nome = "Allan Percy" };
            var autor20 = new Autor() { Nome = "Clovis Brigagão" };

            context.Autores.AddOrUpdate(a => a.Nome, autor1, autor2, autor3, autor4, autor5, autor6, autor7, autor8, autor9, autor10, autor11, autor12, autor13, autor14, autor15, autor16, autor17, autor18, autor19, autor20);

            //Adiciona Livros
            var livro1 = new Livro()
            {
                Titulo = "Libertarianismo",
                Descricao = "Livro sobre economia e fliosofia liberal",
                Genero = "Economia e Filosofia",
                DataPublicacao = new DateTime(1968, 10, 04),
                Capa = "http://cdn.mises.org.br/images/ebooks_thumbs/44.png",
                Autor = autor1,
                Revisor = usuario1,
                DataRevisao = new DateTime(2010, 10, 10)
            };

            var livro2 = new Livro()
            {
                Titulo = "Os Pensadores",
                Descricao = "Livro sobre filosofia positiva",
                Genero = "Filosofia",
                DataPublicacao = new DateTime(1978, 11, 04),
                Capa = "http://lelivros.love/wp-content/uploads/2017/05/Baixar-Livro-Auguste-Comte-Os-Pensadores-em-Pdf-ePub-e-Mobi-ou-ler-online-370x470.jpg",
                Autor = autor2,
                Revisor = usuario1,
                DataRevisao = new DateTime(2012, 12, 01)
            };

            var livro3 = new Livro()
            {
                Titulo = "A mão do homem morto",
                Descricao = "Os super,heróis mais poderosos e os vilões mais bizarros estão de volta nos novos volumes da saga de ficção científica de George R.R. Martin",
                Genero = "Ficção",
                DataPublicacao = new DateTime(2015, 10, 04),
                Capa = "http://lelivros.love/wp-content/uploads/2017/04/Baixar-Livro-A-Mao-do-Homem-Morto-Wild-Cards-Vol-07-George-R.-R.-Martin-em-Pdf-Epub-e-Mobi-Ou-Ler-Onine-370x509.jpg",
                Autor = autor3,
                Revisor = usuario1,
                DataRevisao = new DateTime(2011, 01, 10)
            };

            var livro4 = new Livro()
            {
                Titulo = "Economia do indivíduo",
                Descricao = "São 223 páginas que sintetizam anos e anos de estudos e análises do comportamento humano, da economia e das relações entre os indivíduos.",
                Genero = "Economia",
                DataPublicacao = new DateTime(1975, 10, 04),
                Capa = "http://lelivros.love/wp-content/uploads/2014/02/Download-Economia-do-Individuo-Rodrigo-Constantino-em-epub-mobi-e-pdf-370x552.jpg",
                Autor = autor4,
                Revisor = usuario1,
                DataRevisao = new DateTime(2013, 07, 15)
            };

            var livro5 = new Livro()
            {
                Titulo = "Espero por você",
                Descricao = "Algumas coisas valem a pena esperar. Algumas coisas valem a pena experimentar. Algumas coisas não devem ser mantidas em silêncio. E, por algumas coisas, vale a pena lutar. Avery Morgansten precisa fugir. Ir para uma faculdade a centenas de quilômetros de casa foi a única forma que encontrou para esquecer o acontecimento fatídico que, cinco anos antes, mudara a sua vida para sempre. ",
                Genero = "Romance",
                DataPublicacao = new DateTime(2010, 10, 04),
                Capa = "http://lelivros.love/wp-content/uploads/2017/03/Baixar-Livro-Espero-por-Voce-Jennifer-L.-Armentrout-em-PDF-ePub-e-Mobi-ou-ler-online-370x532.jpg",
                Autor = autor5,
                Revisor = usuario1,
                DataRevisao = new DateTime(2014, 10, 05)
            };

            var livro6 = new Livro()
            {
                Titulo = "A roda da eternidade",
                Descricao = "Joey Harker nunca quis ser um líder, mas o destino o levou a se tornar um. E agora é sua responsabilidade evitar o fim do Entremundos, do Multiverso e tudo mais que existe em A roda da eternidade, a eletrizante conclusão da série Entremundos, imaginada por ninguém menos que Neil Gaiman, e escrita pelo premiado autor Michael Reaves e por sua filha Mallory Reaves. Desde que descobriu ser um Andarilho, capaz de se deslocar entre as dimensões, Joey acreditava ter encontrado seu lugar como um agente do Entremundos (organização responsável por manter a paz nos vários universos e dimensões).",
                Genero = "Ficção Filosofia",
                DataPublicacao = new DateTime(1968, 10, 04),
                Capa = "http://lelivros.love/wp-content/uploads/2017/04/Baixar-Livro-A-Roda-da-Eternidade-Entre-Mundos-Vol-03-Neil-Gaiman-em-Pdf-ePub-e-Mobi-ou-ler-online-370x552.jpg",
                Autor = autor6,
                Revisor = usuario2,
                DataRevisao = new DateTime(2014, 02, 12)
            };

            var livro7 = new Livro()
            {
                Titulo = "Eu nunca... The lying game",
                Descricao = "Autora da bem,sucedida série Pretty Little Liars, Sara Shepard mostra que sabe mesmo prender a atenção dos adolescentes com histórias que mostram o lado obscuro de garotas bonitas e cheias de segredos.",
                Genero = "Adolescente",
                DataPublicacao = new DateTime(2016, 10, 04),
                Capa = "http://lelivros.love/wp-content/uploads/2017/03/Baixar-Livro-Eu-Nunca...-The-Lying-Game-Vol-02-Sara-Shepard-em-Pdf-ePub-e-Mobi-ou-ler-online-370x574.jpg",
                Autor = autor7,
                Revisor = usuario2,
                DataRevisao = new DateTime(2010, 10, 19)
            };

            var livro8 = new Livro()
            {
                Titulo = "O Prisioneiro do Céu",
                Descricao = "Barcelona, 1957. Daniel Sempere e seu amigo Fermín, os heróis de A sombra do vento, estão de volta à aventura para enfrentar o maior desafio de suas vidas.",
                Genero = "Romance",
                DataPublicacao = new DateTime(1971, 10, 04),
                Capa = "http://lelivros.love/wp-content/uploads/2016/11/Baixar-Livro-O-Prisioneiro-do-Ceu-Carlos-Ruiz-Zafon-em-PDF-ePub-e-Mobi-ou-ler-online-370x532.jpg",
                Autor = autor8,
                Revisor = usuario2,
                DataRevisao = new DateTime(2010, 03, 23)
            };

            var livro9 = new Livro()
            {
                Titulo = "A Mágica da Arrumação",
                Descricao = "A mágica da arrumação se tornou um fenômeno mundial por apresentar uma abordagem inovadora para acabar de vez com a bagunça. ",
                Genero = "Desenvolvimento pessoal",
                DataPublicacao = new DateTime(2005, 10, 04),
                Capa = "http://lelivros.love/wp-content/uploads/2016/09/Baixar-Livro-A-Magica-da-Arrumacao-Marie-Kondo-em-PDF-ePub-e-Mobi-ou-ler-online-370x556.jpg",
                Autor = autor9,
                Revisor = usuario2,
                DataRevisao = new DateTime(2010, 12, 25)
            };

            var livro10 = new Livro()
            {
                Titulo = "O último dia de um condenado",
                Descricao = "Em um romance de surpreendente modernidade, o grande escritor do romantismo se joga de corpo e alma contra a pena de morte. ",
                Genero = "Romance",
                DataPublicacao = new DateTime(1905, 10, 4),
                Capa = "http://lelivros.love/wp-content/uploads/2016/09/Baixar-Livro-O-Ultimo-dia-de-um-Condenado-Victor-Hugo-em-PDF-ePub-e-Mobi-ou-ler-online-370x525.jpg",
                Autor = autor10,
                Revisor = usuario2,
                DataRevisao = new DateTime(2011, 08, 18)
            };

            var livro11 = new Livro()
            {
                Titulo = "A viúva",
                Descricao = "Ao longo dos anos, Jean Taylor deixou de contar muitas coisas sobre o terrível crime que o marido era suspeito de ter cometido.",
                Genero = "Romance",
                DataPublicacao = new DateTime(1999, 10, 04),
                Capa = "http://lelivros.love/wp-content/uploads/2017/02/Baixar-Livro-A-Viuva-Fiona-Barton-em-Pdf-ePub-e-Mobi-ou-ler-online-370x549.jpg",
                Autor = autor11,
                Revisor = usuario3,
                DataRevisao = new DateTime(2010, 09, 27)
            };

            var livro12 = new Livro()
            {
                Titulo = "O fardo da nobreza",
                Descricao = "No sétimo volume da premiada série de Donna Leon",
                Genero = "Ficção",
                DataPublicacao = new DateTime(1968, 10, 04),
                Capa = "http://lelivros.love/wp-content/uploads/2017/05/Baixar-Livro-O-Fardo-da-Nobreza-Donna-Leon-em-Pdf-ePub-e-Mobi-ou-ler-online-360x574.jpg",
                Autor = autor12,
                Revisor = usuario3,
                DataRevisao = new DateTime(2010, 08, 29)
            };

            var livro13 = new Livro()
            {
                Titulo = "A história de kullervo",
                Descricao = "Kullervo, filho de Kalervo, é talvez o mais sombrio e trágico de todos os personagens de J.R.R. Tolkien.",
                Genero = "Ficção",
                DataPublicacao = new DateTime(1965, 10, 04),
                Capa = "http://lelivros.love/wp-content/uploads/2017/03/Baixar-Livro-A-Historia-de-Kullervo-J.R.R.-Tolkien-em-Epub-Mobi-e-Pdf-ou-ler-Online-364x574.jpg",
                Autor = autor13,
                Revisor = usuario3,
                DataRevisao = new DateTime(2010, 10, 31)
            };

            var livro14 = new Livro()
            {
                Titulo = "Ascensão e Queda dos Impérios Globais. 1400-2000",
                Descricao = "Tamerlão, os Otomanos, Os Mogóis, os Manchus, os Britânicos, os Soviéticos e os nazis, todos construíram impérios concebidos para durarem para sempre",
                Genero = "Sociologia e história",
                DataPublicacao = new DateTime(2009, 10, 04),
                Capa = "http://lelivros.love/wp-content/uploads/2017/05/Baixar-Livro-Ascensão-e-Queda-dos-Impérios-Globais.1400-2000-John-Darwin-em-Pdf-ePub-e-Mobi-ou-ler-online-370x542.jpg",
                Autor = autor14,
                Revisor = usuario3,
                DataRevisao = new DateTime(2010, 10, 10)
            };

            var livro15 = new Livro()
            {
                Titulo = "Eu estive aqui",
                Descricao = "Quando sua melhor amiga, Meg, toma um frasco de veneno sozinha num quarto de motel, Cody fica chocada e arrasada.",
                Genero = "Romance",
                DataPublicacao = new DateTime(1968, 10, 04),
                Capa = "http://lelivros.love/wp-content/uploads/2015/06/Baixar-Livro-Eu-Estive-Aqui-Gayle-Forman-em-PDF-ePub-e-Mobi-370x532.jpg",
                Autor = autor15,
                Revisor = usuario3,
                DataRevisao = new DateTime(2010, 10, 11)
            };

            var livro16 = new Livro()
            {
                Titulo = "A Náusea",
                Descricao = "Publicado originalmente em 1938, é o primeiro romance de Sartre.",
                Genero = "Romance",
                DataPublicacao = new DateTime(2017, 06, 02),
                Capa = "http://lelivros.love/wp-content/uploads/2017/05/A-Nausea-370x566.jpg",
                Autor = autor16,
                Revisor = usuario1,
                DataRevisao = new DateTime(2017, 06, 03)
            };

            var livro17 = new Livro()
            {
                Titulo = "Os Reis Do Bourbon",
                Descricao = "Por gerações, a família Bradford foi coroada como magnata da capital mundial da produção de bourbon, no Estado norte,americano de Kentucky",
                Genero = "Romance",
                DataPublicacao = new DateTime(2017, 06, 01),
                Capa = "http://lelivros.love/wp-content/uploads/2017/04/Baixar-Livro-Os-Reis-Do-Bourbon-Os-Reis-do-Bourbon-Vol-01-J.-R.-Ward-em-Pdf-ePub-e-Mobi-ou-ler-online-370x543.jpg",
                Autor = autor17,
                Revisor = usuario2,
                DataRevisao = new DateTime(2017, 06, 02)
            };

            var livro18 = new Livro()
            {
                Titulo = "O Medo Mais Profundo",
                Descricao = "Na época da faculdade, Myron Bolitar teve seu primeiro relacionamento sério, que terminou de forma dolorosa quando a namorada o trocou por seu maior adversário no basquete. ",
                Genero = "Romance",
                DataPublicacao = new DateTime(2017, 06, 02),
                Capa = "http://lelivros.love/wp-content/uploads/2016/09/Baixar-Livro-O-Medo-Mais-Profundo-Myron-Bolitar-Vol-07-Harlan-Coben-em-PDF-ePub-e-Mobi-ou-ler-online-370x532.jpg",
                Autor = autor18,
                Revisor = usuario3,
                DataRevisao = new DateTime(2017, 06, 03)
            };

            var livro19 = new Livro()
            {
                Titulo = "Einstein Para Distraídos",
                Descricao = "Einstein para distraídos é um livro inspirador, dedicado a todas as pessoas que buscam relativizar preocupações, resolver problemas e encontrar a fórmula mais simples e poderosa para uma vida plena.",
                Genero = "Desenvolvimento Pessoal",
                DataPublicacao = new DateTime(2017, 06, 02),
                Capa = "http://lelivros.love/wp-content/uploads/2017/03/Baixar-Livro-Einstein-Para-Distra%C3%ADdos-Allan-Percy-em-Epub-Mobi-e-Pdf-ou-ler-Online-370x563.jpg",
                Autor = autor19,
                Revisor = usuario1,
                DataRevisao = new DateTime(2017, 06, 02)
            };

            var livro20 = new Livro()
            {
                Titulo = "Brizola",
                Descricao = "Quando sua melhor amiga, Meg, toma um frasco de veneno sozinha num quarto de motel, Cody fica chocada e arrasada.",
                Genero = "História",
                DataPublicacao = new DateTime(2017, 06, 01),
                Capa = "http://lelivros.love/wp-content/uploads/2015/07/Baixar-Livro-Brizola-Clovis-Brigagao-em-PDF-ePub-e-Mobi-370x544.jpg",
                Autor = autor20,
                Revisor = usuario3,
                DataRevisao = new DateTime(2017, 06, 01)
            };

            context.Livros.AddOrUpdate(a => a.Titulo, livro1, livro2, livro3, livro4, livro5, livro6, livro7, livro8, livro9, livro10, livro11, livro12, livro13, livro14, livro15, livro16, livro17, livro18, livro19, livro20);
        }
    }
}
