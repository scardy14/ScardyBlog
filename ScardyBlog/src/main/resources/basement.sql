CREATE TABLE account(
	id VARCHAR2(100) PRIMARY KEY,
	password VARCHAR2(100) NOT NULL,
	tel VARCHAR2(100) NOT NULL,
	name VARCHAR2(100) NOT NULL,
	nickname VARCHAR2(100) NOT NULL
)

CREATE TABLE grade(
	id VARCHAR2(100) PRIMARY KEY,
	grade VARCHAR2(100) NOT NULL,
	CONSTRAINT grade_fk FOREIGN KEY(id) REFERENCES account(id),
	CONSTRAINT grade_check CHECK(grade='MASTER' OR grade='NORMAL'OR grade='ADMIN')
)
INSERT INTO account VALUES('scardy','blackmusicnote14','010-6346-2516','홍주영','scardy')
INSERT INTO grade VALUES('scardy','MASTER')