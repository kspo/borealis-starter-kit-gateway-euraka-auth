package ksp.borealis.authservice.entity;

import lombok.*;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "users")
@EqualsAndHashCode(of = {"id"})
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "countryCode")
    private Long countryCode;

    @Column(name = "mobileNumber", unique = true)
    private String mobileNumber;

    @Column(name = "email",unique = true)
    private String email;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "password")
    private String password;

    @Column(name = "exchangeId", unique = true)
    private Long exchangeId;

    @Column(name = "dob")
    private Date dob;

    @Column(name = "nationalIdNumber", unique = true)
    private String nationalIdNumber;

    @Column(name = "referenceCode")
    private String referenceCode;

    @Column(name = "nationality")
    private String nationality;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Role> role;

}


