package tn.iit.storeManagement.controllers;

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

    public MedicationController(MedicationService medicationService) {
        this.medicationService = medicationService;
    }

    @GetMapping("/{id}")
    public MedicationDto findOne(@PathVariable("id") long id) {
        return this.medicationService.findOne (id);
    }

    @GetMapping()
    public Collection<MedicationDto> findAll(
            @RequestParam(defaultValue = "0") int pageNo,
            @RequestParam(defaultValue = "3") int pageSize,
            @RequestParam(defaultValue = "id") String pageSort
    ) {
        return this.medicationService.findAll (PageRequest.of(pageNo,pageSize, Sort.by (pageSort).ascending ()));
    }

    @PostMapping
    public MedicationDto add(@Valid @RequestBody MedicationDto medicationDto) {

        return this.medicationService.save (medicationDto);
    }

    @PostMapping("/searches")
    public Collection<MedicationDto> searches(@Valid @RequestBody List<Long> ids){
        return this.medicationService.findAllByIds(ids);
    }

    @PutMapping()
    public MedicationDto update(@Valid @RequestBody MedicationDto medicationDto) {
        return this.medicationService.save (medicationDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") long id) {
        this.medicationService.deleteById (id);
    }
}
