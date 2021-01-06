package tn.iit.storeManagement.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private final Logger logger= LoggerFactory.getLogger (CategoryController.class);

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("{id}")
    public CategoryDto findOne(@PathVariable("id") long id) {
        this.logger.debug ("Getting category {}",id);
        return this.categoryService.findOne (id);
    }

    @GetMapping
    public Collection<CategoryDto> findAll(){
        this.logger.debug ("Getting all categories");
        return this.categoryService.findAll ();
    }

    @PostMapping
    public CategoryDto add(@Valid @RequestBody CategoryDto categoryDto){
        this.logger.debug ("Adding new category {}",categoryDto.getName ());
        return this.categoryService.save (categoryDto);
    }

    @PutMapping
    public CategoryDto update(@Valid @RequestBody CategoryDto categoryDto){
        this.logger.debug ("Updating category {} with {}",categoryDto.getId (),categoryDto.getName ());
        return this.categoryService.save (categoryDto);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") long id){
        this.logger.debug ("Deleting category {}",id);
        this.categoryService.deleteById (id);
    }

}
