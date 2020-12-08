package one.controller.command.guest.post;


import one.controller.command.Command;
import one.controller.config.BCryptPasswordEncoder;
import one.controller.config.Regex;
import one.model.entity.RoleType;
import one.model.entity.User;
import one.model.service.UserService;
import javax.servlet.http.HttpServletRequest;

public class RegistrationCommand implements Command {

    private UserService userService;

    public RegistrationCommand() {
        this.userService=new UserService();
    }

    @Override
    public String execute(HttpServletRequest request) {
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        return save(new User.Builder()
                        .name(name)
                        .surname(surname)
                        .email(email)
                        .password(password)
                        .build());

    }
    public String save(User user){

        if (verify(user)) {
            try {
                userService.addUser(new User.Builder()
                        .name(user.getName())
                        .surname(user.getSurname())
                        .email(user.getEmail())
                        .password(new BCryptPasswordEncoder().encode(user.getPassword()))
                        .role(RoleType.USER)
                        .build());
                return "redirect:/login";
            } catch (Exception e) {
                return "redirect:/registration?error=userAlreadyExist";
            }
        }else
            return "redirect:/registration?regex=error";
    }
    public boolean verify(User user){
        return user.getEmail().matches(Regex.EMAIL_REGEX)
                && (user.getName().matches(Regex.NAME_REGEX) || user.getName().matches(Regex.NAME_UKR_REGEX))
                && (user.getSurname().matches(Regex.NAME_REGEX) || user.getSurname().matches(Regex.NAME_UKR_REGEX))
                && user.getPassword().matches(Regex.PASSWORD_REGEX);

    }
}
