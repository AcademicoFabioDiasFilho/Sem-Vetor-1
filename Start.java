import javax.swing.*;

final class Start {
    private Start() {

    }

    public static void main(final String[] args) {
        long tempoInicial = System.currentTimeMillis();
        long tempoInput;

        double soma = 0D;

        for (int i = 0; i < 10; ) {
            tempoInput = System.currentTimeMillis();
            final String input = JOptionPane.showInputDialog(null, "Insira um número (Exemplo: 1 ou 5.9):", null, JOptionPane.INFORMATION_MESSAGE);

            // Acrescenta o tempo que o usuário gastou no input ao tempoInicial
            tempoInicial += System.currentTimeMillis() - tempoInput;

            if (input == null) {
                return;
            }

            /*
             Tenta converter a entrada do número do usuário de String (texto) para double (número real) e
             guarda na variável local valor.
             Se o usuário errar a entrada, o programa o alertará e a entrada de dados da vez será reiniciada.
            */
            final double valor;

            try {
                valor = Double.parseDouble(input);
            } catch (final NumberFormatException e) {
                tempoInput = System.currentTimeMillis();
                JOptionPane.showMessageDialog(null, String.format("\"%s\" não é um número reconhecido.", input));
                tempoInicial += System.currentTimeMillis() - tempoInput;
                continue;
            }

            // Caso o valor for menor do que quarenta, ele será somado à variável valor.
            if (valor < 40D) {
                soma += valor;
            }

            i++;
        }

        tempoInput = System.currentTimeMillis();
        JOptionPane.showMessageDialog(null, String.format("Valor final da soma efetuada: %.2f", soma), null, JOptionPane.INFORMATION_MESSAGE);
        tempoInicial += System.currentTimeMillis() - tempoInput;

        System.out.printf("O 1º algoritmo foi executado em %d milissegundos.%n", System.currentTimeMillis() - tempoInicial);
    }
}
