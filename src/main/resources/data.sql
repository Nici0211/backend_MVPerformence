-- 1. USERS
INSERT INTO users (id, first_name, last_name, email, password_hash, phone, street, city, role, created_at)
VALUES (1, 'Max', 'Mustermann', 'admin@mwperformance.at', '$2a$10$hash', '+43 664 123', 'Werkstattstr 1', 'Graz',
        'ADMIN', CURRENT_TIMESTAMP),
       (2, 'Thomas', 'Kauer', 'thomas.kauer@gmail.com', '$2a$10$hash', '+43 699 111', 'Hauptstr 5', 'Graz', 'CUSTOMER',
        CURRENT_TIMESTAMP),
       (3, 'Maria', 'Schreiner', 'maria.schreiner@gmail.com', '$2a$10$hash', '+43 699 222', 'Schillerstr 12', 'Graz',
        'CUSTOMER', CURRENT_TIMESTAMP),
       (4, 'Stefan', 'Bauer', 'stefan.bauer@gmail.com', '$2a$10$hash', '+43 699 333', 'Mozartgasse 3', 'Leibnitz',
        'CUSTOMER', CURRENT_TIMESTAMP);

-- 2. VEHICLES
INSERT INTO vehicles (id, user_id, brand, model, build_year, license_plate)
VALUES (1, 2, 'VW', 'Golf', 2019, 'GU-12345'),
       (2, 3, 'BMW', 'X3', 2021, 'GU-67890'),
       (3, 4, 'Audi', 'A4', 2017, 'LB-11111'),
       (4, 2, 'Mercedes', 'C-Klasse', 2018, 'G-44221X'),
       (5, 3, 'Tesla', 'Model 3', 2022, 'W-99887A'),
       (6, 4, 'Ford', 'Focus', 2015, 'LB-77662'),
       (7, 2, 'Porsche', '911', 2023, 'G-FAST1'),
       (8, 3, 'Opel', 'Corsa', 2012, 'GU-88221');

-- 3. SERVICES
INSERT INTO services (id, icon, title, subtitle, price)
VALUES (1, 'oil-can', 'Ölwechsel', 'Motoröl + Filter wechseln', 80.0),
       (2, 'tire', 'Reifenwechsel', 'Sommer-/Winterreifen montieren', 45.0),
       (3, 'brake', 'Bremsenservice', 'Bremsbeläge + Scheiben prüfen', 150.0),
       (4, 'car', 'HU / §57a', 'Hauptuntersuchung durchführen', 90.0),
       (5, 'snowflake', 'Klimaservice', 'Kältemittel + Desinfektion + Check', 70.0),
       (6, 'wrench', 'Großes Service', 'Inkl. aller Filter und Flüssigkeiten', 350.0),
       (7, 'lightbulb', 'Lichtcheck', 'Einstellen von Leuchtmitteln', 20.0),
       (8, 'shield', 'Unterbodenschutz', 'Versiegelung gegen Rost', 180.0);

-- 4. OFFERS
INSERT INTO offers (id, title, description, price, active, created_at)
VALUES (1, 'Frühjahrs-Check', 'Ölwechsel + Bremsen + Reifencheck', 49.0, true, CURRENT_TIMESTAMP),
       (2, 'Klimaservice', 'Kältemittel + Desinfektion + Check', 69.0, true, CURRENT_TIMESTAMP);

-- 5. OFFER_SERVICES
INSERT INTO offer_services (offer_id, service_id)
VALUES (1, 1),
       (1, 2),
       (1, 3),
       (2, 5);

