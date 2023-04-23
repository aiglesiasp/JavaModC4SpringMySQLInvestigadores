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
    nomApels VARCHAR(255) DEFAULT NULL,
    facultad INT,
    PRIMARY KEY(id),
    CONSTRAINT facultad_fk FOREIGN KEY (facultad) REFERENCES facultad (codigo)
    ON DELETE CASCADE ON UPDATE CASCADE
	);
    
CREATE TABLE IF NOT EXISTS equipos (
    id INT AUTO_INCREMENT,
    numserie CHAR(4),
    nombre VARCHAR(100) DEFAULT NULL,
    facultad INT,
    PRIMARY KEY(id),
    CONSTRAINT facultad_fk FOREIGN KEY (facultad) REFERENCES facultad (codigo)
    ON DELETE CASCADE ON UPDATE CASCADE
    );

CREATE TABLE IF NOT EXISTS reserva (
    id INT AUTO_INCREMENT
    investigador INT,
    equipo INT,
    comienzo DATETIME DEFAULT NULL,
    fin DATETIME DEFAULT NULL,
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
INSERT INTO investigadores (dni, nomApels, facultad) VALUES ('00000001', 'Investigador 1', 1);
INSERT INTO investigadores (dni, nomApels, facultad) VALUES ('00000002', 'Investigador 2', 2);
INSERT INTO investigadores (dni, nomApels, facultad) VALUES ('00000003', 'Investigador 3', 3);
INSERT INTO investigadores (dni, nomApels, facultad) VALUES ('00000004', 'Investigador 4', 4);
INSERT INTO investigadores (dni, nomApels, facultad) VALUES ('00000005', 'Investigador 5', 5);

/* INSERT INTO equios */
INSERT INTO equipos (numserie, nombre, facultad) VALUES ('01', 'equipo 1', 1);
INSERT INTO equipos (numserie, nombre, facultad) VALUES ('02', 'equipo 2', 2);
INSERT INTO equipos (numserie, nombre, facultad) VALUES ('03', 'equipo 3', 3);
INSERT INTO equipos (numserie, nombre, facultad) VALUES ('04', 'equipo 4', 4);
INSERT INTO equipos (numserie, nombre, facultad) VALUES ('05', 'equipo 5', 5);

/* INSERT INTO reserva */
INSERT INTO reserva (investigador, equipo, comienzo, fin) VALUES (1, '01', '2023-03-27 14:15:37.000000', '2023-03-17 14:15:37');