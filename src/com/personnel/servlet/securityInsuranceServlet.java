package com.personnel.servlet;

import com.alibaba.fastjson.JSONObject;
import com.entity.Department;
import com.entity.PageBean;
import com.entity.Staff;
import com.manager.dao.DepartmentDao;
import com.manager.dao.daoimpl.DepartmentDaoImpl;
import com.personnel.entity.SecurityInsurance;
import com.personnel.service.SecurityInsuranceService;
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
 * @Date: 2019/3/30
 */
@WebServlet(name = "securityInsuranceServlet",urlPatterns = "/SecurityInsuranceServlet")
public class securityInsuranceServlet extends HttpServlet {
    private SecurityInsuranceService service=new SecurityInsuranceService();
    private StaffService staffService=new StaffService();
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
        for (String securityInsuranceId: array) {
            int i = service.deleteSecurityInsurance(Integer.parseInt(securityInsuranceId));
            sum+=i;
        }
        response.getWriter().print(sum);
    }

    protected void queryDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String securityInsuranceId = request.getParameter("securityInsuranceId");
        SecurityInsurance securityInsurance = service.queryOne(Integer.parseInt(securityInsuranceId));

        request.setAttribute("securityInsurance", securityInsurance);
        request.getRequestDispatcher("/personnel/background/securityInsurance/securityInsuranceDetail.jsp").forward(request, response);
    }

    protected void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String staffId = request.getParameter("staffId");
        String endowmentInsurance = request.getParameter("endowmentInsurance");
        String medicalInsurance = request.getParameter("medicalInsurance");
        String unemploymentInsurance = request.getParameter("unemploymentInsurance");


        String employmentInjuryInsurance = request.getParameter("employmentInjuryInsurance");
        String maternityInsurance = request.getParameter("maternityInsurance");
        String publicHousingFunds = request.getParameter("publicHousingFunds");
        int isEndowmentInsurance=0;
        if(endowmentInsurance!=null){
            isEndowmentInsurance=1;
        }
        int isMedicalInsurance=0;
        if(medicalInsurance!=null){
            isMedicalInsurance=1;
        }
        int isUnemploymentInsurance=0;
        if(unemploymentInsurance!=null){
            isUnemploymentInsurance=1;
        }
        int isEmploymentInjuryInsurance=0;
        if(employmentInjuryInsurance!=null){
            isEmploymentInjuryInsurance=1;
        }
        int isMaternityInsurance=0;
        if(maternityInsurance!=null){
            isMaternityInsurance=1;
        }
        int isPublicHousingFunds=0;
        if(publicHousingFunds!=null){
            isPublicHousingFunds=1;
        }
        SecurityInsurance securityInsurance = new SecurityInsurance(Integer.parseInt(staffId),
                isEndowmentInsurance,isMedicalInsurance,
                isUnemploymentInsurance,isEmploymentInjuryInsurance,
                isMaternityInsurance,isPublicHousingFunds);

        int i = service.addSecurityInsurance(securityInsurance);

        response.getWriter().print(i);
    }

    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String securityInsuranceId = request.getParameter("securityInsuranceId");
        String staffId = request.getParameter("staffId");
        String endowmentInsurance = request.getParameter("endowmentInsurance");
        String medicalInsurance = request.getParameter("medicalInsurance");
        String unemploymentInsurance = request.getParameter("unemploymentInsurance");
        System.out.println(securityInsuranceId);

        String employmentInjuryInsurance = request.getParameter("employmentInjuryInsurance");
        String maternityInsurance = request.getParameter("maternityInsurance");
        String publicHousingFunds = request.getParameter("publicHousingFunds");
        int isEndowmentInsurance=0;
        if(endowmentInsurance!=null){
            isEndowmentInsurance=1;
        }
        int isMedicalInsurance=0;
        if(medicalInsurance!=null){
            isMedicalInsurance=1;
        }
        int isUnemploymentInsurance=0;
        if(unemploymentInsurance!=null){
            isUnemploymentInsurance=1;
        }
        int isEmploymentInjuryInsurance=0;
        if(employmentInjuryInsurance!=null){
            isEmploymentInjuryInsurance=1;
        }
        int isMaternityInsurance=0;
        if(maternityInsurance!=null){
            isMaternityInsurance=1;
        }
        int isPublicHousingFunds=0;
        if(publicHousingFunds!=null){
            isPublicHousingFunds=1;
        }
        SecurityInsurance securityInsurance = new SecurityInsurance(Integer.parseInt(securityInsuranceId),Integer.parseInt(staffId),
                isEndowmentInsurance,isMedicalInsurance,
                isUnemploymentInsurance,isEmploymentInjuryInsurance,
                isMaternityInsurance,isPublicHousingFunds);

        int i = service.updateSecurityInsurance(securityInsurance);

        response.getWriter().print(i);
    }

    protected void queryOne(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String securityInsuranceId = request.getParameter("securityInsuranceId");
        if (securityInsuranceId != null) {
            SecurityInsurance securityInsurance = service.queryOne(Integer.parseInt(securityInsuranceId));
            request.setAttribute("securityInsurance", securityInsurance);
        }
        List<Staff> staffList = staffService.findAll();
        request.setAttribute("staffList",staffList);
        request.getRequestDispatcher("/personnel/background/securityInsurance/securityInsuranceAdd.jsp").forward(request, response);
    }

    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String securityInsuranceId = request.getParameter("securityInsuranceId");
        int i = service.deleteSecurityInsurance(Integer.parseInt(securityInsuranceId));
        response.getWriter().print(i);
    }

    protected void queryPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = request.getParameter("page"); //页码
        String limit = request.getParameter("limit"); // 每页条数
        PageBean pageBean = new PageBean();
        pageBean.setPageIndex(Integer.parseInt(page));
        pageBean.setPageCount(Integer.parseInt(limit));
        pageBean.setCount(service.findAll().size());
        List<SecurityInsurance> securityInsuranceList = service.queryPage(pageBean);
        JSONObject jsonObject = JsonUtil.getJsonObject(securityInsuranceList, pageBean);
        response.getWriter().print(jsonObject);
    }
}
