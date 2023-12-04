-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2023-11-30 19:49:05.616

-- tables
-- Table: county
CREATE TABLE county (
                        id serial  NOT NULL,
                        name varchar(255)  NOT NULL,
                        CONSTRAINT county_id PRIMARY KEY (id)
);

-- Table: feature
CREATE TABLE feature (
                         id serial  NOT NULL,
                         name varchar(255)  NOT NULL,
                         CONSTRAINT id PRIMARY KEY (id)
);

-- Table: image
CREATE TABLE image (
                       id serial  NOT NULL,
                       storage_id int  NOT NULL,
                       data bytea  NOT NULL,
                       CONSTRAINT image_pk PRIMARY KEY (id)
);

-- Table: location
CREATE TABLE location (
                          id serial  NOT NULL,
                          county_id int  NOT NULL,
                          longitude decimal(16,14)  NULL,
                          latitude decimal(16,14)  NULL,
                          CONSTRAINT location_pk PRIMARY KEY (id)
);

-- Table: order
CREATE TABLE "order" (
                         id serial  NOT NULL,
                         user_id int  NOT NULL,
                         customer_user_id int  NOT NULL,
                         storage_id int  NOT NULL,
                         start_date date  NOT NULL,
                         end_date date  NULL,
                         CONSTRAINT order_pk PRIMARY KEY (id)
);

-- Table: profile
CREATE TABLE profile (
                         id serial  NOT NULL,
                         given_name varchar(30)  NOT NULL,
                         surname varchar(50)  NOT NULL,
                         user_id int  NOT NULL,
                         CONSTRAINT profile_pk PRIMARY KEY (id)
);

-- Table: role
CREATE TABLE role (
                      id serial  NOT NULL,
                      name varchar(255)  NOT NULL,
                      CONSTRAINT role_pk PRIMARY KEY (id)
);

-- Table: storage_feature
CREATE TABLE storage_feature (
                                 id serial  NOT NULL,
                                 storage_id int  NOT NULL,
                                 feature_id int  NOT NULL,
                                 CONSTRAINT storage_feature_pk PRIMARY KEY (id)
);

-- Table: storage
CREATE TABLE storage (
                          id serial  NOT NULL,
                          user_id int  NOT NULL,
                          type_id int  NOT NULL,
                          location_id int  NOT NULL,
                          area int  NOT NULL,
                          price int  NOT NULL,
                          description varchar(600)  NOT NULL,
                          status char(1)  NOT NULL,
                          CONSTRAINT location_details_id PRIMARY KEY (id)
);

-- Table: type
CREATE TABLE type (
                      id serial  NOT NULL,
                      name varchar(255)  NOT NULL,
                      CONSTRAINT type_pk PRIMARY KEY (id)
);

-- Table: user
CREATE TABLE "user" (
                        id serial  NOT NULL,
                        email varchar(50)  NOT NULL,
                        password varchar(50)  NOT NULL,
                        role_id int  NOT NULL,
                        status char(1)  NOT NULL,
                        CONSTRAINT user_pk PRIMARY KEY (id)
);

-- foreign keys
-- Reference: image_storage (table: image)
ALTER TABLE image ADD CONSTRAINT image_storage
    FOREIGN KEY (storage_id)
        REFERENCES storage (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: location_attributes_features (table: storage_feature)
ALTER TABLE storage_feature ADD CONSTRAINT location_attributes_features
    FOREIGN KEY (feature_id)
        REFERENCES feature (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: location_county (table: location)
ALTER TABLE location ADD CONSTRAINT location_county
    FOREIGN KEY (county_id)
        REFERENCES county (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: location_details_type (table: storage)
ALTER TABLE storage ADD CONSTRAINT location_details_type
    FOREIGN KEY (type_id)
        REFERENCES type (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: location_details_user (table: storage)
ALTER TABLE storage ADD CONSTRAINT location_details_user
    FOREIGN KEY (user_id)
        REFERENCES "user" (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: order_storage (table: order)
ALTER TABLE "order" ADD CONSTRAINT order_storage
    FOREIGN KEY (storage_id)
        REFERENCES storage (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: order_user (table: order)
ALTER TABLE "order" ADD CONSTRAINT order_user
    FOREIGN KEY (user_id)
        REFERENCES "user" (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: orders_customer_user (table: order)
ALTER TABLE "order" ADD CONSTRAINT orders_customer_user
    FOREIGN KEY (customer_user_id)
        REFERENCES "user" (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: profile_user (table: profile)
ALTER TABLE profile ADD CONSTRAINT profile_user
    FOREIGN KEY (user_id)
        REFERENCES "user" (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: storage_feature_storage (table: storage_feature)
ALTER TABLE storage_feature ADD CONSTRAINT storage_feature_storage
    FOREIGN KEY (storage_id)
        REFERENCES storage (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: storage_location (table: storage)
ALTER TABLE storage ADD CONSTRAINT storage_location
    FOREIGN KEY (location_id)
        REFERENCES location (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: user_roles (table: user)
ALTER TABLE "user" ADD CONSTRAINT user_roles
    FOREIGN KEY (role_id)
        REFERENCES role (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- End of file.

