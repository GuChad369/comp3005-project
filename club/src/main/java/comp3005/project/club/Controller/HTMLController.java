package comp3005.project.club.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HTMLController {

    @GetMapping("/trainer")
    public String trainer(Model model) {
        return "trainer";
    }

    @GetMapping("/administrator")
    public String administrator(Model model) {
        return "administrator";
    }
}
