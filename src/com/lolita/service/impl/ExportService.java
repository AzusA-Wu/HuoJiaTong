package com.lolita.service.impl;

import java.util.Date;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.lolita.dao.ExportMapper;
import com.lolita.dao.GoodsMapper;
import com.lolita.dao.UserMapper;
import com.lolita.data.ResultCode;
import com.lolita.model.Export;
import com.lolita.model.Goods;
import com.lolita.model.User;
import com.lolita.operate.ResultJSON;
import com.lolita.service.IExportService;

@Service
public class ExportService implements IExportService{

	// Mapper
	@Autowired
	ExportMapper exportMapper;
	@Autowired
	GoodsMapper goodsMapper;
	@Autowired
	UserMapper userMapper;

	// 创建实例
	ResultJSON resultJSON = new ResultJSON();

	// 添加出货记录
	@Transactional(propagation = Propagation.REQUIRED)
	public String addExport(Integer goods_id, Integer amount, float export_price, Integer user_id, Integer vip_id, Integer pay_id, String remark) {

		// 构建json
		JSONObject jo = new JSONObject();

		try {
			Export ex = new Export();
			ex.setGoods(goods_id);
			ex.setAmount(amount);
			ex.setPrice(export_price);
			ex.setUser(user_id);
			ex.setTime(new Date());
			ex.setVip(vip_id);
			ex.setPay(pay_id);
			ex.setRemark(remark);
			
			Goods param = new Goods();
			param.setId(goods_id);
			param.setStock(amount);//减少量
			
			exportMapper.addExport(ex);
			goodsMapper.decreaseGoodsStock(param);
			
			jo = resultJSON.createResultJSON(ResultCode.SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			jo = resultJSON.createResultJSON(ResultCode.UNKNOWN_ERROR);
		}

		return jo.toString();
	}

	// 查看出货记录列表
	@Transactional(propagation = Propagation.REQUIRED)
	public String getExportList() {
		
		//构建json
		JSONObject jo = new JSONObject();
		
		try{
			List<Export> ex = exportMapper.getExportList();
			
			JSONArray data = new JSONArray();
			for(Integer i=0;i<ex.size();i++){
				JSONObject temp = new JSONObject();
				putExportToJSON(ex.get(i), temp);
				data.put(temp);
			}
			
			jo = resultJSON.createResultJSON(ResultCode.SUCCESS);
			jo.put("data", data);
		}catch(Exception e){
			e.printStackTrace();
			jo = resultJSON.createResultJSON(ResultCode.UNKNOWN_ERROR);
		}
		
		return jo.toString();
	}

	// 通过id获取出货记录
	@Transactional(propagation = Propagation.REQUIRED)
	public String getExportById(Integer export_id) {
		
		//构建json
		JSONObject jo = new JSONObject();
		
		try{
			Export ex = exportMapper.getExportById(export_id);
			JSONObject data = new JSONObject();
			putExportToJSON(ex, data);
			jo = resultJSON.createResultJSON(ResultCode.SUCCESS);
			jo.put("data", data);
			
		}catch(Exception e){
			e.printStackTrace();
			jo = resultJSON.createResultJSON(ResultCode.UNKNOWN_ERROR);
		}
		
		return jo.toString();
	}
	
	
	//出货数据写入JSON对象
	private void putExportToJSON(Export ex, JSONObject jo) throws Exception{
		
		jo.put("export_id", ex.getId());
		jo.put("goods_id", ex.getGoods());
		jo.put("amount", ex.getAmount());
		jo.put("export_price", ex.getPrice());
		User user = userMapper.getUserById(ex.getUser());
		jo.put("user_id", user.getId());
		jo.put("user_name", user.getName());
		jo.put("export_time", ex.getTime());
		jo.put("vip_id", ex.getVip());
		jo.put("pay_id", ex.getPay());
		jo.put("remark", ex.getRemark());
	}
}