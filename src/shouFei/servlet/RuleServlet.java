package shouFei.servlet;

import com.alibaba.fastjson.JSONObject;
import shouFei.entity.PageBean;
import shouFei.entity.Rule;
import shouFei.service.RuleService;
import shouFei.util.DateUtil;
import shouFei.util.JsonUtil;
import shouFei.util.StringUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @Acthor:孙琪; date:2019/4/1;
 */
@WebServlet("/RuleServlet")
public class RuleServlet extends HttpServlet {
    RuleService service=new RuleService();
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
        String payName = request.getParameter("payName");
        String normName = request.getParameter("normName");
        String price = request.getParameter("price");
        String area = request.getParameter("area");
        String closeEnd = request.getParameter("closeEnd");
        String riqi = request.getParameter("riqi");
        String money2 = request.getParameter("money2");

        int i = service.addRule(new Rule(plotName,roomNumber,
                payName,normName, Double.parseDouble(price),Double.parseDouble(area),Integer.parseInt(closeEnd),DateUtil.formatString(riqi,"yyyy-MM-dd"),Double.parseDouble(money2)));
        response.getWriter().print(i);
    }

    private void queryOne(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        int ruleId=-1;
        if(!StringUtil.isEmpty(id)){
            ruleId=Integer.parseInt(id);
        }
        Rule ruleById = service.findRuleById(ruleId);
        request.setAttribute("ruleById",ruleById);
        request.getRequestDispatcher("/shouFei/rule/ruleAdd.jsp").forward(request,response);
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        int ruleId=-1;
        if(!StringUtil.isEmpty(id)){
            ruleId=Integer.parseInt(id);
        }
        int  i = service.deleteRule(ruleId);
        response.getWriter().print(""+i);
    }

    private void update(HttpServletRequest request, HttpServletResponse response)  {
        String ruleId = request.getParameter("ruleId");
        String plotName = request.getParameter("plotName");
        String roomNumber = request.getParameter("roomNumber");
        String payName = request.getParameter("payName");
        String normName = request.getParameter("normName");
        String price = request.getParameter("price");
        String area = request.getParameter("area");
        String closeEnd = request.getParameter("closeEnd");
        String riqi = request.getParameter("riqi");
        String money2 = request.getParameter("money2");
        try {
            int i = service.updateRule(new Rule(Integer.parseInt(ruleId),plotName,roomNumber,
                    payName,normName, Double.parseDouble(price),Double.parseDouble(area),Integer.parseInt(closeEnd),DateUtil.formatString(riqi,"yyyy-MM-dd"),Double.parseDouble(money2)));
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
        List<Rule> RuleList = service.queryByPage(pageBean);
        JSONObject array = JsonUtil.getJsonObject(RuleList, pageBean);
        response.getWriter().print(array);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
