-- -----------------------------------------------------
-- Table `JuridicApp`.`PEOPLE`
-- -----------------------------------------------------
-- INSERT INTO `JuridicApp`.`PEOPLE` (`document_type`, `id_number`, `first_names`, `last_names`, `email`)
--     VALUES (NULL, NULL, NULL, NULL, NULL);
INSERT INTO `JuridicApp`.`PEOPLE` (`document_type`, `id_number`, `first_names`, `last_names`, `email`)
    VALUES ('Cédula De Ciudadanía', '1022095657', 'Neiber De Jesús', 'Padierna Pérez', 'npadierna@gmail.com');
INSERT INTO `JuridicApp`.`PEOPLE` (`document_type`, `id_number`, `first_names`, `last_names`, `email`)
    VALUES ('Cédula De Extranjería', '1035859551', 'Miguel Ángel', 'Ossa Ruiz', 'migueldcold@gmail.com');
INSERT INTO `JuridicApp`.`PEOPLE` (`document_type`, `id_number`, `first_names`, `last_names`, `email`)
    VALUES ('Número Único De Identificación Personal', '1037622083', 'Andersson', 'García Sotelo', 'anderssongarciasotelo@gmail.com');
INSERT INTO `JuridicApp`.`PEOPLE` (`document_type`, `id_number`, `first_names`, `last_names`, `email`)
    VALUES ('Tarjeta De Identidad', '1039456678', 'Diana Patricia', 'Díaz Ramírez', 'd.diaz@gmail.com');
INSERT INTO `JuridicApp`.`PEOPLE` (`document_type`, `id_number`, `first_names`, `last_names`, `email`)
    VALUES ('Cédula De Ciudadanía', '1035859552', 'Diana', 'Lopez', 'dlopez3@gmail.com.com');

-- -----------------------------------------------------
-- Table `JuridicApp`.`AUTHOR`
-- -----------------------------------------------------
-- INSERT INTO `JuridicApp`.`AUTHOR` (`document_type`, `id_number`, `phone_number`, `mobile_number`)
--     VALUES (NULL, NULL, NULL, NULL);
INSERT INTO `JuridicApp`.`AUTHOR` (`document_type`, `id_number`, `phone_number`, `mobile_number`)
    VALUES ('Cédula De Extranjería', '1035859551', '0342891640', '3148510360');
INSERT INTO `JuridicApp`.`AUTHOR` (`document_type`, `id_number`, `phone_number`, `mobile_number`)
    VALUES ('Número Único De Identificación Personal', '1037622083', '0342695341', '3174169572');
INSERT INTO `JuridicApp`.`AUTHOR` (`document_type`, `id_number`, `phone_number`, `mobile_number`)
    VALUES ('Tarjeta De Identidad', '1039456678', NULL, NULL);
INSERT INTO `JuridicApp`.`AUTHOR` (`document_type`, `id_number`, `phone_number`, `mobile_number`)
    VALUES ('Cédula De Ciudadanía', '1022095657', '0343514856', '3113265833');


-- -----------------------------------------------------
-- Table `JuridicApp`.`DEPENDENCY`
-- -----------------------------------------------------
-- INSERT INTO `JuridicApp`.`DEPENDENCY` (`name`, `description`)
--    VALUES (NULL, NULL);
-- INSERT INTO `JuridicApp`.`DEPENDENCY` (`name`, `description`)
--     VALUES ('DRAI Facultad De Ingeniería', NULL);
INSERT INTO `JuridicApp`.`DEPENDENCY` (`name`, `description`)
    VALUES ('DRAI Facultad De Medicina', 'Departamentos de Recursos y Apoyo Didáctico (D.R.A.I.) para la Facultad de Medicina.');


-- -----------------------------------------------------
-- Table `JuridicApp`.`OEUVRE`
-- -----------------------------------------------------
-- INSERT INTO `JuridicApp`.`OEUVRE` (`id`, `title`, `description`, `dependency`)
--    VALUES (NULL, NULL, NULL, NULL);
INSERT INTO `JuridicApp`.`OEUVRE` (`title`, `description`, `dependency`)
    VALUES ('Algoritmia II', NULL, 'DRAI Facultad De Ingeniería');
