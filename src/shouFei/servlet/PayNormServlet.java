package shouFei.servlet;

import shouFei.entity.PayItems;
import shouFei.service.PayItemsService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @Acthor:孙琪; date:2019/3/27;
 */
public class PayNormServlet {
    PayItemsService service = new PayItemsService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String action = request.getParameter("action");
        System.out.println(action);
        if ("toadd".equals(action)) {
            toadd(request, response);
        }
        //else if ("add".equals(action)) {
//            add(request, response);
//        } else if ("update".equals(action)) {
//            update(request, response);
//        } else if ("delete".equals(action)) {
//            delete(request, response);
//        } else if ("queryOne".equals(action)) {
//            queryOne(request, response);
//        }
    }

    private void toadd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<PayItems> PayItemsList = service.findAll();
        request.setAttribute("PayItemsList",PayItemsList);
        request.getRequestDispatcher("/shouFei/payItemsAdd.jsp").forward(request,response);
    }
}
