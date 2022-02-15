CREATE TABLE images (id BIGINT AUTO_INCREMENT PRIMARY KEY, activity_id BIGINT,filename VARCHAR(255), content BLOB,
CONSTRAINT fk_activity_images FOREIGN KEY(activity_id) REFERENCES activities(id)
);