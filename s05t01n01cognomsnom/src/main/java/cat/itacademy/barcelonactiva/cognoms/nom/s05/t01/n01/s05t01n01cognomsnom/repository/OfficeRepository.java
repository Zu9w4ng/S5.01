package cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n01.s05t01n01cognomsnom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n01.s05t01n01cognomsnom.domain.Office;


@Repository
public interface OfficeRepository extends JpaRepository<Office, Integer> {
	
	 public Office findByName(String officeName);

	 public Office findById(int id);
}