package com.客户关系管理.servelt;


import com.客户关系管理.entity.DecorateApply;
import com.客户关系管理.entity.PageBean;
import com.客户关系管理.service.DecorateApplyService;
import com.客户关系管理.service.ServiceDispathingService;
import utils.StringUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author：Ganlan；
 * @date：2019-03-27；
 */

@WebServlet(name = "DecorateApplyServelt", urlPatterns = "/DecorateApplyServelt", initParams = {@WebInitParam(name = "PageCount", value = "5")})
public class DecorateApplyServelt extends HttpServlet {

    DecorateApplyService service = new DecorateApplyService();
    ServiceDispathingService s = new ServiceDispathingService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("action");
        if ("queryDecorate".equals(action)) {
            queryDecorate(request, response);
        } else if ("findByName".equals(action)) {
            findByName(request, response);
        } else {
            query(request, response);
        }
    }

    private void findByName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("name");

        List<DecorateApply> list = service.findByName(name);
        if (list.size() != 0) {
            request.setAttribute("list", list);
            request.getRequestDispatcher("/crm/serviceManagement/DecorateApplyFind.jsp").forward(request, response);
        } else
            request.getRequestDispatcher("/crm/customerManagement/CustomerFindError.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    protected void query(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String pageIndex = request.getParameter("pageIndex");
        String pageCount = getInitParameter("PageCount");
        PageBean pageBean = new PageBean();
        if (!StringUtil.isEmpty(pageIndex)) {
            pageBean.setPageIndex(Integer.parseInt(pageIndex));
        }
        pageBean.setPageCount(Integer.parseInt(pageCount));
        pageBean.setCount(service.findAll().size());

        List<DecorateApply> decorateApplies = service.find(pageBean);
        request.setAttribute("decorateApplies", decorateApplies);
        request.setAttribute("pageBean", pageBean);
        request.getRequestDispatcher("/crm/serviceManagement/DecorateApplyData.jsp").forward(request, response);
    }

    protected void queryDecorate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("id");
        DecorateApply decorateApply = service.findById(Integer.parseInt(id));

        request.setAttribute("decorateApply", decorateApply);
        request.getRequestDispatcher("/crm/serviceManagement/ServiceDispathingUp.jsp").forward(request, response);
    }

}