-- 6. APPOINTMENTS
INSERT INTO appointments (id, user_id, vehicle_id, service_id, customer_name, preferred_date, status, price, note, created_at)
VALUES (1, 2, 1, 1, 'Thomas Kauer', '2026-03-19 10:00:00', 'NEU', 120.0, NULL, CURRENT_TIMESTAMP),
       (2, 3, 2, 2, 'Maria Schreiner', '2026-03-20 09:00:00', 'BESTÄTIGT', 45.0, NULL, CURRENT_TIMESTAMP),
       (3, 4, 3, 3, 'Stefan Bauer', '2026-03-21 14:00:00', 'ABGESCHLOSSEN', 210.0, NULL, CURRENT_TIMESTAMP),
       (4, 2, 1, 4, 'Thomas Kauer', '2026-04-15 08:30:00', 'NEU', 89.0, NULL, CURRENT_TIMESTAMP),
       (5, 3, 2, 5, 'Maria Schreiner', '2026-04-15 10:00:00', 'BESTÄTIGT', 69.0, NULL, CURRENT_TIMESTAMP),
       (6, 4, 3, 1, 'Stefan Bauer', '2026-04-16 13:00:00', 'NEU', 135.0, NULL, CURRENT_TIMESTAMP),
       (7, 2, 4, 3, 'Thomas Kauer', '2026-04-17 09:15:00', 'BESTÄTIGT', 280.0, NULL, CURRENT_TIMESTAMP),
       (8, 3, 5, 2, 'Maria Schreiner', '2026-04-18 11:00:00', 'NEU', 55.0, NULL, CURRENT_TIMESTAMP),
       (9, 4, 6, 6, 'Stefan Bauer', '2026-04-20 08:00:00', 'ABGESCHLOSSEN', 450.0, NULL, CURRENT_TIMESTAMP),
       (10, 2, 7, 1, 'Thomas Kauer', '2026-04-21 15:30:00', 'ABGESCHLOSSEN', 350.0, NULL, CURRENT_TIMESTAMP),
       (11, 3, 8, 7, 'Maria Schreiner', '2026-04-22 10:00:00', 'NEU', 25.0, NULL, CURRENT_TIMESTAMP),
       (12, 4, 3, 4, 'Stefan Bauer', '2026-04-23 09:00:00', 'BESTÄTIGT', 89.0, NULL, CURRENT_TIMESTAMP),
       (13, 2, 1, 8, 'Thomas Kauer', '2026-04-24 14:00:00', 'NEU', 180.0, NULL, CURRENT_TIMESTAMP),
       (14, 3, 2, 1, 'Maria Schreiner', '2026-05-02 08:00:00', 'NEU', 140.0, NULL, CURRENT_TIMESTAMP),
       (15, 4, 6, 2, 'Stefan Bauer', '2026-05-03 10:30:00', 'NEU', 45.0, NULL, CURRENT_TIMESTAMP);

-- 7. REVIEWS
INSERT INTO reviews (id, user_id, name, stars, text, created_at)
VALUES (1, 2, 'Thomas Kauer', 5, 'Top Service!', CURRENT_TIMESTAMP),
       (2, 3, 'Maria S.', 4, 'Sehr freundlich.', CURRENT_TIMESTAMP),
       (3, 4, 'Stefan B.', 5, 'Transparent und pünktlich.', CURRENT_TIMESTAMP);

-- 8. CONTACT INFO
INSERT INTO contact_info (id, icon, value)
VALUES (1, 'phone', '+43 664 1234567'),
       (2, 'envelope', 'office@mwperformance.at'),
       (3, 'map-pin', 'Graz, AT');

-- 9. OPENING HOURS
INSERT INTO opening_hours (id, day_label, open_time, close_time, closed)
VALUES (1, 'Mo – Fr', '08:00', '17:00', false),
       (2, 'Samstag', '09:00', '13:00', false),
       (3, 'Sonntag', NULL, NULL, true);

-- Reset sequences
SELECT setval('users_id_seq', (SELECT MAX(id) FROM users));
SELECT setval('vehicles_id_seq', (SELECT MAX(id) FROM vehicles));
SELECT setval('services_id_seq', (SELECT MAX(id) FROM services));
SELECT setval('offers_id_seq', (SELECT MAX(id) FROM offers));
SELECT setval('appointments_id_seq', (SELECT MAX(id) FROM appointments));
SELECT setval('reviews_id_seq', (SELECT MAX(id) FROM reviews));
SELECT setval('contact_info_id_seq', (SELECT MAX(id) FROM contact_info));
SELECT setval('opening_hours_id_seq', (SELECT MAX(id) FROM opening_hours));