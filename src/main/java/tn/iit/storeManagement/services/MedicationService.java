package tn.iit.storeManagement.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.iit.storeManagement.dao.MedicationDao;
import tn.iit.storeManagement.models.Medication;
import tn.iit.storeManagement.dto.MedicationDto;
import tn.iit.storeManagement.mappers.MedicationMapper;

import java.util.Collection;
import java.util.List;

@Transactional
@Service
public class MedicationService {

    private final MedicationDao medicationDao;
    @Autowired
    public MedicationService(MedicationDao medicationDao) {
        this.medicationDao = medicationDao;
    }

    public MedicationDto save(MedicationDto medicationDto) {
        this.medicationDao.saveAndFlush (MedicationMapper.medicationDtoToMedication (medicationDto));
        return medicationDto;
    }

    public void deleteById(Long id){
        if(!this.medicationDao.existsById (id))
        this.medicationDao.deleteById (id);
    }

    @Transactional(readOnly = true)
    public MedicationDto findOne(Long id){
        Medication medication=this.medicationDao.findById (id) .orElseThrow ( );
        return MedicationMapper.medicationToMedicationDto (medication);
    }
    @Transactional(
            readOnly=true
    )
    public Collection<MedicationDto> findAll(Pageable pageable){
        return MedicationMapper.medicationsToMedicationDtos (this.medicationDao.findAll (pageable).getContent ());
    }
    @Transactional(readOnly = true)
    public Collection<MedicationDto> findAllByIds(List<Long> ids){
        return MedicationMapper.medicationsToMedicationDtos (this.medicationDao.findAllById (ids));
    }
}