INSERT INTO `JuridicApp`.`OEUVRE` (`title`, `description`, `dependency`)
    VALUES ('Algoritmia III', NULL, 'DRAI Facultad De Ingeniería');
INSERT INTO `JuridicApp`.`OEUVRE` (`title`, `description`, `dependency`)
    VALUES ('Genoma Humano', NULL, 'DRAI Facultad De Medicina');
INSERT INTO `JuridicApp`.`OEUVRE` (`title`, `description`, `dependency`)
    VALUES ('Sistema Sanguíneo Y Óseo', NULL, 'DRAI Facultad De Medicina');
INSERT INTO `JuridicApp`.`OEUVRE` (`title`, `description`, `dependency`)
    VALUES ('Geometría Vectorial', NULL, 'DRAI Facultad De Ingeniería');

-- -----------------------------------------------------
-- Table `JuridicApp`.`TITLE`
-- -----------------------------------------------------
-- INSERT INTO `JuridicApp`.`TITLE` (`profile`, `description`)
--     VALUES (NULL, NULL);


-- -----------------------------------------------------
-- Table `JuridicApp`.`ACQUISITION`
-- -----------------------------------------------------
-- INSERT INTO `JuridicApp`.`ACQUISITION` (`type`, `description`)
--     VALUES (NULL, NULL);


-- -----------------------------------------------------
-- Table `JuridicApp`.`DNDA`
-- -----------------------------------------------------
-- INSERT INTO `JuridicApp`.`DNDA` (`number`)
--     VALUES (NULL);
INSERT INTO `JuridicApp`.`DNDA` (`number`)
    VALUES ('12345');
INSERT INTO `JuridicApp`.`DNDA` (`number`)
    VALUES ('23456');
INSERT INTO `JuridicApp`.`DNDA` (`number`)
    VALUES ('34567');
INSERT INTO `JuridicApp`.`DNDA` (`number`)
    VALUES ('45678');
INSERT INTO `JuridicApp`.`DNDA` (`number`)
    VALUES ('56789');
INSERT INTO `JuridicApp`.`DNDA` (`number`)
    VALUES ('67890');
INSERT INTO `JuridicApp`.`DNDA` (`number`)
    VALUES ('09876');
INSERT INTO `JuridicApp`.`DNDA` (`number`)
    VALUES ('98765');
INSERT INTO `JuridicApp`.`DNDA` (`number`)
    VALUES ('87654');
INSERT INTO `JuridicApp`.`DNDA` (`number`)
    VALUES ('76543');
INSERT INTO `JuridicApp`.`DNDA` (`number`)
    VALUES ('65432');
INSERT INTO `JuridicApp`.`DNDA` (`number`)
    VALUES ('54321');

	
-- -----------------------------------------------------
-- Table `JuridicApp`.`CONTRACT`
-- -----------------------------------------------------
-- INSERT INTO `JuridicApp`.`CONTRACT` (`id`, `route`, `dnda`)
--    VALUES (NULL, NULL, NULL);
INSERT INTO `JuridicApp`.`CONTRACT` (`id`, `route`, `dnda`)
    VALUES ('12345', NULL, '12345');
INSERT INTO `JuridicApp`.`CONTRACT` (`id`, `route`, `dnda`)
    VALUES ('23456', NULL, NULL);
INSERT INTO `JuridicApp`.`CONTRACT` (`id`, `route`, `dnda`)
    VALUES ('34567', NULL, '23456');
INSERT INTO `JuridicApp`.`CONTRACT` (`id`, `route`, `dnda`)
    VALUES ('45678', NULL, '34567');
INSERT INTO `JuridicApp`.`CONTRACT` (`id`, `route`, `dnda`)
    VALUES ('56789', NULL, NULL);
