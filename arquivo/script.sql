
--
-- Name: addresss; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.addresss (
    uuid character varying(255) NOT NULL,
    date_creation timestamp without time zone,
    date_update timestamp without time zone,
    status boolean NOT NULL,
    address character varying(255),
    cep character varying(255),
    complement character varying(255),
    district character varying(255),
    number character varying(255),
    city_id character varying(255),
    client_id character varying(255)
);


--
-- Name: category; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.category (
    uuid character varying(255) NOT NULL,
    date_creation timestamp without time zone,
    date_update timestamp without time zone,
    status boolean NOT NULL,
    nome character varying(255)
);


--
-- Name: citys; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.citys (
    uuid character varying(255) NOT NULL,
    date_creation timestamp without time zone,
    date_update timestamp without time zone,
    status boolean NOT NULL,
    name character varying(255),
    state_id character varying(255)
);


--
-- Name: client; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.client (
    uuid character varying(255) NOT NULL,
    date_creation timestamp without time zone,
    date_update timestamp without time zone,
    status boolean NOT NULL,
    cnpj character varying(255),
    cpf character varying(255),
    email character varying(255),
    nature integer,
    nome character varying(255)
);


--
-- Name: order_items; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.order_items (
    uuid character varying(255) NOT NULL,
    date_creation timestamp without time zone,
    date_update timestamp without time zone,
    status boolean NOT NULL,
    discount numeric(19,2),
    quantity integer,
    total_price numeric(19,2),
    unity_price numeric(19,2),
    order_id character varying(255),
    product_id character varying(255)
);


--
-- Name: payment; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.payment (
    uuid character varying(255) NOT NULL,
    date_creation timestamp without time zone,
    date_update timestamp without time zone,
    status boolean NOT NULL,
    state_payment integer,
    order_id character varying(255)
);


--
-- Name: payment_credit; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.payment_credit (
    installments integer,
    uuid character varying(255) NOT NULL
);


--
-- Name: payment_ticket; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.payment_ticket (
    due_date date,
    payment_date date,
    uuid character varying(255) NOT NULL
);


--
-- Name: pedido; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.pedido (
    uuid character varying(255) NOT NULL,
    date_creation timestamp without time zone,
    date_update timestamp without time zone,
    status boolean NOT NULL,
    date date,
    address_id character varying(255),
    client_id character varying(255)
);


--
-- Name: product; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.product (
    uuid character varying(255) NOT NULL,
    date_creation timestamp without time zone,
    date_update timestamp without time zone,
    status boolean NOT NULL,
    nome character varying(255),
    price numeric(19,2),
    category_id character varying(255)
);


--
-- Name: state; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.state (
    uuid character varying(255) NOT NULL,
    date_creation timestamp without time zone,
    date_update timestamp without time zone,
    status boolean NOT NULL,
    code integer,
    name character varying(255),
    uf character varying(255)
);


--
-- Name: telephones; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.telephones (
    uuid character varying(255) NOT NULL,
    date_creation timestamp without time zone,
    date_update timestamp without time zone,
    status boolean NOT NULL,
    ddd character varying(255),
    telephone character varying(255),
    client_id character varying(255)
);


--
-- Name: addresss addresss_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.addresss
    ADD CONSTRAINT addresss_pkey PRIMARY KEY (uuid);


--
-- Name: category category_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.category
    ADD CONSTRAINT category_pkey PRIMARY KEY (uuid);


--
-- Name: citys citys_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.citys
    ADD CONSTRAINT citys_pkey PRIMARY KEY (uuid);


--
-- Name: client client_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.client
    ADD CONSTRAINT client_pkey PRIMARY KEY (uuid);


--
-- Name: order_items order_items_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.order_items
    ADD CONSTRAINT order_items_pkey PRIMARY KEY (uuid);


--
-- Name: payment_credit payment_credit_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.payment_credit
    ADD CONSTRAINT payment_credit_pkey PRIMARY KEY (uuid);


