package com.wawcode.smogue.domain.borrower;

import com.wawcode.smogue.domain.persistence.borrower.Borrower;
import com.wawcode.smogue.domain.persistence.borrower.BorrowerRepository;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.wawcode.smogue.domain.api.borrower.BorrowerListDto;
import com.wawcode.smogue.domain.api.borrower.BorrowerListService;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class BorrowerListServiceImpl implements BorrowerListService {

    private static final Logger log = LoggerFactory.getLogger(BorrowerListServiceImpl.class);

    private BorrowerRepository borrowerRepository;
    private ModelMapper modelMapper;

    @Autowired
    public BorrowerListServiceImpl(BorrowerRepository borrowerRepository, ModelMapper modelMapper) {
        this.borrowerRepository = borrowerRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<BorrowerListDto> getBorrowers() {
        List<Borrower> borrowers = borrowerRepository.findAll();
        log.info("There was found {} Borrowers accounts", borrowers.size());
        return convertToDtos(borrowers);
    }

    private List<BorrowerListDto> convertToDtos(List<Borrower> borrowers) {
        return borrowers
                .stream()
                .map(this::convertToDto)
                .collect(toList());
    }

    private BorrowerListDto convertToDto(Borrower borrower) {
        return modelMapper.map(borrower, BorrowerListDto.class);
    }
}