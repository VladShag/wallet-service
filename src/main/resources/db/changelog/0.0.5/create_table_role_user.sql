CREATE TABLE user_roles (user_id UUID NOT NULL,
                        role_id UUID NOT NULL,
                        FOREIGN KEY (user_id) REFERENCES users(id),
                        FOREIGN KEY (role_id) REFERENCES roles(id));