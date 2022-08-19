drop table if exists PUBLIC.Car;
drop table if exists PUBLIC.Country;
drop table if exists PUBLIC.Price;

CREATE TABLE PUBLIC.Car(
                    car_Id     INT NOT NULL AUTO_INCREMENT,
                    car_Name  VARCHAR(64) NOT NULL,
                    car_Color VARCHAR(64),
                    car_Model VARCHAR(32),
                    CONSTRAINT Car_PRIMARY_KEY PRIMARY KEY (car_Id)

);

CREATE TABLE PUBLIC.Country(
                        country_Id INT not null AUTO_INCREMENT,
                        car_Id INT NOT NULL UNIQUE ,
                        country_Name  VARCHAR(64) NOT NULL,
                        city_Name VARCHAR(64),
                        CONSTRAINT COUNTRY_PRIMARY_KEY PRIMARY KEY (country_Id),
                        CONSTRAINT Car_FOREIGN_KEY FOREIGN KEY (car_Id) REFERENCES Car (car_Id)
);

CREATE TABLE PUBLIC.Price(
    price_Id INT not null  AUTO_INCREMENT,
    country_Id INT NOT NULL UNIQUE ,
    price_Car INT not null ,
    credit_Price INT NOT NULL,
    CONSTRAINT PRICE_PRIMARY_KEY PRIMARY KEY (price_Id),
    CONSTRAINT COUNTRY_FOREIGN_KEY FOREIGN KEY (country_Id) REFERENCES Country (country_Id)
);


