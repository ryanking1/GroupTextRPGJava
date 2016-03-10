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
-- Name: battle; Type: TABLE; Schema: public; Owner: Guest; Tablespace: 
--

CREATE TABLE battle (
    id integer NOT NULL,
    hero_id integer,
    monster_id integer,
    hero_win boolean
);


ALTER TABLE battle OWNER TO "Guest";

--
-- Name: battle_id_seq; Type: SEQUENCE; Schema: public; Owner: Guest
--

CREATE SEQUENCE battle_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE battle_id_seq OWNER TO "Guest";

--
-- Name: battle_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: Guest
--

ALTER SEQUENCE battle_id_seq OWNED BY battle.id;


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
    stamina integer,
    level integer,
    exp_to_next_level integer,
    treasure_one boolean,
    treasure_two boolean
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
    hero_id integer,
    item_id integer
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
-- Name: level; Type: TABLE; Schema: public; Owner: Guest; Tablespace: 
--

CREATE TABLE level (
    id integer NOT NULL,
    experience integer
);


ALTER TABLE level OWNER TO "Guest";

--
-- Name: level_id_seq; Type: SEQUENCE; Schema: public; Owner: Guest
--

CREATE SEQUENCE level_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE level_id_seq OWNER TO "Guest";

--
-- Name: level_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: Guest
--

ALTER SEQUENCE level_id_seq OWNED BY level.id;


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
    monster_exp integer,
    monster_level integer
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
    password character varying,
    user_name character varying
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

ALTER TABLE ONLY battle ALTER COLUMN id SET DEFAULT nextval('battle_id_seq'::regclass);


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

ALTER TABLE ONLY level ALTER COLUMN id SET DEFAULT nextval('level_id_seq'::regclass);


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
-- Data for Name: battle; Type: TABLE DATA; Schema: public; Owner: Guest
--

COPY battle (id, hero_id, monster_id, hero_win) FROM stdin;
\.


--
-- Name: battle_id_seq; Type: SEQUENCE SET; Schema: public; Owner: Guest
--

SELECT pg_catalog.setval('battle_id_seq', 1, false);


--
-- Data for Name: hero; Type: TABLE DATA; Schema: public; Owner: Guest
--

COPY hero (id, beard_choice, name, experience, gold, attack, defense, speed, stamina, level, exp_to_next_level, treasure_one, treasure_two) FROM stdin;
56	1	dfdffd	0	0	4	4	6	10	\N	\N	\N	\N
57	1	sdfsf	0	0	4	4	6	6	\N	\N	\N	\N
58	1	asdasd	5	8	4	4	6	10	\N	\N	\N	\N
59	1	hjkhk	0	0	4	4	6	10	\N	\N	\N	\N
60	1	sadf	0	0	4	4	6	10	\N	\N	\N	\N
61	1	asdasd	0	0	4	4	6	10	1	\N	\N	\N
62	1	sdf	0	0	4	4	6	10	1	0	\N	\N
63	1	adf	0	0	4	4	6	10	1	0	\N	\N
64	1	asdas	0	0	4	4	6	10	1	0	\N	\N
65	1	asd	3	6	4	4	6	10	1	0	\N	\N
69	1	asdasd	13	21	4	4	6	10	1	9	\N	\N
66	1	sdasd	4	10	4	4	6	10	1	0	\N	\N
70	1	asdasd	0	0	4	4	6	-6	1	0	\N	\N
71	1	asdasd	41	88	4	4	6	-6	1	13	\N	\N
67	1	asdasd	8	14	4	4	6	10	1	3	\N	\N
74	1	asdasd	33	72	4	4	6	10	1	-8	\N	\N
73	1	afdads	14	32	4	4	6	-14	1	9	\N	\N
68	1	asdasd	8	11	4	4	6	10	1	3	\N	\N
72	1	asdasd	23	45	4	4	6	-6	1	30	\N	\N
55	1	sdfsdf	17	42	4	4	6	-6	\N	\N	\N	\N
\.


--
-- Name: hero_id_seq; Type: SEQUENCE SET; Schema: public; Owner: Guest
--

SELECT pg_catalog.setval('hero_id_seq', 74, true);


--
-- Data for Name: inventory; Type: TABLE DATA; Schema: public; Owner: Guest
--

COPY inventory (id, hero_id, item_id) FROM stdin;
\.


