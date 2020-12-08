package one.controller.command.admin.post;


import one.controller.command.Command;

import one.model.entity.Utility;

import one.model.service.UtilityService;

import javax.servlet.http.HttpServletRequest;

public class UpdateUtilitySubmitCommand implements Command {

    private UtilityService utilityService;

    public UpdateUtilitySubmitCommand() {
        this.utilityService = new UtilityService();
    }

    @Override
    public String execute(HttpServletRequest request) {
        long utilityId = Long.parseLong(request.getParameter("id"));
        String utilityName = request.getParameter("name");
        int utilityPrice = Integer.parseInt(request.getParameter("price"));
        Utility utility = new Utility(utilityId, utilityName, utilityPrice);
        utilityService.updateUtility(utility);
        return "redirect:/admin/adminUtilityList";
    }
}
