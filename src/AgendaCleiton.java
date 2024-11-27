import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

public class AgendaCleiton {
    //SPINNERS
    private JSpinner spnHora;
    private JSpinner spnData;

    //EXIBIÇÃO
    private JPanel painelPrincipal;
    private JTextField txtCompromisso;
    private JTable tabelaCompromissos;

    //BOTOES
    private JButton btnCompromisso;
    private JButton btnRemover;

    private void configurarSpinner() {
        spnData.setModel(new SpinnerDateModel());

        JSpinner.DateEditor modificarData = new JSpinner.DateEditor(spnData, "dd/mm/yyyy");
        spnData.setEditor(modificarData);

        spnHora.setModel(new SpinnerDateModel());
        JSpinner.DateEditor modificarHora = new JSpinner.DateEditor(spnHora, "hh:mm");
        spnHora.setEditor(modificarHora);
    }


    public AgendaCleiton(){
        configurarSpinner();
        DefaultTableModel modelo = new DefaultTableModel(
                new String[]{"Compromisso", "Data", "Hora"}, 0
        );

        tabelaCompromissos.setModel(modelo);

        btnRemover.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int excluirLinha = tabelaCompromissos.getSelectedRow();
                if(excluirLinha != -1) {
                    modelo.removeRow(excluirLinha);
                }


            }
        });


        btnCompromisso.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String compromisso = txtCompromisso.getText();
                String data = new SimpleDateFormat("dd/MM/yyyy").format(spnData.getValue());
                String hora = new SimpleDateFormat("HH:mm").format(spnHora.getValue());

                    modelo.addRow(new Object[]{compromisso, data, hora});

            }
        });

    }


    public static void main(String[] args) {
        JFrame frame = new JFrame("Agenda");
        frame.setContentPane(new AgendaCleiton().painelPrincipal);
        frame.setSize(300,400);
        frame.setVisible(true);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}
