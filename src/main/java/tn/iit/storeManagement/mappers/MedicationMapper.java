package tn.iit.storeManagement.mappers;

import tn.iit.storeManagement.models.Medication;
import tn.iit.storeManagement.dto.CategoryDto;
import tn.iit.storeManagement.dto.MedicationDto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MedicationMapper {

    public static MedicationDto medicationToMedicationDto(Medication medication)
    {
        MedicationDto medicationDto = new MedicationDto();
        medicationDto.setId (medication.getId ());
        medicationDto.setName (medication.getName ());
        medicationDto.setCategoryName (medication.getCategory ().getName ());
        medicationDto.setCategoryId (medication.getCategory ().getId ());
        medicationDto.setAgeType (medication.getAgeType ());
        medicationDto.setPosology (medication.getPosology ());
        medicationDto.setPrice (medication.getPrice ());
        medicationDto.setExpirationDate (medication.getExpirationDate ());
        return medicationDto;
    }

    public static Medication medicationDtoToMedication(MedicationDto medicationDto)
    {
        Medication medication = new Medication();
        medication.setId (medicationDto.getId ());
        medication.setName (medicationDto.getName ());
        CategoryDto categoryDto=new CategoryDto (medicationDto.getCategoryId (), medicationDto.getCategoryName ());
        medication.setCategory (CategoryMapper.categoryDtoToCategory (categoryDto));
        medication.setAgeType (medicationDto.getAgeType ());
        medication.setPosology (medicationDto.getPosology ());
        medication.setPrice (medicationDto.getPrice ());
        medication.setExpirationDate (medicationDto.getExpirationDate());

        return medication;
    }

    public static Collection<MedicationDto> medicationsToMedicationDtos(Collection<Medication> medications)
    {
        List<MedicationDto> medicationDtoList = new ArrayList<> ();
        medications.forEach(medication -> {
            medicationDtoList.add (medicationToMedicationDto (medication));
        });
        return medicationDtoList;
    }
}
