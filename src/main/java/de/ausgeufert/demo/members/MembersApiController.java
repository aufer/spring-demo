package de.ausgeufert.demo.members;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/members")
public class MembersApiController {

    @Autowired
    private MembersRepository repository;

    List<Member> list() {
        return repository.findAll();
    }
}
