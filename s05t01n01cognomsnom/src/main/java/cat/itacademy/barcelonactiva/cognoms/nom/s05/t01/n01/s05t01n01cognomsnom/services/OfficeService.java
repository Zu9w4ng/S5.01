package cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n01.s05t01n01cognomsnom.services;

import java.util.List;

import cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n01.s05t01n01cognomsnom.domain.Office;
import cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n01.s05t01n01cognomsnom.dto.OfficeDTO;

public interface OfficeService {
    
    public void addOffice(Office office);

    public void updateOffice(Office office);

    public void deleteOffice(Integer id);

    public OfficeDTO getSingleOffice(Integer id);

    public List<OfficeDTO> getAllOffices();

    public Office findById(Integer id);

}
