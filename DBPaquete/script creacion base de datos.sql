--
-- PostgreSQL database dump
--

-- Dumped from database version 15.1
-- Dumped by pg_dump version 15.1

-- Started on 2023-03-01 07:56:45

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 214 (class 1259 OID 49364)
-- Name: Alojamiento; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."Alojamiento" (
    "alojamientoId" bigint NOT NULL,
    nombre text,
    latitud text,
    longitud text,
    precio numeric,
    descripcion text,
    "ciudadId" bigint,
    "fotoId" bigint,
    "horarioCheckIn" bigint,
    "horarioCheckOut" bigint,
    disponible boolean,
    "categoriaId" bigint
);


ALTER TABLE public."Alojamiento" OWNER TO postgres;

--
-- TOC entry 215 (class 1259 OID 49369)
-- Name: Alojamiento_alojamientoId_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public."Alojamiento_alojamientoId_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public."Alojamiento_alojamientoId_seq" OWNER TO postgres;

--
-- TOC entry 3512 (class 0 OID 0)
-- Dependencies: 215
-- Name: Alojamiento_alojamientoId_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public."Alojamiento_alojamientoId_seq" OWNED BY public."Alojamiento"."alojamientoId";


--
-- TOC entry 216 (class 1259 OID 49370)
-- Name: Categoria; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."Categoria" (
    "categoriaId" bigint NOT NULL,
    "numeroEstrella" bigint
);


ALTER TABLE public."Categoria" OWNER TO postgres;

--
-- TOC entry 217 (class 1259 OID 49373)
-- Name: Ciudad; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."Ciudad" (
    "ciudadId" bigint NOT NULL,
    nombre text,
    "provinciaId" bigint
);


ALTER TABLE public."Ciudad" OWNER TO postgres;

--
-- TOC entry 218 (class 1259 OID 49378)
-- Name: Ciudad_ciudadId_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public."Ciudad_ciudadId_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public."Ciudad_ciudadId_seq" OWNER TO postgres;

--
-- TOC entry 3513 (class 0 OID 0)
-- Dependencies: 218
-- Name: Ciudad_ciudadId_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public."Ciudad_ciudadId_seq" OWNED BY public."Ciudad"."ciudadId";


--
-- TOC entry 219 (class 1259 OID 49379)
-- Name: Domicilio; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."Domicilio" (
    "domicilioId" bigint NOT NULL,
    "ciudadId" bigint,
    calle text,
    altura text,
    "codigoPostal" text
);


ALTER TABLE public."Domicilio" OWNER TO postgres;

--
-- TOC entry 220 (class 1259 OID 49384)
-- Name: Domicilio_domicilioId_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public."Domicilio_domicilioId_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public."Domicilio_domicilioId_seq" OWNER TO postgres;

--
-- TOC entry 3514 (class 0 OID 0)
-- Dependencies: 220
-- Name: Domicilio_domicilioId_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public."Domicilio_domicilioId_seq" OWNED BY public."Domicilio"."domicilioId";


--
-- TOC entry 221 (class 1259 OID 49385)
-- Name: EstadoReserva; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."EstadoReserva" (
    "estadoReservaId" bigint NOT NULL,
    nombre text
);


ALTER TABLE public."EstadoReserva" OWNER TO postgres;

--
-- TOC entry 222 (class 1259 OID 49390)
-- Name: Foto; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."Foto" (
    "fotoId" bigint NOT NULL,
    url text,
    extension text
);


ALTER TABLE public."Foto" OWNER TO postgres;

--
-- TOC entry 223 (class 1259 OID 49395)
-- Name: Foto_fotoId_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public."Foto_fotoId_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public."Foto_fotoId_seq" OWNER TO postgres;

--
-- TOC entry 3515 (class 0 OID 0)
-- Dependencies: 223
-- Name: Foto_fotoId_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public."Foto_fotoId_seq" OWNED BY public."Foto"."fotoId";


--
-- TOC entry 224 (class 1259 OID 49396)
-- Name: Habitacion; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."Habitacion" (
    "habitacionId" bigint NOT NULL,
    nombre text,
    capacidad bigint,
    "precioNoche" numeric,
    descripcion text,
    "alojamientoId" bigint
);


ALTER TABLE public."Habitacion" OWNER TO postgres;

