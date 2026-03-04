package maximo;

public class CuentaBancaria {

    // Atributos constantes de clase (static final)
    private static final int MAX_MOVIMIENTOS = 100;
    private static final double SALDO_MINIMO = -50.0;
    private static final double AVISAR_HACIENDA = 3000.0;
	
    // Atributos constantes (final)
    private final String iban;
    private final String titular;
    
    // Atributos variables
    private double saldo;
    private double[] movimientos;
    private int nMovimientos; // Nº de movimientos
    
    // Cuenta válida
    private boolean valida;

    
    // Constructor
    public CuentaBancaria(String iban, String titular) {

        // Guardamos iban y titular
        this.iban = iban;
        this.titular = titular;

        // Inicilizamos saldo y movimientos
        this.saldo = 0.0;
        this.movimientos = new double[MAX_MOVIMIENTOS];
        this.nMovimientos = 0;

        // Comprobamos IBAN y registramos si es una cuenta válida o no
        if (!iban.matches("^[A-Z]{2}\\d{22}")) {
            System.err.println("ERROR: el formato del IBAN no es correcto");
            this.valida = false;
        } else {
            this.valida = true;
        }
    }
	
	

	


}
