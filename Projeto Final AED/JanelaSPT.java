import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

public class JanelaSPT extends JFrame {

    private BacklogFila backlogFila;
    private JTextField txtId;
    private JTextField txtPrioridade;
    private JButton btnAdicionar;
    private JTextArea areaBacklog;

    public JanelaSPT() {
        super("Sistema de Priorização");

        backlogFila = new BacklogFila();

        setLayout(new BorderLayout());

        add(criarMensagemParaUsuario(), BorderLayout.NORTH);

        JPanel fundo = new JPanel();
        fundo.setBackground(new Color(224, 242, 254));
        fundo.setLayout(new GridBagLayout());
        add(fundo, BorderLayout.CENTER);

        JPanel painelCentral = new JPanel();
        painelCentral.setBackground(Color.WHITE);
        painelCentral.setBorder(new EmptyBorder(40, 50, 40, 50));
        painelCentral.setLayout(new BorderLayout());

        JPanel painelForm = new JPanel(new GridBagLayout());
        painelForm.setBackground(Color.WHITE);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 0, 5, 0);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.weightx = 1.0;

        txtId = new JTextField();
        txtPrioridade = new JTextField();

        estilizarCampo(txtId);
        estilizarCampo(txtPrioridade);

        configurarPlaceholder(txtId, "Digite o ID");
        configurarPlaceholder(txtPrioridade, "Digite a prioridade (1 a 10)");

        gbc.gridx = 0;
        gbc.gridy = 0;
        JLabel lblId = new JLabel("ID:");
        lblId.setFont(new Font("Arial", Font.BOLD, 12));
        painelForm.add(lblId, gbc); 

        gbc.gridy = 1;
        painelForm.add(txtId, gbc);

        gbc.gridy = 2;
        JLabel lblPrio = new JLabel("Prioridade:");
        lblPrio.setFont(new Font("Arial", Font.BOLD, 12));
        painelForm.add(lblPrio, gbc);

        gbc.gridy = 3;
        painelForm.add(txtPrioridade, gbc);

        gbc.gridy = 4;
        JLabel lblInfo = new JLabel("Prioridade de 1 (muito urgente) até 10 (menos urgente).");
        lblInfo.setFont(new Font("Arial", Font.ITALIC, 11));
        lblInfo.setForeground(new Color(90, 90, 90));
        painelForm.add(lblInfo, gbc);

        btnAdicionar = new JButton("ADICIONAR TAREFA");
        btnAdicionar.setBackground(new Color(30, 136, 229));
        btnAdicionar.setForeground(Color.WHITE);
        btnAdicionar.setFont(new Font("Arial", Font.BOLD, 14));
        btnAdicionar.setFocusPainted(false);

        JPanel painelBotao = new JPanel(new FlowLayout(FlowLayout.CENTER));
        painelBotao.setBackground(Color.WHITE);
        painelBotao.add(btnAdicionar);

        areaBacklog = new JTextArea(10, 30);
        areaBacklog.setEditable(false);
        areaBacklog.setFont(new Font("Consolas", Font.PLAIN, 13));
        JScrollPane scroll = new JScrollPane(areaBacklog);

        JPanel painelLista = new JPanel(new BorderLayout());
        painelLista.setBackground(Color.WHITE);
        painelLista.setBorder(new EmptyBorder(10, 0, 0, 0));
        painelLista.add(scroll, BorderLayout.CENTER);

        JPanel topo = new JPanel(new BorderLayout());
        topo.setBackground(Color.WHITE);
        topo.add(painelForm, BorderLayout.NORTH);
        topo.add(painelBotao, BorderLayout.CENTER);

        painelCentral.add(topo, BorderLayout.NORTH);
        painelCentral.add(painelLista, BorderLayout.CENTER);

        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        fundo.add(painelCentral, c);

        btnAdicionar.addActionListener(e -> adicionarTarefa());

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 650);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private JComponent criarMensagemParaUsuario() {

        JTextPane texto = new JTextPane();
        texto.setEditable(false);
        texto.setFocusable(false);
        texto.setBackground(new Color(224, 242, 254));
        texto.setForeground(new Color(38, 50, 56));
        texto.setFont(new Font("Arial", Font.BOLD, 14));
        texto.setBorder(new EmptyBorder(20, 20, 0, 20));

        texto.setText(
                "Olá! Bem-vindo ao Sistema de Priorização de Tarefas.\n\n" +
                        "Aqui você adiciona tarefas informando um ID e uma prioridade.\n" +
                        "Quanto menor o número da prioridade, mais urgente é a tarefa.\n" +
                        "As tarefas são organizadas automaticamente por prioridade.");

        StyledDocument doc = texto.getStyledDocument();
        SimpleAttributeSet center = new SimpleAttributeSet();
        StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
        doc.setParagraphAttributes(0, doc.getLength(), center, false);

        return texto;
    }

    private void estilizarCampo(JTextField campo) {
        campo.setFont(new Font("Arial", Font.PLAIN, 14));
        campo.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(144, 164, 174), 2),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));
    }

    private void configurarPlaceholder(JTextField campo, String placeholder) {

        campo.setText(placeholder);
        campo.setForeground(Color.GRAY);

        campo.addFocusListener(new java.awt.event.FocusAdapter() {

            public void focusGained(java.awt.event.FocusEvent evt) {
                if (campo.getText().equals(placeholder)) {
                    campo.setText("");
                    campo.setForeground(Color.BLACK);
                }
            }

            public void focusLost(java.awt.event.FocusEvent evt) {
                if (campo.getText().isEmpty()) {
                    campo.setForeground(Color.GRAY);
                    campo.setText(placeholder);
                }
            }
        });
    }

    private void adicionarTarefa() {
        try {
            String idTxt = txtId.getText().trim();
            String prioTxt = txtPrioridade.getText().trim();

            if (idTxt.isEmpty() || idTxt.startsWith("Digite") ||
                    prioTxt.isEmpty() || prioTxt.startsWith("Digite")) {
                JOptionPane.showMessageDialog(this, "Preencha ID e prioridade (1 a 10).");
                return;
            }

            int id = Integer.parseInt(idTxt);
            int prio = Integer.parseInt(prioTxt);

            if (prio < 1 || prio > 10) {
                JOptionPane.showMessageDialog(this, "A prioridade deve estar entre 1 e 10.");
                return;
            }

            Dados nova = new Dados(id, prio);
            backlogFila.adicionarTarefa(nova);

            StringBuilder sb = new StringBuilder();
            for (Object o : backlogFila.getListaComoArray()) {
                if (o instanceof Dados d) {
                    sb.append(formatarLinha(d)).append("\n");
                }
            }
            areaBacklog.setText(sb.toString());

            txtId.setText("");
            txtPrioridade.setText("");
            configurarPlaceholder(txtId, "Digite o ID");
            configurarPlaceholder(txtPrioridade, "Digite a prioridade (1 a 10)");
            txtId.requestFocus();

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Digite valores numéricos válidos.");
        }
    }

    private String formatarLinha(Dados d) {
        int p = d.getPrioridade();
        String nivel;
        if (p == 1) {
            nivel = "MUITO URGENTE";
        } else if (p <= 4) {
            nivel = "Alta prioridade";
        } else if (p <= 7) {
            nivel = "Média prioridade";
        } else {
            nivel = "Baixa prioridade";
        }
        return "ID " + d.getId() + " – Prio " + p + " (" + nivel + ")";
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(JanelaSPT::new);
    }
}
