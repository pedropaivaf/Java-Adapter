package pagamento;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PagamentoTest {

    Pagamento paypal;
    Pagamento boleto;

    @BeforeEach
    public void setUp() {
        paypal = new PayPalAdapter(new PagamentoPayPal());
        boleto = new BoletoAdapter(new PagamentoBoleto());
    }

    // PayPal via adapter

    @Test
    public void devePagarViaPayPal() {
        System.out.println("[ADAPTER] pagar(150.0) via PayPal");
        String resultado = paypal.pagar(150.0);
        System.out.println("  -> " + resultado);
        assertTrue(resultado.contains("PayPal"));
        assertTrue(resultado.contains("150,00") || resultado.contains("150.00"));
    }

    @Test
    public void deveReembolsarViaPayPal() {
        System.out.println("[ADAPTER] reembolsar(150.0) via PayPal");
        String resultado = paypal.reembolsar(150.0);
        System.out.println("  -> " + resultado);
        assertTrue(resultado.contains("PayPal"));
        assertTrue(resultado.contains("estorno") || resultado.contains("estornar"));
    }

    // Boleto via adapter

    @Test
    public void devePagarViaBoleto() {
        System.out.println("[ADAPTER] pagar(300.0) via Boleto");
        String resultado = boleto.pagar(300.0);
        System.out.println("  -> " + resultado);
        assertTrue(resultado.contains("Boleto"));
        assertTrue(resultado.contains("300,00") || resultado.contains("300.00"));
    }

    @Test
    public void deveReembolsarViaBoleto() {
        System.out.println("[ADAPTER] reembolsar(300.0) via Boleto");
        String resultado = boleto.reembolsar(300.0);
        System.out.println("  -> " + resultado);
        assertTrue(resultado.contains("Boleto"));
        assertTrue(resultado.contains("cancelamento") || resultado.contains("cancelar"));
    }

    // Interface unificada

    @Test
    public void deveUsarMesmaInterfaceParaAmbosMeios() {
        System.out.println("[ADAPTER] mesma interface Pagamento para PayPal e Boleto");
        String rPaypal = paypal.pagar(50.0);
        String rBoleto = boleto.pagar(50.0);
        System.out.println("  -> PayPal: " + rPaypal);
        System.out.println("  -> Boleto: " + rBoleto);
        assertNotNull(rPaypal);
        assertNotNull(rBoleto);
        assertNotEquals(rPaypal, rBoleto);
    }

    @Test
    public void deveReembolsarValorCorretoPayPal() {
        System.out.println("[ADAPTER] reembolsar(75.50) PayPal contem valor");
        String resultado = paypal.reembolsar(75.50);
        System.out.println("  -> " + resultado);
        assertTrue(resultado.contains("75") );
    }

    @Test
    public void devePagarValorZeroSemErro() {
        System.out.println("[ADAPTER] pagar(0.0) nao deve lancar excecao");
        String rP = paypal.pagar(0.0);
        String rB = boleto.pagar(0.0);
        System.out.println("  -> PayPal: " + rP);
        System.out.println("  -> Boleto: " + rB);
        assertNotNull(rP);
        assertNotNull(rB);
    }
}
