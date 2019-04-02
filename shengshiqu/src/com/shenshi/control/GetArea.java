package com.shenshi.control;

import com.alibaba.fastjson.JSONObject;
import com.shenshi.model.Area;
import com.shenshi.service.AreaService;
import com.shenshi.service.AreaServiceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
/**
 * 业务模块流程控制，调用service层接口
 * @author Looking Tomorrow
 *
 */

@WebServlet("/getCity")
public class GetArea extends HttpServlet {
	private AreaService areaService = new AreaServiceImp();
	private static final long serialVersionUID = 1L;

	public GetArea() {
		super();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//getParameter是用来获取URL中的参数的
		String flag = request.getParameter("flag");
		String id = request.getParameter("id");
		if (flag == null && id == null) {
			province(request, response);
		} else {
			if (flag.equals("city")) {
				city(request, response, Integer.valueOf(id));
				//Integer.valueOf(id)将String强转为int类型
			} else {
				if(flag.equals("area")){
					area(request, response, Integer.valueOf(id));
				}
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	// 一级查询---输出（name,id）
	public void province(HttpServletRequest request, HttpServletResponse response) {
		List<Area> list = areaService.getAreaByParentno(0);
		//设置以json格式响应，并设置编码类型防止数据传递乱码
		response.setContentType("application/json;charset=utf-8");
		try {
			System.out.println(JSONObject.toJSONString(list));
			//响应信息通过out对象输出到网页上，当响应结束时它自动被关闭，与jsp页面无关，无需刷新页面
			//write()：仅支持输出字符类型数据，字符、字符数组、字符串等
			response.getWriter().write(JSONObject.toJSONString(list));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 二级查询---输出（name,id）---根据id查询
	public void city(HttpServletRequest request, HttpServletResponse response, int id) {

		//List<Area> list = areaService.getAreaByParentno("code",0, number);
		List<Area> list = areaService.getAreaByParentno(id);
		//设置以json格式响应，并设置编码类型防止数据传递乱码
		response.setContentType("application/json;charset=utf-8");
		try {
			response.getWriter().write(JSONObject.toJSONString(list));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	// 三级查询----输出（name,id）---根据id查询
	public void area(HttpServletRequest request, HttpServletResponse response, int id) {

		List<Area> list = areaService.getAreaByParentno(id);
		response.setContentType("application/json;charset=utf-8");
		try {
			response.getWriter().write(JSONObject.toJSONString(list));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
