package bancario.base;
import java.sql.SQLException;
import java.sql.Statement;

public class Cuenta {
    double saldo;
    String numero;
    String tipo;
    Cliente titular;

    public Cuenta(String tipo, String numero, double saldo, Cliente titular) {
        this.tipo = tipo;
        this.numero = numero;
        this.saldo = saldo;
        this.titular = titular;
    }

    public Cuenta(String tipo, String numero, Cliente titular) {
        this(tipo, numero, 0, titular);
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getNumero() {
        return numero;
    }

    public Cliente getTitular() {
        return titular;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double consultarSaldo() {
        return saldo;
    }

    public boolean retirar(double cantidad) {
        if (saldo >= cantidad) {
            saldo -= cantidad;
            return true;
        } else {
            return false;
        }
    }

    public void consignar(double cantidad) {
        saldo += cantidad;
    }

    boolean insertarCuenta(Statement statement)
    {
        try {
            statement.execute("INSERT INTO cuentas (numero_cuenta, tipo_cuenta, saldo_cuenta) VALUES ('" + this.numero + "', '" + this.tipo + "', " + this.saldo + ") RETURNING id_cuenta");
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}