CREATE TABLE trackpoints (id BIGINT, activity_id BIGINT, track_time TIMESTAMP, lat FLOAT, lon FLOAT,
PRIMARY KEY(id),
    CONSTRAINT fk_activity FOREIGN KEY(activity_id) REFERENCES activities(id)
		  );
