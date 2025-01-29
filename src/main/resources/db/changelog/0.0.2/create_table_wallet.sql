CREATE TABLE wallet (id UUID PRIMARY KEY,
                    balance BIGINT NOT NULL,
                    user_id UUID NOT NULL,
                    FOREIGN KEY (user_id) REFERENCES users(id));