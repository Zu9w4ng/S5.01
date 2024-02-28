package cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n01.s05t01n01cognomsnom.dto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n01.s05t01n01cognomsnom.domain.Office;

public class OfficeDTO {

    private int id;

    private String name;

    private String country;

    private boolean isEU;

    private final List<String> europeanCountries = new ArrayList<String>(Arrays.asList("Albania", "Alemania", "Andorra",
			"Armenia", "Austria", "Azerbaiyán", "Bélgica", "Bielorrusia", "Bosnia y Herzegovina", "Bulgaria", "Chipre",
			"Croacia", "Dinamarca", "Eslovaquia", "Eslovenia", "España", "Estonia", "Finlandia", "Francia", "Georgia",
			"Grecia", "Hungría", "Irlanda", "Islandia", "Italia", "Kazajistán", "Kosovo", "Letonia", "Liechtenstein",
			"Lituania", "Luxemburgo", "Macedonia del Norte", "Malta", "Moldavia", "Mónaco", "Montenegro", "Noruega",
			"Países Bajos", "Polonia", "Portugal", "Reino Unido", "República Checa", "Rumanía", "Rusia", "San Marino",
			"Serbia", "Suecia", "Suiza", "Turquía", "Ucrania", "Vaticano"));

	public OfficeDTO() {

	}

    public OfficeDTO(Office office) {
        this.id = office.getId();
        this.name = office.getName();
        this.country = office.getCountry();
        this.isEU = europeanCountries.contains(country);
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

    public boolean isEU() {
        return isEU;
    }

    public void setEU(boolean isEU) {
        this.isEU = isEU;
    }

    
}
