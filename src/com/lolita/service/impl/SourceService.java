package com.lolita.service.impl;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.lolita.dao.SourceMapper;
import com.lolita.data.ResultCode;
import com.lolita.model.GoodsSource;
import com.lolita.operate.ResultJSON;
import com.lolita.service.ISourceService;

@Service
public class SourceService implements ISourceService{

	// Mapper
	@Autowired
	SourceMapper sourceMapper;

	// 创建实例
	ResultJSON resultJSON = new ResultJSON();

	// 添加货源
	@Transactional(propagation = Propagation.REQUIRED)
	public String addSrouce(String source_name) {

		// 构建json
		JSONObject jo = new JSONObject();

		try {
			sourceMapper.addSrouce(source_name);
			jo = resultJSON.createResultJSON(ResultCode.SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			jo = resultJSON.createResultJSON(ResultCode.UNKNOWN_ERROR);
		}

		return jo.toString();
	}

	// 修改货源
	@Transactional(propagation = Propagation.REQUIRED)
	public String updateSource(Integer source_id, String source_name) {

		// 构建json
		JSONObject jo = new JSONObject();

		try {
			GoodsSource source = new GoodsSource();
			source.setId(source_id);
			source.setName(source_name);

			sourceMapper.updateSource(source);
			jo = resultJSON.createResultJSON(ResultCode.SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			jo = resultJSON.createResultJSON(ResultCode.UNKNOWN_ERROR);
		}

		return jo.toString();
	}

	// 获取货源列表
	@Transactional(propagation = Propagation.REQUIRED)
	public String getSourceList() {

		// 构建json
		JSONObject jo = new JSONObject();

		try {
			List<GoodsSource> source = sourceMapper.getSourceList();

			JSONArray data = new JSONArray();
			for (Integer i = 0; i < source.size(); i++) {
				JSONObject temp = new JSONObject();
				putSourceToJSON(source.get(i), temp);
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

	// 通过id获取货源
	@Transactional(propagation = Propagation.REQUIRED)
	public String getSourceById(Integer source_id) {

		// 构建json
		JSONObject jo = new JSONObject();

		try {
			GoodsSource source = sourceMapper.getSourceById(source_id);

			JSONObject data = new JSONObject();
			putSourceToJSON(source, data);

			jo = resultJSON.createResultJSON(ResultCode.SUCCESS);
			jo.put("data", data);
		} catch (Exception e) {
			e.printStackTrace();
			jo = resultJSON.createResultJSON(ResultCode.UNKNOWN_ERROR);
		}

		return jo.toString();
	}

	// 货源资料写入JSON
	private void putSourceToJSON(GoodsSource source, JSONObject jo)
			throws Exception {

		jo.put("source_id", source.getId());
		jo.put("source_name", source.getName());
	}
}