--
-- TOC entry 225 (class 1259 OID 49401)
-- Name: Habitacion_habitacionId_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public."Habitacion_habitacionId_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public."Habitacion_habitacionId_seq" OWNER TO postgres;

--
-- TOC entry 3516 (class 0 OID 0)
-- Dependencies: 225
-- Name: Habitacion_habitacionId_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public."Habitacion_habitacionId_seq" OWNED BY public."Habitacion"."habitacionId";


--
-- TOC entry 226 (class 1259 OID 49402)
-- Name: Imagen; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."Imagen" (
    "imagenId" bigint NOT NULL,
    url text
);


ALTER TABLE public."Imagen" OWNER TO postgres;

--
-- TOC entry 227 (class 1259 OID 49407)
-- Name: Imagen_imagenId_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public."Imagen_imagenId_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public."Imagen_imagenId_seq" OWNER TO postgres;

--
-- TOC entry 3517 (class 0 OID 0)
-- Dependencies: 227
-- Name: Imagen_imagenId_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public."Imagen_imagenId_seq" OWNED BY public."Imagen"."imagenId";


--
-- TOC entry 228 (class 1259 OID 49408)
-- Name: Login; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."Login" (
    "loginId" bigint NOT NULL,
    nombre text,
    "contraseña" text
);


ALTER TABLE public."Login" OWNER TO postgres;

--
-- TOC entry 229 (class 1259 OID 49413)
-- Name: Login_loginId_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public."Login_loginId_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public."Login_loginId_seq" OWNER TO postgres;

--
-- TOC entry 3518 (class 0 OID 0)
-- Dependencies: 229
-- Name: Login_loginId_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public."Login_loginId_seq" OWNED BY public."Login"."loginId";


--
-- TOC entry 230 (class 1259 OID 49414)
-- Name: Oferta; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."Oferta" (
    "ofertaId" bigint NOT NULL,
    "fechaInicio" timestamp with time zone,
    "fechaFin" timestamp with time zone,
    descuento numeric,
    descripcion text,
    nombre text,
    "alojamientoId" bigint
);


ALTER TABLE public."Oferta" OWNER TO postgres;

--
-- TOC entry 231 (class 1259 OID 49419)
-- Name: Oferta_ofertaId_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public."Oferta_ofertaId_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public."Oferta_ofertaId_seq" OWNER TO postgres;

--
-- TOC entry 3519 (class 0 OID 0)
-- Dependencies: 231
-- Name: Oferta_ofertaId_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public."Oferta_ofertaId_seq" OWNED BY public."Oferta"."ofertaId";


--
-- TOC entry 232 (class 1259 OID 49420)
-- Name: Pago; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."Pago" (
    "pagoId" bigint NOT NULL,
    monto numeric,
    fecha timestamp with time zone,
    "codigoBarra" text,
    "ultimosDigitos" bigint,
    cbu bigint
);


ALTER TABLE public."Pago" OWNER TO postgres;

--
-- TOC entry 233 (class 1259 OID 49425)
-- Name: Pago_pagoId_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public."Pago_pagoId_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public."Pago_pagoId_seq" OWNER TO postgres;

--
-- TOC entry 3520 (class 0 OID 0)
-- Dependencies: 233
-- Name: Pago_pagoId_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public."Pago_pagoId_seq" OWNED BY public."Pago"."pagoId";


--
-- TOC entry 234 (class 1259 OID 49426)
-- Name: Pais; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."Pais" (
    "paisId" bigint NOT NULL,
    nombre text
);


ALTER TABLE public."Pais" OWNER TO postgres;

--
-- TOC entry 235 (class 1259 OID 49431)
-- Name: Pais_paisId_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public."Pais_paisId_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public."Pais_paisId_seq" OWNER TO postgres;

--
-- TOC entry 3521 (class 0 OID 0)
-- Dependencies: 235
-- Name: Pais_paisId_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public."Pais_paisId_seq" OWNED BY public."Pais"."paisId";


--
-- TOC entry 236 (class 1259 OID 49432)
-- Name: Paquete; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."Paquete" (
    "paqueteId" bigint NOT NULL,
    nombre text,
    descripcion text,
    "cantidadDias" bigint,
    "cantidadNoches" bigint,
    "imagenId" bigint,
    "alojamientoId" bigint
);


