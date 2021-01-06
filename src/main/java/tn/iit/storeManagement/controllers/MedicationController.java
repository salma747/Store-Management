package tn.iit.storeManagement.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;
import tn.iit.storeManagement.dto.MedicationDto;
import tn.iit.storeManagement.services.MedicationService;

import javax.validation.Valid;
import java.util.Collection;
import java.util.List;

@CrossOrigin("*")
@RequestMapping(value = "/api/medications")
@RestController()
public class MedicationController {

    private final MedicationService medicationService;
    private final Logger logger = LoggerFactory.getLogger (MedicationController.class);

    public MedicationController(MedicationService medicationService) {
        this.medicationService = medicationService;
    }

    @GetMapping("/{id}")
    public MedicationDto findOne(@PathVariable("id") long id) {
        this.logger.debug ("Getting medication {}", id);
        return this.medicationService.findOne (id);
    }

    @GetMapping()
    public Collection<MedicationDto> findAll(
            @RequestParam(defaultValue = "0") int pageNo,
            @RequestParam(defaultValue = "2") int pageSize,
            @RequestParam(defaultValue = "id") String pageSort
    ) {
        this.logger.debug ("Getting all medications");
        return this.medicationService.findAll (PageRequest.of(pageNo,pageSize, Sort.by (pageSort).ascending ()));
    }

    @PostMapping
    public MedicationDto add(@Valid @RequestBody MedicationDto medicationDto) {
        this.logger.debug ("Adding new medication {}", medicationDto);
        return this.medicationService.save (medicationDto);
    }

    @PostMapping("/searches")
    public Collection<MedicationDto> searches(@Valid @RequestBody List<Long> ids){
        this.logger.debug ("Getting all medications with ids {}",ids);
        return this.medicationService.findAllByIds(ids);
    }

    @PutMapping()
    public MedicationDto update(@Valid @RequestBody MedicationDto medicationDto) {
        this.logger.debug ("Updating medication {} with {}", medicationDto.getId (), medicationDto);
        return this.medicationService.save (medicationDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") long id) {
        this.logger.debug ("Deleting medication {}", id);
        this.medicationService.deleteById (id);
    }
}
