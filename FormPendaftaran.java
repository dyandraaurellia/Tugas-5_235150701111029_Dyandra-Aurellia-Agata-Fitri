import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormPendaftaran extends JFrame {
    private JTextField namaField, tanggalLahirField, nomorPendaftaranField, noTelpField, emailField;
    private JTextArea alamatArea;
    private JButton submitButton;

    public FormPendaftaran() {
        setTitle("Form Pendaftaran Mahasiswa Baru");
        setSize(540, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(221, 160, 221));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        Font font = new Font("Arial", Font.PLAIN, 18);

        JLabel namaLabel = new JLabel("Nama Lengkap:");
        namaField = new JTextField();
        namaField.setFont(font);
        namaField.setPreferredSize(new Dimension(200, 30));

        JLabel tanggalLahirLabel = new JLabel("Tanggal Lahir:");
        tanggalLahirField = new JTextField();
        tanggalLahirField.setFont(font);
        tanggalLahirField.setPreferredSize(new Dimension(200, 30));

        JLabel nomorPendaftaranLabel = new JLabel("Nomor Pendaftaran:");
        nomorPendaftaranField = new JTextField();
        nomorPendaftaranField.setFont(font);
        nomorPendaftaranField.setPreferredSize(new Dimension(200, 30));

        JLabel noTelpLabel = new JLabel("No. Telp:");
        noTelpField = new JTextField();
        noTelpField.setFont(font);
        noTelpField.setPreferredSize(new Dimension(200, 30));

        JLabel alamatLabel = new JLabel("Alamat:");
        alamatArea = new JTextArea();
        alamatArea.setFont(font);
        alamatArea.setPreferredSize(new Dimension(200, 100));
        alamatArea.setLineWrap(true);
        alamatArea.setWrapStyleWord(true);

        JLabel emailLabel = new JLabel("E-mail:");
        emailField = new JTextField();
        emailField.setFont(font);
        emailField.setPreferredSize(new Dimension(200, 30));

        submitButton = new JButton("Submit");
        submitButton.setFont(new Font("Arial", Font.PLAIN, 14));
        submitButton.addActionListener(new SubmitAction());

        gbc.gridx = 0;
        gbc.gridy = 0;
        add(namaLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        add(namaField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        add(tanggalLahirLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        add(tanggalLahirField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        add(nomorPendaftaranLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        add(nomorPendaftaranField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        add(noTelpLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        add(noTelpField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        add(alamatLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        add(new JScrollPane(alamatArea), gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        add(emailLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 5;
        add(emailField, gbc);

        gbc.gridx = 1;
        gbc.gridy = 6;
        add(submitButton, gbc);

        setVisible(true);
    }

    private class SubmitAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (namaField.getText().isEmpty() || tanggalLahirField.getText().isEmpty() ||
                nomorPendaftaranField.getText().isEmpty() || noTelpField.getText().isEmpty() ||
                alamatArea.getText().isEmpty() || emailField.getText().isEmpty()) {

                JOptionPane.showMessageDialog(FormPendaftaran.this, "Semua kolom harus diisi!", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                int response = JOptionPane.showConfirmDialog(FormPendaftaran.this, "Apakah anda yakin data yang Anda isi sudah benar?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
                if (response == JOptionPane.YES_OPTION) {
                    JFrame dataFrame = new JFrame("Data Mahasiswa");
                    dataFrame.getContentPane().setBackground(new Color(221, 160, 221));
                    dataFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    dataFrame.setSize(540, 600);
                    dataFrame.setLayout(new GridBagLayout());
                    dataFrame.setLocationRelativeTo(null);

                    GridBagConstraints gbc = new GridBagConstraints();
                    gbc.insets = new Insets(10, 10, 10, 10);
                    gbc.fill = GridBagConstraints.HORIZONTAL;

                    Font outputFont = new Font("Arial", Font.PLAIN, 18);

                    JPanel outputPanel = new JPanel();
                    outputPanel.setLayout(new GridBagLayout());
                    outputPanel.setBackground(Color.WHITE);
                    outputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

                    JLabel namaOutput = new JLabel("Nama: " + namaField.getText());
                    namaOutput.setFont(outputFont);

                    JLabel tanggalLahirOutput = new JLabel("Tanggal Lahir: " + tanggalLahirField.getText());
                    tanggalLahirOutput.setFont(outputFont);

                    JLabel nomorPendaftaranOutput = new JLabel("No. Pendaftaran: " + nomorPendaftaranField.getText());
                    nomorPendaftaranOutput.setFont(outputFont);

                    JLabel noTelpOutput = new JLabel("No. Telp: " + noTelpField.getText());
                    noTelpOutput.setFont(outputFont);

                    JLabel alamatOutput = new JLabel("<html>Alamat: " + alamatArea.getText().replaceAll("\n", "<br>") + "</html>");
                    alamatOutput.setFont(outputFont);

                    JLabel emailOutput = new JLabel("E-mail: " + emailField.getText());
                    emailOutput.setFont(outputFont);

                    gbc.gridx = 0;
                    gbc.gridy = 0;
                    outputPanel.add(namaOutput, gbc);

                    gbc.gridy++;
                    outputPanel.add(tanggalLahirOutput, gbc);

                    gbc.gridy++;
                    outputPanel.add(nomorPendaftaranOutput, gbc);

                    gbc.gridy++;
                    outputPanel.add(noTelpOutput, gbc);

                    gbc.gridy++;
                    outputPanel.add(alamatOutput, gbc);

                    gbc.gridy++;
                    outputPanel.add(emailOutput, gbc);

                    gbc.gridx = 0;
                    gbc.gridy = 0;
                    dataFrame.add(outputPanel, gbc);

                    dataFrame.setVisible(true);
                }
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new FormPendaftaran());
    }
}
