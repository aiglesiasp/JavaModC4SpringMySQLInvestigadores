DROP TABLE IF EXISTS reserva;
DROP TABLE IF EXISTS equipos;
DROP TABLE IF EXISTS investigadores;
DROP TABLE IF EXISTS facultad;


CREATE TABLE IF NOT EXISTS facultad (
    codigo INT AUTO_INCREMENT,
    nombre VARCHAR(100) DEFAULT NULL,
    PRIMARY KEY(codigo)
    );
    
CREATE TABLE IF NOT EXISTS investigadores (
    id INT AUTO_INCREMENT,
    dni VARCHAR(8),
    nom_apels VARCHAR(255) DEFAULT NULL,
    facultad INT,
    PRIMARY KEY(id),
    CONSTRAINT facultad_investigadores_fk FOREIGN KEY (facultad) REFERENCES facultad (codigo)
    ON DELETE CASCADE ON UPDATE CASCADE
	);
    
CREATE TABLE IF NOT EXISTS equipos (
    id INT AUTO_INCREMENT,
    numserie CHAR(4),
    nombre VARCHAR(100) DEFAULT NULL,
    facultad INT,
    PRIMARY KEY(id),
    CONSTRAINT facultad_equipos_fk FOREIGN KEY (facultad) REFERENCES facultad (codigo)
    ON DELETE CASCADE ON UPDATE CASCADE
    );

CREATE TABLE IF NOT EXISTS reserva (
    id INT AUTO_INCREMENT,
    comienzo DATETIME DEFAULT NULL,
    fin DATETIME DEFAULT NULL,
    investigador INT,
    equipo INT,
    PRIMARY KEY(id),
    KEY (investigador, equipo),
    CONSTRAINT investigador_fk FOREIGN KEY (investigador) REFERENCES investigadores(id)
    ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT equipo_fk FOREIGN KEY (equipo) REFERENCES equipos(id)
    ON DELETE CASCADE ON UPDATE CASCADE
    );

/* INSERT INTO facultad */
INSERT INTO facultad(nombre) VALUES ('FACULTAD 1');
INSERT INTO facultad(nombre) VALUES ('FACULTAD 2');
INSERT INTO facultad(nombre) VALUES ('FACULTAD 3');
INSERT INTO facultad(nombre) VALUES ('FACULTAD 4');
INSERT INTO facultad(nombre) VALUES ('FACULTAD 5');

/* INSERT INTO investigadores */
INSERT INTO investigadores (dni, nom_apels, facultad) VALUES ('00000001', 'Investigador 1', 1);
INSERT INTO investigadores (dni, nom_apels, facultad) VALUES ('00000002', 'Investigador 2', 2);
INSERT INTO investigadores (dni, nom_apels, facultad) VALUES ('00000003', 'Investigador 3', 3);
INSERT INTO investigadores (dni, nom_apels, facultad) VALUES ('00000004', 'Investigador 4', 4);
INSERT INTO investigadores (dni, nom_apels, facultad) VALUES ('00000005', 'Investigador 5', 5);

/* INSERT INTO equios */
INSERT INTO equipos (numserie, nombre, facultad) VALUES ('01', 'equipo 1', 1);
INSERT INTO equipos (numserie, nombre, facultad) VALUES ('02', 'equipo 2', 2);
INSERT INTO equipos (numserie, nombre, facultad) VALUES ('03', 'equipo 3', 3);
INSERT INTO equipos (numserie, nombre, facultad) VALUES ('04', 'equipo 4', 4);
INSERT INTO equipos (numserie, nombre, facultad) VALUES ('05', 'equipo 5', 5);

/* INSERT INTO reserva */
INSERT INTO reserva (comienzo, fin, investigador, equipo) VALUES ('2019-03-27 14:15:37.000000', '2025-12-17 14:15:37', 1, 1);
INSERT INTO reserva (comienzo, fin, investigador, equipo) VALUES ('2020-03-28 14:15:37.000000', '2025-12-17 14:15:37', 2, 2);
INSERT INTO reserva (comienzo, fin, investigador, equipo) VALUES ('2021-03-29 14:15:37.000000', '2025-12-17 14:15:37', 3, 3);
INSERT INTO reserva (comienzo, fin, investigador, equipo) VALUES ('2022-03-30 14:15:37.000000', '2025-12-17 14:15:37', 4, 4);
INSERT INTO reserva (comienzo, fin, investigador, equipo) VALUES ('2023-03-31 14:15:37.000000', '2025-12-17 14:15:37', 5, 5);