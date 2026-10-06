import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Agenda extends JFrame {

    private DefaultTableModel modelo;
    private JTable tabela;

    private Color azul = new Color(23, 105, 170);
    private Color azulBotao = new Color(25, 118, 210);
    private Color vermelho = new Color(220, 53, 69);
    private Color cinza = new Color(108, 117, 125);
    private Color fundo = new Color(244, 246, 248);

    public Agenda() {

        setTitle("AgendaFácil - Agenda");

        setSize(1000, 650);

        setDefaultCloseOperation(
                JFrame.EXIT_ON_CLOSE
        );

        setLocationRelativeTo(null);


        // =========================
        // PAINEL PRINCIPAL
        // =========================

        JPanel principal =
                new JPanel(new BorderLayout());

        principal.setBackground(fundo);


        // =========================
        // CABEÇALHO
        // =========================

        JPanel cabecalho =
                new JPanel(new BorderLayout());

        cabecalho.setBackground(azul);

        cabecalho.setBorder(
                BorderFactory.createEmptyBorder(
                        20,
                        40,
                        20,
                        40
                )
        );


        JLabel logo =
                new JLabel("AgendaFácil");

        logo.setForeground(Color.WHITE);

        logo.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        25
                )
        );


        cabecalho.add(
                logo,
                BorderLayout.WEST
        );


        principal.add(
                cabecalho,
                BorderLayout.NORTH
        );


        // =========================
        // CONTEÚDO
        // =========================

        JPanel conteudo =
                new JPanel();

        conteudo.setLayout(
                new BoxLayout(
                        conteudo,
                        BoxLayout.Y_AXIS
                )
        );

        conteudo.setBackground(fundo);

        conteudo.setBorder(
                BorderFactory.createEmptyBorder(
                        30,
                        40,
                        30,
                        40
                )
        );


        JLabel titulo =
                new JLabel("Agenda");

        titulo.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        28
                )
        );

        titulo.setAlignmentX(
                Component.LEFT_ALIGNMENT
        );


        conteudo.add(titulo);

        conteudo.add(
                Box.createVerticalStrut(20)
        );


        // =========================
        // FORMULÁRIO
        // =========================

        JPanel formulario =
                new JPanel(
                        new FlowLayout(
                                FlowLayout.LEFT,
                                10,
                                12
                        )
                );

        formulario.setBackground(Color.WHITE);

        formulario.setAlignmentX(
                Component.LEFT_ALIGNMENT
        );


        JLabel clienteLabel =
                new JLabel("Cliente:");

        JTextField cliente =
                new JTextField(14);


        JLabel dataLabel =
                new JLabel("Data:");

        JTextField data =
                new JTextField(10);


        JLabel horarioLabel =
                new JLabel("Horário:");

        JTextField horario =
                new JTextField(7);


        JButton adicionar =
                criarBotao(
                        "Adicionar",
                        azulBotao
                );


        formulario.add(clienteLabel);
        formulario.add(cliente);

        formulario.add(dataLabel);
        formulario.add(data);

        formulario.add(horarioLabel);
        formulario.add(horario);

        formulario.add(adicionar);


        conteudo.add(formulario);

        conteudo.add(
                Box.createVerticalStrut(20)
        );


        // =========================
        // TABELA
        // =========================

        String[] colunas = {
                "Cliente",
                "Data",
                "Horário"
        };


        Object[][] dados = {

                {
                        "João Silva",
                        "10/10/2026",
                        "08:00"
                },

                {
                        "Maria Santos",
                        "10/10/2026",
                        "10:00"
                },

                {
                        "Carlos Oliveira",
                        "11/10/2026",
                        "14:00"
                }

        };


        modelo =
                new DefaultTableModel(
                        dados,
                        colunas
                );


        tabela =
                new JTable(modelo);


        tabela.setRowHeight(38);

        tabela.setFont(
                new Font(
                        "Arial",
                        Font.PLAIN,
                        14
                )
        );


        tabela.getTableHeader()
                .setBackground(azul);

        tabela.getTableHeader()
                .setForeground(Color.WHITE);


        tabela.getTableHeader()
                .setFont(
                        new Font(
                                "Arial",
                                Font.BOLD,
                                14
                        )
                );


        JScrollPane scroll =
                new JScrollPane(tabela);

        scroll.setAlignmentX(
                Component.LEFT_ALIGNMENT
        );


        conteudo.add(scroll);

        conteudo.add(
                Box.createVerticalStrut(20)
        );


        // =========================
        // BOTÕES
        // =========================

        JPanel botoes =
                new JPanel(
                        new FlowLayout(
                                FlowLayout.LEFT
                        )
                );

        botoes.setBackground(fundo);

        botoes.setAlignmentX(
                Component.LEFT_ALIGNMENT
        );


        JButton editar =
                criarBotao(
                        "Editar",
                        cinza
                );


        JButton excluir =
                criarBotao(
                        "Excluir",
                        vermelho
                );


        botoes.add(editar);

        botoes.add(excluir);


        conteudo.add(botoes);


        principal.add(
                conteudo,
                BorderLayout.CENTER
        );


        setContentPane(principal);


        // =========================
        // ADICIONAR
        // =========================

        adicionar.addActionListener(e -> {

            String nome =
                    cliente.getText();

            String dataTexto =
                    data.getText();

            String horarioTexto =
                    horario.getText();


            if (
                    nome.isEmpty()
                    ||
                    dataTexto.isEmpty()
                    ||
                    horarioTexto.isEmpty()
            ) {

                JOptionPane.showMessageDialog(
                        this,
                        "Preencha todos os campos."
                );

                return;
            }


            modelo.addRow(
                    new Object[] {
                            nome,
                            dataTexto,
                            horarioTexto
                    }
            );


            cliente.setText("");

            data.setText("");

            horario.setText("");

        });


        // =========================
        // EXCLUIR
        // =========================

        excluir.addActionListener(e -> {

            int linha =
                    tabela.getSelectedRow();


            if (linha == -1) {

                JOptionPane.showMessageDialog(
                        this,
                        "Selecione um agendamento."
                );

                return;
            }


            int resposta =
                    JOptionPane.showConfirmDialog(
                            this,
                            "Deseja excluir este agendamento?",
                            "Confirmação",
                            JOptionPane.YES_NO_OPTION
                    );


            if (
                    resposta ==
                    JOptionPane.YES_OPTION
            ) {

                modelo.removeRow(linha);

            }

        });


        // =========================
        // EDITAR
        // =========================

        editar.addActionListener(e -> {

            int linha =
                    tabela.getSelectedRow();


            if (linha == -1) {

                JOptionPane.showMessageDialog(
                        this,
                        "Selecione um agendamento."
                );

                return;
            }


            String novoNome =
                    JOptionPane.showInputDialog(
                            this,
                            "Digite o novo nome:",
                            tabela.getValueAt(
                                    linha,
                                    0
                            )
                    );


            if (
                    novoNome != null
                    &&
                    !novoNome.trim().isEmpty()
            ) {

                tabela.setValueAt(
                        novoNome,
                        linha,
                        0
                );

            }

        });

    }


    // =========================
    // CRIAR BOTÃO
    // =========================

    private JButton criarBotao(
            String texto,
            Color cor
    ) {

        JButton botao =
                new JButton(texto);

        botao.setBackground(cor);

        botao.setForeground(Color.WHITE);

        botao.setFocusPainted(false);

        botao.setBorder(
                BorderFactory.createEmptyBorder(
                        10,
                        18,
                        10,
                        18
                )
        );

        return botao;
    }


    // =========================
    // MAIN
    // =========================

    public static void main(
            String[] args
    ) {

        SwingUtilities.invokeLater(
                () -> {

                    Agenda tela =
                            new Agenda();

                    tela.setVisible(true);

                }
        );

    }

}