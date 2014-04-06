-- -----------------------------------------------------
-- Table `JuridicApp`.`PEOPLE`
-- -----------------------------------------------------
-- INSERT INTO `JuridicApp`.`PEOPLE` (`document_type`, `id_number`, `first_names`, `last_names`, `email`)
--     VALUES (NULL, NULL, NULL, NULL, NULL);
INSERT INTO `JuridicApp`.`PEOPLE` (`document_type`, `id_number`, `first_names`, `last_names`, `email`)
    VALUES ('Cédula de Ciudadanía', '1022095657', 'Neiber de Jesús', 'Padierna Pérez', 'npadierna@gmail.com');
INSERT INTO `JuridicApp`.`PEOPLE` (`document_type`, `id_number`, `first_names`, `last_names`, `email`)
    VALUES ('Cédula de Extranjería', '1035859551', 'Miguel Ángel', 'Ossa Ruiz', 'migueldcold@gmail.com');
INSERT INTO `JuridicApp`.`PEOPLE` (`document_type`, `id_number`, `first_names`, `last_names`, `email`)
    VALUES ('Número Único de Identificación Personal', '1037622083', 'Andersson', 'García Sotelo', 'anderssongarciasotelo@gmail.com');
INSERT INTO `JuridicApp`.`PEOPLE` (`document_type`, `id_number`, `first_names`, `last_names`, `email`)
    VALUES ('Tarjeta de Identidad', '1039456678', 'Diana Patricia', 'Díaz Ramírez', 'd.diaz@gmail.com');
INSERT INTO `JuridicApp`.`PEOPLE` (`document_type`, `id_number`, `first_names`, `last_names`, `email`)
    VALUES ('Cédula de Ciudadanía', '1035859552', 'Diana', 'Lopez', 'dlopez3@gmail.com.com');

-- -----------------------------------------------------
-- Table `JuridicApp`.`AUTHOR`
-- -----------------------------------------------------
-- INSERT INTO `JuridicApp`.`AUTHOR` (`document_type`, `id_number`, `phone_number`, `mobile_number`)
--     VALUES (NULL, NULL, NULL, NULL);
INSERT INTO `JuridicApp`.`AUTHOR` (`document_type`, `id_number`, `phone_number`, `mobile_number`)
    VALUES ('Cédula de Extranjería', '1035859551', '0342891640', '3148510360');
INSERT INTO `JuridicApp`.`AUTHOR` (`document_type`, `id_number`, `phone_number`, `mobile_number`)
    VALUES ('Número Único de Identificación Personal', '1037622083', '0342695341', '3174169572');
INSERT INTO `JuridicApp`.`AUTHOR` (`document_type`, `id_number`, `phone_number`, `mobile_number`)
    VALUES ('Tarjeta de Identidad', '1039456678', NULL, NULL);
INSERT INTO `JuridicApp`.`AUTHOR` (`document_type`, `id_number`, `phone_number`, `mobile_number`)
    VALUES ('Cédula de Ciudadanía', '1022095657', '0343514856', '3113265833');


-- -----------------------------------------------------
-- Table `JuridicApp`.`DEPENDENCY`
-- -----------------------------------------------------
-- INSERT INTO `JuridicApp`.`DEPENDENCY` (`name`, `description`)
--    VALUES (NULL, NULL);


-- -----------------------------------------------------
-- Table `JuridicApp`.`OEUVRE`
-- -----------------------------------------------------
-- INSERT INTO `JuridicApp`.`OEUVRE` (`id`, `title`, `description`, `dependency`)
--    VALUES (NULL, NULL, NULL, NULL);
INSERT INTO `JuridicApp`.`OEUVRE` (`title`, `description`, `dependency`)
    VALUES ('Algoritmia II', NULL, 'Ingeniería de Sistemas');
INSERT INTO `JuridicApp`.`OEUVRE` (`title`, `description`, `dependency`)
    VALUES ('Algoritmia III', NULL, 'Ingeniería de Sistemas');
INSERT INTO `JuridicApp`.`OEUVRE` (`title`, `description`, `dependency`)
    VALUES ('Genoma Humano', NULL, 'Facultad de Comunicaciones');
INSERT INTO `JuridicApp`.`OEUVRE` (`title`, `description`, `dependency`)
    VALUES ('Sistema Sanguíneo y Óseo', NULL, 'Facultad de Comunicaciones');
