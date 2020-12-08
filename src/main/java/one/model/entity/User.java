package one.model.entity;

import one.model.entity.RoleType;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table( name="user",
        uniqueConstraints={@UniqueConstraint(columnNames={"email"})})
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private long id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "surname")
    private String surname;
    @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 225)
    @Column(name = "password")
    private String password;
    @Column(name = "role", nullable = false)
    @Enumerated(EnumType.STRING)
    private RoleType role;

    public User() {
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public RoleType getRole() {
        return role;
    }

    public void setRole(RoleType role) {
        this.role = role;
    }

    public static class Builder{
        private User user;

        public Builder() {
            user = new User();
        }

        public Builder id(int id){
            user.id = id;
            return this;
        }
        public Builder name(String name){
            user.name = name;
            return this;
        }
        public Builder surname(String surname){
            user.surname = surname;
            return this;
        }
        public Builder email(String email){
            user.email = email;
            return this;
        }
        public Builder password(String password){
            user.password = password;
            return this;
        }
        public Builder role(RoleType role){
            user.role = role;
            return this;
        }
        public User build(){
            return user;
        }

    }
}
