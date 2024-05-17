CREATE TABLE IF NOT EXISTS tag
(
  id bigserial not null
    constraint tag_pkey
      primary key,
  name character varying(255) unique not null
)
  WITH (
    OIDS=FALSE
  );
ALTER TABLE tag OWNER TO unicorn;

CREATE TABLE IF NOT EXISTS customer
(
  id bigserial not null
    constraint t_event_pkey
      primary key,
  username character varying(255) unique not null,
  name character varying(255),
  surname character varying(255),
  email character varying(255) unique not null
)
  WITH (
    OIDS=FALSE
  );
ALTER TABLE customer OWNER TO unicorn;


CREATE TABLE IF NOT EXISTS customer_tags
(
  customer_id bigint NOT NULL
    constraint fk_customer_tags_customer
      references customer,
  tag_id bigint NOT NULL
    constraint fk_customer_tags_tag
      references tag,
  CONSTRAINT customer_tags_pkey PRIMARY KEY (customer_id, tag_id)
)
  WITH (
    OIDS=FALSE
  );
ALTER TABLE customer_tags OWNER TO unicorn;

CREATE INDEX IF NOT EXISTS fk_customer_tags_customer
  ON customer_tags (customer_id);

insert into tag (name) values ('student');
insert into tag (name) values ('employee');
insert into tag (name) values ('unemployed');
insert into tag (name) values ('male');
insert into tag (name) values ('female');
insert into tag (name) values ('turkish');
insert into tag (name) values ('european');
insert into tag (name) values ('american');
insert into tag (name) values ('asian');
insert into tag (name) values ('african');
insert into tag (name) values ('tag1');
insert into tag (name) values ('tag2');
insert into tag (name) values ('tag3');
insert into tag (name) values ('tag4');
insert into tag (name) values ('tag5');
insert into tag (name) values ('tag6');
insert into tag (name) values ('tag7');
insert into tag (name) values ('tag8');
insert into tag (name) values ('tag9');
