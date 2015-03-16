
CREATE TABLE Person
(
  PersonId serial,
  age int,
  firstname character varying(255),
  lastname character varying(255),
  FacilityId int REFERENCES Facility(FacilityId),
  PRIMARY KEY (PersonId)
);

CREATE TABLE Facility
(
  FacilityId serial,
  vacant boolean,
  cost double precision,
  description character varying(255),
  ownerid int REFERENCES Person (PersonId),
  renterid int REFERENCES Person (PersonId),
  PRIMARY KEY (FacilityId)
);

CREATE TABLE FacilityProblems
(
  FacilityProblemId serial,
  current boolean,
  description character varying(255),
  date date,
  FacilityId int REFERENCES Facility (FacilityId) ON DELETE CASCADE,
  PRIMARY KEY (FacilityProblemId)
);

CREATE TABLE MaintenanceRequest
(
  MaintReqId serial,
  description character varying(255),
  FacilityId int REFERENCES Facility (FacilityId) ON UPDATE NO ACTION ON DELETE CASCADE,
  current boolean,
  date date,
  estimatedcost double precision,
  PRIMARY KEY (MaintReqId)

);

CREATE TABLE Maintenance
(
  MaintenanceId serial,
  completed boolean,
  description character varying(255),
  MaintReqId integer REFERENCES MaintenanceRequest(MaintReqId) ON UPDATE NO ACTION ON DELETE CASCADE,
  date date,
  PRIMARY KEY (MaintenanceId)

);

CREATE TABLE Use
(
  UseId serial,
  startdate date,
  enddate date,
  description character varying(255),
  PRIMARY KEY (UseId)
);