--
-- Name: inventory_id_seq; Type: SEQUENCE SET; Schema: public; Owner: Guest
--

SELECT pg_catalog.setval('inventory_id_seq', 1, false);


--
-- Data for Name: level; Type: TABLE DATA; Schema: public; Owner: Guest
--

COPY level (id, experience) FROM stdin;
1	20
2	40
3	60
4	80
5	100
6	120
7	140
8	160
9	180
10	200
11	220
12	240
13	260
14	280
15	300
\.


--
-- Name: level_id_seq; Type: SEQUENCE SET; Schema: public; Owner: Guest
--

SELECT pg_catalog.setval('level_id_seq', 25, true);


--
-- Data for Name: monster; Type: TABLE DATA; Schema: public; Owner: Guest
--

COPY monster (id, monster_name, monster_defense, monster_attack, monster_gold, monster_speed, monster_stamina, monster_exp, monster_level) FROM stdin;
3	Chad Bro	6	6	7	6	12	4	3
4	Chad Bro	6	6	8	6	12	4	3
5	Feminazi Scum	6	6	7	6	12	4	3
6	Christian Fundie	6	6	7	6	12	3	3
7	Feminazi Scum	6	6	5	6	12	3	3
8	Feminazi Scum	6	6	10	6	12	5	3
9	Christian Fundie	6	6	8	6	12	3	3
10	Chad Bro	6	6	10	6	12	3	3
11	Chad Bro	6	6	9	6	12	5	3
12	Christian Fundie	6	6	11	6	12	3	3
13	Christian Fundie	6	6	9	6	12	3	3
14	Christian Fundie	6	6	6	6	12	4	3
15	Christian Fundie	6	6	11	6	12	4	3
34	Christian Fundie	4	4	10	4	-8	5	4
35	Chad Bro	4	4	10	4	0	3	4
57	Christian Fundie	4	4	11	4	-4	4	4
36	Christian Fundie	4	4	9	4	0	4	4
37	Chad Bro	4	4	7	4	0	4	4
22	Christian Fundie	6	6	6	6	-16	3	4
23	Christian Fundie	6	6	8	6	12	4	4
24	Feminazi Scum	6	6	7	6	12	4	4
25	Chad Bro	6	6	8	6	12	4	4
38	Christian Fundie	4	4	8	4	4	4	4
17	Christian Fundie	6	6	6	6	-2	3	4
67	Christian Fundie	4	4	9	4	8	4	4
49	Christian Fundie	4	4	7	4	-8	4	4
68	Christian Fundie	4	4	11	4	8	3	4
39	Christian Fundie	4	4	8	4	-4	3	4
69	Christian Fundie	4	4	5	4	8	3	4
40	Chad Bro	4	4	5	4	0	4	4
58	Christian Fundie	4	4	10	4	-12	3	4
50	Christian Fundie	4	4	7	4	0	4	4
41	Christian Fundie	4	4	9	4	-12	5	4
19	Christian Fundie	6	6	6	6	-56	4	5
70	Christian Fundie	4	4	5	4	8	4	4
42	Christian Fundie	4	4	5	4	-8	4	4
71	Christian Fundie	4	4	9	4	8	5	4
43	Christian Fundie	4	4	9	4	-8	3	4
51	Christian Fundie	4	4	11	4	4	4	4
26	Christian Fundie	4	4	8	4	-142	4	4
20	Christian Fundie	6	6	7	6	-2	3	4
27	Christian Fundie	4	4	7	4	4	5	4
28	Chad Bro	4	4	10	4	8	3	4
44	Christian Fundie	4	4	6	4	-4	4	4
29	Christian Fundie	4	4	10	4	-4	3	4
52	Christian Fundie	4	4	10	4	-8	4	4
30	Christian Fundie	4	4	5	4	-4	3	4
31	Christian Fundie	4	4	5	4	-4	5	4
18	Christian Fundie	6	6	10	6	-38	5	4
21	Christian Fundie	6	6	6	6	-12	5	4
16	Christian Fundie	6	6	11	6	12	3	3
45	Christian Fundie	4	4	7	4	-4	5	4
59	Christian Fundie	4	4	7	4	0	3	4
46	Chad Bro	4	4	5	4	-4	3	4
32	Chad Bro	4	4	8	4	-8	4	4
33	Christian Fundie	4	4	5	4	0	5	4
53	Feminazi Scum	4	4	8	4	-4	5	4
47	Christian Fundie	4	4	11	4	-8	5	4
76	Christian Fundie	4	4	5	4	-4	3	4
60	Christian Fundie	4	4	6	4	-4	3	4
54	Christian Fundie	4	4	6	4	0	4	4
48	Christian Fundie	4	4	6	4	-8	4	4
55	Christian Fundie	4	4	5	4	-4	5	4
72	Christian Fundie	4	4	6	4	-8	3	4
79	Christian Fundie	4	4	5	4	-4	5	4
61	Christian Fundie	4	4	8	4	-8	4	4
56	Christian Fundie	4	4	8	4	4	4	4
73	Christian Fundie	4	4	10	4	-12	4	4
62	Christian Fundie	4	4	6	4	4	5	4
63	Christian Fundie	4	4	11	4	0	4	4
77	Christian Fundie	4	4	6	4	-8	5	4
64	Christian Fundie	4	4	8	4	0	5	4
65	Christian Fundie	4	4	11	4	0	3	4
66	Christian Fundie	4	4	10	4	8	3	4
74	Christian Fundie	4	4	6	4	-16	3	4
85	Christian Fundie	4	4	8	4	-8	4	4
80	Christian Fundie	4	4	8	4	-4	4	4
75	Christian Fundie	4	4	8	4	-4	5	4
78	Christian Fundie	4	4	8	4	0	4	4
82	Christian Fundie	4	4	10	4	-8	4	4
81	Christian Fundie	4	4	9	4	0	3	4
84	Christian Fundie	4	4	10	4	-4	5	4
83	Christian Fundie	4	4	8	4	-8	3	4
86	Christian Fundie	4	4	10	4	0	5	4
87	Christian Fundie	4	4	9	4	-4	3	4
88	Christian Fundie	4	4	10	4	0	5	4
89	Christian Fundie	4	4	7	4	-8	5	4
90	Christian Fundie	4	4	8	4	-8	4	4
91	Christian Fundie	4	4	10	4	0	4	4
92	Christian Fundie	4	4	5	4	0	4	4
93	Christian Fundie	4	4	9	4	0	5	4
94	Christian Fundie	4	4	5	4	-12	3	4
95	Christian Fundie	4	4	7	4	-8	4	4
96	Christian Fundie	4	4	11	4	-4	4	4
97	Christian Fundie	4	4	8	4	-8	3	4
98	Christian Fundie	4	4	6	4	4	3	4
99	Christian Fundie	4	4	6	4	-8	3	4
100	Christian Fundie	4	4	7	4	-8	4	4
101	Christian Fundie	4	4	11	4	-8	4	4
102	Christian Fundie	4	4	8	4	-8	3	4
103	Christian Fundie	4	4	9	4	4	4	4
104	Christian Fundie	4	4	9	4	-8	3	4
105	Christian Fundie	4	4	6	4	-12	3	4
106	Christian Fundie	4	4	7	4	-4	5	4
107	Christian Fundie	4	4	9	4	0	4	4
108	Christian Fundie	4	4	7	4	-8	4	4
109	Christian Fundie	4	4	10	4	-4	3	4
110	Christian Fundie	4	4	9	4	0	3	4
111	Christian Fundie	4	4	5	4	0	3	4
112	Christian Fundie	4	4	10	4	-8	5	4
\.


--
-- Name: monster_id_seq; Type: SEQUENCE SET; Schema: public; Owner: Guest
--

SELECT pg_catalog.setval('monster_id_seq', 112, true);


--
-- Data for Name: player; Type: TABLE DATA; Schema: public; Owner: Guest
--

COPY player (id, password, user_name) FROM stdin;
1	pass1	\N
2	pass2	\N
3	pass3	\N
4	pass4	\N
5	pass4	user4
6	123	bob
\.


--
-- Name: player_id_seq; Type: SEQUENCE SET; Schema: public; Owner: Guest
--

SELECT pg_catalog.setval('player_id_seq', 6, true);


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
-- Name: battle_pkey; Type: CONSTRAINT; Schema: public; Owner: Guest; Tablespace: 
--

ALTER TABLE ONLY battle
    ADD CONSTRAINT battle_pkey PRIMARY KEY (id);


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
-- Name: level_pkey; Type: CONSTRAINT; Schema: public; Owner: Guest; Tablespace: 
--

ALTER TABLE ONLY level
    ADD CONSTRAINT level_pkey PRIMARY KEY (id);


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

