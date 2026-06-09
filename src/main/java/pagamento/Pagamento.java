package pagamento;

public interface Pagamento {
    String pagar(double valor);
    String reembolsar(double valor);
}
