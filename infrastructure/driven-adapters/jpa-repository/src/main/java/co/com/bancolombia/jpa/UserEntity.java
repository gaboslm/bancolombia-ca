package co.com.bancolombia.jpa;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="`user`")
@Data
public class UserEntity {
    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String username;
    private String email;
    private int age;
}
