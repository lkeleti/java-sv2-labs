CREATE TABLE trackpoints (id BIGINT AUTO_INCREMENT, activity_id BIGINT DEFAULT NULL, track_time TIMESTAMP, lat FLOAT, lon FLOAT,
PRIMARY KEY(id),
    CONSTRAINT fk_activity FOREIGN KEY(activity_id) REFERENCES activities(id)
		  );
