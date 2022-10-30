CREATE SEQUENCE groep214.workorder_id_seq;

GRANT ALL ON SEQUENCE groep214.workorder_id_seq TO local_r0887747;


CREATE TABLE groep214.workorder
(   id integer NOT NULL DEFAULT nextval('groep214.workorder_id_seq'::regclass),
    employee character varying COLLATE pg_catalog."default" NOT NULL,
    date timestamp,
    duration time,
    description character varying(100),
    CONSTRAINT workorder_pkey PRIMARY KEY (id)
);

GRANT ALL ON TABLE groep214.workorder TO local_r0887747;

INSERT INTO groep214.workorder ("employee","date","duration","description") values ('joske','2032-01-19','12:30','dit is een description voor joske');
INSERT INTO groep214.workorder ("employee","date","duration","description") values ('maria','2032-01-19','06:40','dit is een description voor joske');

-- grant aan teamgenoot
GRANT ALL ON SCHEMA groep214 TO local_r0887519;
GRANT ALL ON SEQUENCE groep214.workorder_id_seq TO local_r0887519;
GRANT ALL ON TABLE groep214.workorder TO local_r0887519;

--grant aan lectoren
GRANT ALL ON SCHEMA groep214 TO local_u0015529;
GRANT ALL ON SEQUENCE groep214.workorder_id_seq TO local_u0015529;
GRANT ALL ON TABLE groep214.workorder TO local_u0015529;

GRANT ALL ON SCHEMA groep214 TO local_u0034562;
GRANT ALL ON SEQUENCE groep214.workorder_id_seq TO local_u0034562;
GRANT ALL ON TABLE groep214.workorder TO local_u0034562;