ALTER TABLE public."Paquete" OWNER TO postgres;

--
-- TOC entry 237 (class 1259 OID 49437)
-- Name: Paquete_paqueteId_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public."Paquete_paqueteId_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public."Paquete_paqueteId_seq" OWNER TO postgres;

--
-- TOC entry 3522 (class 0 OID 0)
-- Dependencies: 237
-- Name: Paquete_paqueteId_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public."Paquete_paqueteId_seq" OWNED BY public."Paquete"."paqueteId";


--
-- TOC entry 238 (class 1259 OID 49438)
-- Name: Provincia; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."Provincia" (
    "provinciaId" bigint NOT NULL,
    nombre text,
    "paisId" bigint
);


ALTER TABLE public."Provincia" OWNER TO postgres;

--
-- TOC entry 239 (class 1259 OID 49443)
-- Name: Provincia_provinciaId_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public."Provincia_provinciaId_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public."Provincia_provinciaId_seq" OWNER TO postgres;

--
-- TOC entry 3523 (class 0 OID 0)
-- Dependencies: 239
-- Name: Provincia_provinciaId_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public."Provincia_provinciaId_seq" OWNED BY public."Provincia"."provinciaId";


--
-- TOC entry 240 (class 1259 OID 49444)
-- Name: Reserva; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."Reserva" (
    numero bigint NOT NULL,
    "usuarioId" bigint,
    "fechaInicio" timestamp with time zone,
    "fechaFin" timestamp with time zone,
    "pagoId" bigint,
    "paqueteId" bigint,
    "servicioPagoId" bigint,
    "estadoReservaId" bigint
);


ALTER TABLE public."Reserva" OWNER TO postgres;

--
-- TOC entry 241 (class 1259 OID 49447)
-- Name: Reserva_numero_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public."Reserva_numero_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public."Reserva_numero_seq" OWNER TO postgres;

--
-- TOC entry 3524 (class 0 OID 0)
-- Dependencies: 241
-- Name: Reserva_numero_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public."Reserva_numero_seq" OWNED BY public."Reserva".numero;


--
-- TOC entry 242 (class 1259 OID 49448)
-- Name: Rol; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."Rol" (
    "rolId" bigint NOT NULL,
    descripcion text
);


ALTER TABLE public."Rol" OWNER TO postgres;

--
-- TOC entry 243 (class 1259 OID 49453)
-- Name: Rol_rolId_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public."Rol_rolId_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public."Rol_rolId_seq" OWNER TO postgres;

--
-- TOC entry 3525 (class 0 OID 0)
-- Dependencies: 243
-- Name: Rol_rolId_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public."Rol_rolId_seq" OWNED BY public."Rol"."rolId";


--
-- TOC entry 244 (class 1259 OID 49454)
-- Name: Servicio; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."Servicio" (
    "servicioId" bigint NOT NULL,
    nombre text,
    descripcion text,
    "alojamientoId" bigint
);


ALTER TABLE public."Servicio" OWNER TO postgres;

--
-- TOC entry 245 (class 1259 OID 49459)
-- Name: ServicioPago; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."ServicioPago" (
    "servicioPagoId" bigint NOT NULL,
    nombre text
);


ALTER TABLE public."ServicioPago" OWNER TO postgres;

--
-- TOC entry 246 (class 1259 OID 49464)
-- Name: Servicio_servicioId_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public."Servicio_servicioId_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public."Servicio_servicioId_seq" OWNER TO postgres;

--
-- TOC entry 3526 (class 0 OID 0)
-- Dependencies: 246
-- Name: Servicio_servicioId_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public."Servicio_servicioId_seq" OWNED BY public."Servicio"."servicioId";


--
-- TOC entry 247 (class 1259 OID 49465)
-- Name: Usuario; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."Usuario" (
    "usuarioId" bigint NOT NULL,
    "rolId" bigint NOT NULL,
    nombre text,
    "domicilioId" bigint,
    "fechaNacimiento" date,
    dni text,
    "tipoDocumento" text,
    telefono bigint,
    apellido text,
    "loginId" bigint NOT NULL
);


ALTER TABLE public."Usuario" OWNER TO postgres;

