import java.awt.Color;
import java.awt.Font;
import java.awt.FlowLayout;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class Main {
    public static void main(String[] args) {
        // Título
        JLabel label = new JLabel("O culto terminou?", JLabel.CENTER);
        label.setFont(new Font("Calibri", Font.BOLD, 40));
        label.setForeground(Color.BLACK);

        // Botão Sim
        JButton sim = new JButton("sim");
        sim.setFont(new Font("Calibri", Font.BOLD, 20));
        sim.addActionListener(e -> enviarSinal("Sim"));


        // Botão mais 5 minutos
        JButton nao = new JButton("daqui 5 minutos");
        nao.setFont(new Font("Calibri", Font.BOLD, 20));
        nao.addActionListener(e -> enviarSinal("Não"));


        //janela
        JFrame janela = new JFrame();
        janela.setLayout(new FlowLayout());
        janela.setVisible(true);
        janela.setSize(700, 250);
        janela.add(label);
        janela.getContentPane().setBackground(new Color(200, 200, 200));

        janela.add(sim); // Botão Sim
        janela.add(nao); // Botão Não


    }
    // Função para enviar e receber o Sinal
    public static void enviarSinal(String mensagem) {
        try {
            URL url = new URL("https://southamerica-east1-projetosanl.cloudfunctions.net/recebeSinal"); // substitua pela URL da sua função
            HttpURLConnection conexao = (HttpURLConnection) url.openConnection();
            conexao.setRequestMethod("POST");
            conexao.setRequestProperty("Content-Type", "application/json");
            conexao.setDoOutput(true);

            // Corpo da requisição JSON
            String jsonInputString = "{\"message\": \"" + mensagem + "\"}";

            // Enviar a requisição
            try (OutputStream os = conexao.getOutputStream()) {
                byte[] input = jsonInputString.getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            // Checar a resposta
            int codigoResposta = conexao.getResponseCode();
            System.out.println("Código de resposta: " + codigoResposta);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

