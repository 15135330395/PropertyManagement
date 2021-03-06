package com.shouFei.servlet;

import com.alibaba.fastjson.JSONObject;
import com.shouFei.service.MeterReadingService;
import com.utils.JsonUtil;
import com.shouFei.entity.MeterReading;
import com.entity.PageBean;

import com.utils.DateUtil;
import com.utils.StringUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @Acthor:孙琪; date:2019/3/29;
 */
@WebServlet("/MeterReadingServlet")
public class MeterReadingServlet extends HttpServlet {
    MeterReadingService service=new MeterReadingService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String action = request.getParameter("action");
        System.out.println(action);
        if ("query".equals(action)) {
            query(request, response);
        }else if ("update".equals(action)) {
            update(request, response);
        } else if ("delete".equals(action)) {
            delete(request, response);
        }else if ("queryOne".equals(action)) {
            queryOne(request, response);
        } else if ("add".equals(action)) {
            try {
                add(request, response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    private void add(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String plotName = request.getParameter("plotName");
        String roomNumber = request.getParameter("roomNumber");
        String riqi = request.getParameter("riqi");
        String price = request.getParameter("price");
        String start = request.getParameter("start");
        String stop = request.getParameter("stop");
        String pooled = request.getParameter("pooled");
        int i = service.addMeterReading(new MeterReading(plotName,roomNumber, DateUtil.formatString(riqi,"yyyy-MM-dd"),Double.parseDouble(price),Double.parseDouble(start),Double.parseDouble(stop),Double.parseDouble(pooled)));
        response.getWriter().print(i);
        //request.getRequestDispatcher("/shouFei/mReading/mReadingList.jsp").forward(request,response);
    }

    private void queryOne(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        int meterReadingId=-1;
        if(!StringUtil.isEmpty(id)){
            meterReadingId=Integer.parseInt(id);
        }
        MeterReading meterReadingById = service.findMeterReadingById(meterReadingId);
        request.setAttribute("meterReadingById",meterReadingById);
        request.getRequestDispatcher("/shouFei/mReading/mReadingAdd.jsp").forward(request,response);
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        int meterReadingId=-1;
        if(!StringUtil.isEmpty(id)){
            meterReadingId=Integer.parseInt(id);
        }
        int  i = service.deleteMeterReading(meterReadingId);
        response.getWriter().print(""+i);
    }

    private void update(HttpServletRequest request, HttpServletResponse response)  {
        String meterReadingId = request.getParameter("meterReadingId");
        String plotName = request.getParameter("plotName");
        String roomNumber = request.getParameter("roomNumber");
        String riqi = request.getParameter("riqi");
        String price=request.getParameter("price");
        String start = request.getParameter("start");
        String stop = request.getParameter("stop");
        String pooled = request.getParameter("pooled");
        try {
            int i = service.updateMeterReading(new MeterReading(Integer.parseInt(meterReadingId),plotName,roomNumber,
                     DateUtil.formatString(riqi, "yyyy-MM-dd"),Double.parseDouble(price),Double.parseDouble(start),Double.parseDouble(stop),Double.parseDouble(pooled)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void query(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = request.getParameter("page");
        String limit = request.getParameter("limit");
        PageBean pageBean = new PageBean();
        pageBean.setPageIndex(Integer.parseInt(page));
        pageBean.setPageCount(Integer.parseInt(limit));
        pageBean.setCount(service.findAll().size());
        List<MeterReading> MeterReadingList = service.queryByPage(pageBean);
        JSONObject array = JsonUtil.getJsonObject(MeterReadingList, pageBean);
        response.getWriter().print(array);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
