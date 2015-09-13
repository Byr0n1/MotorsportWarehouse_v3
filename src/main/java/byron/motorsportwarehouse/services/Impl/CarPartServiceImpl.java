/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byron.motorsportwarehouse.services.Impl;

import byron.motorsportwarehouse.domain.CarPart;
import byron.motorsportwarehouse.domain.Category;
import byron.motorsportwarehouse.repository.CategoryRepository;
import byron.motorsportwarehouse.services.CarPartService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Byron
 */

@Service
public class CarPartServiceImpl implements CarPartService{

    @Autowired
    private CategoryRepository repository;
    
    @Override
    public List<Category> getAllCategories() {
        List<Category> cat = new ArrayList<>();
        Iterable<Category> values = repository.findAll();
        for (Category value : values) {
            cat.add(value);
        }
        return cat;
    }

    @Override
    public List<CarPart> getCarParts(Long id) {

        return repository.findOne(id).getCarPart();
    }
}
