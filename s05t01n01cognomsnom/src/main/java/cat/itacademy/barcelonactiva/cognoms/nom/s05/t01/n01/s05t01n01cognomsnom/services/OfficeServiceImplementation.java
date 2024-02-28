package cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n01.s05t01n01cognomsnom.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n01.s05t01n01cognomsnom.domain.Office;
import cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n01.s05t01n01cognomsnom.dto.OfficeDTO;
import cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n01.s05t01n01cognomsnom.exceptions.OfficeAlreadyExistsException;
import cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n01.s05t01n01cognomsnom.exceptions.OfficeNotFoundException;
import cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n01.s05t01n01cognomsnom.repository.OfficeRepository;

@Service
public class OfficeServiceImplementation implements OfficeService {

    @Autowired
    OfficeRepository officeRepository;

    @Override
    public void addOffice(Office office) {

        Office existingOffice = officeRepository.findByName(office.getName());
        if (existingOffice != null)
            throw new OfficeAlreadyExistsException("This office already exists");  
        officeRepository.save(office);  
    }

    @Override
    public void updateOffice(Office office) {

        officeRepository.save(office);
    }

    @Override
    public void deleteOffice(Integer id) {
        
        Optional<Office> office = officeRepository.findById(id);
        if (!office.isPresent())
            throw new OfficeNotFoundException("Office not found");
        officeRepository.deleteById(id);
    }

    @Override
    public OfficeDTO getSingleOffice(Integer id) {

        Optional<Office> office = officeRepository.findById(id);
        if (!office.isPresent())
            throw new OfficeNotFoundException("Office not found");
        return new OfficeDTO(office.get());
    }

    @Override
    public List<OfficeDTO> getAllOffices() {

        List<OfficeDTO> offices = new ArrayList<OfficeDTO>();
        officeRepository.findAll().forEach(o -> offices.add(new OfficeDTO(o)));
        return offices;
    }

    public Office findById(Integer id) {
        return officeRepository.findById(id).orElseThrow(() -> new OfficeNotFoundException("Office not found"));
    }
}
