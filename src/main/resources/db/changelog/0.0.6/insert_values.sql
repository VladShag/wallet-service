INSERT INTO roles (id, name)
VALUES ('123e4567-e89b-12d3-a456-426614174001', 'ROLE_ADMIN'),
       ('123e4567-e89b-12d3-a456-426614174002', 'ROLE_USER');
INSERT INTO users (id, username, password)
VALUES ('123e4567-e89b-12d3-a456-426614174003', 'admin',
        '$2a$10$EIX.Y1.ZMYZ.ZMYZ.ZMYZ.ZMYZ.ZMYZ.ZMYZ.ZMYZ.ZMYZ.ZMYZ.ZMYZ.ZMYZ'),
       ('123e4567-e89b-12d3-a456-426614174004', 'user',
        '$2a$10$EIX.Y1.ZMYZ.ZMYZ.ZMYZ.ZMYZ.ZMYZ.ZMYZ.ZMYZ.ZMYZ.ZMYZ.ZMYZ.ZMYZ');

INSERT INTO user_roles (user_id, role_id)
VALUES ('123e4567-e89b-12d3-a456-426614174003', '123e4567-e89b-12d3-a456-426614174001'),
       ('123e4567-e89b-12d3-a456-426614174004', '123e4567-e89b-12d3-a456-426614174002');
INSERT INTO wallet (id, balance, user_id)
VALUES ('123e4567-e89b-12d3-a456-426614174005', 1000, '123e4567-e89b-12d3-a456-426614174004');