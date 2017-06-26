<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <title>Pessoa</title>
    </head>

    <body>
        <div class="container">

        <% String title = "FORM PESSOA"; %>
        <h1><% out.println(title);%></h1>

            <h1 class="page-header">Pessoas</h1>
            <form>

                <div class="form-group">
                    <label class="sr-only" for="nome">Nome</label>
                    <input type="nome" name="nome" class="form-control" id="nome" placeholder="Nome da Pessoa">
                </div>

                <button type="submit" class="btn btn-primary">Submit</button>
            </form>

            <div id="table"></div>

        </div>

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script type="text/javascript">

            var findAll = function () {
                $.get('pessoa', function (data) {
                    $('#table').html(data);
                });
            }();

//            Caso o envio for feito por ajax.
            $('form').submit(function () {
                debugger;
                $.post('pessoa', $('form').serialize(), function (data) {
                    findAll();
                });
            });

        </script>

    </body>

</html>