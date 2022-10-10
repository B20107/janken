package oit.is.z1639.kaizi.janken.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class JankenController {
  @PostMapping("/join")
  public String join(@RequestParam String kakeru1, ModelMap model) {
    String kakeruResult = kakeru1;
    model.addAttribute("kakeruResult", kakeruResult);
    return "janken.html";
  }

  @GetMapping("/join")
  public String join() {
    return "janken.html";
  }

}