--
-- TOC entry 248 (class 1259 OID 49470)
-- Name: Usuario_usuarioId_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public."Usuario_usuarioId_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public."Usuario_usuarioId_seq" OWNER TO postgres;

--
-- TOC entry 3527 (class 0 OID 0)
-- Dependencies: 248
-- Name: Usuario_usuarioId_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public."Usuario_usuarioId_seq" OWNED BY public."Usuario"."usuarioId";


--
-- TOC entry 3260 (class 2604 OID 49471)
-- Name: Alojamiento alojamientoId; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Alojamiento" ALTER COLUMN "alojamientoId" SET DEFAULT nextval('public."Alojamiento_alojamientoId_seq"'::regclass);


--
-- TOC entry 3261 (class 2604 OID 49472)
-- Name: Ciudad ciudadId; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Ciudad" ALTER COLUMN "ciudadId" SET DEFAULT nextval('public."Ciudad_ciudadId_seq"'::regclass);


--
-- TOC entry 3262 (class 2604 OID 49473)
-- Name: Domicilio domicilioId; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Domicilio" ALTER COLUMN "domicilioId" SET DEFAULT nextval('public."Domicilio_domicilioId_seq"'::regclass);


--
-- TOC entry 3263 (class 2604 OID 49474)
-- Name: Foto fotoId; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Foto" ALTER COLUMN "fotoId" SET DEFAULT nextval('public."Foto_fotoId_seq"'::regclass);


--
-- TOC entry 3264 (class 2604 OID 49475)
-- Name: Habitacion habitacionId; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Habitacion" ALTER COLUMN "habitacionId" SET DEFAULT nextval('public."Habitacion_habitacionId_seq"'::regclass);


--
-- TOC entry 3265 (class 2604 OID 49476)
-- Name: Imagen imagenId; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Imagen" ALTER COLUMN "imagenId" SET DEFAULT nextval('public."Imagen_imagenId_seq"'::regclass);


--
-- TOC entry 3266 (class 2604 OID 49477)
-- Name: Login loginId; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Login" ALTER COLUMN "loginId" SET DEFAULT nextval('public."Login_loginId_seq"'::regclass);


--
-- TOC entry 3267 (class 2604 OID 49478)
-- Name: Oferta ofertaId; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Oferta" ALTER COLUMN "ofertaId" SET DEFAULT nextval('public."Oferta_ofertaId_seq"'::regclass);


--
-- TOC entry 3268 (class 2604 OID 49479)
-- Name: Pago pagoId; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Pago" ALTER COLUMN "pagoId" SET DEFAULT nextval('public."Pago_pagoId_seq"'::regclass);


--
-- TOC entry 3269 (class 2604 OID 49480)
-- Name: Pais paisId; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Pais" ALTER COLUMN "paisId" SET DEFAULT nextval('public."Pais_paisId_seq"'::regclass);


--
-- TOC entry 3270 (class 2604 OID 49481)
-- Name: Paquete paqueteId; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Paquete" ALTER COLUMN "paqueteId" SET DEFAULT nextval('public."Paquete_paqueteId_seq"'::regclass);


--
-- TOC entry 3271 (class 2604 OID 49482)
-- Name: Provincia provinciaId; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Provincia" ALTER COLUMN "provinciaId" SET DEFAULT nextval('public."Provincia_provinciaId_seq"'::regclass);


--
-- TOC entry 3272 (class 2604 OID 49483)
-- Name: Reserva numero; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Reserva" ALTER COLUMN numero SET DEFAULT nextval('public."Reserva_numero_seq"'::regclass);


--
-- TOC entry 3273 (class 2604 OID 49484)
-- Name: Rol rolId; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Rol" ALTER COLUMN "rolId" SET DEFAULT nextval('public."Rol_rolId_seq"'::regclass);


--
-- TOC entry 3274 (class 2604 OID 49485)
-- Name: Servicio servicioId; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Servicio" ALTER COLUMN "servicioId" SET DEFAULT nextval('public."Servicio_servicioId_seq"'::regclass);


--
-- TOC entry 3275 (class 2604 OID 49486)
-- Name: Usuario usuarioId; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Usuario" ALTER COLUMN "usuarioId" SET DEFAULT nextval('public."Usuario_usuarioId_seq"'::regclass);





