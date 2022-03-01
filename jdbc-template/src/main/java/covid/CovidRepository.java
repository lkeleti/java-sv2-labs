package covid;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class CovidRepository {
    private JdbcTemplate jdbcTemplate;

    /*
    CREATE TABLE person (taj VARCHAR(9) PRIMARY KEY, full_name VARCHAR(100), zip VARCHAR(4), age BIGINT, email VARCHAR(100));
    CREATE TABLE citizen (id BIGINT PRIMARY KEY AUTO_INCREMENT, person_taj VARCHAR(9), number_of_vaccination INT DEFAULT 0, last_vaccination_date TIMESTAMP NULL DEFAULT NULL ON UPDATE current_timestamp(),
	    CONSTRAINT `fk_person_taj`
        FOREIGN KEY (person_taj) REFERENCES person (taj) );
     */

    public CovidRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void savePerson(Person person) {
        jdbcTemplate.update("INSERT INTO person (full_name, zip, age, email, taj) VALUES(?,?,?,?,?)",
                person.getFullName(), person.getZip(), person.getAge(), person.getEmail(), person.getTaj());
    }

    public Person findPersonByTaj(String taj) {
        return jdbcTemplate.queryForObject("SELECT * FROM person WHERE taj =?",
                (rs, numRows) -> new Person(
                        rs.getString("full_name"),
                        rs.getString("zip"),
                        rs.getInt("age"),
                        rs.getString("email"),
                        taj
                ), taj
        );
    }

    public void saveCitizen(Person person) {
        jdbcTemplate.update("INSERT INTO citizen (person_taj) VALUES(?)", person.getTaj());
    }

    public String findCityByZip(String zip) {
        return jdbcTemplate.queryForObject("SELECT * FROM cities WHERE zip = ?",
                ((resultSet, i) -> resultSet.getString("city")), zip
        );
    }

    public List<Person> generateVaccinationList(String zip) {
        return jdbcTemplate.query("SELECT * FROM person " +
                        " INNER JOIN citizen ON person.taj = citizen.person_taj" +
                        " WHERE zip = ? AND (citizen.last_vaccination_date IS NULL OR DATEDIFF(NOW(),citizen.last_vaccination_date) > 15)" +
                        " ORDER BY age, full_name" +
                        " LIMIT 16;",
                (rs, rowNum) -> new Person(
                        rs.getString("full_name"),
                        rs.getString("zip"),
                        rs.getInt("age"),
                        rs.getString("email"),
                        rs.getString("taj")
                ), zip
        );
    }
}
