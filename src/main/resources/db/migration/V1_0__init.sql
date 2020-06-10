
-- -------------------------------------
--  Table structure for wc_stadium
-- -------------------------------------

DROP TABLE IF EXISTS wc_stadium;

CREATE TABLE wc_stadium (
  id int4 NOT NULL,
  name text NOT NULL,
  location text NOT NULL,
  PRIMARY KEY (id)
);


-----------------------------
--  Table structure for wc_team
-- -------------------------------------

DROP TABLE IF EXISTS wc_team;
CREATE TABLE wc_team (
  code varchar(6) NOT NULL,
  code_alt varchar(3) NOT NULL,
  name text NOT NULL,
  PRIMARY KEY (code)
);



-- ---------------------------------------
--  Table structure for wc_standings
-- ---------------------------------------

DROP TABLE IF EXISTS wc_standings;

CREATE TABLE wc_standings (
  team VARCHAR(6) NOT NULL,
  group_letter text not NULL,
  games int NOT NULL DEFAULT 0,
  wins int NOT NULL DEFAULT 0,
  draws int NOT NULL DEFAULT 0,
  loses int NOT NULL DEFAULT 0,
  scored_goals int NOT NULL DEFAULT 0,
  received_goals int NOT NULL DEFAULT 0,
  points int NOT NULL DEFAULT 0,
  PRIMARY KEY (team)
);



-- -------------------------------------
--  Table structure for wc_fixture
-- -------------------------------------

DROP TABLE IF EXISTS wc_fixture;

CREATE SEQUENCE fixture_id_seq;

CREATE TABLE wc_fixture (
  id int8 NOT NULL DEFAULT nextval('fixture_id_seq'),
  stage text NOT NULL,
  stadium int4 NOT NULL DEFAULT 1,
  datetime timestamp(6) NOT NULL,
  local VARCHAR(6) NOT NULL,
  visitor VARCHAR(6) NOT NULL,
  goals_local int DEFAULT -1,
  goals_visitor int DEFAULT -1 ,
  PRIMARY KEY (id)
);

ALTER SEQUENCE fixture_id_seq OWNED BY wc_fixture.id;






-------------------------------------------
-- QUINIELA!!!!!
--------------------------

-- -------------------------------------
--  Table structure for wc_quiniela
-- -------------------------------------


DROP TABLE IF EXISTS wc_quiniela;


CREATE TABLE wc_quiniela_master (
  match int8 NOT NULL,
  local VARCHAR(6) NOT NULL,
  visitor VARCHAR(6) NOT NULL,
  goals_local int NOT NULL,
  goals_visitor int NOT NULL,
  PRIMARY KEY (match)
);


CREATE TABLE wc_quiniela (
  username text NOT NULL,
  match int8 NOT NULL,
  local VARCHAR(6) NOT NULL,
  visitor VARCHAR(6) NOT NULL,
  goals_local int DEFAULT -1,
  goals_visitor int DEFAULT -1 ,
  PRIMARY KEY (username, match)
);




-------------------------------------------
-- LEAGUEEE!!!!!
--------------------------


-- -------------------------------------
--  Table structure for wc_league
-- -------------------------------------


DROP TABLE IF EXISTS wc_league;

CREATE SEQUENCE league_id_seq;

CREATE TABLE wc_league (
  id int8 NOT NULL DEFAULT nextval('league_id_seq'),
  name text NOT NULL UNIQUE ,
  type text NOT NULL DEFAULT 'standard',
  uuid text NOT NULL UNIQUE,
  PRIMARY KEY (id)
);


ALTER SEQUENCE league_id_seq OWNED BY wc_league.id;



-- -------------------------------------
--  Table structure for wc_user_leagues
-- -------------------------------------


DROP TABLE IF EXISTS wc_user_leagues;

CREATE TABLE wc_user_leagues (
  username text NOT NULL,
  league int4 NOT NULL DEFAULT 0,
  current_position int4,
  previous_position int4,
  admin BOOLEAN NOT NULL DEFAULT FALSE ,
  PRIMARY KEY (username,league)
);

