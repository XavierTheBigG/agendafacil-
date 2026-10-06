from flask import Flask, render_template, request, redirect

app = Flask(__name__)

clientes = [
    {
        "id": 1,
        "nome": "João Silva",
        "telefone": "(88) 99999-1111",
        "email": "joao@email.com"
    },
    {
        "id": 2,
        "nome": "Maria Santos",
        "telefone": "(88) 98888-2222",
        "email": "maria@email.com"
    },
    {
        "id": 3,
        "nome": "Carlos Oliveira",
        "telefone": "(88) 97777-3333",
        "email": "carlos@email.com"
    }
]


@app.route("/")
def inicio():
    return render_template(
        "clientes.html",
        clientes=clientes
    )


@app.route("/adicionar", methods=["POST"])
def adicionar():

    nome = request.form["nome"]
    telefone = request.form["telefone"]
    email = request.form["email"]

    novo_id = 1

    if clientes:
        novo_id = clientes[-1]["id"] + 1

    clientes.append({
        "id": novo_id,
        "nome": nome,
        "telefone": telefone,
        "email": email
    })

    return redirect("/")


@app.route("/excluir/<int:id>")
def excluir(id):

    global clientes

    clientes = [
        cliente
        for cliente in clientes
        if cliente["id"] != id
    ]

    return redirect("/")


if __name__ == "__main__":
    app.run(debug=True)