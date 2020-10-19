package web.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;
import java.util.List;


@Controller
@RequestMapping("/users")
public class UsersController {

    public UserService service;

    @Autowired
    public UsersController(UserService service) {
        this.service = service;
    }

    @GetMapping(value = "/users")
    public String listAll(Model model) {
        List<User> users = service.getAllUsers();
        model.addAttribute("listOfUsers", users);
        return "/users/home";
    }

    @GetMapping(value = "/create")
    public String createUser(Model create_model) {
        User user = new User();
        create_model.addAttribute("user", user);
        return "/users/create";
    }

    @PostMapping(value = "/createUser")
    public String createUser(@ModelAttribute User user) {
        service.addUser(user);
        return "redirect:/users/users";
    }


    @GetMapping(value = "/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        service.deleteUserById(id);
        return "redirect:/users/users";
    }

    @GetMapping(value = "/read")
    public String readAll(Model model) {
        List<User> users = service.getAllUsers();
        model.addAttribute("listOfUsers", users);
        return "/users/home";
    }

    @GetMapping(value = "/update/{id}")
    public String editUser(@PathVariable("id") Long id, Model model) {
        User user = service.readUserById(id);
        model.addAttribute("user", user);
        return "users/update";
    }
    
    @PostMapping(value = "/update")
    public String updateUser(@ModelAttribute User user) {
        service.updateUser(user);
        return "redirect:/users/users";
    }
}
