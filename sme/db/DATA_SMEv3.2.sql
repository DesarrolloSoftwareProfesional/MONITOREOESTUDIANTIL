use BD_SGMEv3;

-- insert into perfiles(nomPerfil,estadoRegistro)
-- values('Director',1),
-- ('Secretaria',1),
-- ('Apoderado',1),
-- ('Alumno',1);

insert into alumnos(apPaternoAlumno,apMaternoAlumno,nombresAlumno,dniAlumno,fechaNacAlumno,direccionAlumno,nomCompleto,estadoRegistro)
values
('Palomino','Rojas','Jober Abel','54875421','1987-05-12','Av.Los jardines 452','Palomino Rojas Jober Abel',1),
('Fabian','Garcia','Ronald','85425425','1996-05-12','Av.Los jardines 452','Fabian Garcia Ronald',1),
('Aruhanca','Vilca','Jhonatan','70034427','1995-09-17','Av.Canto Grande 954','Aruhanca Vilca Jhonatan',1),
('Lalangui','Yarame','Carmen','71484790','1997-08-05','Av.Canto grande 1542','Lalangui Yarame Carmen',1),
('Vidaurre','Sangama','Maria','62300639','1998-03-12','Av.Piramides del Sol 352','Vidaurre Sangama Maria',1),
('Hermitaño','Salas','Manuel','47891831','1996-07-14','Av.Proceres  322','Hermitaño Salas Manuel',1),
('Sosa','Manya','Juan','42425846','1997-09-21','Av.Las Flores 5482','Sosa Manya Juan',1),
('Diaz','Juarez','Jhercy','70197418','1998-03-11','Av.Miraflores 4521','Diaz Juarez Jhercy',1),
('Sanchez','Elizalde','Carmen','76578821','1995-11-12','Av.Los Amautas 4528','Sanchez Elizalde Carmen',1),
('Moriano','Yola','Juliany','70123464','1997-10-17','Av.Wisse 84','Moriano Yola Juliany',1),
('Rojas','Fernandez','Gladis','71059247','1996-02-19','Av.Canto rey 9686','Rojas Fernandez Gladis',1),
('Casabona','Tarrillo','Percy','46115254','1998-07-12','Av.San martin2154','Casabona Tarrillo Percy',1),
('Tacuman','Rondo','Miguel','18896961','1998-09-16','Av.Primavera 4582','Tucuman Rondo Miguel',1),
('Palacios','Garcia','Edgar','47302501','1996-02-12','Av.Los soldados 4754','Palacios Garcia Edgar',1),
('Lopez','Caceres','Sergio','73867264','1996-05-12','Av.La libertad 6585','Lopez Caceres Sergio',1),
('Calmet','Farroñan','Jose','48845708','1997-10-12','Av.Abancay 7845','Calmet Farroñan Jose',1);


insert into Usuario_Alumno(idAlumno,userAlumno,passAlumno,estadoRegistro)
values(1,'pabel','pabel',1),
(2,'fronald','fronald',1),
(3,'ajhonatan','ajhonatan',1),
(4,'lcarmen','lcarmen',1),
(5,'vmaria','vmaria',1),
(6,'hmanuel','hmanuel',1),
(7,'sjuan','sjuan',1),
(8,'djhercy','djhercy',1),
(9,'scarmen','scarmen',1),
(10,'mjuliany','mjuliany',1),
(11,'rgladis','rgladis',1),
(12,'cpercy','cpercy',1),
(13,'tmiguel','tmiguel',1),
(14,'pedgar','pedgar',1),
(15,'lsergio','lsergio',1);


insert into grados(nomGrado,estadoRegistro) values
('Primero',1),
('Segundo',1),
('Tercero',1),
('Cuarto',1),
('Quinto',1);
-- ('Sexto',1);

insert into secciones(codSeccion,estadoRegistro) values
('A',1),
('B',1),
('C',1),
('D',1),
('E',1);