INSERT INTO `JuridicApp`.`CONTRACT` (`id`, `route`, `dnda`)
    VALUES ('67890', NULL, '45678');


-- -----------------------------------------------------
-- Table `JuridicApp`.`SUPPORT`
-- -----------------------------------------------------
-- INSERT INTO `JuridicApp`.`SUPPORT` (`type`, `description`)
--     VALUES (NULL, NULL);


-- -----------------------------------------------------
-- Table `JuridicApp`.`COMMENT`
-- -----------------------------------------------------
-- INSERT INTO `JuridicApp`.`COMMENT` (`id`, `oeuvre_id`, `text`, `date_time`)
--    VALUES (NULL, NULL, NULL, NULL);
INSERT INTO `JuridicApp`.`COMMENT` (`oeuvre_id`, `text`, `date_time`)
   VALUES ('1', 'Comment for oeuvre #1', '2014-02-01 14:51:44');
INSERT INTO `JuridicApp`.`COMMENT` (`oeuvre_id`, `text`, `date_time`)
   VALUES ('1', 'Comment for oeuvre #1', '2014-02-02 14:51:44');
INSERT INTO `JuridicApp`.`COMMENT` (`oeuvre_id`, `text`, `date_time`)
   VALUES ('1', 'Comment for oeuvre #1', '2014-02-03 14:51:44');
INSERT INTO `JuridicApp`.`COMMENT` (`oeuvre_id`, `text`, `date_time`)
   VALUES ('2', 'Comment for oeuvre #2', '2014-02-04 14:51:44');
INSERT INTO `JuridicApp`.`COMMENT` (`oeuvre_id`, `text`, `date_time`)
   VALUES ('2', 'Comment for oeuvre #2', '2014-02-05 14:51:44');
INSERT INTO `JuridicApp`.`COMMENT` (`oeuvre_id`, `text`, `date_time`)
   VALUES ('2', 'Comment for oeuvre #2', '2014-02-06 14:51:44');
INSERT INTO `JuridicApp`.`COMMENT` (`oeuvre_id`, `text`, `date_time`)
   VALUES ('3', 'Comment for oeuvre #3', '2014-02-07 14:51:44');
INSERT INTO `JuridicApp`.`COMMENT` (`oeuvre_id`, `text`, `date_time`)
   VALUES ('3', 'Comment for oeuvre #3', '2014-02-08 14:51:44');
INSERT INTO `JuridicApp`.`COMMENT` (`oeuvre_id`, `text`, `date_time`)
   VALUES ('3', 'Comment for oeuvre #3', '2014-02-09 14:51:44');
INSERT INTO `JuridicApp`.`COMMENT` (`oeuvre_id`, `text`, `date_time`)
   VALUES ('4', 'Comment for oeuvre #4', '2014-02-10 14:51:44');
INSERT INTO `JuridicApp`.`COMMENT` (`oeuvre_id`, `text`, `date_time`)
   VALUES ('4', 'Comment for oeuvre #4', '2014-02-11 14:51:44');
INSERT INTO `JuridicApp`.`COMMENT` (`oeuvre_id`, `text`, `date_time`)
   VALUES ('4', 'Comment for oeuvre #4', '2014-02-12 14:51:44');
INSERT INTO `JuridicApp`.`COMMENT` (`oeuvre_id`, `text`, `date_time`)
   VALUES ('5', 'Comment for oeuvre #5', '2014-02-13 14:51:44');
INSERT INTO `JuridicApp`.`COMMENT` (`oeuvre_id`, `text`, `date_time`)
   VALUES ('5', 'Comment for oeuvre #5', '2014-02-14 14:51:44');
INSERT INTO `JuridicApp`.`COMMENT` (`oeuvre_id`, `text`, `date_time`)
   VALUES ('5', 'Comment for oeuvre #5', '2014-02-15 14:51:44');


-- -----------------------------------------------------
-- Table `JuridicApp`.`TYPE`
-- -----------------------------------------------------
-- INSERT INTO `JuridicApp`.`TYPE` (`name`, `description`)
--     VALUES (NULL, NULL);


