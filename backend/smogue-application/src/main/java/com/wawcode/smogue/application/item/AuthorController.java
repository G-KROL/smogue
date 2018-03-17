package com.wawcode.smogue.application.item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.wawcode.smogue.domain.api.item.AuthorListDto;
import com.wawcode.smogue.domain.api.item.AuthorListService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AuthorController {

    private final AuthorListService authorListService;

    @Autowired
    public AuthorController(AuthorListService authorListService) {
        this.authorListService = authorListService;
    }

    @RequestMapping(value = "/authors", method = RequestMethod.GET)
    public @ResponseBody
    List<AuthorListDto> findAllAuthors() {
        return authorListService.findAllAuthors();
    }
}
