CREATE TABLE account (
	id	varchar2(100)	NOT NULL,
	password	varchar2(100)	NOT NULL,
	tel	varchar2(100)	NOT NULL,
	name	varchar2(100)	NOT NULL,
	nickname	varchar2(100)	NOT NULL
);
ALTER TABLE account ADD CONSTRAINT PK_ACCOUNT PRIMARY KEY (
	id
);
ALTER TABLE account ADD CONSTRAINT UK_ACCOUNT UNIQUE (
	tel
);


CREATE SEQUENCE category_seq START WITH 1 INCREMENT BY 1;
CREATE TABLE category (
    seq NUMBER NOT NULL,
    category VARCHAR2(100) NOT NULL
);
ALTER TABLE category ADD CONSTRAINT PK_category PRIMARY KEY (
	seq
);
ALTER TABLE category ADD CONSTRAINT UK_category UNIQUE (
	category
);


CREATE SEQUENCE board_seq START WITH 1 INCREMENT BY 1;
CREATE TABLE board (
	post_No	number NOT NULL,
	category	varchar2(100)	NOT NULL,
	title	varchar2(100)	NOT NULL,
	content	clob	NOT NULL,
	id	varchar2(100)	NOT NULL,
	post_date	date	NOT NULL,
	update_date	date,
	thumbnail clob
);
ALTER TABLE board ADD CONSTRAINT PK_BOARD PRIMARY KEY (
	post_No
);
ALTER TABLE board ADD CONSTRAINT FK_category FOREIGN KEY(
	category
) REFERENCES category (
	category
);



CREATE TABLE grade (
	id	varchar2(100)	NOT NULL,
	grade	varchar2(100)	NOT NULL
);
ALTER TABLE grade ADD CONSTRAINT PK_GRADE PRIMARY KEY (
	id
);
ALTER TABLE grade ADD CONSTRAINT FK_account_TO_grade_1 FOREIGN KEY (
	id
) REFERENCES account (
	id
);

DROP TABLE board;
DROP TABLE category;
DROP TABLE grade;
DROP TABLE account;
DROP SEQUENCE board_seq;
DROP SEQUENCE category_seq;