-- -----------------------------------------------------
-- Table `JuridicApp`.`OEUVRE_TYPE`
-- -----------------------------------------------------
-- INSERT INTO `JuridicApp`.`OEUVRE_TYPE` (`oeuvre_id`, `type_name`)
--    VALUES (NULL, NULL);
INSERT INTO `JuridicApp`.`OEUVRE_TYPE` (`oeuvre_id`, `type_name`)
    VALUES (1, 'Composición Musical');
INSERT INTO `JuridicApp`.`OEUVRE_TYPE` (`oeuvre_id`, `type_name`)
    VALUES (2, 'Exposición (Conferencia)');
INSERT INTO `JuridicApp`.`OEUVRE_TYPE` (`oeuvre_id`, `type_name`)
    VALUES (2, 'Escrito');
INSERT INTO `JuridicApp`.`OEUVRE_TYPE` (`oeuvre_id`, `type_name`)
    VALUES (3, 'Obra Derivada');
INSERT INTO `JuridicApp`.`OEUVRE_TYPE` (`oeuvre_id`, `type_name`)
    VALUES (4, 'Programa De Ordenador (Software)');
INSERT INTO `JuridicApp`.`OEUVRE_TYPE` (`oeuvre_id`, `type_name`)
    VALUES (4, 'Audiovisual, Multimedia');
INSERT INTO `JuridicApp`.`OEUVRE_TYPE` (`oeuvre_id`, `type_name`)
    VALUES (4, 'Escrito');
INSERT INTO `JuridicApp`.`OEUVRE_TYPE` (`oeuvre_id`, `type_name`)
    VALUES (5, 'Obra Fotográfica');


