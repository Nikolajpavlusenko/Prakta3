package one.controller.command.admin.post;


import one.controller.command.Command;
import one.model.service.UtilityService;

import javax.servlet.http.HttpServletRequest;

public class UpdateUtilityCommand implements Command {

    private UtilityService utilityService;

    public UpdateUtilityCommand() {
        this.utilityService = new UtilityService();
    }

    @Override
    public String execute(HttpServletRequest request) {
        long utilityId = Long.parseLong(request.getParameter("utilityId2"));
        try {
           request.setAttribute("utility", utilityService.getUtility(utilityId));
        } catch (Exception e) {
            System.out.println(e);
        }
            return "/WEB-INF/admin/update_utility.jsp";
    }
}