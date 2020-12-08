package one.controller.command.guest;


import one.controller.command.Command;

import javax.servlet.http.HttpServletRequest;

public class MainCommand implements Command {


    @Override
    public String execute(HttpServletRequest request) {
        return "/WEB-INF/guest/main.jsp";
    }
}
