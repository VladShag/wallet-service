create table users (id uuid primary key not null,
                     username varchar(50) not null unique,
                     password varchar(255) not null)