-- insert into cursos(nomCurso,estadoRegistro)values
-- ('Historia',1),
-- ('Geografia',1),
-- ('Matematica',1),
-- ('Lengua',1),
-- ('Quimica',1),
-- ('Biologia',1),
-- ('Civica',1),
-- ('Fisica',1),
-- ('Ingles',1),
-- ('Contabilidad',1),
-- ('Psicologia',1),
-- ('Educacion Fisica',1),
-- ('Religion',1),
-- ('Computacion',1);

insert into cursos(nomCurso,abrevCurso)values
('Desarrollo Personal, Ciudananía y Cívica','DPCC'),
('Ciencias Sociales','CcSs'),
('Educación Fisica','EFis'),
('Arte y Cultura','ArtC'),
('Comunicación','Ccc'),
('Castellano como Segunda Lengua','CcSL'),
('Ingles como Lengua Extranjera','IcLE'),
('Matematica','Mat'),
('Ciencia y Tecnología','CTec'),
('Educación para el Trabajo','EpT'),
('Educación Relegiosa','ERel');


insert into grupoacademico(codGrupoAcademico,idGrado,codSeccion,anio) values
('1A2017',1,'A',2017),
('1B2017',1,'B',2017),
('1C2017',1,'C',2017),
('1D2017',1,'D',2017),
('1E2017',1,'E',2017),

('2A2017',2,'A',2017),
('2B2017',2,'B',2017),
('2C2017',2,'C',2017),
('2D2017',2,'D',2017),
('2E2017',2,'E',2017),

('3A2017',3,'A',2017),
('3B2017',3,'B',2017),
('3C2017',3,'C',2017),
('3D2017',3,'D',2017),
('3E2017',3,'E',2017),

('4A2017',4,'A',2017),
('4B2017',4,'B',2017),
('4C2017',4,'C',2017),
('4D2017',4,'D',2017),
('4E2017',4,'E',2017),

('5A2017',5,'A',2017),
('5B2017',5,'B',2017),
('5C2017',5,'C',2017),
('5D2017',5,'D',2017),
('5E2017',5,'E',2017);

-- ('6A2017',6,'A',2017),
-- ('6B2017',6,'B',2017),
-- ('6C2017',6,'C',2017),
-- ('6D2017',6,'D',2017),
-- ('6E2017',6,'E',2017);


insert into alumnos_grupoacademico(idAlumno, codGrupoAcademico ,estadoRegistro) values
(1,'5C2017',1),
(2,'3C2017',1),
(3,'4D2017',1),
(4,'5C2017',1),
(5,'4E2017',1),
(6,'5C2017',1),
(7,'4B2017',1),
(8,'2A2017',1),
(9,'1E2017',1),
(10,'5C2017',1),
(11,'5C2017',1),
(12,'4C2017',1),
(13,'4C2017',1),
(14,'5C2017',1),
(15,'3D2017',1);


insert into Periodos(anio,trimestre,fechaIni,fechaFin,estadoRegistro) values
(2017,1,'2017-03-13','2017-06-09',1),
(2017,2,'2017-06-12','2017-09-08',1),
(2017,3,'2017-09-11','2017-12-15',1);

insert into cargos(nomCargo,estadoRegistro) values
('Director',1),
('Secretaria',1),
('Profesor',1),
('Administrador',1);
-- ('Apoderado',1),
-- ('Alumno',1),



-- insert into detalleacademico(idGrado,codSeccion,idPeriodo) values
-- (1,'D',1),
-- (2,'A',3),
-- (2,'B',2),
-- (1,'C',2),
-- (2,'D',1),
-- (4,'E',3),
-- (6,'B',2),
-- (4,'A',1),
-- (3,'D',2);


