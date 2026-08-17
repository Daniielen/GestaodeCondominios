INSERT INTO tb_units (id, number, block) VALUES (1, '101', 'A');
INSERT INTO tb_units (id, number, block) VALUES (2, '102', 'A');

INSERT INTO tb_common_areas (id, active, capacity, name) VALUES (1, true, 50, 'Salão de Festas');
INSERT INTO tb_common_areas (id, active, capacity, name) VALUES (2, true, 20, 'Churrasqueira');

INSERT INTO tb_role (id, name) VALUES (1, 'ROLE_ADMIN');
INSERT INTO tb_role (id, name) VALUES (2, 'ROLE_USER');

INSERT INTO tb_user (id, created_at, email, name, password_hash, unit_id) VALUES (1, '2026-08-01 10:00:00+00', 'joao@email.com', 'João Silva', 'hash123', 1);
INSERT INTO tb_user (id, created_at, email, name, password_hash, unit_id) VALUES (2, '2026-08-01 10:30:00+00', 'maria@email.com', 'Maria Souza', 'hash456', 2);
INSERT INTO tb_user (id, created_at, email, name, password_hash, unit_id) VALUES (3, '2026-08-01 11:00:00+00', 'porteiro@email.com', 'Carlos Eduardo', 'hash789', NULL);

INSERT INTO tb_user_roles (role_id, user_id) VALUES (2, 1);
INSERT INTO tb_user_roles (role_id, user_id) VALUES (2, 2);
INSERT INTO tb_user_roles (role_id, user_id) VALUES (1, 3);

INSERT INTO tb_condo_fees (id, unit_id, amount, due_date, status, payment_date) VALUES (1, 1, 550.00, '2026-09-05', 'PENDING', NULL);
INSERT INTO tb_condo_fees (id, unit_id, amount, due_date, status, payment_date) VALUES (2, 2, 550.00, '2026-08-05', 'PAID', '2026-08-04');

INSERT INTO tb_tickets (id, title, description, user_id, status, created_at) VALUES (1, 'Vazamento na Garagem', 'Há um cano pingando no subsolo.', 2, 'OPEN', '2026-08-16 10:15:00+00');
INSERT INTO tb_tickets (id, title, description, user_id, status, created_at) VALUES (2, 'Lâmpada queimada', 'Lâmpada do corredor do 1º andar queimada.', 1, 'RESOLVED', '2026-08-10 18:00:00+00');

INSERT INTO tb_notices (id, title, content, user_id, created_at) VALUES (1, 'Assembleia Geral', 'Nossa assembleia ocorrerá no próximo dia 25 às 19h.', 1, '2026-08-15 09:00:00+00');
INSERT INTO tb_notices (id, title, content, user_id, created_at) VALUES (2, 'Dedetização', 'Haverá dedetização nas áreas comuns na sexta-feira.', 1, '2026-08-17 08:30:00+00');

INSERT INTO tb_reservations (id, common_area_id, user_id, start_date, end_time, status) VALUES (1, 1, 2, '2026-08-22', '2026-08-22', 'CONFIRMADO');
INSERT INTO tb_reservations (id, common_area_id, user_id, start_date, end_time, status) VALUES (2, 2, 1, '2026-08-23', '2026-08-23', 'CANCELADO');

INSERT INTO tb_deliveries (id, description, tracking_code, unit_id, received_by_id, received_at, status, delivered_by_id, recipient_name, delivered_at) VALUES (1, 'Caixa Amazon', 'BR987654321', 2, 3, '2026-08-17 14:00:00', 'AGUARDANDO_RETIRADA', NULL, 'Mariana Oliveira', NULL);
INSERT INTO tb_deliveries (id, description, tracking_code, unit_id, received_by_id, received_at, status, delivered_by_id, recipient_name, delivered_at) VALUES (2, 'Documento Sedex', 'BR123456789', 1, 3, '2026-08-16 10:00:00', 'ENTREGUE', 3, 'Carlos Eduardo', '2026-08-16 19:30:00');

INSERT INTO tb_maintenance_task (id, title, description, completed_date, status) VALUES (1, 'Limpeza da caixa d''água', 'Limpeza semestral preventiva', '2026-08-10', 'FINALIZADO');
INSERT INTO tb_maintenance_task (id, title, description, completed_date, status) VALUES (2, 'Revisão dos elevadores', 'Manutenção mensal', '2026-08-25', 'AGENDADO');