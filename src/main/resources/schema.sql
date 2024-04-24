create table if not exists Product (
    name varchar(255) primary key,
    price bigint not null,
    category varchar(255) not null,
    quantity bigint not null
);
