docker run -d -e MYSQL_DATABASE=activitytracker -e MYSQL_USER=activitytracker -e MYSQL_PASSWORD=activitytracker -e MYSQL_ALLOW_EMPTY_PASSWORD=yes -p 3360:3306 --name activitytracker-mariadb mariadb
