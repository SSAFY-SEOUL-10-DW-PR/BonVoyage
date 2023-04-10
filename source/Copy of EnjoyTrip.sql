CREATE TABLE `user` (
	`user_id`	varchar(20)	NOT NULL,
	`user_pwd`	varchar(20)	NULL,
	`email`	varchar(20)	NULL,
	`name`	varchar(20)	NULL,
	`birth`	date	NULL,
	`phone`	text	NULL,
	`question`	text	NULL,
	`answer`	text	NULL,
	`authorization`	varchar(20)	NULL
);

CREATE TABLE `route` (
	`route_id`	int	NOT NULL	DEFAULT auto_increment,
	`route_info`	text	NULL,
	`user_id`	varchar(20)	NOT NULL
);

CREATE TABLE `board` (
	`acticle_no`	int	NOT NULL	DEFAULT auto_increment,
	`title`	varchar(255)	NULL,
	`date`	date	NULL,
	`content`	text	NULL,
	`hit`	int	NULL,
	`user_id`	varchar(20)	NOT NULL
);

CREATE TABLE `review` (
	`review_id`	int	NOT NULL	DEFAULT auto_increment,
	`content_type_id`	int	NULL,
	`review_content`	varchar(255)	NULL,
	`write_date`	datetime	NULL,
	`location`	varchar(100)	NULL,
	`user_id`	varchar(20)	NOT NULL,
	`content_id`	INT	NOT NULL
);

CREATE TABLE `sido` (
	`sido_code`	INT	NOT NULL,
	`sido_name`	VARCHAR(30)	NULL
);

CREATE TABLE `gugun` (
	`gugun_code`	INT	NOT NULL,
	`sido_code`	INT	NOT NULL,
	`gugun_name`	VARCHAR(30)	NULL,
	`INDEX`	`gugun_to_sido_sido_code_fk_idx`	NULL
);

CREATE TABLE `attraction_info` (
	`content_id`	INT	NOT NULL,
	`content_type_id`	INT	NULL,
	`title`	VARCHAR(100)	NULL,
	`addr1`	VARCHAR(100)	NULL,
	`addr2`	VARCHAR(50)	NULL,
	`zipcode`	VARCHAR(50)	NULL,
	`tel`	VARCHAR(50)	NULL,
	`first_image`	VARCHAR(200)	NULL,
	`first_image2`	VARCHAR(200)	NULL,
	`readcount`	INT	NULL,
	`sido_code`	INT	NULL,
	`gugun_code`	INT	NULL,
	`latitude`	DECIMAL(20,17)	NULL,
	`longitude`	DECIMAL(20,17)	NULL,
	`mlevel`	VARCHAR(2)	NULL,
	`INDEX`	`attraction_to_content_type_id_fk_idx`	NULL,
	`INDEX`	`attraction_to_sido_code_fk_idx`	NULL,
	`INDEX`	`attraction_to_gugun_code_fk_idx`	NULL
);

CREATE TABLE `attraction_description` (
	`content_id`	INT	NOT NULL,
	`homepage`	VARCHAR(100)	NULL,
	`overview`	VARCHAR(10000)	NULL,
	`telname`	VARCHAR(45)	NULL
);

CREATE TABLE `attraction_detail` (
	`content_id`	INT	NOT NULL,
	`cat1`	VARCHAR(3)	NULL,
	`cat2`	VARCHAR(5)	NULL,
	`cat3`	VARCHAR(9)	NULL,
	`created_time`	VARCHAR(14)	NULL,
	`modified_time`	VARCHAR(14)	NULL,
	`booktour`	VARCHAR(5)	NULL
);

ALTER TABLE `user` ADD CONSTRAINT `PK_USER` PRIMARY KEY (
	`user_id`
);

ALTER TABLE `route` ADD CONSTRAINT `PK_ROUTE` PRIMARY KEY (
	`route_id`
);

ALTER TABLE `board` ADD CONSTRAINT `PK_BOARD` PRIMARY KEY (
	`acticle_no`
);

ALTER TABLE `review` ADD CONSTRAINT `PK_REVIEW` PRIMARY KEY (
	`review_id`
);

ALTER TABLE `sido` ADD CONSTRAINT `PK_SIDO` PRIMARY KEY (
	`sido_code`
);

ALTER TABLE `gugun` ADD CONSTRAINT `PK_GUGUN` PRIMARY KEY (
	`gugun_code`,
	`sido_code`
);

ALTER TABLE `attraction_info` ADD CONSTRAINT `PK_ATTRACTION_INFO` PRIMARY KEY (
	`content_id`
);

ALTER TABLE `attraction_description` ADD CONSTRAINT `PK_ATTRACTION_DESCRIPTION` PRIMARY KEY (
	`content_id`
);

ALTER TABLE `attraction_detail` ADD CONSTRAINT `PK_ATTRACTION_DETAIL` PRIMARY KEY (
	`content_id`
);

ALTER TABLE `gugun` ADD CONSTRAINT `FK_sido_TO_gugun_1` FOREIGN KEY (
	`sido_code`
)
REFERENCES `sido` (
	`sido_code`
);

ALTER TABLE `attraction_description` ADD CONSTRAINT `FK_attraction_info_TO_attraction_description_1` FOREIGN KEY (
	`content_id`
)
REFERENCES `attraction_info` (
	`content_id`
);

ALTER TABLE `attraction_detail` ADD CONSTRAINT `FK_attraction_info_TO_attraction_detail_1` FOREIGN KEY (
	`content_id`
)
REFERENCES `attraction_info` (
	`content_id`
);

