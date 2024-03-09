package com.devsuperior.demo.services;

import com.devsuperior.demo.dto.CityDTO;
import com.devsuperior.demo.entities.City;
import com.devsuperior.demo.repositories.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CityService {

    @Autowired
    private CityRepository repository;

    @Transactional(readOnly = true)
    public List<CityDTO> findAll() {
        List<City> dto = repository.findAll(Sort.by("name"));
        return dto.stream().map(CityList -> new CityDTO(CityList)).toList();
    }

    @Transactional
    public CityDTO insert(CityDTO cityDTO) {
<<<<<<< HEAD
        City city = convertToCityDTO(cityDTO);
        City dto = repository.save(city);
        return new CityDTO(dto);
    }


    private City convertToCityDTO(CityDTO cityDTO) {
=======
        City city = convertToCity(cityDTO);
        City createdCity = repository.save(city);
        return new CityDTO(createdCity);
    }


    private City convertToCity(CityDTO cityDTO) {
>>>>>>> origin/main
        City city = new City();
        city.setName(cityDTO.getName());
        return city;
    }

<<<<<<< HEAD
=======

>>>>>>> origin/main
}
