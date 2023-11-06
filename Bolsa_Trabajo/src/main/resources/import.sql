-- Inserción de empresas
INSERT INTO empresa (correo, direccion, nombre, telefono) VALUES ('empresa1@example.com', 'Dirección 1', 'Empresa Uno', '1234567890');
INSERT INTO empresa (correo, direccion, nombre, telefono) VALUES ('empresa2@example.com', 'Dirección 2', 'Empresa Dos', '9876543210');

-- Inserción de ofertas asociadas a empresas
INSERT INTO oferta (id, nombre, descripcion, horario, puesto, jornada, fecha, empresa_id) VALUES (1, 'Leo', 'Matar a un ruiseñor', '7am - 12 pm', 'frontend', 'mañana', '12 abril', 1); -- Asocia oferta a "Empresa Uno" (ID 1)
INSERT INTO oferta (id, nombre, descripcion, horario, puesto, jornada, fecha, empresa_id) VALUES (2, 'Luis', 'Matar a un ruiseñor ---- asdf', '7am - 12 pm', 'frontend', 'mañana', '12 abril', 1); -- Asocia oferta a "Empresa Uno" (ID 1)
INSERT INTO oferta (id, nombre, descripcion, horario, puesto, jornada, fecha, empresa_id) VALUES (3, 'Esto es un ejemplo', '2 de noviembre', '3am - 5 pm', 'matutina', 'pa la nasa', 'en 4', 2); -- Asocia oferta a "Empresa Dos" (ID 2)
