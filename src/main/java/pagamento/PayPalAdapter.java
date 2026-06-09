package pagamento;

public class PayPalAdapter implements Pagamento {
    private PagamentoPayPal paypal;

    public PayPalAdapter(PagamentoPayPal paypal) { this.paypal = paypal; }

    @Override
    public String pagar(double valor) { return paypal.realizarCobranca(valor); }

    @Override
    public String reembolsar(double valor) { return paypal.estornarCobranca(valor); }
}
