package ksp.borealis.authservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "roles")
@EqualsAndHashCode(of = {"id"})
public class Role implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotBlank
	@Column(unique = true)
	private String name;

	@NotBlank
	private String description;

	@Column(columnDefinition = "tinyint(1) default 0")
	private boolean isAdminRole = false;

	@ManyToMany(fetch = FetchType.EAGER)
	private Set<Privilege> privileges;


}
