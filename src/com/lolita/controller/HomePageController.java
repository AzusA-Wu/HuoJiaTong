package com.lolita.controller;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomePageController {
	private static Logger logger = Logger.getLogger(HomePageController.class);

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String homePage() throws Exception {
		return "forward:/login";
	}

	@RequestMapping(value = "login", method = RequestMethod.GET)
	public ModelAndView login(
			@RequestParam(value = "error", required = false) String error)
			throws Exception {
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("name", "货架通");
		// 登录有错误
		if ("true".equals(error)) {
			data.put("error",
					"Login failed due to invalid username or password.");
		}
		// 登出成功
		if ("logout".equals(error)) {
			data.put("error", "Logout Success.");
		}
		return new ModelAndView("login.ftl", data);
	}

	@RequestMapping(value = "home.do", method = RequestMethod.GET)
	public ModelAndView home() throws Exception {
		// 获取认证的用户信息
//		logger.debug("Currently principal: " + principal.toString());

		Map<String, Object> data = new HashMap<String, Object>();
//		data.put("username", user.getName());
		return new ModelAndView("h-ui/index.ftl", data);
	}
	
	@RequestMapping(value = "welcome.do", method = RequestMethod.GET)
	public ModelAndView welcome() throws Exception {
		Map<String, Object> data = new HashMap<String, Object>();
//		data.put("username", user.getName());
		return new ModelAndView("h-ui/welcome.ftl", data);
	}
}
