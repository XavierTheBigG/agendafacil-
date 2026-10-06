<?php

$servicos = [

    [
        "id" => 1,
        "nome" => "Corte de cabelo",
        "preco" => "R$ 35,00"
    ],

    [
        "id" => 2,
        "nome" => "Barba",
        "preco" => "R$ 25,00"
    ],

    [
        "id" => 3,
        "nome" => "Corte + Barba",
        "preco" => "R$ 50,00"
    ]

];

?>

<!DOCTYPE html>

<html lang="pt-BR">

<head>

<meta charset="UTF-8">

<meta
    name="viewport"
    content="width=device-width, initial-scale=1.0"
>

<title>AgendaFácil - Serviços</title>


<style>

* {

    margin: 0;

    padding: 0;

    box-sizing: border-box;

    font-family: Arial, sans-serif;

}


body {

    background: #f4f6f8;

    color: #333;

}


/* CABEÇALHO */

header {

    background: #1769aa;

    color: white;

    padding: 22px 50px;

}


header h1 {

    font-size: 25px;

}


/* CONTAINER */

.container {

    width: 90%;

    max-width: 1100px;

    margin: 35px auto;

}


/* TÍTULO */

.titulo {

    display: flex;

    justify-content: space-between;

    align-items: center;

    margin-bottom: 25px;

}


.titulo h2 {

    font-size: 28px;

    color: #222;

}


/* BOTÕES */

.btn {

    border: none;

    padding: 11px 18px;

    border-radius: 6px;

    cursor: pointer;

    font-weight: bold;

    color: white;

}


.btn-adicionar {

    background: #1976d2;

}


.btn-adicionar:hover {

    background: #125ca0;

}


.btn-editar {

    background: #6c757d;

}


.btn-excluir {

    background: #dc3545;

}


/* FORMULÁRIO */

.formulario {

    background: white;

    padding: 25px;

    border-radius: 10px;

    margin-bottom: 25px;

    box-shadow:
        0 2px 8px rgba(0,0,0,0.08);

}


.formulario h3 {

    margin-bottom: 18px;

}


.campo {

    padding: 12px;

    border: 1px solid #ccc;

    border-radius: 6px;

    margin-right: 8px;

    width: 30%;

}


/* TABELA */

table {

    width: 100%;

    border-collapse: collapse;

    background: white;

    border-radius: 10px;

    overflow: hidden;

    box-shadow:
        0 2px 8px rgba(0,0,0,0.08);

}


th {

    background: #1769aa;

    color: white;

    padding: 15px;

    text-align: left;

}


td {

    padding: 15px;

    border-bottom: 1px solid #eee;

}


.acoes {

    display: flex;

    gap: 8px;

}


/* RESPONSIVIDADE */

@media(max-width: 700px) {

    .campo {

        width: 100%;

        margin-bottom: 10px;

    }

    .titulo {

        flex-direction: column;

        align-items: flex-start;

        gap: 15px;

    }

}

</style>

</head>


<body>


<header>

<h1>AgendaFácil</h1>

</header>


<div class="container">


<div class="titulo">

<h2>Serviços</h2>


<button
    class="btn btn-adicionar"
    onclick="document.getElementById('nome').focus()"
>

+ Adicionar

</button>

</div>



<div class="formulario">

<h3>Novo serviço</h3>


<form method="POST">


<input
    class="campo"
    id="nome"
    type="text"
    name="nome"
    placeholder="Nome do serviço"
    required
>


<input
    class="campo"
    type="text"
    name="preco"
    placeholder="Preço"
    required
>


<button
    class="btn btn-adicionar"
    type="submit"
>

Adicionar

</button>


</form>

</div>



<table>


<thead>

<tr>

<th>ID</th>

<th>Serviço</th>

<th>Preço</th>

<th>Ações</th>

</tr>

</thead>



<tbody>


<?php foreach ($servicos as $servico): ?>


<tr>


<td>

<?php echo $servico["id"]; ?>

</td>


<td>

<?php echo $servico["nome"]; ?>

</td>


<td>

<?php echo $servico["preco"]; ?>

</td>


<td>


<div class="acoes">


<button
    class="btn btn-editar"
    onclick="editarServico()"
>

Editar

</button>


<button
    class="btn btn-excluir"
    onclick="excluirServico()"
>

Excluir

</button>


</div>


</td>


</tr>


<?php endforeach; ?>


</tbody>


</table>


</div>



<script>

function editarServico() {

    alert(
        "Função de edição selecionada."
    );

}


function excluirServico() {

    let resposta = confirm(
        "Deseja realmente excluir este serviço?"
    );


    if (resposta) {

        alert(
            "Serviço excluído com sucesso!"
        );

    }

}

</script>


</body>

</html>