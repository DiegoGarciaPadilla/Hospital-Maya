# Hospital Maya 🏥

## Description

This web application allows the user to create a patient, add a doctor to the patient, and add a specialty to the doctor. The user can also view all patients and doctors. It uses Spring framework, Java, and MySQL database. It was created as a project for the course "Desarrollo de Aplicaciones Web" at CETIS 26 Technical Highschool on December 2020.

## Entity Relationship Diagram

![ERD](HospitalMaya_DiagramaER.jpg)

## Intructions

To deploy this application, you will need to have Apache Maven installed. You will also need to have MySQL installed and running.

1. Clone this repository to your local machine.
2. Open the project in your favorite IDE.
3. Create a database called "hospital_maya" in MySQL.
4. Run the application.
5. Open your browser and go to http://localhost:8080/

## SQL Initialization

```sql
CREATE DATABASE hospital_maya;
USE hospital_maya;

CREATE TABLE pacientes(id_paciente int PRIMARY KEY, nombre varchar(16), apellidoP varchar(16), apellidoM varchar(16), telefono varchar(10), domicilio varchar(64), edad int, id_area int);
CREATE TABLE medicos(matricula int PRIMARY KEY, nombre varchar(16), apellidoP varchar(16), apellidoM varchar(16), telefono varchar(10), domicilio varchar(64), especialidad varchar(16), id_area int);
CREATE TABLE ingresos(id_ingreso int NOT NULL AUTO_INCREMENT PRIMARY KEY, fecha_ingreso date, padecimiento varchar(32), estado_salud varchar(36), id_paciente int);
CREATE TABLE areas(id_area int NOT NULL AUTO_INCREMENT PRIMARY KEY, nombre_area varchar(32), cupo int);
CREATE TABLE medico_paciente(matricula int, id_paciente int, PRIMARY KEY(matricula, id_paciente));

DESCRIBE pacientes;
DESCRIBE medicos;
DESCRIBE ingresos;
DESCRIBE areas;
DESCRIBE medico_paciente;

ALTER TABLE pacientes MODIFY id_paciente int NOT NULL AUTO_INCREMENT;
ALTER TABLE pacientes ADD FOREIGN KEY(id_area) REFERENCES areas(id_area);
ALTER TABLE medicos ADD FOREIGN KEY(id_area) REFERENCES areas(id_area);
ALTER TABLE ingresos ADD FOREIGN KEY(id_paciente) REFERENCES pacientes(id_paciente);
ALTER TABLE medico_paciente ADD FOREIGN KEY(matricula) REFERENCES medicos(matricula);
ALTER TABLE medico_paciente ADD FOREIGN KEY(id_paciente) REFERENCES pacientes(id_paciente);

DESCRIBE pacientes;
DESCRIBE medicos;
DESCRIBE ingresos;
DESCRIBE areas;
DESCRIBE medico_paciente;

INSERT INTO pacientes(nombre, apellidoP, apellidoM, telefono, domicilio, edad, id_area) 
VALUES ("Isabella", "Garcia", "Oropeza", "7731338150", "Av. Reforma #1611, Polanco, CD.MX", 13, null), 
("Martin", "Godinez", "Vaca", "7731420948","Cl. Venustiano Carranza #34, Iztapalapa, CD.MX", 64, null), 
("Regina", "Barrera", "Vargas", "7787370184","Cl. 5 de Mayo #67, Col, Roma, CD.MX", 22, null), 
("Gonzalo", "Juarez", "Miranda", "7717129869","Av. Benito Juarez #1771, Condesa, CD.MX", 17, null), 
("Bruno", "Marinez", "Martinez", "7787371301","Cl. Guillermo Prieto #34, Satelite, CD.MX", 34, null);

INSERT INTO areas(nombre_area, cupo) 
VALUES ("Urgencias", 80), 
("Pediatria", 30), 
("Cardiologia", 50), 
("Terapia Intensiva", 50), 
("COVID-19", 200);

INSERT INTO medicos(matricula, nombre, apellidoP, apellidoM, telefono, domicilio, especialidad, id_area) 
VALUES (16116859, "Javier", "Reyes", "Cortes", "7731067801", "Cl. 5 de Mayo #96, Santa Fe, CD.MX", "Medico General", 5), 
(16129361, "Mariana", "Perez", "Ayub", "7717816758", "Cl. Emiliano Zapata #16, Condesa, CD.MX", "Pediatra", 2), 
(16138097, "Patricia", "Garcia", "Ponce", "7731050769", "Av. Caballos #151, Satelite, CD.MX", "Paramedica", 1), 
(16149876, "Carlos", "Madero", "Hernandez", "7781338143", "Cl. Venustiano Carranza #78, Iztapalapa, CD.MX", "Internista", 4), 
(16159860, "Karem", "Oropeza", "Yañez", "7731096832", "Av. Reforma #1611, Polanco, CD.MX", "Cardiologa", 3);

INSERT INTO ingresos (fecha_ingreso, padecimiento, estado_salud, id_paciente)
VALUES ("2020-11-19", "Gripe", "Estable", 1), 
("2020-11-23", "Neumonia", "Critico", 2), 
("2020-12-05", "COVID-19", "Estable", 5), 
("2020-10-15", "Hipertensión", "Critico", 4), 
("2020-11-26", "COVID-19", "Critico", 3);

INSERT INTO medico_paciente(matricula, id_paciente)
VALUES (16159860, 3), 
(16129361, 1), 
(16138097, 4), 
(16159860, 5), 
(16149876, 4);

UPDATE pacientes SET id_area=2 WHERE id_paciente=1;
UPDATE pacientes SET id_area=3 WHERE id_paciente=2;
UPDATE pacientes SET id_area=5 WHERE id_paciente=3;
UPDATE pacientes SET id_area=3 WHERE id_paciente=4;
UPDATE pacientes SET id_area=5 WHERE id_paciente=5;

SELECT * FROM pacientes;
SELECT * FROM medicos;
SELECT * FROM areas;
SELECT * FROM ingresos;
SELECT * FROM medico_paciente;

SELECT * FROM pacientes WHERE id_paciente=1 OR id_paciente>3;
SELECT matricula, nombre FROM medicos ORDER BY nombre;
SELECT avg(edad)FROM pacientes;
SELECT min(edad), nombre FROM pacientes;
SELECT max(id_area), nombre_area FROM areas;
SELECT sum(cupo) FROM areas;
SELECT ingresos.id_ingreso, pacientes.nombre FROM ingresos, pacientes WHERE ingresos.id_paciente=pacientes.id_paciente ORDER BY ingresos.id_ingreso DESC;
SELECT DISTINCT matricula FROM medico_paciente;

UPDATE pacientes SET nombre="Sofia" WHERE id_paciente=2;
UPDATE pacientes SET apellidoP="Marquez" WHERE id_paciente=2;
UPDATE pacientes SET apellidoM="Ruiz" WHERE id_paciente=2;
UPDATE pacientes SET telefono="7731408590" WHERE id_paciente=2;
UPDATE pacientes SET domicilio="Av. Constitucion #321, Tepito, CD.MX" WHERE id_paciente=2;
UPDATE pacientes SET edad=50 WHERE id_paciente=2;
UPDATE pacientes SET id_area=5 WHERE id_paciente=2;

UPDATE medicos SET nombre="Lizbeth" WHERE matricula=16116859;
UPDATE medicos SET apellidoP="Ramirez" WHERE matricula=16116859;
UPDATE medicos SET apellidoM="Flores" WHERE matricula=16116859;
UPDATE medicos SET telefono="7737864371" WHERE matricula=16116859;
UPDATE medicos SET domicilio="Av. Guillermo Prieto #34, Roma, CD.MX" WHERE matricula=16116859;
UPDATE medicos SET especialidad="Cirujano" WHERE matricula=16116859;
UPDATE medicos SET id_area=1 WHERE matricula=16116859;

UPDATE areas SET nombre_area="Cuidados intensivos" WHERE id_area=4;
UPDATE areas SET cupo=100 WHERE id_area=4;

SELECT * FROM pacientes;
SELECT * FROM medicos;
SELECT * FROM areas;
SELECT * FROM ingresos;
SELECT * FROM medico_paciente;


--------------------------------------------------------------------------------------------------------------------------------------------------------------------

CREATE DATABASE hospital_maya;
USE hospital_maya;
CREATE TABLE pacientes(id_paciente int PRIMARY KEY, nombre varchar(16), apellidoP varchar(16), apellidoM varchar(16), telefono varchar(10), domicilio varchar(64), edad int, id_area int);
CREATE TABLE medicos(matricula int PRIMARY KEY, nombre varchar(16), apellidoP varchar(16), apellidoM varchar(16), telefono varchar(10), domicilio varchar(64), especialidad varchar(16), id_area int);
CREATE TABLE ingresos(id_ingreso int NOT NULL AUTO_INCREMENT PRIMARY KEY, fecha_ingreso date, padecimiento varchar(32), estado_salud varchar(36), id_paciente int);
CREATE TABLE areas(id_area int NOT NULL AUTO_INCREMENT PRIMARY KEY, nombre_area varchar(32), cupo int);
CREATE TABLE medico_paciente(matricula int, id_paciente int, PRIMARY KEY(matricula, id_paciente));
DESCRIBE pacientes;
DESCRIBE medicos;
DESCRIBE ingresos;
DESCRIBE areas;
DESCRIBE medico_paciente;
ALTER TABLE pacientes MODIFY id_paciente int NOT NULL AUTO_INCREMENT;
ALTER TABLE pacientes ADD FOREIGN KEY(id_area) REFERENCES areas(id_area);
ALTER TABLE medicos ADD FOREIGN KEY(id_area) REFERENCES areas(id_area);
ALTER TABLE ingresos ADD FOREIGN KEY(id_paciente) REFERENCES pacientes(id_paciente);
ALTER TABLE medico_paciente ADD FOREIGN KEY(matricula) REFERENCES medicos(matricula);
ALTER TABLE medico_paciente ADD FOREIGN KEY(id_paciente) REFERENCES pacientes(id_paciente);
DESCRIBE pacientes;
DESCRIBE medicos;
DESCRIBE ingresos;
DESCRIBE areas;
DESCRIBE medico_paciente;
INSERT INTO pacientes(nombre, apellidoP, apellidoM, telefono, domicilio, edad, id_area) VALUES ("Isabella", "Garcia", "Oropeza", "7731338150", "Av. Reforma #1611, Polanco, CD.MX", 13, null), ("Martin", "Godinez", "Vaca", "7731420948","Cl. Venustiano Carranza #34, Iztapalapa, CD.MX", 64, null), ("Regina", "Barrera", "Vargas", "7787370184","Cl. 5 de Mayo #67, Col, Roma, CD.MX", 22, null), ("Gonzalo", "Juarez", "Miranda", "7717129869","Av. Benito Juarez #1771, Condesa, CD.MX", 17, null), ("Bruno", "Marinez", "Martinez", "7787371301","Cl. Guillermo Prieto #34, Satelite, CD.MX", 34, null);
INSERT INTO areas(nombre_area, cupo) VALUES ("Urgencias", 80), ("Pediatria", 30), ("Cardiologia", 50), ("Terapia Intensiva", 50), ("COVID-19", 200);
INSERT INTO medicos(matricula, nombre, apellidoP, apellidoM, telefono, domicilio, especialidad, id_area) VALUES (16116859, "Javier", "Reyes", "Cortes", "7731067801", "Cl. 5 de Mayo #96, Santa Fe, CD.MX", "Medico General", 5), (16129361, "Mariana", "Perez", "Ayub", "7717816758", "Cl. Emiliano Zapata #16, Condesa, CD.MX", "Pediatra", 2), (16138097, "Patricia", "Garcia", "Ponce", "7731050769", "Av. Caballos #151, Satelite, CD.MX", "Paramedica", 1), (16149876, "Carlos", "Madero", "Hernandez", "7781338143", "Cl. Venustiano Carranza #78, Iztapalapa, CD.MX", "Internista", 4), (16159860, "Karem", "Oropeza", "Yañez", "7731096832", "Av. Reforma #1611, Polanco, CD.MX", "Cardiologa", 3);
INSERT INTO ingresos (fecha_ingreso, padecimiento, estado_salud, id_paciente) VALUES ("2020-11-19", "Gripe", "Estable", 1), ("2020-11-23", "Neumonia", "Critico", 2), ("2020-12-05", "COVID-19", "Estable", 5), ("2020-10-15", "Hipertensión", "Critico", 4), ("2020-11-26", "COVID-19", "Critico", 3);
INSERT INTO medico_paciente(matricula, id_paciente) VALUES (16159860, 3), (16129361, 1), (16138097, 4), (16159860, 5), (16149876, 4);
UPDATE pacientes SET id_area=2 WHERE id_paciente=1;
UPDATE pacientes SET id_area=3 WHERE id_paciente=2;
UPDATE pacientes SET id_area=5 WHERE id_paciente=3;
UPDATE pacientes SET id_area=3 WHERE id_paciente=4;
UPDATE pacientes SET id_area=5 WHERE id_paciente=5;
SELECT * FROM pacientes;
SELECT * FROM medicos;
SELECT * FROM areas;
SELECT * FROM ingresos;
SELECT * FROM medico_paciente;
SELECT * FROM pacientes WHERE id_paciente=1 OR id_paciente>3;
SELECT matricula, nombre FROM medicos ORDER BY nombre;
SELECT avg(edad)FROM pacientes;
SELECT min(edad), nombre FROM pacientes;
SELECT max(id_area), nombre_area FROM areas;
SELECT sum(cupo) FROM areas;
SELECT ingresos.id_ingreso, pacientes.nombre FROM ingresos, pacientes WHERE ingresos.id_paciente=pacientes.id_paciente ORDER BY ingresos.id_ingreso DESC;
SELECT DISTINCT matricula FROM medico_paciente;
UPDATE pacientes SET nombre="Sofia" WHERE id_paciente=2;
UPDATE pacientes SET apellidoP="Marquez" WHERE id_paciente=2;
UPDATE pacientes SET apellidoM="Ruiz" WHERE id_paciente=2;
UPDATE pacientes SET telefono="7731408590" WHERE id_paciente=2;
UPDATE pacientes SET domicilio="Av. Constitucion #321, Tepito, CD.MX" WHERE id_paciente=2;
UPDATE pacientes SET edad=50 WHERE id_paciente=2;
UPDATE pacientes SET id_area=5 WHERE id_paciente=2;
UPDATE medicos SET nombre="Lizbeth" WHERE matricula=16116859;
UPDATE medicos SET apellidoP="Ramirez" WHERE matricula=16116859;
UPDATE medicos SET apellidoM="Flores" WHERE matricula=16116859;
UPDATE medicos SET telefono="7737864371" WHERE matricula=16116859;
UPDATE medicos SET domicilio="Av. Guillermo Prieto #34, Roma, CD.MX" WHERE matricula=16116859;
UPDATE medicos SET especialidad="Cirujano" WHERE matricula=16116859;
UPDATE medicos SET id_area=1 WHERE matricula=16116859;
UPDATE areas SET nombre_area="Cuidados intensivos" WHERE id_area=4;
UPDATE areas SET cupo=100 WHERE id_area=4;
SELECT * FROM pacientes;
SELECT * FROM medicos;
SELECT * FROM areas;
SELECT * FROM ingresos;
SELECT * FROM medico_paciente;
```
