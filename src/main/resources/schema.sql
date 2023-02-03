CREATE TABLE stations(
    station_name varchar(64)  primary key,
    fid int not null,
    station_id  varchar(3) not null,
    station_name_fi varchar(64)  not null,
    station_name_se varchar(64)  not null,
    address_fi varchar(64)  not null,
    address_se varchar(64)  not null,
    city_fi varchar(64),
    city_se varchar(64),
    operator varchar(64),
    capacity int  not null,
    coordinate_x decimal(9,6) not null,
    coordinate_y decimal(8,6) not null
);

CREATE TABLE journeys (
    journey_id bigint auto_increment primary key,
    departure_date  varchar(19)  not null,
    return_date varchar(19)  not null,
    departure_station_id varchar(3)  not null,
    departure_station varchar(64)  not null,
    return_station_id varchar(3)  not null,
    return_station varchar(64)  not null,
    distance_meters int  not null,
    duration_seconds int  not null
);