INSERT INTO `JuridicApp`.`OEUVRE` (`title`, `description`, `dependency`)
    VALUES ('Geometría Vectorial', NULL, 'Ingeniería de Sistemas');

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
-- INSERT INTO `JuridicApp`.`CONTRACT` (`id`, `route`, `dnda`, `beginning`, `delivering`)
--    VALUES (NULL, NULL, NULL, NULL, NULL);
INSERT INTO `JuridicApp`.`CONTRACT` (`id`, `route`, `dnda`, `beginning`, `delivering`)
    VALUES ('12345', NULL, '12345', '2014-03-03', '2014-03-03');
INSERT INTO `JuridicApp`.`CONTRACT` (`id`, `route`, `dnda`, `beginning`, `delivering`)
    VALUES ('23456', NULL, NULL, '2014-02-02', '2014-02-02');
INSERT INTO `JuridicApp`.`CONTRACT` (`id`, `route`, `dnda`, `beginning`, `delivering`)
    VALUES ('34567', NULL, '23456', '2014-01-01', '2014-01-01');
INSERT INTO `JuridicApp`.`CONTRACT` (`id`, `route`, `dnda`, `beginning`, `delivering`)
    VALUES ('45678', NULL, '34567', '2014-04-04', '2014-04-04');
INSERT INTO `JuridicApp`.`CONTRACT` (`id`, `route`, `dnda`, `beginning`, `delivering`)
    VALUES ('56789', NULL, NULL, '2014-05-05', '2014-05-05');
INSERT INTO `JuridicApp`.`CONTRACT` (`id`, `route`, `dnda`, `beginning`, `delivering`)
    VALUES ('67890', NULL, '45678', '2014-06-06', '2014-06-06');


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
    VALUES (4, 'Programa de Ordenador (Software)');
INSERT INTO `JuridicApp`.`OEUVRE_TYPE` (`oeuvre_id`, `type_name`)
    VALUES (4, 'Audiovisual, Multimedia');
INSERT INTO `JuridicApp`.`OEUVRE_TYPE` (`oeuvre_id`, `type_name`)
    VALUES (4, 'Escrito');
INSERT INTO `JuridicApp`.`OEUVRE_TYPE` (`oeuvre_id`, `type_name`)
    VALUES (5, 'Obra Fotográfica');


