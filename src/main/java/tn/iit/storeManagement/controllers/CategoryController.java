package tn.iit.storeManagement.controllers;

import org.springframework.web.bind.annotation.*;
import tn.iit.storeManagement.dto.CategoryDto;
import tn.iit.storeManagement.services.CategoryService;

import javax.validation.Valid;
import java.util.Collection;

@CrossOrigin("*")
@RequestMapping(value = "/api/categories")
@RestController()
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("{id}")
    public CategoryDto findOne(@PathVariable("id") long id) {
        return this.categoryService.findOne (id);
    }

    @GetMapping
    public Collection<CategoryDto> findAll(){
        return this.categoryService.findAll ();
    }

    @PostMapping
    public CategoryDto add(@Valid @RequestBody CategoryDto categoryDto){
        return this.categoryService.save (categoryDto);
    }

    @PutMapping
    public CategoryDto update(@Valid @RequestBody CategoryDto categoryDto){
        return this.categoryService.save (categoryDto);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") long id){
        this.categoryService.deleteById (id);
    }

}
