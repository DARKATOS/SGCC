DROP FUNCTION IF EXISTS NUEVO_INGRESO;
DELIMITER $$
CREATE FUNCTION NUEVO_INGRESO(FECHA_P DATE, EMPRESA_P VARCHAR(200), CANTIDAD_P INTEGER, VALORUNITARIO_P INTEGER, 
VALORTOTAL_P INTEGER, IDCONCEPTO_P INTEGER, IDFUENTE_P INTEGER, IDUSUARIO_P INTEGER)
RETURNS VARCHAR(200)
BEGIN	
    INSERT INTO INGRESO VALUES(DEFAULT,FECHA_P, EMPRESA_P, CANTIDAD, VALORUNITARIO_P, VALORTOTAL_P, IDCONCEPTO_P, IDFUENTE_P,IDUSUARIO_P);
    RETURN "Se ha insertado correctamente el ingreso";
END$$
DELIMITER ;

DROP FUNCTION IF EXISTS MODIFICAR_INGRESO;
DELIMITER $$
CREATE FUNCTION MODIFICAR_INGRESO(IDENTIFICADOR_P INTEGER, FECHA_P DATE, EMPRESA_P VARCHAR(200), CANTIDAD_P INTEGER, VALORUNITARIO_P INTEGER,
VALORTOTAL_P INTEGER, IDCONCEPTO_P INTEGER, IDFUENTE_P INTEGER, IDUSUARIO_P INTEGER)
RETURNS VARCHAR(200)
BEGIN
	UPDATE INGRESO SET FECHA=FECHA_P, EMPRESA=EMPRESA_P, CANTIDAD=CANTIDAD_P, VALORUNITARIO=VALORUNITARIO_P, VALORTOTAL=VALORTOTAL_P,
    IDCONCEPTO=IDCONCEPTO_P, IDFUENTE=IDFUENTE_P, IDUSUARIO=IDUSUARIO_P WHERE IDENTIFICADOR=IDENTIFICADOR_P;
    RETURN "Se modifico exitosamente el ingreso";
END$$
DELIMITER ;

DROP FUNCTION IF EXISTS ELIMINAR_INGRESO;
DELIMITER $$
CREATE FUNCTION ELIMINAR_INGRESO(IDENTIFICADOR_P INTEGER)
RETURNS VARCHAR(200)
BEGIN
	DELETE FROM INGRESO WHERE IDENTIFICADOR=IDENTIFICADOR_P;
    RETURN "Se ha eliminado correctamente el ingreso";
END$$
DELIMITER ;

DROP PROCEDURE IF EXISTS LEER_INGRESOS;
DELIMITER $$
CREATE PROCEDURE LEER_INGRESOS()
BEGIN
	SELECT * FROM INGRESO;
END$$
DELIMITER ;

DROP PROCEDURE IF EXISTS LEER_FUENTES;
DELIMITER $$
CREATE PROCEDURE LEER_FUENTES()
BEGIN
	SELECT * FROM FUENTE;
END$$
DELIMITER ;

/*DE AQUI EN ADELANTE FUNCIONES Y PROCEDIMIENTOS VARIOS.*/

DROP PROCEDURE IF EXISTS SOPORTES_DE_INGRESO;
DELIMITER $$
CREATE PROCEDURE SOPORTES_DE_INGRESO(IDINGRESO INTEGER)
BEGIN
	SELECT * FROM SOPORTE_INGRESO WHERE IDENTIFICADOR=IDINGRESO;
END$$
DELIMITER ;

DROP PROCEDURE IF EXISTS NOMBRE_CONCEPTO;
DELIMITER $$
CREATE PROCEDURE NOMBRE_CONCEPTO(IDCONCEPTO INTEGER)
BEGIN
	SELECT NOMBRE FROM CONCEPTO WHERE IDENTIFICADOR=IDCONCEPTO;
END$$
DELIMITER ;

DROP PROCEDURE IF EXISTS NOMBRE_FUENTE;
DELIMITER $$
CREATE PROCEDURE NOMBRE_FUENTE(IDFUENTE INTEGER)
BEGIN
	SELECT NOMBRE FROM FUENTE WHERE IDENTIFICADOR=IDFUENTE;
END$$
DELIMITER ;

 
    
