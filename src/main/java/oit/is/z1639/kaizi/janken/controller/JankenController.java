package oit.is.z1639.kaizi.janken.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import oit.is.z1639.kaizi.janken.model.Entry;

@Controller

public class JankenController {
  @Autowired
  private Entry entry;

  @PostMapping("/join")
  public String join(@RequestParam String name, ModelMap model) {
    model.addAttribute("name", name);
    return "janken.html";
  }

  @GetMapping("/join")
  public String join() {
    return "janken.html";
  }

  @GetMapping("/janken")
  public String janken() {
    return "janken.html";
  }

  @GetMapping("/hand_rock")
  public String hand_rock(ModelMap model) {
    String myhand = "ぐー";
    String cpuhand = "ぐー";
    String result = "引き分け";
    model.addAttribute("myhand", myhand);
    model.addAttribute("cpuhand", cpuhand);
    model.addAttribute("result", result);
    return "janken.html";
  }

  @GetMapping("/hand_scissors")
  public String hand_scissors(ModelMap model) {
    String myhand = "ちょき";
    String cpuhand = "ぐー";
    String result = "負け";
    model.addAttribute("myhand", myhand);
    model.addAttribute("cpuhand", cpuhand);
    model.addAttribute("result", result);
    return "janken.html";
  }

  @GetMapping("/hand_paper")
  public String hand_paper(ModelMap model) {
    String myhand = "ぱー";
    String cpuhand = "ぐー";
    String result = "勝ち";
    model.addAttribute("myhand", myhand);
    model.addAttribute("cpuhand", cpuhand);
    model.addAttribute("result", result);
    return "janken.html";
  }

  @GetMapping("/entry")
  public String entry(Principal prin, ModelMap model) {
    String loginUser = prin.getName();
    this.entry.addUser(loginUser);
    model.addAttribute("room", this.entry);

    return "janken.html";
  }

}