--
-- TOC entry 3528 (class 0 OID 0)
-- Dependencies: 215
-- Name: Alojamiento_alojamientoId_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public."Alojamiento_alojamientoId_seq"', 1, false);


--
-- TOC entry 3529 (class 0 OID 0)
-- Dependencies: 218
-- Name: Ciudad_ciudadId_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public."Ciudad_ciudadId_seq"', 1, false);


--
-- TOC entry 3530 (class 0 OID 0)
-- Dependencies: 220
-- Name: Domicilio_domicilioId_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public."Domicilio_domicilioId_seq"', 1, false);


--
-- TOC entry 3531 (class 0 OID 0)
-- Dependencies: 223
-- Name: Foto_fotoId_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public."Foto_fotoId_seq"', 1, false);


--
-- TOC entry 3532 (class 0 OID 0)
-- Dependencies: 225
-- Name: Habitacion_habitacionId_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public."Habitacion_habitacionId_seq"', 4, true);


--
-- TOC entry 3533 (class 0 OID 0)
-- Dependencies: 227
-- Name: Imagen_imagenId_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public."Imagen_imagenId_seq"', 1, false);


--
-- TOC entry 3534 (class 0 OID 0)
-- Dependencies: 229
-- Name: Login_loginId_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public."Login_loginId_seq"', 1, false);


--
-- TOC entry 3535 (class 0 OID 0)
-- Dependencies: 231
-- Name: Oferta_ofertaId_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public."Oferta_ofertaId_seq"', 1, false);


--
-- TOC entry 3536 (class 0 OID 0)
-- Dependencies: 233
-- Name: Pago_pagoId_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public."Pago_pagoId_seq"', 1, false);


--
-- TOC entry 3537 (class 0 OID 0)
-- Dependencies: 235
-- Name: Pais_paisId_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public."Pais_paisId_seq"', 6, true);


--
-- TOC entry 3538 (class 0 OID 0)
-- Dependencies: 237
-- Name: Paquete_paqueteId_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public."Paquete_paqueteId_seq"', 1, false);


--
-- TOC entry 3539 (class 0 OID 0)
-- Dependencies: 239
-- Name: Provincia_provinciaId_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public."Provincia_provinciaId_seq"', 21, true);


--
-- TOC entry 3540 (class 0 OID 0)
-- Dependencies: 241
-- Name: Reserva_numero_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public."Reserva_numero_seq"', 1, false);


--
-- TOC entry 3541 (class 0 OID 0)
-- Dependencies: 243
-- Name: Rol_rolId_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public."Rol_rolId_seq"', 2, true);


--
-- TOC entry 3542 (class 0 OID 0)
-- Dependencies: 246
-- Name: Servicio_servicioId_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public."Servicio_servicioId_seq"', 1, true);


--
-- TOC entry 3543 (class 0 OID 0)
-- Dependencies: 248
-- Name: Usuario_usuarioId_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public."Usuario_usuarioId_seq"', 1, false);


--
-- TOC entry 3277 (class 2606 OID 49488)
-- Name: Alojamiento Alojamiento_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Alojamiento"
    ADD CONSTRAINT "Alojamiento_pkey" PRIMARY KEY ("alojamientoId");


--
-- TOC entry 3279 (class 2606 OID 49490)
-- Name: Categoria Categoria_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Categoria"
    ADD CONSTRAINT "Categoria_pkey" PRIMARY KEY ("categoriaId");


--
-- TOC entry 3281 (class 2606 OID 49492)
-- Name: Ciudad Ciudad_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Ciudad"
    ADD CONSTRAINT "Ciudad_pkey" PRIMARY KEY ("ciudadId");


--
-- TOC entry 3283 (class 2606 OID 49494)
-- Name: Domicilio Domicilio_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Domicilio"
    ADD CONSTRAINT "Domicilio_pkey" PRIMARY KEY ("domicilioId");


--
-- TOC entry 3285 (class 2606 OID 49496)
-- Name: EstadoReserva EstadoReserva_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."EstadoReserva"
    ADD CONSTRAINT "EstadoReserva_pkey" PRIMARY KEY ("estadoReservaId");


--
-- TOC entry 3287 (class 2606 OID 49498)
-- Name: Foto Foto_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Foto"
    ADD CONSTRAINT "Foto_pkey" PRIMARY KEY ("fotoId");


