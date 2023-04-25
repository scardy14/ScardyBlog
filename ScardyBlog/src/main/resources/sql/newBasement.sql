CREATE TABLE account (
	id	varchar2(100)		NOT NULL,
	password	varchar2(100)		NOT NULL,
	tel	varchar2(100)		NOT NULL,
	name	varchar2(100)		NOT NULL,
	nickname	varchar2(100)		NOT NULL,
	status	varchar2(100)		NOT NULL
);
ALTER TABLE account ADD CONSTRAINT PK_ACCOUNT PRIMARY KEY (
	id
);




CREATE TABLE authority (
	id	varchar2(100)		NOT NULL,
	grade	varchar2(100)		NOT NULL
);
ALTER TABLE authority ADD CONSTRAINT PK_AUTHORITY PRIMARY KEY (
	id
);
ALTER TABLE authority ADD CONSTRAINT FK_account_TO_authority_1 FOREIGN KEY (
	id
) REFERENCES account (
	id
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
------------------------------------------------------------------
CREATE SEQUENCE blog_seq START WITH 1 INCREMENT BY 1;
CREATE TABLE blog (
	post_No	number		NOT NULL,
	category	varchar2(100)		NOT NULL,
	title	varchar2(100)		NOT NULL,
	content	clob		NOT NULL,
	id	varchar2(100)		NOT NULL,
	post_date	date		NOT NULL,
	update_date	date		NOT NULL,
	status	varchar2(100)		NOT NULL,
	thumbnail	clob		NULL
);
ALTER TABLE blog ADD CONSTRAINT PK_BLOG PRIMARY KEY (
	post_No
);
ALTER TABLE blog ADD CONSTRAINT FK_account_TO_blog_1 FOREIGN KEY (
	id
) REFERENCES account (
	id
);
ALTER TABLE blog ADD CONSTRAINT FK_category_TO_blog_1 FOREIGN KEY (
	category
) REFERENCES category (
	category
);







CREATE SEQUENCE community_category_seq START WITH 1 INCREMENT BY 1;
CREATE TABLE community_category (
    seq NUMBER NOT NULL,
    category VARCHAR2(100) NOT NULL
);
ALTER TABLE community_category ADD CONSTRAINT PK_community_category PRIMARY KEY (
	seq
);
ALTER TABLE community_category ADD CONSTRAINT UK_community_category UNIQUE (
	category
);
-----------------------------------------------------------------------
CREATE SEQUENCE community_seq START WITH 1 INCREMENT BY 1;
CREATE TABLE community (
	post_No	number		NOT NULL,
	category	varchar2(100)		NOT NULL,
	title	varchar2(100)		NOT NULL,
	content	clob		NOT NULL,
	id	varchar2(100)		NOT NULL,
	post_date	date		NOT NULL,
	update_date	date		NOT NULL,
	status	varchar2(100)		NOT NULL,
	thumbnail	clob		NOT NULL
);
ALTER TABLE community ADD CONSTRAINT PK_COMMUNITY PRIMARY KEY (
	post_No
);
ALTER TABLE community ADD CONSTRAINT FK_account_TO_community_1 FOREIGN KEY (
	id
) REFERENCES account (
	id
);
ALTER TABLE blog ADD CONSTRAINT FK_community_category FOREIGN KEY (
	category
) REFERENCES community_category (
	category
);






CREATE SEQUENCE memo_category_seq START WITH 1 INCREMENT BY 1;
CREATE TABLE memo_category (
    seq NUMBER NOT NULL,
    category VARCHAR2(100) NOT NULL
);
ALTER TABLE memo_category ADD CONSTRAINT PK_memo_category PRIMARY KEY (
	seq
);
ALTER TABLE memo_category ADD CONSTRAINT UK_memo_category UNIQUE (
	category
);
-----------------------------------------------------------------------
CREATE SEQUENCE memo_seq START WITH 1 INCREMENT BY 1;
CREATE TABLE memo (
	post_No	number		NOT NULL,
	category	varchar2(100)		NOT NULL,
	title	varchar2(100)		NOT NULL,
	content	clob		NOT NULL,
	id	varchar2(100)		NOT NULL,
	post_date	date		NOT NULL,
	update_date	date		NOT NULL,
	status	varchar2(100)		NOT NULL,
	thumbnail	clob		NULL
);
ALTER TABLE memo ADD CONSTRAINT PK_MEMO PRIMARY KEY (
	post_No
);
ALTER TABLE memo ADD CONSTRAINT FK_account_TO_memo_1 FOREIGN KEY (
	id
) REFERENCES account (
	id
);
ALTER TABLE blog ADD CONSTRAINT FK_memo_category FOREIGN KEY (
	category
) REFERENCES memo_category (
	category
);







SELECT * FROM account;
SELECT * FROM authority;

