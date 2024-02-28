package cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n01.s05t01n01cognomsnom.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n01.s05t01n01cognomsnom.domain.Office;
import cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n01.s05t01n01cognomsnom.dto.OfficeDTO;
import cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n01.s05t01n01cognomsnom.services.OfficeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
@RequestMapping("api/v1/office")
public class OfficeController {
    
    @Autowired
    private OfficeService officeService;

    @GetMapping("/getAll")
    public String showAllOffices(Model model) {
        
        List<OfficeDTO> officesDTO = officeService.getAllOffices();
        model.addAttribute("officesDTO", officesDTO);
        return "offices";
    }

    @GetMapping("/getOne/{id}")
    public String showSingleOffice(@PathVariable("id") Integer id, Model model) {

        OfficeDTO officeDTO = officeService.getSingleOffice(id);
        model.addAttribute("office", officeDTO);
        return "showOffice";
    }

    @GetMapping("/showAddRequest")
    public String showNewOffice(Model model) {

        OfficeDTO officeDTO = new OfficeDTO();
        model.addAttribute("officeDTO", officeDTO);
        return "newOffice";
    }
    

    @PostMapping("/add")
    public String addOffice(@ModelAttribute Office office) {

        officeService.addOffice(office);
        return "redirect:getAll";
    }

    @GetMapping("/showUpdateRequest/{id}")
    public String showUpdate(@PathVariable("id") Integer id, Model model) {

        model.addAttribute("office", officeService.findById(id));
        return "updateOffice";
    }

    @PostMapping("/update")
    public String updateOffice(@ModelAttribute Office office) {
        
        officeService.updateOffice(office);
        return "redirect:getAll";
    }

    @GetMapping("/delete/{id}")
    public String deleteOffice(@PathVariable("id") Integer id, Model model) {
        
        officeService.deleteOffice(id);
        return "redirect:/api/v1/office/getAll";
    }
}
