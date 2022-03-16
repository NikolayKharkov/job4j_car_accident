CREATE TABLE accidents (
  id serial primary key,
  name varchar(200),
  text varchar(2000),
  address varchar(200),
  type_id integer references types (id)
);

CREATE TABLE rules (
  id serial primary key,
  name varchar(255)
);

CREATE TABLE types (
  id serial primary key,
  name varchar(255)
);

CREATE TABLE accidents_rules (
  accident_id integer,
  rules_id integer
);