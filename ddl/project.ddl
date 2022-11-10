
CREATE SEQUENCE groep214.project_id_seq;

GRANT ALL ON SEQUENCE groep214.project_id_seq TO local_r0887747;


CREATE TABLE groep214.project
(   id integer NOT NULL DEFAULT nextval('groep214.project_id_seq'::regclass),
    name character varying COLLATE pg_catalog."default" NOT NULL,
    team character varying COLLATE pg_catalog."default" NOT NULL,
    startdate timestamp ,
    enddate timestamp  ,
    CONSTRAINT project_pkey PRIMARY KEY (id)
);


GRANT ALL ON TABLE groep214.project TO local_r0887747;

INSERT INTO groep214.project ("name","team","startdate","enddate") values ('project1','BETA','2032-01-19','2038-01-19');
INSERT INTO groep214.project ("name","team","startdate","enddate") values ('project2','ALPHA','2033-01-19','2036-01-19');


-- grant aan teamgenoot
GRANT ALL ON SCHEMA groep214 TO local_r0887519;
GRANT ALL ON SEQUENCE groep214.project_id_seq TO local_r0887519;
GRANT ALL ON TABLE groep214.project TO local_r0887519;

--grant aan lectoren
GRANT ALL ON SCHEMA groep214 TO local_u0015529;
GRANT ALL ON SEQUENCE groep214.project_id_seq TO local_u0015529;
GRANT ALL ON TABLE groep214.project TO local_u0015529;

GRANT ALL ON SCHEMA groep214 TO local_u0034562;
GRANT ALL ON SEQUENCE groep214.project_id_seq TO local_u0034562;
GRANT ALL ON TABLE groep214.project TO local_u0034562;