package one.controller.command.guest.post;


import one.controller.command.Command;
import one.controller.command.CommandUtility;
import one.controller.config.BCryptPasswordEncoder;
import one.controller.config.Regex;
import one.model.entity.RoleType;
import one.model.entity.User;
import one.model.service.UserService;

import javax.servlet.http.HttpServletRequest;

public class LoginCommand implements Command {

    private UserService userService;

    public LoginCommand() {
        this.userService = new UserService();
    }

    @Override
    public String execute(HttpServletRequest request) {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        User user;
        try {
            if (isValid(email, password) ) {
                user = userService.findByEmail(email);
                if (new BCryptPasswordEncoder().matches(password, user.getPassword()) && CommandUtility.checkUserIsNotLogged(request, email)) {
                    CommandUtility.setUserToSession(request, user);
                }else {
                    return "redirect:/login?user=error";
                }

            }else {
                return "redirect:/login?validation=error";
            }
        }catch (Exception e){
            return "redirect:/login?user=exception";
        }

        return redirect(user.getRole());

    }

    //todo
    private boolean isValid (String email, String password){
        return email.matches(Regex.EMAIL_REGEX) && password.matches(Regex.PASSWORD_REGEX);
    }
    private String redirect(RoleType role){
        return role.equals(RoleType.USER)
                ? "redirect:/user/order_utility"
                : "redirect:/admin/add_new_utility";
    }
}
