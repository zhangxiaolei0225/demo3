package com.zhangxiaolei.week1.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.zhangxiaolei.week1.domain.Flower;
import com.zhangxiaolei.week1.domain.Types;
import com.zhangxiaolei.week1.service.FlowerService;
import com.zhangxiaolei.week1.utils.PageUtil;

@Controller
public class FlowerController {
	@Resource
	private FlowerService service;
	//列表展示  模糊  分页
	@RequestMapping("selects")
	public String selects(Flower f,@RequestParam(defaultValue = "1")Integer pageNum,@RequestParam(defaultValue = "3")Integer pageSize,HttpServletRequest request) {
		PageInfo<Flower> info = service.selects(f, pageNum, pageSize);
		PageUtil.page(request, "selects?name="+f.getName(), pageSize, info.getList(), (int) info.getTotal(), pageNum);
		request.setAttribute("f", f);
		request.setAttribute("info",info.getList());
		return "list";
		
	}
	//查看
	@RequestMapping("look")
	
	public String look(Integer id,HttpServletRequest request) {
		Flower f = service.getflowerbyid(id);
		request.setAttribute("f", f);
		return "look";
		
	}
	
	//去添加
	@RequestMapping("toadd")
	public String toadd(HttpServletRequest request) {
		//查询类型表
		List<Types> list = service.gettypelist();
		request.setAttribute("list",list);
		return "add";
	}
	//添加
	@RequestMapping("add")
	@ResponseBody
	public int add(Flower f) {
		return service.add(f);
	}
	//去修改
	@RequestMapping("toupdate")
	public String toupdate(Integer id,HttpServletRequest request) {
		Flower f = service.getflowerbyid(id);
		List<Types> list = service.gettypelist();
		request.setAttribute("f", f);
		request.setAttribute("list",list);
		return "update";
	}
	//修改
	@RequestMapping("update")
	@ResponseBody
	public int update(Flower f) {
		return service.update(f);
	}
	//单删
	@RequestMapping("deletebyid")
	@ResponseBody
	public int deletebyid(Integer id) {
		return service.deletebyid(id);
	}
	//批删
	@RequestMapping("deletes")
	@ResponseBody
	public int deletes(@RequestParam("ids[]")Integer [] ids) {
		return service.deletes(ids);
	}
}