insert into empleados(idCargo,apPaternoEmpleado,apMaternoEmpleado, nombresEmpleado, dniEmpleado ,fechaNacEmpleado ,direccionEmpleado, nomCompleto,estadoRegistro) values
(1,'Acuña','Trujillo','Rosis','43577508','1887-05-22','Av.Larcomar 4523','Acuña Trujillo Rosis',1),
(2,'Jara','Morales','Blanca','15764855','1887-03-15','Av.Jasmines 4523','Jara Morales Blanca',1),
(3,'Saldaña','Suclupe','Sara','45550509','1887-02-12','Av.Canto Rey 658','Saldaña Suclupe Sara',1),
(3,'Collantes','Quiche','Patricia','47575913','1887-06-05','Av.Las Flores 683','Collantes Quiche Patricia',1),
(4,'Huaman','Berrospi','Onoria','80283699','1887-10-12','Av.Canto Grande 423','Huaman Berrospi Onoria',1);


insert into usuario_empleado(idEmpleado, userEmpleado, passEmpleado, estadoRegistro) values
(1,'arosis','',1),
(2,'jblanca','jblanca',1),
(3,'ssara','ssara',1),
(4,'cpatricia','cpatricia',1),
(5,'honoria','honoria',1);

insert into tiponotas(nomTipoNota, estadoRegistro) values
('Ex Continuo 1',1),
('Ex Continuo 2',1),
('Ex Continuo 3',1),
('Ex Parcial',1),
('Ex Final',1);

insert into notas(idAlumno,idCurso,idPeriodo,idEmpleado,idTipoNota,nota,estadoRegistro) values
(1,1,1,1,2,18,1),
(1,2,1,1,2,15,1),
(1,3,1,1,2,19,1),
(1,4,1,1,2,12,1),
(1,5,1,1,2,08,1),
(1,6,1,1,2,12,1),
(1,7,1,1,2,15,1),
(1,8,1,1,2,14,1),
(1,9,1,1,2,17,1),
(1,10,1,1,2,18,1),
(1,11,1,1,2,15,1);

insert into notas(idAlumno,idCurso,idPeriodo,idEmpleado,idTipoNota,nota,estadoRegistro) values
(1,1,1,1,1,18,1),
(1,2,1,1,1,15,1),
(1,3,1,1,1,19,1),
(1,4,1,1,1,12,1),
(1,5,1,1,1,08,1),
(1,6,1,1,1,12,1),
(1,7,1,1,1,15,1),
(1,8,1,1,1,14,1),
(1,9,1,1,1,17,1),
(1,10,1,1,1,18,1),
(1,11,1,1,1,15,1),

-- (1,12,1,1,1,12,1),
-- (1,13,1,1,1,08,1),
-- (1,14,1,1,1,12,1),

(2,1,1,1,1,18,1),
(2,2,1,1,1,15,1),
(2,3,1,1,1,19,1),
(2,4,1,1,1,12,1),
(2,5,1,1,1,08,1),
(2,6,1,1,1,12,1),
(2,7,1,1,1,15,1),
(2,8,1,1,1,14,1),
(2,9,1,1,1,17,1),
(2,10,1,1,1,18,1),
(2,11,1,1,1,15,1),
-- (2,12,1,1,1,12,1),
-- (2,13,1,1,1,08,1),
-- (2,14,1,1,1,12,1),

(3,1,1,1,1,18,1),
(3,2,1,1,1,15,1),
(3,3,1,1,1,19,1),
(3,4,1,1,1,12,1),
(3,5,1,1,1,08,1),
(3,6,1,1,1,12,1),
(3,7,1,1,1,15,1),
(3,8,1,1,1,14,1),
(3,9,1,1,1,17,1),
(3,10,1,1,1,18,1),
(3,11,1,1,1,15,1),
-- (3,12,1,1,1,12,1),
-- (3,13,1,1,1,08,1),
-- (3,14,1,1,1,12,1),

(4,1,1,1,1,18,1),
(4,2,1,1,1,15,1),
(4,3,1,1,1,19,1),
(4,4,1,1,1,12,1),
(4,5,1,1,1,08,1),
(4,6,1,1,1,12,1),
(4,7,1,1,1,15,1),
(4,8,1,1,1,14,1),
(4,9,1,1,1,17,1),
(4,10,1,1,1,18,1),
(4,11,1,1,1,15,1),
-- (4,12,1,1,1,12,1),
-- (4,13,1,1,1,08,1),
-- (4,14,1,1,1,12,1),

