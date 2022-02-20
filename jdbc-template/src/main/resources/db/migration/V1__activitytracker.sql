CREATE TABLE activities (id BIGINT AUTO_INCREMENT PRIMARY KEY, start_time TIMESTAMP, activity_desc VARCHAR(255), activity_type VARCHAR(255));
CREATE TABLE trackpoints (id BIGINT AUTO_INCREMENT, activity_id BIGINT DEFAULT NULL, track_time TIMESTAMP, lat FLOAT, lon FLOAT,
PRIMARY KEY(id),
    CONSTRAINT fk_activity FOREIGN KEY(activity_id) REFERENCES activities(id)
		  );
CREATE TABLE images (id BIGINT AUTO_INCREMENT PRIMARY KEY, activity_id BIGINT,filename VARCHAR(255), content BLOB,
CONSTRAINT fk_activity_images FOREIGN KEY(activity_id) REFERENCES activities(id)
);