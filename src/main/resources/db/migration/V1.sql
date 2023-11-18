CREATE TABLE CATEGORY_DISHES(
   ID SERIAL PRIMARY KEY,
   NAME VARCHAR(40) NOT NULL
);

CREATE TABLE DISHES(
   ID SERIAL PRIMARY KEY,
   NAME VARCHAR(40),
   PRICE FLOAT,
   CATEGORY_ID INT,
   FOREIGN KEY (CATEGORY_ID) REFERENCES CATEGORY_DISHES(ID)
);

CREATE TABLE ORDERINGS(
   ID SERIAL PRIMARY KEY,
   NUMBER INT NOT NULL,
   TOTAL FLOAT
);


CREATE TABLE ORDERINGS_DISHES(
   ID_ORDERINGS INT,
   ID_DISHES INT,
   FOREIGN KEY (ID_ORDERINGS) REFERENCES ORDERINGS(ID),
   FOREIGN KEY (ID_DISHES) REFERENCES DISHES(ID)
);

CREATE INDEX IDX_CATEGORY_DISHES_NAME ON CATEGORY_DISHES (NAME);
CREATE INDEX IDX_DISHES_NAME ON DISHES (NAME);
CREATE INDEX IDX_ORDERINGS_NUMBER ON ORDERINGS (NUMBER);