CREATE TABLE public.tipo_animal
(
    id bigserial NOT NULL primary key,
    descricao character varying(200) NOT NULL
);

CREATE TABLE  public.veterinario
(
    id bigserial  NOT NULL primary key,
    nome character varying(100) NOT NULL,
    crmv character varying(20) NOT NULL,
    email character varying(100) NOT NULL,
    especialidade bigint NOT NULL references public.tipo_animal(id)
);

CREATE TABLE public.consulta
(
    id bigserial  NOT NULL primary key,
    veterinario bigint NOT NULL references veterinario(id),
    quando timestamp without time zone,
    tutor character varying(100) NOT NULL,
    animal character varying(100) NOT NULL,
    telefone_tutor character varying(100) ,
    queixa character varying(500)
);

