package domain.entity;

/*
CREATE TABLE children
(`id` BIGINT AUTO_INCREMENT PRIMARY KEY,
`name` VARCHAR(255) NOT NULL,
`city` VARCHAR(100) NOT NULL,
`gender` VARCHAR(6) NOT NULL,
`behaviour` VARCHAR(4) NOT NULL,
`state` VARCHAR(20) NOT NULL)
 */



import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table (name="children")
public class Child {

    @Id
    @GeneratedValue
    private long id;

    @NotNull
    @NotEmpty
    @Column (name="name", length = 255)
    private String name;

    @NotNull
    @Column (name="city", length = 100)
    private String city;

    @NotNull
    @Column (name="gender", length = 6)
    @Enumerated (EnumType.STRING)
    private Gender gender;

    @NotNull
    @Column (name="behaviour", length = 4)
    @Enumerated (EnumType.STRING)
    private Behaviour behaviour;

    @NotNull
    @Column (name="state", length = 20)
    @Enumerated (EnumType.STRING)
    private State state;


    public Child() {
    }

    public Child(Integer id, String name, String city, Gender gender, Behaviour behaviour, State state) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.gender = gender;
        this.behaviour = behaviour;
        this.state = state;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Behaviour getBehaviour() {
        return behaviour;
    }

    public void setBehaviour(Behaviour behaviour) {
        this.behaviour = behaviour;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}