(5,1,1,1,1,18,1),
(5,2,1,1,1,15,1),
(5,3,1,1,1,19,1),
(5,4,1,1,1,12,1),
(5,5,1,1,1,08,1),
(5,6,1,1,1,12,1),
(5,7,1,1,1,15,1),
(5,8,1,1,1,14,1),
(5,9,1,1,1,17,1),
(5,10,1,1,1,18,1),
(5,11,1,1,1,15,1),
-- (5,12,1,1,1,12,1),
-- (5,13,1,1,1,08,1),
-- (5,14,1,1,1,12,1),

(6,1,1,1,1,18,1),
(6,2,1,1,1,15,1),
(6,3,1,1,1,19,1),
(6,4,1,1,1,12,1),
(6,5,1,1,1,08,1),
(6,6,1,1,1,12,1),
(6,7,1,1,1,15,1),
(6,8,1,1,1,14,1),
(6,9,1,1,1,17,1),
(6,10,1,1,1,18,1),
(6,11,1,1,1,15,1),
-- (6,12,1,1,1,12,1),
-- (6,13,1,1,1,08,1),
-- (6,14,1,1,1,12,1),

(7,1,1,1,1,18,1),
(7,2,1,1,1,15,1),
(7,3,1,1,1,19,1),
(7,4,1,1,1,12,1),
(7,5,1,1,1,08,1),
(7,6,1,1,1,12,1),
(7,7,1,1,1,15,1),
(7,8,1,1,1,14,1),
(7,9,1,1,1,17,1),
(7,10,1,1,1,18,1),
(7,11,1,1,1,15,1),
-- (7,12,1,1,1,12,1),
-- (7,13,1,1,1,08,1),
-- (7,14,1,1,1,12,1),

(8,1,1,1,1,18,1),
(8,2,1,1,1,15,1),
(8,3,1,1,1,19,1),
(8,4,1,1,1,12,1),
(8,5,1,1,1,08,1),
(8,6,1,1,1,12,1),
(8,7,1,1,1,15,1),
(8,8,1,1,1,14,1),
(8,9,1,1,1,17,1),
(8,10,1,1,1,18,1),
(8,11,1,1,1,15,1),
-- (8,12,1,1,1,12,1),
-- (8,13,1,1,1,08,1),
-- (8,14,1,1,1,12,1),

(9,1,1,1,1,18,1),
(9,2,1,1,1,15,1),
(9,3,1,1,1,19,1),
(9,4,1,1,1,12,1),
(9,5,1,1,1,08,1),
(9,6,1,1,1,12,1),
(9,7,1,1,1,15,1),
(9,8,1,1,1,14,1),
(9,9,1,1,1,17,1),
(9,10,1,1,1,18,1),
(9,11,1,1,1,15,1);
-- (9,12,1,1,1,12,1),
-- (9,13,1,1,1,08,1),
-- (9,14,1,1,1,12,1);

