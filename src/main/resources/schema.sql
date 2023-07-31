CREATE TABLE IF NOT EXISTS train
(
    trainId UUID NOT NULL,
    trainName VARCHAR(20) NOT NULL,
    CONSTRAINT train_pkey PRIMARY KEY (trainId)
);

CREATE TABLE IF NOT EXISTS station
(
    stationId UUID NOT NULL,
    stationName VARCHAR(50) NOT NULL,
    stationAddress VARCHAR(50) NOT NULL,
    CONSTRAINT station_pkey PRIMARY KEY (stationId)
);

CREATE TABLE IF NOT EXISTS track
(
    trackId UUID NOT NULL,
    trainId UUID NOT NULL,
    sourceStationIdd UUID NOT NULL,
    destinationStationId UUID NOT NULL,
    timeIn DATE,
    timeOut DATE,
    CONSTRAINT track_pkey PRIMARY KEY (trackId)
    FOREIGN KEY (trainId) REFERENCES (train.trainId)
    FOREIGN KEY (sourceStationId) REFERENCES (station.stationId)
    FOREIGN KEY (destinationStationId) REFERENCES (station.stationId)
);