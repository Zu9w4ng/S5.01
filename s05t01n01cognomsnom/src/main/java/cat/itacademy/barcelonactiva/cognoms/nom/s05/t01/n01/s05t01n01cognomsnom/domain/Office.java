package cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n01.s05t01n01cognomsnom.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "Office", uniqueConstraints = @UniqueConstraint(columnNames = "name"))
public class Office {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

	@Column
    private String name;

	@Column
    private String country;

	public Office() {}

	public Office(String name, String country) {

		this.name = name;
		this.country = country;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
}