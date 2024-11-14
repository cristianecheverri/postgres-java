import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/banco";
        String user = "postgres";
        String password = "postgres";

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            System.out.println("Conexión exitosa");
            Statement statement = connection.createStatement();

            // boolean result = statement.execute("INSERT INTO cuentas (numero_cuenta, tipo_cuenta, saldo_cuenta) VALUES ('123456789', 'Ahorro', 1000) RETURNING id_cuenta");
            // System.out.println(result);

            Cuenta cuenta = new Cuenta("Ahorro", "utyvdhb-lioj", 1000);
            boolean result = cuenta.insertarCuenta(statement);
            if (result) {
                System.out.println("Cuenta insertada correctamente");
            } else {
                System.out.println("No se pudo insertar la cuenta");
            }


            ResultSet resultSet = statement.executeQuery("SELECT * FROM cuentas");

            while (resultSet.next()) {
                // Acceder a los datos de cada fila
                int idCuenta = resultSet.getInt("id_cuenta");
                String numeroCuenta = resultSet.getString("numero_cuenta");
                String tipoCuenta = resultSet.getString("tipo_cuenta");
                double saldo = resultSet.getDouble("saldo_cuenta");

                // Imprimir los resultados
                System.out.println("ID: " + idCuenta + ", Numero: " + numeroCuenta + ", Tipo: " + tipoCuenta + ", Saldo: " + saldo);
            }

            

        } catch (SQLException e) {
            System.out.println("Error de conexión: " + e.getMessage());
        }
    }
}