--
-- TOC entry 3289 (class 2606 OID 49500)
-- Name: Habitacion Habitacion_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Habitacion"
    ADD CONSTRAINT "Habitacion_pkey" PRIMARY KEY ("habitacionId");


--
-- TOC entry 3291 (class 2606 OID 49502)
-- Name: Imagen Imagen_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Imagen"
    ADD CONSTRAINT "Imagen_pkey" PRIMARY KEY ("imagenId");


--
-- TOC entry 3295 (class 2606 OID 49504)
-- Name: Oferta Oferta_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Oferta"
    ADD CONSTRAINT "Oferta_pkey" PRIMARY KEY ("ofertaId");


--
-- TOC entry 3297 (class 2606 OID 49506)
-- Name: Pago Pago_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Pago"
    ADD CONSTRAINT "Pago_pkey" PRIMARY KEY ("pagoId");


--
-- TOC entry 3299 (class 2606 OID 49508)
-- Name: Pais Pais_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Pais"
    ADD CONSTRAINT "Pais_pkey" PRIMARY KEY ("paisId");


--
-- TOC entry 3301 (class 2606 OID 49510)
-- Name: Paquete Paquete_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Paquete"
    ADD CONSTRAINT "Paquete_pkey" PRIMARY KEY ("paqueteId");


--
-- TOC entry 3303 (class 2606 OID 49512)
-- Name: Provincia Provincia_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Provincia"
    ADD CONSTRAINT "Provincia_pkey" PRIMARY KEY ("provinciaId");


--
-- TOC entry 3305 (class 2606 OID 49514)
-- Name: Reserva Reserva_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Reserva"
    ADD CONSTRAINT "Reserva_pkey" PRIMARY KEY (numero);


--
-- TOC entry 3307 (class 2606 OID 49516)
-- Name: Rol Rol_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Rol"
    ADD CONSTRAINT "Rol_pkey" PRIMARY KEY ("rolId");


--
-- TOC entry 3309 (class 2606 OID 49518)
-- Name: Servicio Servicio_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Servicio"
    ADD CONSTRAINT "Servicio_pkey" PRIMARY KEY ("servicioId");


--
-- TOC entry 3313 (class 2606 OID 49520)
-- Name: Usuario Usuario_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Usuario"
    ADD CONSTRAINT "Usuario_pkey" PRIMARY KEY ("usuarioId");


--
-- TOC entry 3293 (class 2606 OID 49522)
-- Name: Login loginId; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Login"
    ADD CONSTRAINT "loginId" PRIMARY KEY ("loginId") INCLUDE ("loginId");


--
-- TOC entry 3311 (class 2606 OID 49524)
-- Name: ServicioPago servicioPago_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."ServicioPago"
    ADD CONSTRAINT "servicioPago_pkey" PRIMARY KEY ("servicioPagoId");


--
-- TOC entry 3314 (class 2606 OID 49525)
-- Name: Alojamiento FK_ALOJAMIENTO_CIUDAD; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Alojamiento"
    ADD CONSTRAINT "FK_ALOJAMIENTO_CIUDAD" FOREIGN KEY ("ciudadId") REFERENCES public."Ciudad"("ciudadId") NOT VALID;


--
-- TOC entry 3315 (class 2606 OID 49530)
-- Name: Alojamiento FK_ALOJAMIENTO_IMAGEN; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Alojamiento"
    ADD CONSTRAINT "FK_ALOJAMIENTO_IMAGEN" FOREIGN KEY ("fotoId") REFERENCES public."Foto"("fotoId") NOT VALID;


--
-- TOC entry 3316 (class 2606 OID 49535)
-- Name: Ciudad FK_CIUDAD_PROVINCIA; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Ciudad"
    ADD CONSTRAINT "FK_CIUDAD_PROVINCIA" FOREIGN KEY ("provinciaId") REFERENCES public."Provincia"("provinciaId") NOT VALID;


--
-- TOC entry 3317 (class 2606 OID 49540)
-- Name: Domicilio FK_DOMICILIO_CIUDAD; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Domicilio"
    ADD CONSTRAINT "FK_DOMICILIO_CIUDAD" FOREIGN KEY ("ciudadId") REFERENCES public."Ciudad"("ciudadId") NOT VALID;


