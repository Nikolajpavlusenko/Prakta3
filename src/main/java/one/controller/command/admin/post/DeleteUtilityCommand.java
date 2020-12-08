package one.controller.command.admin.post;


import one.controller.command.Command;
import one.model.service.UtilityService;

import javax.servlet.http.HttpServletRequest;

public class DeleteUtilityCommand implements Command {

    private UtilityService utilityService;

    public DeleteUtilityCommand() {
        this.utilityService = new UtilityService();
    }

    @Override
    public String execute(HttpServletRequest request) {
        long utilityId = Long.parseLong(request.getParameter("utilityId"));
        try {
            utilityService.deleteUtility(utilityId);
        } catch (Exception e) {

        }
        return "redirect:/admin/adminUtilityList";
    }
}
