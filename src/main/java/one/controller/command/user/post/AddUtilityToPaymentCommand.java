package one.controller.command.user.post;


import one.controller.command.Command;
import one.model.entity.Payment;
import one.model.entity.User;
import one.model.entity.Utility;
import one.model.service.PaymentService;
import one.model.service.UserService;
import one.model.service.UtilityService;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;

public class AddUtilityToPaymentCommand implements Command {

    private PaymentService paymentService;
    private UserService userService;
    private UtilityService utilityService;

    public AddUtilityToPaymentCommand() {
        this.paymentService = new PaymentService();
        this.userService = new UserService();
        this.utilityService = new UtilityService();
    }

    @Override
    public String execute(HttpServletRequest request) {

        long utilityId = Long.parseLong(request.getParameter("utilityId"));
        String name = request.getParameter("name");
        int amount = Integer.parseInt(request.getParameter("amount"));
        int price = Integer.parseInt(request.getParameter("price"));
        LocalDate date = LocalDate.parse(request.getParameter("date"));
        long clientId = ((User) request.getSession().getAttribute("user")).getId();
        Payment payment = new Payment.Builder()
                .utilityId(utilityId)
                .clientId(clientId)
                .amount(amount)
                .price(price*amount)
                .date(date)
                .build();
        paymentService.payment(payment);
        request.setAttribute("payment", payment);
        request.setAttribute("utilityName", name);
        request.setAttribute("utilityPrice", price);
        return "/WEB-INF/user/order_submit.jsp";
    }
}
