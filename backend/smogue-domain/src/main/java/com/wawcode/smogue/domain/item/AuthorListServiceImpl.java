package com.wawcode.smogue.domain.item;

import com.wawcode.smogue.domain.api.item.AuthorListDto;
import com.wawcode.smogue.domain.persistence.item.Author;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.wawcode.smogue.domain.api.item.AuthorListService;
import com.wawcode.smogue.domain.persistence.item.AuthorRepository;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class AuthorListServiceImpl implements AuthorListService {

    private static final Logger log = LoggerFactory.getLogger(AuthorListServiceImpl.class);

    private AuthorRepository authorRepository;
    private ModelMapper modelMapper;

    @Autowired
    public AuthorListServiceImpl(AuthorRepository authorRepository, ModelMapper modelMapper) {
        this.authorRepository = authorRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<AuthorListDto> findAllAuthors() {
        List<Author> authors = authorRepository.findAll();
        log.info("There was found {} Authors", authors.size());
        return convertToDtos(authors);
    }

    private List<AuthorListDto> convertToDtos(List<Author> authors) {
        return authors
                .stream()
                .map(this::convertToDto)
                .collect(toList());
    }

    private AuthorListDto convertToDto(Author author) {
        return modelMapper.map(author, AuthorListDto.class);
    }
}