--
-- TOC entry 3318 (class 2606 OID 49545)
-- Name: Habitacion FK_HABITACION_ALOJAMIENTO; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Habitacion"
    ADD CONSTRAINT "FK_HABITACION_ALOJAMIENTO" FOREIGN KEY ("alojamientoId") REFERENCES public."Alojamiento"("alojamientoId") NOT VALID;


--
-- TOC entry 3319 (class 2606 OID 49550)
-- Name: Oferta FK_OFERTA_ALOJAMIENTO; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Oferta"
    ADD CONSTRAINT "FK_OFERTA_ALOJAMIENTO" FOREIGN KEY ("alojamientoId") REFERENCES public."Alojamiento"("alojamientoId") NOT VALID;


--
-- TOC entry 3320 (class 2606 OID 49555)
-- Name: Paquete FK_PAQUETE_ALOJAMIENTO; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Paquete"
    ADD CONSTRAINT "FK_PAQUETE_ALOJAMIENTO" FOREIGN KEY ("alojamientoId") REFERENCES public."Alojamiento"("alojamientoId") NOT VALID;


--
-- TOC entry 3321 (class 2606 OID 49560)
-- Name: Paquete FK_PAQUETE_IMAGEN; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Paquete"
    ADD CONSTRAINT "FK_PAQUETE_IMAGEN" FOREIGN KEY ("imagenId") REFERENCES public."Imagen"("imagenId") NOT VALID;


--
-- TOC entry 3322 (class 2606 OID 49565)
-- Name: Provincia FK_PROVINCIA_PAIS; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Provincia"
    ADD CONSTRAINT "FK_PROVINCIA_PAIS" FOREIGN KEY ("paisId") REFERENCES public."Pais"("paisId") NOT VALID;


--
-- TOC entry 3323 (class 2606 OID 49570)
-- Name: Reserva FK_RESERVA_ESTADORESERVA; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Reserva"
    ADD CONSTRAINT "FK_RESERVA_ESTADORESERVA" FOREIGN KEY ("estadoReservaId") REFERENCES public."EstadoReserva"("estadoReservaId") NOT VALID;


--
-- TOC entry 3324 (class 2606 OID 49575)
-- Name: Reserva FK_RESERVA_PAGO; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Reserva"
    ADD CONSTRAINT "FK_RESERVA_PAGO" FOREIGN KEY ("pagoId") REFERENCES public."Pago"("pagoId") NOT VALID;


--
-- TOC entry 3325 (class 2606 OID 49580)
-- Name: Reserva FK_RESERVA_SERVICIOPAGO; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Reserva"
    ADD CONSTRAINT "FK_RESERVA_SERVICIOPAGO" FOREIGN KEY ("servicioPagoId") REFERENCES public."ServicioPago"("servicioPagoId") NOT VALID;


--
-- TOC entry 3326 (class 2606 OID 49585)
-- Name: Servicio FK_SERVICIO_ALOJAMIENTO; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Servicio"
    ADD CONSTRAINT "FK_SERVICIO_ALOJAMIENTO" FOREIGN KEY ("alojamientoId") REFERENCES public."Alojamiento"("alojamientoId") NOT VALID;


--
-- TOC entry 3327 (class 2606 OID 49590)
-- Name: Usuario FK_Usuario__DOMICILIO; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Usuario"
    ADD CONSTRAINT "FK_Usuario__DOMICILIO" FOREIGN KEY ("domicilioId") REFERENCES public."Domicilio"("domicilioId") NOT VALID;


--
-- TOC entry 3328 (class 2606 OID 49595)
-- Name: Usuario FK_Usuario__Login; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Usuario"
    ADD CONSTRAINT "FK_Usuario__Login" FOREIGN KEY ("loginId") REFERENCES public."Login"("loginId") NOT VALID;


--
-- TOC entry 3329 (class 2606 OID 49600)
-- Name: Usuario FK_Usuario__Rol; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Usuario"
    ADD CONSTRAINT "FK_Usuario__Rol" FOREIGN KEY ("rolId") REFERENCES public."Rol"("rolId");


-- Completed on 2023-03-01 07:56:45

--
-- PostgreSQL database dump complete
--

