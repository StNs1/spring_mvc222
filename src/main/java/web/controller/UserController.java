package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

import java.util.List;
import java.util.Map;

@Controller
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String printUsers(ModelMap model) {
        List<User> list = userService.listUsers();
        model.addAttribute("list", list);
        return "users";
    }

    @GetMapping("/users/add")
    public String addUser(Map<String, Object> model) {
        User user = new User();
        model.put("user", user);
        return "add";
    }

    @PostMapping("/users/add")
    public String addUser(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return "redirect:/users";
    }

    @GetMapping("/users/delete")
    public String deleteUser(@RequestParam long id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }

    @GetMapping("/users/edit")
    public String editUser(@RequestParam long id, Map<String, Object> model) {
        User user = userService.getUserById(id);
        model.put("user", user);
        return "edit";
    }

    @PostMapping("/users/edit")
    public String editUser(@ModelAttribute("user") User user) {
        userService.editUser(user);
        return "redirect:/users";
    }
}
