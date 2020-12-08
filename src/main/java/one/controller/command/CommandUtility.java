package one.controller.command;


import one.model.entity.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashSet;

public class CommandUtility {

    public static void setUserToSession(HttpServletRequest request, User user) {
        HttpSession session = request.getSession();
        session.setAttribute("email", user.getEmail());
        session.setAttribute("role", user.getRole());
        session.setAttribute("clientId", user.getId());
        session.setAttribute("name", user.getName());
        session.setAttribute("user", user);
    }

    public static boolean checkUserIsNotLogged(HttpServletRequest request, String email){
        HashSet<String> loggedUsers = (HashSet<String>) request.getSession().getServletContext()
                .getAttribute("loggedUsers");

        if(loggedUsers.stream().anyMatch(email::equals)){
            return false;
        }
        loggedUsers.add(email);
        request.getSession().getServletContext()
                .setAttribute("loggedUsers", loggedUsers);
        return true;
    }
}
