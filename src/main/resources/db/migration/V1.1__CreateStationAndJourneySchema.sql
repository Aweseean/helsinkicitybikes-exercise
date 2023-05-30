CREATE TABLE stations(
    station_name VARCHAR(64) PRIMARY KEY,
    fid INT NOT NULL,
    station_id VARCHAR(3) NOT NULL,
    station_name_fi VARCHAR(64) NOT NULL,
    station_name_se VARCHAR(64) NOT NULL,
    address_fi VARCHAR(64) NOT NULL,
    address_se VARCHAR(64) NOT NULL,
    city_fi VARCHAR(64),
    city_se VARCHAR(64),
    operator VARCHAR(64),
    capacity INT NOT NULL,
    coordinate_x decimal(9,6) NOT NULL,
    coordinate_y decimal(8,6) NOT NULL
);

CREATE SEQUENCE journeys_seq INCREMENT 1 START 1;

CREATE TABLE journeys (
    journey_id BIGINT PRIMARY KEY NOT NULL,
    departure_date VARCHAR(19) NOT NULL,
    return_date VARCHAR(19) NOT NULL,
    departure_station_id VARCHAR(3) NOT NULL,
    departure_station VARCHAR(64) NOT NULL,
    return_station_id VARCHAR(3) NOT NULL,
    return_station VARCHAR(64) NOT NULL,
    distance_meters INT NOT NULL,
    duration_seconds INT NOT NULL
);

