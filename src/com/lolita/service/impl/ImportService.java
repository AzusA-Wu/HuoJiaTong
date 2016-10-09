package com.lolita.service.impl;

import java.util.Date;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.lolita.dao.GoodsMapper;
import com.lolita.dao.ImportMapper;
import com.lolita.dao.UserMapper;
import com.lolita.data.ResultCode;
import com.lolita.model.Goods;
import com.lolita.model.Import;
import com.lolita.model.User;
import com.lolita.operate.ResultJSON;
import com.lolita.service.IImportService;

@Service
public class ImportService implements IImportService{

	// Mapper
	@Autowired
	GoodsMapper goodsMapper;
	@Autowired
	ImportMapper importMapper;
	@Autowired
	UserMapper userMapper;

	// 创建实例
	ResultJSON resultJSON = new ResultJSON();

	// 添加入货记录
	@Transactional(propagation = Propagation.REQUIRED)
	public String addImport(Integer goods_id, float import_price,
			Integer amount, Integer source_id, Integer user_id, String remark) {

		// 构建json
		JSONObject jo = new JSONObject();

		try {
			Import im = new Import();
			im.setGoods(goods_id);
			im.setPrice(import_price);
			im.setAmount(amount);
			im.setSource(source_id);
			im.setUser(user_id);
			im.setTime(new Date());
			im.setRemark(remark);
			
			Goods param  = new Goods();
			param.setId(goods_id);
			param.setStock(amount);//增加量
			
			importMapper.addImport(im);
			goodsMapper.increaseGoodsStock(param);
			jo = resultJSON.createResultJSON(ResultCode.SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			jo = resultJSON.createResultJSON(ResultCode.UNKNOWN_ERROR);
		}

		return jo.toString();
	}

	// 查看入货记录列表
	@Transactional(propagation = Propagation.REQUIRED)
	public String getImportList() {

		// 构建json
		JSONObject jo = new JSONObject();

		try {
			List<Import> im = importMapper.getImportList();

			JSONArray data = new JSONArray();
			for (Integer i = 0; i < im.size(); i++) {
				JSONObject temp = new JSONObject();
				putImportToJSON(im.get(i), temp);

				data.put(temp);
			}
			jo = resultJSON.createResultJSON(ResultCode.SUCCESS);
			jo.put("data", data);
		} catch (Exception e) {
			e.printStackTrace();
			jo = resultJSON.createResultJSON(ResultCode.UNKNOWN_ERROR);
		}

		return jo.toString();
	}

	// 通过id获取入货记录
	@Transactional(propagation = Propagation.REQUIRED)
	public String getImportById(Integer import_id) {

		// 构建json
		JSONObject jo = new JSONObject();

		try {
			Import im = importMapper.getImportById(import_id);

			JSONObject data = new JSONObject();
			putImportToJSON(im, data);

			jo = resultJSON.createResultJSON(ResultCode.SUCCESS);
			jo.put("data", data);
		} catch (Exception e) {
			e.printStackTrace();
			jo = resultJSON.createResultJSON(ResultCode.UNKNOWN_ERROR);
		}

		return jo.toString();
	}
	
	
	//入货记录写入JSON
	private void putImportToJSON(Import im, JSONObject jo) throws Exception{
		
		jo.put("import_id", im.getId());
		jo.put("goods_id", im.getGoods());
		jo.put("import_price", im.getPrice());
		jo.put("amount", im.getAmount());
		jo.put("source_id", im.getSource());
		User user = userMapper.getUserById(im.getUser());
		jo.put("user_id", user.getId());
		jo.put("user_name", user.getName());
		jo.put("import_time", im.getTime());
		jo.put("remark", im.getRemark() == null ? "" : im.getRemark());
	}
}