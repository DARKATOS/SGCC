/*
	MODELO RELACIONAL CASO DE USO ADMINISTRACIÓN DE USUARIOS
*/

DROP TABLE IF EXISTS EMPLEADO;
CREATE TABLE EMPLEADO(
	IDENTIFICADOR INTEGER AUTO_INCREMENT,
    NOMBRE VARCHAR(200),
	CEDULA VARCHAR(200),
    CORREO VARCHAR(200),
    CARGO VARCHAR(200),
    SALARIO_BASICO INTEGER,
    CONTRASENA VARCHAR(200),
    
    CONSTRAINT PK_USUARIO PRIMARY KEY (IDENTIFICADOR),
    CONSTRAINT UNIQUE_EMPLEADO_CEDULA UNIQUE(CEDULA)
);

ALTER TABLE INGRESO ADD CONSTRAINT FK_INGRESO_EMPLEADO FOREIGN KEY (IDEMPLEADO) REFERENCES EMPLEADO(IDENTIFICADOR);
ALTER TABLE INGRESO DROP FOREIGN KEY FK_INGRESO_EMPLEADO;

/*
	MODELO RELACIONAL CASO DE USO GESTIÓN DE NÓMINA
*/

DROP TABLE IF EXISTS LIQUIDACION;
CREATE TABLE LIQUIDACION(
	IDENTIFICADOR INTEGER AUTO_INCREMENT,
    FECHA DATE,
    COMISIONES INTEGER,
    AUXILIO_TRANSPORTE INTEGER,
    VALOR_HORA_EXTRA INTEGER,
    NUMERO_HORAS_EXTRA INTEGER,
    TOTAL_HORAS_EXTRA INTEGER,
    SALUD INTEGER,
    PENSION INTEGER,
    SALARIO_NETO INTEGER,
    IDEMPLEADO INTEGER,
    
    CONSTRAINT PK_LIQUIDACION PRIMARY KEY (IDENTIFICADOR)
);

ALTER TABLE LIQUIDACION ADD CONSTRAINT FK_LIQUIDACION_EMPLEADO FOREIGN KEY (IDEMPLEADO) REFERENCES EMPLEADO(IDENTIFICADOR);
ALTER TABLE LIQUIDACION DROP FOREIGN KEY FK_LIQUIDACION_EMPLEADO;

/*
DROP TABLE IF EXISTS HORAS_EXTRA;
CREATE TABLE HORAS_EXTRA(
	IDENTIFICADOR INTEGER AUTO_INCREMENT,
    NUMERO_HORAS INTEGER,
    VALOR INTEGER,
    IDTIPO_HORAS_EXTRA INTEGER,
    IDLIQUIDACION INTEGER,
    
    CONSTRAINT PK_HORAS_EXTRA PRIMARY KEY(IDENTIFICADOR)
);

ALTER TABLE HORAS_EXTRA ADD CONSTRAINT FK_HORAS_EXTRA_TIPO_HORAS_EXTRA FOREIGN KEY (IDTIPO_HORA_EXTRA) REFERENCES TIPO_HORAS_EXTRA(IDENTIFICADOR);
ALTER TABLE HORAS_EXTRA DROP FOREIGN KEY FK_HORAS_EXTRA_TIPO_HORAS_EXTRA;

ALTER TABLE HORAS_EXTRA ADD CONSTRAINT FK_HORAS_EXTRA_LIQUIDACION FOREIGN KEY (IDLIQUIDACION) REFERENCES LIQUIDACION(IDENTIFICADOR);
ALTER TABLE HORAS_EXTRA DROP FOREIGN KEY FK_HORAS_EXTRA_LIQUIDACION;

DROP TABLE IF EXISTS TIPO_HORAS_EXTRA;
CREATE TABLE TIPO_HORAS_EXTRA(
	IDENTIFICADOR INTEGER AUTO_INCREMENT,
    NOMBRE VARCHAR(200),
    PORCENTAJE DOUBLE,
    
    CONSTRAINT PK_TIPO_HORAS_EXTRA PRIMARY KEY(IDENTIFICADOR)
);

DROP TABLE IF EXISTS DEDUCCION;
CREATE TABLE DEDUCCION(
	IDENTIFICADOR INTEGER AUTO_INCREMENT,
    VALOR INTEGER,
    IDTIPO_DEDUCCION INTEGER,
    IDLIQUIDACION INTEGER,
    
    CONSTRAINT PK_DEDUCCION PRIMARY KEY(IDENTIFICADOR)
);

ALTER TABLE DEDUCCION ADD CONSTRAINT FK_DEDUCCION_TIPO_DEDUCCION FOREIGN KEY (IDTIPO_DEDUCCION) REFERENCES TIPO_DEDUCCION(IDENTIFICADOR);
ALTER TABLE DEDUCCION DROP FOREIGN KEY FK_DEDUCCION_TIPO_DEDUCCION;

ALTER TABLE DEDUCCION ADD CONSTRAINT FK_DEDUCCION_LIQUIDACION FOREIGN KEY (IDLIQUIDACION) REFERENCES LIQUIDACION(IDENTIFICADOR);
ALTER TABLE DEDUCCION DROP FOREIGN KEY FK_DEDUCCION_TIPO_DEDUCCION;

DROP TABLE IF EXISTS TIPO_DEDUCCION;
CREATE TABLE TIPO_DEDUCCION(
	IDENTIFICADOR INTEGER,
    NOMBRE VARCHAR(100),
    
    CONSTRAINT PK_TIPO_DEDUCCION PRIMARY KEY (IDENTIFICADOR)
);
*/