insert into apoderados(apPaternoApoderado,apMaternoApoderado,nombresApoderado,dniApoderado,fechaNacApoderado,direccionApoderado,nomCompleto,estadoRegistro) values
('Saavedra','Menor','Hebert','71059247','1982-05-12','Av.Los Portales 856','Saavedra Menor Hebert',1),
('Cedron','Cabrera','Jose','46115254','1980-02-11','Av.Girasoles 123','Cedron Cabrera Jose',1),
('Diaz','Durand','Deyner','18896961','1987-08-05','Av.Los Amautas 213','Diaz Durand Deyner',1),
('Ordoñez','Cancho','Sadith','47302501','1972-12-12','Av.Villaflores 5321','Ordoñez Cancho Sadith',1),
('Hurtado','Mendoza','Naysha','73867264','1970-03-15','Av.Miguel Grau 1234','Hurtado Mendoza Naysha',1),
('Gutierrez','Tapullima','Llac','48845708','1982-05-17','Av.Abancay 2353','Gutierrez Tapullima Llac',1),
('Arevalo','Del castillo','Isaias','47515181','1982-03-12','Av.Mexico 3423','Arevalo Del castillo Isaias',1),
('Gutierrez','Huaraca','Jesus','45906631','1982-05-19','Av.La republica 1234','Gutierrez Huaraca Jesus',1),
('Ruiz','Shapiama','Alfonso','44831936','1982-05-20','Av.Argentina 3435','Ruiz Shapiama Alfonso',1),
('Rodriguez','Ortiz','Edwin','75420840','1982-05-21','Av.Canada 4587','Rodriguez Ortiz Edwin',1),
('Espino','Joo','Lucas','74580285','1982-05-22','Av.Brasil 2333','Espino Joo Lucas',1),
('Bautista','Perez','Javier','72324734','1982-05-23','Av.Arequipa 1234','Bautista Perez Javier',1),
('Villanueva','Vergara','Nemias','44985911','1982-05-24','Av.Salaverry 3453','Villanueva Vergara Nemias',1),
('Garrido','Palomares','Jose','75716350','1982-05-25','Av.Proceres 3234','Garrido Palomares Jose',1),
('Sanchez','Chorres','Tomas','41943596','1982-05-26','Av.Canto grande 1243','Sanchez Chorres Tomas',1);


insert into usuario_apoderado(idApoderado,userApoderado,passApoderado,estadoRegistro) values
(1,'shebert','shebert',1),
(2,'cjose','cjose',1),
(3,'ddeyner','ddeyner',1),
(4,'osadith','osadith',1),
(5,'hnaysha','hnaysha',1),
(6,'gllac','gllac',1),
(7,'aisaias','aisaias',1),
(8,'gjesus','gjesus',1),
(9,'ralfonso','ralfonso',1),
(10,'redwin','redwin',1),
(11,'elucas','elucas',1),
(12,'bjavier','bjavier',1),
(13,'vnemias','vnemias',1),
(14,'gjose','gjose',1),
(15,'stomas','stomas',1);


insert into alumnos_apoderados(idAlumno,idApoderado) values
(1,1),
(2,2),
(3,3),
(4,4),
(5,5),
(6,6),
(7,7),
(8,8),
(9,9),
(10,10),
(11,11),
(12,12),
(13,13),
(14,14),
(15,15);

insert into actividades(idEmpleado,idCurso,codGrupoAcademico,NomActividad,DescrActividad,fechaRealizacion,HoraInicio,HoraFin,frecuenciaAviso,Flag_Notificado) values
(2,1,'1A2017','Examen','Examen parcial, nota final para el registro en la libreta.','2017-04-28','08:30:00','10:00:00',1,1),
(2,2,'2B2017','Practica Calificada','Estudiar ultimos temas aprendidos.','2017-04-28','08:30:00','10:00:00',1,1),
(2,3,'2C2017','Examen','Examen parcial, nota final para el registro en la libreta.','2017-04-28','08:30:00','10:00:00',1,1),
(2,4,'4D2017','Examen','Examen parcial, nota final para el registro en la libreta.','2017-04-28','08:30:00','10:00:00',1,1),
(2,5,'2E2017','Practica Calificada','Estudiar ultimos temas aprendidos.','2017-04-28','08:30:00','10:00:00',1,1),
(2,6,'3A2017','Examen','Examen parcial, nota final para el registro en la libreta.','2017-04-28','08:30:00','10:00:00',1,1),
(2,7,'1E2017','Practica Calificada','Estudiar ultimos temas aprendidos.','2017-04-28','08:30:00','10:00:00',1,1),
(2,8,'4C2017','Practica Calificada','Estudiar ultimos temas aprendidos.','2017-04-28','08:30:00','10:00:00',1,1),
(3,2,'4C2017','Practica Calificada','Estudiar ultimos temas aprendidos.','2017-05-02','08:30:00','10:00:00',1,1),
(2,9,'2B2017','Examen','Examen parcial, nota final para el registro en la libreta.','2017-04-28','08:30:00','10:00:00',1,1);
