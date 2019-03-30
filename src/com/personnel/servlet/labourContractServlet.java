package com.personnel.servlet;

import com.alibaba.fastjson.JSONObject;
import com.entity.Department;
import com.entity.PageBean;
import com.entity.Staff;
import com.manager.dao.DepartmentDao;
import com.manager.dao.daoimpl.DepartmentDaoImpl;
import com.personnel.entity.LabourContract;
import com.personnel.service.LabourContractService;
import com.utils.DateUtil;
import com.utils.JsonUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author: LiGX
 * @Date: 2019/3/30
 */
@WebServlet(name = "labourContractServlet",urlPatterns ="/labourContractServlet")
public class labourContractServlet extends HttpServlet {
    private LabourContractService service=new LabourContractService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String action = request.getParameter("action");
        if ("queryDetail".equals(action)) {
            queryDetail(request, response);
        } else if ("add".equals(action)) {
            add(request, response);
        } else if ("update".equals(action)) {
            update(request, response);
        } else if ("delete".equals(action)) {
            delete(request, response);
        } else if ("queryOne".equals(action)) {
            queryOne(request, response);
        } else if ("queryPage".equals(action)) {
            queryPage(request, response);
        }else if ("deleteAll".equals(action)) {
            deleteAll(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
    protected void deleteAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ids = request.getParameter("ids");
        String[] array = ids.split(",");
        int sum=0;
        for (String labourContractId: array) {
            int i = service.deleteLabourContract(Integer.parseInt(labourContractId));
            sum+=i;
        }
        response.getWriter().print(sum);
    }

    protected void queryDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String labourContractId = request.getParameter("labourContractId");
        LabourContract labourContract = service.queryOne(Integer.parseInt(labourContractId));

        request.setAttribute("labourContract", labourContract);
        request.getRequestDispatcher("/personnel/background/labourContract/labourContractDetail.jsp").forward(request, response);
    }

    protected void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String staffName = request.getParameter("staffName");
        String companyName = request.getParameter("companyName");
        String jobTime = request.getParameter("jobTime");
        String signTime = request.getParameter("signTime");

        String basicSalary = request.getParameter("basicSalary");
        LabourContract labourContract = new LabourContract(
                companyName,staffName,jobTime, DateUtil.formatString(signTime, "yyyy-MM-dd HH:mm:ss")
            ,Double.parseDouble(basicSalary));

        int i = service.addLabourContract(labourContract);

        response.getWriter().print(i);

    }

    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String labourContractId = request.getParameter("labourContractId");
        String staffName = request.getParameter("staffName");
        String companyName = request.getParameter("companyName");
        String jobTime = request.getParameter("jobTime");
        String signTime = request.getParameter("signTime");

        String basicSalary = request.getParameter("basicSalary");


        LabourContract labourContract = new LabourContract(Integer.parseInt(labourContractId)
                ,companyName,staffName,jobTime, DateUtil.formatString(signTime, "yyyy-MM-dd HH:mm:ss")
                ,Double.parseDouble(basicSalary));

        int i = service.updateLabourContract(labourContract);

        response.getWriter().print(i);
    }

    protected void queryOne(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String labourContractId = request.getParameter("labourContractId");
        if (labourContractId != null) {
            LabourContract labourContract = service.queryOne(Integer.parseInt(labourContractId));
            request.setAttribute("labourContract", labourContract);
        }
        request.getRequestDispatcher("/personnel/background/labourContract/labourContractAdd.jsp").forward(request, response);
    }

    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String labourContractId = request.getParameter("labourContractId");
        int i = service.deleteLabourContract(Integer.parseInt(labourContractId));
        response.getWriter().print(i);
    }

    protected void queryPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = request.getParameter("page"); //页码
        String limit = request.getParameter("limit"); // 每页条数
        PageBean pageBean = new PageBean();
        pageBean.setPageIndex(Integer.parseInt(page));
        pageBean.setPageCount(Integer.parseInt(limit));
        pageBean.setCount(service.findAll().size());
        List<LabourContract> labourContractList = service.queryPage(pageBean);
        JSONObject jsonObject = JsonUtil.getJsonObject(labourContractList, pageBean);
        response.getWriter().print(jsonObject);
    }
}
