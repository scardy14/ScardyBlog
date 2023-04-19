CREATE TABLE account (
	id	varchar2(100)	NOT NULL,
	password	varchar2(100)	NOT NULL,
	tel	varchar2(100)	NOT NULL,
	name	varchar2(100)	NOT NULL,
	nickname	varchar2(100)	NOT NULL
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

CREATE SEQUENCE category_seq START WITH 1 INCREMENT BY 1;
CREATE TABLE category (
    seq NUMBER PRIMARY KEY,
    category VARCHAR2(100) NOT NULL
);
ALTER TABLE category ADD CONSTRAINT PK_category PRIMARY KEY (
	seq
);

ALTER TABLE category ADD CONSTRAINT UK_category UNIQUE (
	category
);

ALTER TABLE board ADD CONSTRAINT FK_category FOREIGN KEY(category) REFERENCES category (category);








INSERT INTO account VALUES('scardy','blackmusicnote14','010-6346-2516','홍주영','scardy');

INSERT INTO grade VALUES('scardy','MASTER');

;

INSERT INTO BOARD VALUES(board_seq.nextval, '테스트 카테고리', '테스트 타이틀', '테스트 컨텐츠', 'scardy',sysdate,sysdate);

SELECT * FROM board;

SELECT * FROM account;

SELECT * FROM category;

UPDATE account SET tel='01063462516' WHERE id = 'scardy'

DELETE FROM ACCOUNT WHERE id = 'scardy'