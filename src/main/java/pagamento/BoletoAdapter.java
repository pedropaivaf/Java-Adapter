package pagamento;

public class BoletoAdapter implements Pagamento {
    private PagamentoBoleto boleto;

    public BoletoAdapter(PagamentoBoleto boleto) { this.boleto = boleto; }

    @Override
    public String pagar(double valor) { return boleto.gerarBoleto(valor); }

    @Override
    public String reembolsar(double valor) { return boleto.cancelarBoleto(valor); }
}