-- -----------------------------------------------------
-- Table `JuridicApp`.`AUTHOR_OEUVRE`
-- -----------------------------------------------------
-- INSERT INTO `JuridicApp`.`AUTHOR_OEUVRE` (`oeuvre_type_id`, `oeuvre_type_name`, `document_type`, `id_number`, `contract`, `acquisition`, `support_type`, `dnda`, `isbn`, `title`, `route`)
--    VALUES (NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `JuridicApp`.`AUTHOR_OEUVRE` (`oeuvre_type_id`, `oeuvre_type_name`, `document_type`, `id_number`, `contract`, `acquisition`, `support_type`, `dnda`, `isbn`, `title`, `route`)
    VALUES (1, 'Composición Musical', 'Cédula de Extranjería', '1035859551', '12345', 'Autorización', 'Digital', '56789', '123456789', 'Externo', 'file_name_1.pdf');
INSERT INTO `JuridicApp`.`AUTHOR_OEUVRE` (`oeuvre_type_id`, `oeuvre_type_name`, `document_type`, `id_number`, `contract`, `acquisition`, `support_type`, `dnda`, `isbn`, `title`, `route`)
    VALUES (2, 'Exposición (Conferencia)', 'Número Único de Identificación Personal', '1037622083', '23456', 'Contrato de Obra Por Encargo', 'Físico', NULL, '987654321', 'Empleado de Carrera', 'file_name_2.iso');
INSERT INTO `JuridicApp`.`AUTHOR_OEUVRE` (`oeuvre_type_id`, `oeuvre_type_name`, `document_type`, `id_number`, `contract`, `acquisition`, `support_type`, `dnda`, `isbn`, `title`, `route`)
    VALUES (2, 'Escrito', 'Número Único de Identificación Personal', '1037622083', '23456', 'Licencia de Software', 'Digital', NULL, NULL, 'Empleado Provisional', 'file_name_3.rar');
INSERT INTO `JuridicApp`.`AUTHOR_OEUVRE` (`oeuvre_type_id`, `oeuvre_type_name`, `document_type`, `id_number`, `contract`, `acquisition`, `support_type`, `dnda`, `isbn`, `title`, `route`)
    VALUES (3, 'Obra Derivada', 'Tarjeta de Identidad', '1039456678', '34567',  'Licencia Creative Commons', 'Digital', '67890', '654987321', 'Empleado Provisional', 'file_name_4.png');
INSERT INTO `JuridicApp`.`AUTHOR_OEUVRE` (`oeuvre_type_id`, `oeuvre_type_name`, `document_type`, `id_number`, `contract`, `acquisition`, `support_type`, `dnda`, `isbn`, `title`, `route`)
    VALUES (4, 'Programa de Ordenador (Software)', 'Cédula de Ciudadanía', '1022095657', '56789', 'Autorización', 'Físico', NULL, NULL, 'Profesor Visitante', 'file_name_5.docx');
INSERT INTO `JuridicApp`.`AUTHOR_OEUVRE` (`oeuvre_type_id`, `oeuvre_type_name`, `document_type`, `id_number`, `contract`, `acquisition`, `support_type`, `dnda`, `isbn`, `title`, `route`)
    VALUES (4, 'Audiovisual, Multimedia', 'Cédula de Ciudadanía', '1022095657', '56789', 'Presunción Legal Plan de Trabajo', 'Digital', '09876', '321654987', 'Profesor Visitante', 'file_name_6.zip');
INSERT INTO `JuridicApp`.`AUTHOR_OEUVRE` (`oeuvre_type_id`, `oeuvre_type_name`, `document_type`, `id_number`, `contract`, `acquisition`, `support_type`, `dnda`, `isbn`, `title`, `route`)
    VALUES (4, 'Escrito', 'Cédula de Extranjería', '1035859551', '67890',  'Licencia Creative Commons', 'Digital', NULL, '951847263', 'No Aplica', 'file_name_7.pptx');
INSERT INTO `JuridicApp`.`AUTHOR_OEUVRE` (`oeuvre_type_id`, `oeuvre_type_name`, `document_type`, `id_number`, `contract`, `acquisition`, `support_type`, `dnda`, `isbn`, `title`, `route`)
    VALUES (5, 'Obra Fotográfica', 'Tarjeta de Identidad', '1039456678', '67890', 'Contrato de Cesión de Derechos', 'Físico', '98765', NULL, 'Empleado de Libre Nombramiento', 'file_name_8.xls');


-- -----------------------------------------------------
-- Table `JuridicApp`.`PROFILE`
-- -----------------------------------------------------
-- INSERT INTO `JuridicApp`.`PROFILE` (`title`, `description`)
--     VALUES (NULL, NULL);
-- INSERT INTO `JuridicApp`.`PROFILE` (`title`, `description`)
--     VALUES ('Administrador', NULL);
-- INSERT INTO `JuridicApp`.`PROFILE` (`title`, `description`)
--     VALUES ('Gestor de Contratos', NULL);

-- -----------------------------------------------------
-- Table `JuridicApp`.`CLIENT`
-- -----------------------------------------------------
-- INSERT INTO `JuridicApp`.`CLIENT` (`document_type`, `id_number`, `user_name`, `password`, `title`, `dependency`)
--     VALUES (NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `JuridicApp`.`CLIENT` (`document_type`, `id_number`, `user_name`, `password`, `title`, `dependency`)
    VALUES ('Cédula de Ciudadanía', '1022095657', 'neiber.padierna', 'neiber123', 'Administrador', 'Ingeniería de Sistemas');
INSERT INTO `JuridicApp`.`CLIENT` (`document_type`, `id_number`, `user_name`, `password`, `title`, `dependency`)
    VALUES ('Cédula de Extranjería', '1035859551', 'miguel.ossa', 'coldlomejor', 'Gestor de Contratos', 'Facultad de Comunicaciones');
INSERT INTO `JuridicApp`.`CLIENT` (`document_type`, `id_number`, `user_name`, `password`, `title`, `dependency`)
    VALUES ('Cédula de Ciudadanía', '1035859552', 'admin', 'admin', 'Administrador', 'Facultad de Comunicaciones');
INSERT INTO `JuridicApp`.`CLIENT` (`document_type`, `id_number`, `user_name`, `password`, `title`, `dependency`)
    VALUES ('Número Único de Identificación Personal', '1037622083', 'anderber', 'Anderber', 'Consultor', 'Facultad de Comunicaciones');