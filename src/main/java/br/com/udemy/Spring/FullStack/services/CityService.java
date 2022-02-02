package br.com.udemy.Spring.FullStack.services;

import br.com.udemy.Spring.FullStack.domain.City;
import br.com.udemy.Spring.FullStack.domain.State;
import br.com.udemy.Spring.FullStack.dto.CityDto;
import br.com.udemy.Spring.FullStack.dto.StateDto;
import br.com.udemy.Spring.FullStack.factory.CityBusinessRule;
import br.com.udemy.Spring.FullStack.factory.StateBusinessRule;
import br.com.udemy.Spring.FullStack.repositorys.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class CityService {

    @Autowired
    private CityRepository cityRepository;

    public Page<CityDto> findByAllCitys(Integer page, Integer linesPerPage, String orderBy, String direction){
        Pageable pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.fromString(direction), orderBy);
        Page<City> pageCity = cityRepository.findByAllCityOrderByName(pageRequest);
        Page<CityDto> pageCityDto = pageCity.map(CityBusinessRule::convertPageCityInPageCityDto);
        return pageCityDto;
    }

    public Page<CityDto> findByAllCitysPerOneState(String nameState, Integer page, Integer linesPerPage, String orderBy, String direction){
        Pageable pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.fromString(direction), orderBy);
        Page<City> pageCity = cityRepository.findByAllCityPerStateOrderByName(nameState, pageRequest);
        Page<CityDto> pageCityDto = pageCity.map(CityBusinessRule::convertPageCityInPageCityDto);
        return pageCityDto;
    }
}
