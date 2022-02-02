package br.com.udemy.Spring.FullStack.factory;

import br.com.udemy.Spring.FullStack.domain.City;
import br.com.udemy.Spring.FullStack.domain.State;
import br.com.udemy.Spring.FullStack.dto.CityDto;
import br.com.udemy.Spring.FullStack.dto.StateDto;
import org.springframework.data.domain.Page;

public class CityBusinessRule {

    public static CityDto convertPageCityInPageCityDto(City city){
        CityDto cityDto = new CityDto();

        cityDto.setName(city.getName());
        StateDto stateDto = StateBusinessRule.convertPageStateInPageStateDto(city.getState());
        cityDto.setStateDto(stateDto);

        return cityDto;
    }
}
