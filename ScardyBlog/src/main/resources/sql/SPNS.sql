CREATE TABLE account (
	id	varchar2(100)	NOT NULL,
	password	varchar2(100)	NOT NULL,
	tel	varchar2(100)	NOT NULL,
	name	varchar2(100)	NOT NULL,
	nickname	varchar2(100)	NOT NULL
);

CREATE TABLE board (
	post_No	number	NOT NULL,
	category	varchar2(100)	NOT NULL,
	title	varchar2(100)	NOT NULL,
	content	clob	NOT NULL,
	id	varchar2(100)	NOT NULL,
	post_date	date	NOT NULL,
	update_date	date
);

CREATE TABLE grade (
	id	varchar2(100)	NOT NULL,
	grade	varchar2(100)	NOT NULL
);

ALTER TABLE account ADD CONSTRAINT PK_ACCOUNT PRIMARY KEY (
	id
);

ALTER TABLE board ADD CONSTRAINT PK_BOARD PRIMARY KEY (
	post_No
);

ALTER TABLE grade ADD CONSTRAINT PK_GRADE PRIMARY KEY (
	id
);

ALTER TABLE grade ADD CONSTRAINT FK_account_TO_grade_1 FOREIGN KEY (
	id
)
REFERENCES account (
	id
);
INSERT INTO account VALUES('scardy','blackmusicnote14','010-6346-2516','홍주영','scardy');

INSERT INTO grade VALUES('scardy','MASTER');

CREATE SEQUENCE board_seq START WITH 1 INCREMENT BY 1;