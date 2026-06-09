package pagamento;

public class PagamentoBoleto {
    public String gerarBoleto(double valor) {
        return String.format("Boleto: documento de R$%.2f gerado", valor);
    }
    public String cancelarBoleto(double valor) {
        return String.format("Boleto: cancelamento de R$%.2f processado", valor);
    }
}
