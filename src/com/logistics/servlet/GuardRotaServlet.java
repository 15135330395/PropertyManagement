package com.logistics.servlet;

import com.alibaba.fastjson.JSONObject;
import com.entity.PageBean;
import com.logistics.entity.GuardRota;
import com.logistics.entity.OperatingRecord;
import com.logistics.service.GuardRotaService;
import com.utils.DateUtil;
import com.utils.JsonUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * @Description GuardRotaServlet
 * @Author WYR
 * @CreateTime 2019-03-27 21:21
 */
@WebServlet(name = "GuardRotaServlet", urlPatterns = "/GuardRotaServlet")
public class GuardRotaServlet extends HttpServlet {
    private GuardRotaService service = new GuardRotaService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String action = request.getParameter("action");
        if ("getAllRota".equals(action)) {
            getAllRota(request, response);
        } else if ("getAllRotaByPage".equals(action)) {
            getAllRotaByPage(request, response);
        } else if ("findRotaByRotaId".equals(action)) {
            findRotaByRotaId(request, response);
        } else if ("findRotaByStaffId".equals(action)) {
            findRotaByStaffId(request, response);
        } else if ("addRota".equals(action)) {
            addRota(request, response);
        } else if ("editRota".equals(action)) {
            editRota(request, response);
        } else if ("updateRota".equals(action)) {
            updateRota(request, response);
        } else if ("deleteRota".equals(action)) {
            deleteRota(request, response);
        } else if ("deleteRotas".equals(action)) {
            deleteRotas(request, response);
        } else if ("clockIn".equals(action)) {
            clockIn(request, response);
        } else if ("clockOut".equals(action)) {
            clockOut(request, response);
        }
    }

    private void getAllRota(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    private void getAllRotaByPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PageBean pageBean = new PageBean();
        // 页码
        String pageIndex = request.getParameter("page");
        if (pageIndex != null) {
            pageBean.setPageIndex(Integer.parseInt(pageIndex));
        }
        // 每页条数
        String pageCount = request.getParameter("limit");
        pageBean.setPageCount(Integer.parseInt(pageCount));
        // 总条数
        int rotaCount = service.getAllRota().size();
        pageBean.setCount(rotaCount);
        List<GuardRota> rotaList = service.getAllRotaByPage(pageBean);
        JSONObject table = JsonUtil.getJsonObject(rotaList, pageBean);
        response.getWriter().print(table);
    }

    private void findRotaByRotaId(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String rotaId = request.getParameter("rotaId");
        GuardRota rota = service.findRotaByRotaId(Integer.parseInt(rotaId));
        request.setAttribute("rota", rota);
        request.getRequestDispatcher("/logistics/GuardRota/GuardRotaByRotaId.jsp").forward(request, response);
    }

    private void findRotaByStaffId(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    private void addRota(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String rotaTime = request.getParameter("rotaTime");
        String staffId = request.getParameter("staffId");
        String staffName = request.getParameter("staffName");
        GuardRota guardRota = new GuardRota(rotaTime, Integer.parseInt(staffId), staffName);
        int i = service.addRota(guardRota);
        response.getWriter().print(i);
    }

    private void editRota(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String rotaId = request.getParameter("rotaId");
        GuardRota rota = service.findRotaByRotaId(Integer.parseInt(rotaId));
        request.setAttribute("rota", rota);
        request.getRequestDispatcher("/logistics/GuardRota/EditGuardRota.jsp").forward(request, response);

    }

    private void updateRota(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String rotaId = request.getParameter("rotaId");
        String rotaTime = request.getParameter("rotaTime");
        String staffId = request.getParameter("staffId");
        String staffName = request.getParameter("staffName");
        GuardRota guardRota = new GuardRota(Integer.parseInt(rotaId), rotaTime, Integer.parseInt(staffId), staffName);
        int i = service.updateRota(guardRota);
        response.getWriter().print(i);
    }

    private void deleteRota(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String rotaId = request.getParameter("rotaId");
        int i = service.deleteRota(Integer.parseInt(rotaId));
        response.getWriter().print(i);
    }

    private void deleteRotas(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ids = request.getParameter("rotaIds");
        String[] rotaIds = ids.split(",");
        int sum = 0;
        for (int i = 0; i < rotaIds.length; i++) {
            sum += service.deleteRota(Integer.parseInt(rotaIds[i]));
        }
        response.getWriter().print(sum);
    }

    private void clockIn(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String rotaId = request.getParameter("rotaId");
        int i = service.clockIn(Integer.parseInt(rotaId));
        response.getWriter().print(i);
    }

    private void clockOut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String rotaId = request.getParameter("rotaId");
        int i = service.clockOut(Integer.parseInt(rotaId));
        response.getWriter().print(i);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
