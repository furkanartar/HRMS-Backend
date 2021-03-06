-- This script was generated by a beta version of the ERD tool in pgAdmin 4.
-- Please log an issue at https://redmine.postgresql.org/projects/pgadmin4/issues/new if you find any bugs, including reproduction steps.
BEGIN;


CREATE TABLE public.cityies
(
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    name character varying NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE public.employees
(
    first_name character varying NOT NULL,
    last_name character varying NOT NULL,
    national_identity character varying NOT NULL,
    birth_date date NOT NULL,
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    user_id integer NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE public.employers
(
    company_name character varying NOT NULL,
    web_site character varying NOT NULL,
    phone_number character varying NOT NULL,
    user_id integer NOT NULL,
    PRIMARY KEY (user_id)
);

CREATE TABLE public.experiences
(
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    job_seeker_id integer NOT NULL,
    job_position_id integer NOT NULL,
    company_name character varying NOT NULL,
    starting_date date NOT NULL,
    ending_date date NOT NULL,
    working_status boolean NOT NULL,
    active boolean NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE public.images
(
    id integer NOT NULL,
    active boolean NOT NULL,
    image_path character varying NOT NULL,
    job_seeker_id integer NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE public.job_advertisements
(
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    employer_id integer NOT NULL,
    jobposition_id integer NOT NULL,
    city_id integer NOT NULL,
    description character varying NOT NULL,
    minimum_salary double precision NOT NULL,
    maximum_salary double precision NOT NULL,
    number_of_people_to_be_hired smallint NOT NULL,
    application_deadline date NOT NULL,
    active boolean NOT NULL,
    created_at date NOT NULL,
    last_modified_at date NOT NULL,
    way_of_working_id integer NOT NULL,
    remote boolean NOT NULL,
    hrms_auth boolean NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE public.job_positions
(
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    name character varying NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE public.job_seeker
(
    first_name character varying NOT NULL,
    last_name character varying NOT NULL,
    national_identity character varying NOT NULL,
    birth_date date NOT NULL,
    user_id integer NOT NULL,
    PRIMARY KEY (user_id)
);

CREATE TABLE public.languages
(
    id integer NOT NULL,
    language character varying(255) NOT NULL,
    language_level smallint NOT NULL,
    job_seeker_id integer NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE public.school_informations
(
    id integer NOT NULL,
    ending_date date NOT NULL,
    graduation_status boolean NOT NULL,
    school_name character varying NOT NULL,
    section_name character varying NOT NULL,
    starting_date date NOT NULL,
    job_seeker_id integer NOT NULL,
    active boolean NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE public.skills
(
    id integer NOT NULL,
    active boolean NOT NULL,
    skill character varying(255) NOT NULL,
    job_seeker_id integer NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE public.social_medias
(
    id integer NOT NULL,
    link character varying NOT NULL,
    job_seeker_id integer NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE public.users
(
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    email character varying NOT NULL,
    password character varying NOT NULL,
    active boolean NOT NULL,
    email_authentication_status boolean NOT NULL,
    created_at date NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE public.way_of_workings
(
    id integer NOT NULL,
    name character varying(255),
    PRIMARY KEY (id)
);

ALTER TABLE public.employees
    ADD FOREIGN KEY (user_id)
    REFERENCES public.users (id)
    NOT VALID;


ALTER TABLE public.employers
    ADD FOREIGN KEY (user_id)
    REFERENCES public.users (id)
    NOT VALID;


ALTER TABLE public.experiences
    ADD FOREIGN KEY (job_position_id)
    REFERENCES public.job_positions (id)
    NOT VALID;


ALTER TABLE public.experiences
    ADD FOREIGN KEY (job_seeker_id)
    REFERENCES public.job_seeker (user_id)
    NOT VALID;


ALTER TABLE public.images
    ADD FOREIGN KEY (job_seeker_id)
    REFERENCES public.job_seeker (user_id)
    NOT VALID;


ALTER TABLE public.job_advertisements
    ADD FOREIGN KEY (way_of_working_id)
    REFERENCES public.way_of_workings (id)
    NOT VALID;


ALTER TABLE public.job_advertisements
    ADD FOREIGN KEY (city_id)
    REFERENCES public.cityies (id)
    NOT VALID;


ALTER TABLE public.job_advertisements
    ADD FOREIGN KEY (employer_id)
    REFERENCES public.employers (user_id)
    NOT VALID;


ALTER TABLE public.job_advertisements
    ADD FOREIGN KEY (jobposition_id)
    REFERENCES public.job_positions (id)
    NOT VALID;


ALTER TABLE public.job_seeker
    ADD FOREIGN KEY (user_id)
    REFERENCES public.users (id)
    NOT VALID;


ALTER TABLE public.languages
    ADD FOREIGN KEY (job_seeker_id)
    REFERENCES public.job_seeker (user_id)
    NOT VALID;


ALTER TABLE public.school_informations
    ADD FOREIGN KEY (job_seeker_id)
    REFERENCES public.job_seeker (user_id)
    NOT VALID;


ALTER TABLE public.skills
    ADD FOREIGN KEY (job_seeker_id)
    REFERENCES public.job_seeker (user_id)
    NOT VALID;


ALTER TABLE public.social_medias
    ADD FOREIGN KEY (job_seeker_id)
    REFERENCES public.job_seeker (user_id)
    NOT VALID;

END;