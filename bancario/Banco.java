package bancario;

import java.util.ArrayList;

import bancario.base.Cliente;
import bancario.base.Cuenta;

public class Banco {
    String nombre;
    ArrayList<Cuenta> cuentas;

    public Banco() {
        this.cuentas = new ArrayList<>(4);
    }

    public Cuenta buscarCuenta(String numero) {
        // for(int i = 0; i < this.cuentas.size(); i++) {
        //     if (numero.equals(cuentas.get(i).getNumero())) {
        //         return this.cuentas.get(i);
        //     }
        // }

        for (Cuenta cuenta : this.cuentas) {
            if (cuenta.getNumero().equals(numero)) {
                return cuenta;
            }
        }
        return null;
    }

    public boolean adicionarCuenta(String numero, double saldoInicial, String tipo, String cedulaTitular, String nombreTitular) {
        Cliente cliente = new Cliente(cedulaTitular, nombreTitular);

        Cuenta cuentaBuscar = this.buscarCuenta(numero);
        if (cuentaBuscar == null) {
            Cuenta cuenta = new Cuenta(tipo, numero, saldoInicial, cliente);
            return cuentas.add(cuenta);
        } else {
            return false;
        }
    }

    public double consultarTotalDinero() {
        double total = 0;

        for (Cuenta cuenta : this.cuentas) {
            total += cuenta.consultarSaldo();
        }

        // for (int i = 0; i < this.cuentas.size(); i++) {
        //     total += cuentas.get(i).getSaldo();
        // }

        return total;
    }

    public String consultarClienteMayorSaldo() {
        double mayorSaldo = 0;
        String nombreTitular = "";

        for (Cuenta cuenta : this.cuentas) {
            if (cuenta.consultarSaldo() > mayorSaldo) {
                mayorSaldo = cuenta.consultarSaldo();
                nombreTitular = cuenta.getTitular().getNombre();
            }
        }
        return nombreTitular.isEmpty() ? "Nadie": nombreTitular;
    }
}
