package com.客户关系管理.servelt;


import com.客户关系管理.entity.CustomerFeedback;
import com.客户关系管理.entity.PageBean;
import com.客户关系管理.entity.ServiceDispathing;
import com.客户关系管理.service.CustomerFeedbackService;
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

@WebServlet(name = "ServiceDispathingServelt",urlPatterns = "/ServiceDispathingServelt",initParams = {@WebInitParam(name = "PageCount",value = "5")})
public class ServiceDispathingServelt extends HttpServlet {

    CustomerFeedbackService cservice = new CustomerFeedbackService();
    ServiceDispathingService service = new ServiceDispathingService();
    DecorateApplyService dservice = new DecorateApplyService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("action");

        if("serviceAdd".equals(action)){
            serviceAdd(request,response);
        }else if("queryFeedback".equals(action)){
            queryFeedback(request,response);
        }else if("applyAdd".equals(action)){
            applyAdd(request,response);
        }else if("queryByname".equals(action)){
            queryByname(request,response);
        }else{
            query(request,response);
        }


    }

    private void queryByname(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("name");
        List<ServiceDispathing> list = service.findByName(name);
        if(list.size()!=0){
            request.setAttribute("list",list);
            request.getRequestDispatcher("/crm/serviceManagement/ServiceDispathingfFind.jsp").forward(request,response);
        }else{
            request.getRequestDispatcher("/crm/customerManagement/CustomerFindError.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    protected void serviceAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String addr = request.getParameter("addr");
        String cphone = request.getParameter("c_phone");
        String things = request.getParameter("things");
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        int i = service.add(name,addr, things,cphone);
        if(i!=0){
            cservice.update(Integer.parseInt(id),"已处理");
        }
        response.getWriter().print(i);
    }

    protected void queryFeedback(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        CustomerFeedback customerFeedback = cservice.findByid(Integer.parseInt(id));
        request.setAttribute("customerFeedback",customerFeedback);
        request.getRequestDispatcher("/crm/serviceManagement/ServiceDispathingAdd.jsp").forward(request,response);
    }

    protected void applyAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String addr = request.getParameter("addr");
        String c_phone = request.getParameter("phone");
        String things = request.getParameter("things");
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        int i = service.add(name,addr, things,c_phone);
        System.out.println(i);
        if(i!=0){
            dservice.updata(Integer.parseInt(id),"已处理");
        }
        response.getWriter().print(i);
    }

    protected void query(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String pageIndex = request.getParameter("pageIndex");
        String pageCount = getInitParameter("PageCount");
        PageBean pageBean = new PageBean();
        if(!StringUtil.isEmpty(pageIndex)){
            pageBean.setPageIndex(Integer.parseInt(pageIndex));
        }
        pageBean.setPageCount(Integer.parseInt(pageCount));
        pageBean.setCount(service.findAll().size());

        List<ServiceDispathing> serviceDispathings = service.queryAll(pageBean);
        request.setAttribute("serviceDispathings",serviceDispathings);
        request.setAttribute("pageBean",pageBean);
        request.getRequestDispatcher("/crm/serviceManagement/ServiceDispathingData.jsp").forward(request,response);
    }

}
