package com.equipment.servlet;

import com.alibaba.fastjson.JSONObject;
import com.entity.PageBean;
import com.equipment.entity.Contract;
import com.equipment.service.ContractService;
import com.utils.DateUtil;
import com.utils.JsonUtil;
import com.utils.StringUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/*
 * @author :张
 * Date  : 2019/3/27
 * @Description: ${NAME}
 */

@WebServlet(name = "ContractServlet",urlPatterns = "/ContractServlet" ,initParams = {@WebInitParam(name="pageCount",value="10")})
public class ContractServlet extends HttpServlet {
    ContractService contractService=new ContractService();


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        String action = request.getParameter("action");
        System.out.println("ContractServlet....");
        if("query".equals(action)){
            query(request,response);
        }else if("add".equals(action)){
            add(request,response);
        }else if("update".equals(action)){

            update(request,response);
        }else if("delete".equals(action)){
            delete(request,response);
        }else if("queryPage".equals(action)){

            queryPage(request,response);
        }else if("queryOneBack".equals(action)){
           /* System.out.println("action===="+action);*/
            queryOneBack(request,response);
        }else if("toAdd".equals(action)){
            toAdd(request,response);
        }else if("deleteAll".equals(action)){
            deleteAll(request,response);
        }
    }



    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doPost(request,response);
    }

    protected void query(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Contract> contractList = contractService.findAll();
        request.setAttribute("contractList",contractList);
        request.getRequestDispatcher("contractList.jsp").forward(request,response);

    }

    protected void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String  id = request.getParameter("id");
        String contractId = request.getParameter("contractId");
        String contractName = request.getParameter("contractName");
        String firstParty = request.getParameter("firstParty");
        String secondParty = request.getParameter("secondParty");
        String sigingDate =  request.getParameter("sigingDate");
        System.out.println("update...sigingDate="+sigingDate);
        String projectLocation = request.getParameter("projectLocation");
        String cost = request.getParameter("cost");
        String content = request.getParameter("content");
        String supplyChain = request.getParameter("supplyChain");
        String paymentCycle = request.getParameter("paymentCycle");
        String acceptanceResult = request.getParameter("acceptanceResult");
        Contract contract=new Contract(Integer.parseInt(id),contractId,contractName, firstParty,secondParty,
                DateUtil.formatString(sigingDate,"yyyy-MM-dd HH:mm:ss") ,projectLocation,
                Double.parseDouble(cost),content,supplyChain, paymentCycle, acceptanceResult);
        System.out.println("contract===="+contract);
       int i = contractService.addContract(contract);
       response.getWriter().print(i);

    }

    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String contractId = request.getParameter("contractId");
        String contractName = request.getParameter("contractName");
        String firstParty = request.getParameter("firstParty");
        String secondParty = request.getParameter("secondParty");
        String sigingDate =  request.getParameter("sigingDate");
        System.out.println("update...sigingDate="+sigingDate);
        String projectLocation = request.getParameter("projectLocation");
        String cost = request.getParameter("cost");
        String content = request.getParameter("content");
        String supplyChain = request.getParameter("supplyChain");
        String paymentCycle = request.getParameter("paymentCycle");
        String acceptanceResult = request.getParameter("acceptanceResult");
        Contract contract=new Contract(Integer.parseInt(id),contractId,contractName, firstParty,secondParty,
                DateUtil.formatString(sigingDate,"yyyy-MM-dd HH:mm:ss") ,projectLocation,
                Double.parseDouble(cost),content,supplyChain, paymentCycle, acceptanceResult);
        System.out.println("contract="+contract);
     int i = contractService.updateContract(contract);
        System.out.println(i);
     response.getWriter().print(i);

    }

    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        int i = contractService.deleteContract(Integer.parseInt(id));
        //用$.ajax({ }) 传递数据
        response.getWriter().print(i);

    }

    protected void queryPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pageIndex = request.getParameter("page");
        PageBean pageBean=new PageBean();
        if(!StringUtil.isEmpty(pageIndex)){
            pageBean.setPageIndex(Integer.parseInt(pageIndex));
        }
        pageBean.setCount(contractService.findAll().size());
        String pageCount = request.getParameter("limit");
        pageBean.setPageCount(Integer.parseInt(pageCount));

        List<Contract> contractList = contractService.queryPage(pageBean);
        System.out.println(contractList.get(0).getSigingDate());

        JSONObject jsonObject= JsonUtil.getJsonObject(contractList,pageBean);
         System.out.println(jsonObject);
        response.getWriter().print(jsonObject);
    }

    private void queryOneBack(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String id = request.getParameter("id");
        Contract contract = contractService.findContractById(Integer.parseInt(id));
        System.out.println("id======"+id);
        System.out.println("contract="+contract);
        request.setAttribute("contract",contract);
        request.getRequestDispatcher("equbackground/contract/contractUpdate.jsp").forward(request,response);

    }

    protected void toAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       request.getRequestDispatcher("/equbackground/contract/contractAdd.jsp").forward(request,response);
    }

    protected void deleteAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ids = request.getParameter("ids");
        String[] idArr = ids.split(",");
        int sum=0;
        for(String id : idArr){
            int i = contractService.deleteContract(Integer.parseInt(id));
            sum+=i;
        }
        response.getWriter().print(sum);
    }
}
