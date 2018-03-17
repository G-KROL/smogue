package com.wawcode.smogue.application.borrower;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.wawcode.smogue.domain.api.borrower.BorrowerListDto;
import com.wawcode.smogue.domain.api.borrower.BorrowerListService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BorrowerController {

    private final BorrowerListService borrowerListService;

    @Autowired
    public BorrowerController(BorrowerListService borrowerListService) {
        this.borrowerListService = borrowerListService;
    }

    @RequestMapping(value = "/borrowers", method = RequestMethod.GET)
    public @ResponseBody
    List<BorrowerListDto> findAllBorrowers() {
        return borrowerListService.getBorrowers();
    }
}