--
-- Name: payment payment_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.payment
    ADD CONSTRAINT payment_pkey PRIMARY KEY (uuid);


--
-- Name: payment_ticket payment_ticket_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.payment_ticket
    ADD CONSTRAINT payment_ticket_pkey PRIMARY KEY (uuid);


--
-- Name: pedido pedido_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.pedido
    ADD CONSTRAINT pedido_pkey PRIMARY KEY (uuid);


--
-- Name: product product_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.product
    ADD CONSTRAINT product_pkey PRIMARY KEY (uuid);


--
-- Name: state state_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.state
    ADD CONSTRAINT state_pkey PRIMARY KEY (uuid);


--
-- Name: telephones telephones_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.telephones
    ADD CONSTRAINT telephones_pkey PRIMARY KEY (uuid);


--
-- Name: order_items fk1263i88q602gig7fxad3pmfuo; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.order_items
    ADD CONSTRAINT fk1263i88q602gig7fxad3pmfuo FOREIGN KEY (order_id) REFERENCES public.pedido(uuid);


--
-- Name: product fk1mtsbur82frn64de7balymq9s; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.product
    ADD CONSTRAINT fk1mtsbur82frn64de7balymq9s FOREIGN KEY (category_id) REFERENCES public.category(uuid);


--
-- Name: pedido fk322wo1hgta9rxfrhgbjexsyvh; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.pedido
    ADD CONSTRAINT fk322wo1hgta9rxfrhgbjexsyvh FOREIGN KEY (address_id) REFERENCES public.addresss(uuid);


--
-- Name: payment_ticket fk7r6pg62da6ea05mwsnj7b1lr; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.payment_ticket
    ADD CONSTRAINT fk7r6pg62da6ea05mwsnj7b1lr FOREIGN KEY (uuid) REFERENCES public.payment(uuid);


--
-- Name: citys fkdq9li6gi1hbw8urucf9fber2k; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.citys
    ADD CONSTRAINT fkdq9li6gi1hbw8urucf9fber2k FOREIGN KEY (state_id) REFERENCES public.state(uuid);


--
-- Name: payment fkffjmb2f9luqfak4lnk1rceb2b; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.payment
    ADD CONSTRAINT fkffjmb2f9luqfak4lnk1rceb2b FOREIGN KEY (order_id) REFERENCES public.pedido(uuid);


--
-- Name: pedido fkk5facti0es38cfg0sed66dxpv; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.pedido
    ADD CONSTRAINT fkk5facti0es38cfg0sed66dxpv FOREIGN KEY (client_id) REFERENCES public.client(uuid);


--
-- Name: order_items fklf6f9q956mt144wiv6p1yko16; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.order_items
    ADD CONSTRAINT fklf6f9q956mt144wiv6p1yko16 FOREIGN KEY (product_id) REFERENCES public.product(uuid);


--
-- Name: payment_credit fkphiosu6svaaksit62of9n9iu; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.payment_credit
    ADD CONSTRAINT fkphiosu6svaaksit62of9n9iu FOREIGN KEY (uuid) REFERENCES public.payment(uuid);


--
-- Name: addresss fkpry12epdy8db5j0o9dotg4ki6; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.addresss
    ADD CONSTRAINT fkpry12epdy8db5j0o9dotg4ki6 FOREIGN KEY (city_id) REFERENCES public.citys(uuid);


--
-- Name: addresss fkqhxoeg1f2j6u1fha33srvvqqk; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.addresss
    ADD CONSTRAINT fkqhxoeg1f2j6u1fha33srvvqqk FOREIGN KEY (client_id) REFERENCES public.client(uuid);


--
-- Name: telephones fkqwph5onbc9ewpfqoghe1s7gw0; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.telephones
    ADD CONSTRAINT fkqwph5onbc9ewpfqoghe1s7gw0 FOREIGN KEY (client_id) REFERENCES public.client(uuid);


--
-- PostgreSQL database dump complete
--

