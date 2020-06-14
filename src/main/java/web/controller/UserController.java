package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import web.model.User;
import web.service.UserService;

import javax.jws.WebParam;
import java.util.List;
import java.util.Map;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String printUsers(ModelMap model) {
        List<User> list = userService.listUsers();
        model.addAttribute("list", list);
        return "users";
    }

    @RequestMapping(value = "/users/add", method = RequestMethod.GET)
    public String addUser(Map<String, Object> model) {
        User user = new User();
        model.put("user", user);
        return "add";
    }

    @RequestMapping(value = "/users/add", method = RequestMethod.POST)
    public String addUser(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return "redirect:/users";
    }

    @RequestMapping(value = "/users/delete", method = RequestMethod.GET)
    public String deleteUser(@RequestParam long id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }

    @RequestMapping(value = "/users/edit", method = RequestMethod.GET)
    public ModelAndView editUser(@RequestParam long id) {
        ModelAndView modelAndView = new ModelAndView("edit");
        User user = userService.getUserById(id);
        modelAndView.addObject("user", user);
        return modelAndView;
    }

    @RequestMapping(value = "/users/edit", method = RequestMethod.POST)
    public String editUser(@ModelAttribute("user") User user) {
        userService.editUser(user);
        return "redirect:/users";
    }
}