-- -----------------------------------------------------
-- Table `JuridicApp`.`AUTHOR_OEUVRE`
-- -----------------------------------------------------
-- INSERT INTO `JuridicApp`.`AUTHOR_OEUVRE` (`oeuvre_type_id`, `oeuvre_type_name`, `document_type`, `id_number`, `contract`, `support_type`, `dnda`, `isbn`, `beginning`, `delivering`, `title`)
--     VALUES (NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `JuridicApp`.`AUTHOR_OEUVRE` (`oeuvre_type_id`, `oeuvre_type_name`, `document_type`, `id_number`, `contract`, `support_type`, `dnda`, `isbn`, `beginning`, `delivering`, `title`)
    VALUES (1, 'Composición Musical', 'Cédula De Extranjería', '1035859551', '12345', 'Digital', '56789', '123456789', '2014-03-03', '2014-03-03', 'Externo');
INSERT INTO `JuridicApp`.`AUTHOR_OEUVRE` (`oeuvre_type_id`, `oeuvre_type_name`, `document_type`, `id_number`, `contract`, `support_type`, `dnda`, `isbn`, `beginning`, `delivering`, `title`)
    VALUES (2, 'Exposición (Conferencia)', 'Número Único De Identificación Personal', '1037622083', '23456', 'Físico', NULL, '987654321', '2014-03-03', '2014-03-03', 'Empleado De Carrera');
INSERT INTO `JuridicApp`.`AUTHOR_OEUVRE` (`oeuvre_type_id`, `oeuvre_type_name`, `document_type`, `id_number`, `contract`, `support_type`, `dnda`, `isbn`, `beginning`, `delivering`, `title`)
    VALUES (2, 'Escrito', 'Número Único De Identificación Personal', '1037622083', '23456', 'Digital', NULL, NULL, '2014-03-03', '2014-03-03', 'Empleado Provisional');
INSERT INTO `JuridicApp`.`AUTHOR_OEUVRE` (`oeuvre_type_id`, `oeuvre_type_name`, `document_type`, `id_number`, `contract`, `support_type`, `dnda`, `isbn`, `beginning`, `delivering`, `title`)
    VALUES (3, 'Obra Derivada', 'Tarjeta De Identidad', '1039456678', '34567', 'Digital', '67890', '654987321', '2014-03-03', '2014-03-03', 'Empleado Provisional');
INSERT INTO `JuridicApp`.`AUTHOR_OEUVRE` (`oeuvre_type_id`, `oeuvre_type_name`, `document_type`, `id_number`, `contract`, `support_type`, `dnda`, `isbn`, `beginning`, `delivering`, `title`)
    VALUES (4, 'Programa De Ordenador (Software)', 'Cédula De Ciudadanía', '1022095657', '56789', 'Físico', NULL, NULL, '2014-03-03', '2014-03-03', 'Profesor Visitante');
INSERT INTO `JuridicApp`.`AUTHOR_OEUVRE` (`oeuvre_type_id`, `oeuvre_type_name`, `document_type`, `id_number`, `contract`, `support_type`, `dnda`, `isbn`, `beginning`, `delivering`, `title`)
    VALUES (4, 'Audiovisual, Multimedia', 'Cédula De Ciudadanía', '1022095657', '56789', 'Digital', '09876', '321654987', '2014-03-03', '2014-03-03', 'Profesor Visitante');
INSERT INTO `JuridicApp`.`AUTHOR_OEUVRE` (`oeuvre_type_id`, `oeuvre_type_name`, `document_type`, `id_number`, `contract`, `support_type`, `dnda`, `isbn`, `beginning`, `delivering`, `title`)
    VALUES (4, 'Escrito', 'Cédula De Extranjería', '1035859551', '67890', 'Digital', NULL, '951847263', '2014-03-03', '2014-03-03', 'No Aplica');
INSERT INTO `JuridicApp`.`AUTHOR_OEUVRE` (`oeuvre_type_id`, `oeuvre_type_name`, `document_type`, `id_number`, `contract`, `support_type`, `dnda`, `isbn`, `beginning`, `delivering`, `title`)
    VALUES (5, 'Obra Fotográfica', 'Tarjeta De Identidad', '1039456678', '67890', 'Físico', '98765', NULL, '2014-03-03', '2014-03-03', 'Empleado De Libre Nombramiento');


-- -----------------------------------------------------
-- Table `JuridicApp`.`PROFILE`
-- -----------------------------------------------------
-- INSERT INTO `JuridicApp`.`PROFILE` (`title`, `description`)
--     VALUES (NULL, NULL);
-- INSERT INTO `JuridicApp`.`PROFILE` (`title`, `description`)
--     VALUES ('Administrador', NULL);
-- INSERT INTO `JuridicApp`.`PROFILE` (`title`, `description`)
--     VALUES ('Gestor De Contratos', NULL);

-- -----------------------------------------------------
-- Table `JuridicApp`.`CLIENT`
-- -----------------------------------------------------
-- INSERT INTO `JuridicApp`.`CLIENT` (`document_type`, `id_number`, `user_name`, `password`, `title`, `dependency`)
--     VALUES (NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `JuridicApp`.`CLIENT` (`document_type`, `id_number`, `user_name`, `password`, `title`, `dependency`)
    VALUES ('Cédula De Ciudadanía', '1022095657', 'neiber.padierna', 'neiber123', 'Administrador', 'DRAI Facultad De Ingeniería');
INSERT INTO `JuridicApp`.`CLIENT` (`document_type`, `id_number`, `user_name`, `password`, `title`, `dependency`)
    VALUES ('Cédula De Extranjería', '1035859551', 'miguel.ossa', 'coldlomejor', 'Gestor De Contratos', 'DRAI Facultad De Medicina');
INSERT INTO `JuridicApp`.`CLIENT` (`document_type`, `id_number`, `user_name`, `password`, `title`, `dependency`)
    VALUES ('Cédula De Ciudadanía', '1035859552', 'admin', 'admin', 'Administrador', 'DRAI Facultad De Medicina');
INSERT INTO `JuridicApp`.`CLIENT` (`document_type`, `id_number`, `user_name`, `password`, `title`, `dependency`)
    VALUES ('Número Único De Identificación Personal', '1037622083', 'anderber', 'Anderber', 'Consultor', 'DRAI Facultad De Medicina');

-- -----------------------------------------------------
-- Table `JuridicApp`.`AUTHOR_OEUVRE_ACQUISITION_FILE`
-- -----------------------------------------------------
-- INSERT INTO `JuridicApp`.`AUTHOR_OEUVRE_ACQUISITION_FILE` (`acquisition`, `oeuvre_type_id`, `oeuvre_type_name`, `document_type`, `id_number`, `contract`, `route`)
--     VALUES (NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `JuridicApp`.`AUTHOR_OEUVRE_ACQUISITION_FILE` (`acquisition`, `oeuvre_type_id`, `oeuvre_type_name`, `document_type`, `id_number`, `contract`, `route`)
    VALUES ('Autorización', 1, 'Composición Musical', 'Cédula De Extranjería', '1035859551', '12345', 'file_name_1.pdf');
INSERT INTO `JuridicApp`.`AUTHOR_OEUVRE_ACQUISITION_FILE` (`acquisition`, `oeuvre_type_id`, `oeuvre_type_name`, `document_type`, `id_number`, `contract`, `route`)
    VALUES ('Contrato De Obra Por Encargo', 2, 'Exposición (Conferencia)', 'Número Único De Identificación Personal', '1037622083', '23456', 'file_name_2.iso');
INSERT INTO `JuridicApp`.`AUTHOR_OEUVRE_ACQUISITION_FILE` (`acquisition`, `oeuvre_type_id`, `oeuvre_type_name`, `document_type`, `id_number`, `contract`, `route`)
    VALUES ('Licencia De Software', 2, 'Escrito', 'Número Único De Identificación Personal', '1037622083', '23456', 'file_name_3.rar');
INSERT INTO `JuridicApp`.`AUTHOR_OEUVRE_ACQUISITION_FILE` (`acquisition`, `oeuvre_type_id`, `oeuvre_type_name`, `document_type`, `id_number`, `contract`, `route`)
    VALUES ('Licencia Creative Commons', 3, 'Obra Derivada', 'Tarjeta De Identidad', '1039456678', '34567', 'file_name_4.png');
INSERT INTO `JuridicApp`.`AUTHOR_OEUVRE_ACQUISITION_FILE` (`acquisition`, `oeuvre_type_id`, `oeuvre_type_name`, `document_type`, `id_number`, `contract`, `route`)
    VALUES ('Autorización', 4, 'Programa De Ordenador (Software)', 'Cédula De Ciudadanía', '1022095657', '56789', 'file_name_5.docx');
INSERT INTO `JuridicApp`.`AUTHOR_OEUVRE_ACQUISITION_FILE` (`acquisition`, `oeuvre_type_id`, `oeuvre_type_name`, `document_type`, `id_number`, `contract`, `route`)
    VALUES ('Presunción Legal Plan De Trabajo', 4, 'Audiovisual, Multimedia', 'Cédula De Ciudadanía', '1022095657', '56789', 'file_name_6.zip');
INSERT INTO `JuridicApp`.`AUTHOR_OEUVRE_ACQUISITION_FILE` (`acquisition`, `oeuvre_type_id`, `oeuvre_type_name`, `document_type`, `id_number`, `contract`, `route`)
    VALUES ('Licencia Creative Commons', 4, 'Escrito', 'Cédula De Extranjería', '1035859551', '67890', 'file_name_7.pptx');
INSERT INTO `JuridicApp`.`AUTHOR_OEUVRE_ACQUISITION_FILE` (`acquisition`, `oeuvre_type_id`, `oeuvre_type_name`, `document_type`, `id_number`, `contract`, `route`)
    VALUES ('Contrato De Cesión De Derechos', 5, 'Obra Fotográfica', 'Tarjeta De Identidad', '1039456678', '67890', 'file_name_8.xls');