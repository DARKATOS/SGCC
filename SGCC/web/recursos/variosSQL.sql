INSERT INTO FUENTE VALUES(DEFAULT, "CAJA");
INSERT INTO FUENTE VALUES(DEFAULT, "BANCO");
SELECT * FROM FUENTE;

INSERT INTO CONCEPTO_INGRESO VALUES(DEFAULT, "INGRESO POR VENTAS");
INSERT INTO CONCEPTO_INGRESO VALUES(DEFAULT, "INGRESO POR ALQUILER");
SELECT * FROM CONCEPTO_INGRESO;

INSERT INTO CONCEPTO_GASTO VALUES(DEFAULT, "PAGO ARRENDAMIENTO");
INSERT INTO CONCEPTO_GASTO VALUES(DEFAULT, "PAGO SERVICIOS");
SELECT * FROM CONCEPTO_GASTO;

INSERT INTO USUARIO VALUES(DEFAULT, "ADMIN", "12345", "ADMIN@GMAIL.COM", "ADMINISTRADOR", "12345");
SELECT * FROM USUARIO;

SELECT * FROM INGRESO;
