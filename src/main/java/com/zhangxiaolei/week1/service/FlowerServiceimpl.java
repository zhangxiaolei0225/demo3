package com.zhangxiaolei.week1.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhangxiaolei.week1.dao.FlowerMapper;
import com.zhangxiaolei.week1.domain.Flower;
import com.zhangxiaolei.week1.domain.Types;

@Service
public class FlowerServiceimpl implements FlowerService {
	@Resource
	private FlowerMapper mapper;

	@Override
	//列表展示 模糊  分页
	public PageInfo<Flower> selects(Flower f, Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<Flower> list = mapper.selects(f);
		PageInfo<Flower> info = new PageInfo<Flower>(list);
		return info;
	}

	@Override
	//单查方法用于回显
	public Flower getflowerbyid(Integer id) {
		// TODO Auto-generated method stub
		return mapper.getflowerbyid(id);
	}

	@Override
	//全查类型
	public List<Types> gettypelist() {
		// TODO Auto-generated method stub
		return mapper.gettypelist();
	}

	@Override
	//添加
	public int add(Flower f) {
		// TODO Auto-generated method stub
		return mapper.add(f);
	}
	@Override
	//修改
	public int update(Flower f) {
		// TODO Auto-generated method stub
		return mapper.update(f);
	}
	@Override
	//单删
	public int deletebyid(Integer id) {
		// TODO Auto-generated method stub
		return mapper.deletebyid(id);
	}
	@Override
	//批删
	public int deletes(Integer[] ids) {
		// TODO Auto-generated method stub
		return mapper.deletes(ids);
	}

}
