--
-- PostgreSQL database dump
--

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner:
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner:
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: armor; Type: TABLE; Schema: public; Owner: Guest; Tablespace:
--

CREATE TABLE armor (
    id integer NOT NULL,
    armor_name character varying,
    armor_defense integer
);


ALTER TABLE armor OWNER TO "Guest";

--
-- Name: armor_id_seq; Type: SEQUENCE; Schema: public; Owner: Guest
--

CREATE SEQUENCE armor_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE armor_id_seq OWNER TO "Guest";

--
-- Name: armor_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: Guest
--

ALTER SEQUENCE armor_id_seq OWNED BY armor.id;


--
-- Name: hero; Type: TABLE; Schema: public; Owner: Guest; Tablespace:
--

CREATE TABLE hero (
    id integer NOT NULL,
    beard_choice integer,
    name character varying,
    experience integer,
    gold integer,
    attack integer,
    defense integer,
    speed integer,
    stamina integer
);


ALTER TABLE hero OWNER TO "Guest";

--
-- Name: hero_id_seq; Type: SEQUENCE; Schema: public; Owner: Guest
--

CREATE SEQUENCE hero_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE hero_id_seq OWNER TO "Guest";

--
-- Name: hero_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: Guest
--

ALTER SEQUENCE hero_id_seq OWNED BY hero.id;


--
-- Name: inventory; Type: TABLE; Schema: public; Owner: Guest; Tablespace:
--

CREATE TABLE inventory (
    id integer NOT NULL,
    name character varying,
    classification character varying,
    hero_id integer,
    equipped boolean
);


ALTER TABLE inventory OWNER TO "Guest";

--
-- Name: inventory_id_seq; Type: SEQUENCE; Schema: public; Owner: Guest
--

CREATE SEQUENCE inventory_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE inventory_id_seq OWNER TO "Guest";

--
-- Name: inventory_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: Guest
--

ALTER SEQUENCE inventory_id_seq OWNED BY inventory.id;


--
-- Name: monster; Type: TABLE; Schema: public; Owner: Guest; Tablespace:
--

CREATE TABLE monster (
    id integer NOT NULL,
    monster_name character varying,
    monster_defense integer,
    monster_attack integer,
    monster_gold integer,
    monster_speed integer,
    monster_stamina integer,
    monster_exp integer
);


ALTER TABLE monster OWNER TO "Guest";

--
-- Name: monster_id_seq; Type: SEQUENCE; Schema: public; Owner: Guest
--

CREATE SEQUENCE monster_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE monster_id_seq OWNER TO "Guest";

--
-- Name: monster_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: Guest
--

ALTER SEQUENCE monster_id_seq OWNED BY monster.id;


--
-- Name: player; Type: TABLE; Schema: public; Owner: Guest; Tablespace:
--

CREATE TABLE player (
    id integer NOT NULL,
    username character varying,
    password character varying
);


ALTER TABLE player OWNER TO "Guest";

--
-- Name: player_id_seq; Type: SEQUENCE; Schema: public; Owner: Guest
--

CREATE SEQUENCE player_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE player_id_seq OWNER TO "Guest";

--
-- Name: player_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: Guest
--

ALTER SEQUENCE player_id_seq OWNED BY player.id;


--
-- Name: weapon; Type: TABLE; Schema: public; Owner: Guest; Tablespace:
--

CREATE TABLE weapon (
    id integer NOT NULL,
    wep_name character varying,
    wep_damage integer
);


ALTER TABLE weapon OWNER TO "Guest";

--
-- Name: weapon_id_seq; Type: SEQUENCE; Schema: public; Owner: Guest
--

CREATE SEQUENCE weapon_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE weapon_id_seq OWNER TO "Guest";

--
-- Name: weapon_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: Guest
--

ALTER SEQUENCE weapon_id_seq OWNED BY weapon.id;


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: Guest
--

