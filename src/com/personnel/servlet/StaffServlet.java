package com.personnel.servlet;

import com.alibaba.fastjson.JSONObject;
import com.entity.PageBean;
import com.entity.Staff;
import com.personnel.service.StaffService;
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
 * @Date: 2019-03-27 下午 6:21
 */
@WebServlet(name = "StaffServlet", urlPatterns = "/StaffServlet")
public class StaffServlet extends HttpServlet {
    private StaffService staffService = new StaffService();

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
        doPost(request, response);
    }
    protected void deleteAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ids = request.getParameter("ids");
        System.out.println("ids"+ids);
        String[] array = ids.split(",");
        int sum=0;
        for (String staffId: array) {
            int i = staffService.deleteStaff(Integer.parseInt(staffId));
            sum+=i;
        }
        response.getWriter().print(sum);
    }

    protected void queryDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String staffId = request.getParameter("staffId");
        Staff staff = staffService.queryOneStaff(Integer.parseInt(staffId));

        request.setAttribute("staff", staff);
        request.getRequestDispatcher("/personnel/background/staff/staffDetail.jsp").forward(request, response);
    }

    protected void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String staffName = request.getParameter("staffName");
        String identityCard = request.getParameter("identityCard");
        String age = request.getParameter("age");
        String sex = request.getParameter("sex");

        String address = request.getParameter("address");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String city = request.getParameter("city");
        String household = request.getParameter("household");
        String station = request.getParameter("station");
        String education = request.getParameter("education");
        String departmentId = request.getParameter("departmentId");
        String salaryId = request.getParameter("salaryId");
        String securityInsuranceId = request.getParameter("securityInsuranceId");
        String joinTime = request.getParameter("joinTime");


        String image = (String) request.getSession().getAttribute("image");
        request.getSession().removeAttribute("image");
        Staff staff = new Staff(staffName,image!=null?image:"",identityCard, Integer.parseInt(age),
                sex, address,phone,email,city,household,station,education,
                Integer.parseInt(departmentId),
                Integer.parseInt(salaryId),
                Integer.parseInt(securityInsuranceId),
                DateUtil.formatString(joinTime, "yyyy-MM-dd HH:mm:ss"));

        int i = staffService.addStaff(staff);
        response.getWriter().print(i);
    }

    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String staffId = request.getParameter("staffId");
        String staffName = request.getParameter("staffName");
        String identityCard = request.getParameter("identityCard");
        String age = request.getParameter("age");
        String sex = request.getParameter("sex");


        String address = request.getParameter("address");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String city = request.getParameter("city");
        String household = request.getParameter("household");
        String station = request.getParameter("station");
        String education = request.getParameter("education");
        String departmentId = request.getParameter("departmentId");
        String salaryId = request.getParameter("salaryId");
        String securityInsuranceId = request.getParameter("securityInsuranceId");
        String joinTime = request.getParameter("joinTime");


        String image = (String) request.getSession().getAttribute("image");
        request.getSession().removeAttribute("image");
        Staff staff = new Staff(Integer.parseInt(staffId),staffName,image!=null?image:"",identityCard, Integer.parseInt(age),
                sex, address,phone,email,city,household,station,education,
                Integer.parseInt(departmentId),
                Integer.parseInt(salaryId),
                Integer.parseInt(securityInsuranceId),
                DateUtil.formatString(joinTime, "yyyy-MM-dd HH:mm:ss"));

        int i = staffService.updateStaff(staff);

        response.getWriter().print(i);
    }

    protected void queryOne(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String staffId = request.getParameter("staffId");
        Staff staff = staffService.queryOne(Integer.parseInt(staffId));
        request.setAttribute("staff", staff);
        request.getRequestDispatcher("/personnel/background/staff/staffAdd.jsp").forward(request, response);
    }

    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String staffId = request.getParameter("staffId");
        int i = staffService.deleteStaff(Integer.parseInt(staffId));
        response.getWriter().print(i);
    }

    protected void queryPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = request.getParameter("page"); //页码
        String limit = request.getParameter("limit"); // 每页条数
        PageBean pageBean = new PageBean();
        pageBean.setPageIndex(Integer.parseInt(page));
        pageBean.setPageCount(Integer.parseInt(limit));
        pageBean.setCount(staffService.findAll().size());
        List<Staff> staffList = staffService.queryStaffPage(pageBean);
        JSONObject jsonObject = JsonUtil.getJsonObject(staffList, pageBean);
        response.getWriter().print(jsonObject);
    }

}
