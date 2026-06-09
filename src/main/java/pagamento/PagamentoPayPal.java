package pagamento;

public class PagamentoPayPal {
    public String realizarCobranca(double valor) {
        return String.format("PayPal: cobranca de R$%.2f realizada", valor);
    }
    public String estornarCobranca(double valor) {
        return String.format("PayPal: estorno de R$%.2f realizado", valor);
    }
}
