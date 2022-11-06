package oit.is.z1639.kaizi.janken.controller;

import java.security.Principal;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import oit.is.z1639.kaizi.janken.model.Entry;
import oit.is.z1639.kaizi.janken.model.User;
import oit.is.z1639.kaizi.janken.model.UserMapper;
import oit.is.z1639.kaizi.janken.model.Match;
import oit.is.z1639.kaizi.janken.model.MatchMapper;
import oit.is.z1639.kaizi.janken.model.MatchInfo;
import oit.is.z1639.kaizi.janken.model.MatchInfoMapper;

@Controller

public class JankenController {

  @Autowired
  UserMapper userMapper;

  @Autowired
  MatchMapper matchMapper;

  @Autowired
  MatchInfoMapper matchInfoMapper;

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
  public String janken(Principal prin, ModelMap model) {
    String loginUser = prin.getName();
    ArrayList<User> users = userMapper.selectAllUser();
    ArrayList<Match> matches = matchMapper.selectAllMatches();
    ArrayList<MatchInfo> matchInfo = matchInfoMapper.selectAllMatchInfo();
    model.addAttribute("name", loginUser);
    model.addAttribute("users", users);
    model.addAttribute("matches", matches);
    model.addAttribute("matchInfo", matchInfo);
    return "janken.html";
  }

  @GetMapping("/match")
  public String match(@RequestParam int id, Principal prin, ModelMap model) {
    String loginUser = prin.getName();
    User user1 = userMapper.selectByName(loginUser);
    User user2 = userMapper.selectById(id);
    model.addAttribute("user1", user1);
    model.addAttribute("user2", user2);
    return "match.html";
  }

  @GetMapping("/fight")
  public String fight(@RequestParam int id, @RequestParam String user1Hand, Principal prin, ModelMap model) {
    String loginUser = prin.getName();
    User user1 = userMapper.selectByName(loginUser);
    User user2 = userMapper.selectById(id);
    String cpuhand = "";
    if (user1Hand.equals("ぐー")) {
      String myhand = "ぐー";
      cpuhand = "ぐー";
      String result = "引き分け";
      model.addAttribute("myhand", myhand);
      model.addAttribute("cpuhand", cpuhand);
      model.addAttribute("result", result);
    } else if (user1Hand.equals("ちょき")) {
      String myhand = "ちょき";
      cpuhand = "ぐー";
      String result = "負け";
      model.addAttribute("myhand", myhand);
      model.addAttribute("cpuhand", cpuhand);
      model.addAttribute("result", result);
    } else if (user1Hand.equals("ぱー")) {
      String myhand = "ぱー";
      cpuhand = "ぐー";
      String result = "勝ち";
      model.addAttribute("myhand", myhand);
      model.addAttribute("cpuhand", cpuhand);
      model.addAttribute("result", result);
    }
    model.addAttribute("user1", user1);
    model.addAttribute("user2", user2);
    matchMapper.InsertMatch(user1.getId(), id, user1Hand, cpuhand);
    return "match.html";
  }

  @GetMapping("/wait")
  public String wait(@RequestParam int id, @RequestParam String user1Hand, Principal prin, ModelMap model) {
    String loginUser = prin.getName();
    User user1 = userMapper.selectByName(loginUser);
    model.addAttribute("name", loginUser);
    matchInfoMapper.InsertMatchInfo(user1.getId(), id, user1Hand, true);
    return "wait.html";
  }

  @GetMapping("/hand_rock")
  public String hand_rock(ModelMap model) {
    String myhand = "ぐー";
    String cpuhand = "ぐー";
    String result = "引き分け";
    model.addAttribute("myhand", myhand);
    model.addAttribute("cpuhand", cpuhand);
    model.addAttribute("result", result);
    return "match.html";
  }

  @GetMapping("/hand_scissors")
  public String hand_scissors(ModelMap model) {
    String myhand = "ちょき";
    String cpuhand = "ぐー";
    String result = "負け";
    model.addAttribute("myhand", myhand);
    model.addAttribute("cpuhand", cpuhand);
    model.addAttribute("result", result);
    return "match.html";
  }

  @GetMapping("/hand_paper")
  public String hand_paper(ModelMap model) {
    String myhand = "ぱー";
    String cpuhand = "ぐー";
    String result = "勝ち";
    model.addAttribute("myhand", myhand);
    model.addAttribute("cpuhand", cpuhand);
    model.addAttribute("result", result);
    return "match.html";
  }

  /*
   * @GetMapping("/entry")
   * public String entry(Principal prin, ModelMap model) {
   * String loginUser = prin.getName();
   * this.entry.addUser(loginUser);
   * model.addAttribute("room", this.entry);
   *
   * return "janken.html";
   * }
   */

  @GetMapping("janken4-3/{id}")
  public String sample42(@PathVariable Integer id, ModelMap model) {
    User user2 = userMapper.selectById(id);
    model.addAttribute("user2", user2);
    return "janken.html";
  }

}
