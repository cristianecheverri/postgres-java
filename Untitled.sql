CREATE TABLE cuentas (
	id_cuenta SERIAL PRIMARY KEY,
	numero_cuenta VARCHAR(20),
	tipo_cuenta VARCHAR(30),
	saldo_cuenta DECIMAL DEFAULT 0
);

INSERT INTO cuentas (numero_cuenta, tipo_cuenta, saldo_cuenta)
VALUES ('1234-3', 'Ahorros', 100000),
		('54353-1', 'Corriente', 0);