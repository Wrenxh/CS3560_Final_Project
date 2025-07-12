-- Table: public.student

-- DROP TABLE public.student;

CREATE TABLE IF NOT EXISTS public.student
(
  id serial NOT NULL,
  s_name character varying  COLLATE pg_catalog."default",
  s_address character varying COLLATE pg_catalog."default",
  degree character varying  COLLATE pg_catalog."default",
  CONSTRAINT student_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.student
  OWNER TO postgres;
  
-- Table: public.loan

-- DROP TABLE IF EXISTS public.loan;

CREATE TABLE IF NOT EXISTS public.loan
(
    id serial NOT NULL,
    startDate date,
	endDate date,
    CONSTRAINT loan_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.loan
    OWNER to postgres;

-- Table: public.recipt

-- DROP TABLE IF EXISTS public.recipt;

CREATE TABLE IF NOT EXISTS public.recipt
(
    recipt_id integer NOT NULL,
    loan_id integer NOT NULL,
	student_id integer NOT NULL,
    CONSTRAINT recipt_pkey PRIMARY KEY (recipt_id, loan_id),
    CONSTRAINT recipt_fk FOREIGN KEY (student_id)
        REFERENCES public.student (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID,
    CONSTRAINT loan_fk FOREIGN KEY (loan_id)
        REFERENCES public.loan (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.order_detail
    OWNER to postgres;
    
-- Table: public.book

-- DROP TABLE public.book;

CREATE TABLE IF NOT EXISTS public.book
(
  isbn serial NOT NULL,
  title character varying  COLLATE pg_catalog."default",
  description character varying COLLATE pg_catalog."default",
  author character varying  COLLATE pg_catalog."default",
  pages int NOT NULL,
  publisher character varying  COLLATE pg_catalog."default",
  pubDate date,
  isavalible int NOT NULL,
  CONSTRAINT book_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.book
  OWNER TO postgres;

CREATE TABLE IF NOT EXISTS public.copy
(
  id serial NOT NULL,
  barCode int NOT NULL,
  copy_location character varying  COLLATE pg_catalog."default",
  title character varying  COLLATE pg_catalog."default",
  description character varying COLLATE pg_catalog."default",
  author character varying  COLLATE pg_catalog."default",
  pages int NOT NULL,
  publisher character varying  COLLATE pg_catalog."default",
  pubDate date,
  isavalible int NOT NULL,
  CONSTRAINT copy_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.copy
  OWNER TO postgres;

-- Table: public.staff

-- DROP TABLE IF EXISTS public.staff;

CREATE TABLE IF NOT EXISTS public.staff
(
    staff_id int NOT NULL,
	student_id int NOT NULL,
	book_id int NOT NULL,
	staff_name character varying  COLLATE pg_catalog."default",
    CONSTRAINT staff_pkey PRIMARY KEY (staff_id),
    CONSTRAINT stud_fk FOREIGN KEY (student_id)
        REFERENCES public.student (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID,
    CONSTRAINT book_fk FOREIGN KEY (book_isbn)
        REFERENCES public.book (isbn) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.order_detail
    OWNER to postgres;