ALTER TABLE ONLY armor ALTER COLUMN id SET DEFAULT nextval('armor_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: Guest
--

ALTER TABLE ONLY hero ALTER COLUMN id SET DEFAULT nextval('hero_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: Guest
--

ALTER TABLE ONLY inventory ALTER COLUMN id SET DEFAULT nextval('inventory_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: Guest
--

ALTER TABLE ONLY monster ALTER COLUMN id SET DEFAULT nextval('monster_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: Guest
--

ALTER TABLE ONLY player ALTER COLUMN id SET DEFAULT nextval('player_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: Guest
--

ALTER TABLE ONLY weapon ALTER COLUMN id SET DEFAULT nextval('weapon_id_seq'::regclass);


--
-- Data for Name: armor; Type: TABLE DATA; Schema: public; Owner: Guest
--

COPY armor (id, armor_name, armor_defense) FROM stdin;
\.


--
-- Name: armor_id_seq; Type: SEQUENCE SET; Schema: public; Owner: Guest
--

SELECT pg_catalog.setval('armor_id_seq', 1, false);


--
-- Data for Name: hero; Type: TABLE DATA; Schema: public; Owner: Guest
--

COPY hero (id, beard_choice, name, experience, gold, attack, defense, speed, stamina) FROM stdin;
\.


--
-- Name: hero_id_seq; Type: SEQUENCE SET; Schema: public; Owner: Guest
--

SELECT pg_catalog.setval('hero_id_seq', 1, false);


--
-- Data for Name: inventory; Type: TABLE DATA; Schema: public; Owner: Guest
--

COPY inventory (id, name, classification, hero_id, equipped) FROM stdin;
\.


--
-- Name: inventory_id_seq; Type: SEQUENCE SET; Schema: public; Owner: Guest
--

SELECT pg_catalog.setval('inventory_id_seq', 1, false);


--
-- Data for Name: monster; Type: TABLE DATA; Schema: public; Owner: Guest
--

COPY monster (id, monster_name, monster_defense, monster_attack, monster_gold, monster_speed, monster_stamina, monster_exp) FROM stdin;
\.


--
-- Name: monster_id_seq; Type: SEQUENCE SET; Schema: public; Owner: Guest
--

SELECT pg_catalog.setval('monster_id_seq', 1, false);


--
-- Data for Name: player; Type: TABLE DATA; Schema: public; Owner: Guest
--

COPY player (id, username, password) FROM stdin;
\.


--
-- Name: player_id_seq; Type: SEQUENCE SET; Schema: public; Owner: Guest
--

SELECT pg_catalog.setval('player_id_seq', 1, false);


--
-- Data for Name: weapon; Type: TABLE DATA; Schema: public; Owner: Guest
--

COPY weapon (id, wep_name, wep_damage) FROM stdin;
\.


--
-- Name: weapon_id_seq; Type: SEQUENCE SET; Schema: public; Owner: Guest
--

SELECT pg_catalog.setval('weapon_id_seq', 1, false);


--
-- Name: armor_pkey; Type: CONSTRAINT; Schema: public; Owner: Guest; Tablespace:
--

ALTER TABLE ONLY armor
    ADD CONSTRAINT armor_pkey PRIMARY KEY (id);


--
-- Name: hero_pkey; Type: CONSTRAINT; Schema: public; Owner: Guest; Tablespace:
--

ALTER TABLE ONLY hero
    ADD CONSTRAINT hero_pkey PRIMARY KEY (id);


--
-- Name: inventory_pkey; Type: CONSTRAINT; Schema: public; Owner: Guest; Tablespace:
--

ALTER TABLE ONLY inventory
    ADD CONSTRAINT inventory_pkey PRIMARY KEY (id);


--
-- Name: monster_pkey; Type: CONSTRAINT; Schema: public; Owner: Guest; Tablespace:
--

ALTER TABLE ONLY monster
    ADD CONSTRAINT monster_pkey PRIMARY KEY (id);


--
-- Name: player_pkey; Type: CONSTRAINT; Schema: public; Owner: Guest; Tablespace:
--

ALTER TABLE ONLY player
    ADD CONSTRAINT player_pkey PRIMARY KEY (id);


--
-- Name: weapon_pkey; Type: CONSTRAINT; Schema: public; Owner: Guest; Tablespace:
--

ALTER TABLE ONLY weapon
    ADD CONSTRAINT weapon_pkey PRIMARY KEY (id);


--
-- Name: public; Type: ACL; Schema: -; Owner: epicodus
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM epicodus;
GRANT ALL ON SCHEMA public TO epicodus;
GRANT ALL ON SCHEMA public TO PUBLIC;


--
-- PostgreSQL database dump complete
--
