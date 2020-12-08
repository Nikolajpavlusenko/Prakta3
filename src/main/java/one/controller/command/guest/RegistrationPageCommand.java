package one.controller.command.guest;


import one.controller.command.Command;

import javax.servlet.http.HttpServletRequest;

public class RegistrationPageCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        return "/WEB-INF/guest/registration.jsp";
    }
}
