DROP SCHEMA IF EXISTS public cascade;
CREATE SCHEMA public;

-- tabla waterBody
CREATE TABLE waterbody
(
    waterbodyid SERIAL,
    namewaterbody character varying(50),
    typeof character varying(60),
    plants character varying(60),
    animals character varying(60),
    waterquality character varying(60),
    long float,
	lat float,
    organization character varying(60),
    CONSTRAINT waterbody_pkey PRIMARY KEY (waterbodyid)
);

-- tabla especie
CREATE TABLE specie
(
    specieid SERIAL,
	waterbodyid int,
    namespecie character varying(60),
    CONSTRAINT specie_pkey PRIMARY KEY (specieid),
	CONSTRAINT specie_fkey FOREIGN KEY (waterbodyid)
	REFERENCES waterbody(waterbodyid) ON UPDATE CASCADE ON DELETE CASCADE
);

-- table user
CREATE TABLE  userapp
(
    userid SERIAL,
	nameuserapp character varying(60),
	mail character varying(100),
    userpassword character varying(100),
    CONSTRAINT user_pkey PRIMARY KEY (userid)
);

