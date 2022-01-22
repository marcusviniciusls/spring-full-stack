package br.com.udemy.Spring.FullStack.services;

import br.com.udemy.Spring.FullStack.domain.Categoria;
import br.com.udemy.Spring.FullStack.dto.CategoriaDto;
import br.com.udemy.Spring.FullStack.exception.ResourceNotFoundException;
import br.com.udemy.Spring.FullStack.factory.CategoriaBusinessRule;
import br.com.udemy.Spring.FullStack.form.atualizar.CategoriaRefresh;
import br.com.udemy.Spring.FullStack.form.salvar.CategoriaForm;
import br.com.udemy.Spring.FullStack.repositorys.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class CategoriaService {
    
    @Autowired
    private CategoriaRepository categoriaRepository;
    
    public CategoriaDto buscarCategoria(UUID id){
        Optional<Categoria> categoriaOptional = categoriaRepository.findById(id);
        if (categoriaOptional.isEmpty()){
            throw new ResourceNotFoundException("Categoria não encontrada");
        }
        Categoria categoria = categoriaOptional.get();
        CategoriaDto categoriaDto = CategoriaBusinessRule.convertCategoriaInCategoriaDto(categoria);

        return categoriaDto;
    }

    public CategoriaDto salvarCategoria(CategoriaForm categoriaForm){
        Categoria categoria = CategoriaBusinessRule.convertCategoriaFormInCategoria(categoriaForm);
        categoriaRepository.save(categoria);
        return CategoriaBusinessRule.convertCategoriaInCategoriaDto(categoria);
    }

    public void atualizarCategoria(UUID id, CategoriaRefresh categoriaRefresh){
        Optional<Categoria> optionalCategoria = categoriaRepository.findById(id);
        if (optionalCategoria.isEmpty()){
            throw new ResourceNotFoundException("Categoria Não Encontrada");
        }
        Categoria categoria = optionalCategoria.get();
        Categoria categoriaSalvar = CategoriaBusinessRule.atualizarCategoria(categoria, categoriaRefresh);
        categoriaRepository.save(categoriaSalvar);
    }

    public void deletarCategoriaId(UUID id){
        categoriaRepository.deleteById(id);
    }

    public Page<CategoriaDto> findAll(Integer page, Integer linesPerPage, String orderBy, String direction){
        Pageable pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.fromString(direction), orderBy);
        Page<Categoria> listCategoria = categoriaRepository.findAll(pageRequest);
        Page<CategoriaDto> listCategoriaDto = listCategoria.map(CategoriaBusinessRule::convertCategoriaInCategoriaDto);
        return listCategoriaDto;
    }
}
