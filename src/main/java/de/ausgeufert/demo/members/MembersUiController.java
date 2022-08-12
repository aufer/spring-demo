package de.ausgeufert.demo.members;

import de.ausgeufert.demo.shared.EntityController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/web/members")
public class MembersUiController extends EntityController<Member, MembersRepository> {

    @Override
    protected String getViewName() {
        return "members";
    }
}
