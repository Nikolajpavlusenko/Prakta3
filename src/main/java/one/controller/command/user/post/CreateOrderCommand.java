package one.controller.command.user.post;


import one.controller.command.Command;
import one.model.service.UtilityService;

import javax.servlet.http.HttpServletRequest;

public class CreateOrderCommand implements Command {

    private UtilityService utilityService;

    public CreateOrderCommand() {
        this.utilityService = new UtilityService();
    }


    @Override
    public String execute(HttpServletRequest request) {
        int utilityId = Integer.parseInt(request.getParameter("utilityId"));
        try {
            request.setAttribute("utility", utilityService.getUtility(utilityId));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "/WEB-INF/user/create_order.jsp";
    }
}
