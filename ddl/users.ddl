CREATE TABLE IF NOT EXISTS groep214."user"
(
    id integer NOT NULL DEFAULT nextval
(
    'groep214.user_id_seq'::regclass
),
    email character varying
(
    200
) COLLATE pg_catalog."default" NOT NULL,
    firstname character varying
(
    200
) COLLATE pg_catalog."default" NOT NULL,
    lastname character varying
(
    200
) COLLATE pg_catalog."default" NOT NULL,
    team character varying
(
    20
) COLLATE pg_catalog."default" NOT NULL,
    role character varying
(
    42
) COLLATE pg_catalog."default" NOT NULL,
    password character varying
(
    30
) COLLATE pg_catalog."default",
    CONSTRAINT user_pkey PRIMARY KEY
(
    id,
    email
)
    )
    TABLESPACE pg_default;

ALTER TABLE IF EXISTS groep214."user"
    OWNER to r0887519;

GRANT
ALL
ON TABLE groep214."user" TO local_r0887519;

GRANT ALL
ON TABLE groep214."user" TO local_r0887747;

GRANT ALL
ON TABLE groep214."user" TO local_u0015529;

GRANT ALL
ON TABLE groep214."user" TO local_u0034562;

GRANT ALL
ON TABLE groep214."user" TO r0887519;

GRANT ALL
ON TABLE groep214."user" TO r0887747;

INSERT INTO groep214.user (email, firstname, lastname, team, role, password)
VALUES ('director@ucll.be', 'director', 'ucll', 'ALPHA', 'director', 't');
INSERT INTO groep214.user(email, firstname, lastname, team, role, password)
VALUES ('teamleader@ucll.be', 'teamleader', 'ucll', 'BETA', 'teamleader', 't');
INSERT INTO groep214.user(email, firstname, lastname, team, role, password)
VALUES ('employee@ucll.be', 'employee', 'ucll', 'BETA', 'employee', 't');