package br.com.udemy.Spring.FullStack.resources;

import br.com.udemy.Spring.FullStack.dto.CityDto;
import br.com.udemy.Spring.FullStack.dto.StateDto;
import br.com.udemy.Spring.FullStack.services.CityService;
import br.com.udemy.Spring.FullStack.services.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "city")
public class CityResource {

    @Autowired
    private CityService cityService;

    @GetMapping
    public ResponseEntity<Page<CityDto>> findByAllCity(
            @RequestParam(value="page", defaultValue = "0") Integer page,
            @RequestParam(value="linesPerPage", defaultValue = "10") Integer linesPerPage,
            @RequestParam(value="orderBy", defaultValue = "name") String orderBy,
            @RequestParam(value="direction", defaultValue = "DESC") String direction
    ){
        Page<CityDto> listCityDto = cityService.findByAllCitys(page,linesPerPage,orderBy,direction);
        return ResponseEntity.ok().body(listCityDto);
    }

    @GetMapping(value = "state/{nameState}/city")
    public ResponseEntity<Page<CityDto>> findByAllCityPerState(
            @PathVariable String nameState,
            @RequestParam(value="page", defaultValue = "0") Integer page,
            @RequestParam(value="linesPerPage", defaultValue = "10") Integer linesPerPage,
            @RequestParam(value="orderBy", defaultValue = "name") String orderBy,
            @RequestParam(value="direction", defaultValue = "DESC") String direction
    ){
        Page<CityDto> listCityDto = cityService.findByAllCitysPerOneState(nameState, page,linesPerPage,orderBy,direction);
        return ResponseEntity.ok().body(listCityDto);
    }
}
