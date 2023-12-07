package com.frozen.fkp.topInfo;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TopInfoController {
	
	@Autowired private TopInfoDAO topDAO;
	
	@RequestMapping(value="/topInfo.go", method=RequestMethod.GET)
	public String getTopInfo(HttpServletRequest req) {
		req.setAttribute("cp", "topInfo/topInfo.jsp");
		
		return "index";
	}
	
	@RequestMapping(value="/topInfo.ajax", method=RequestMethod.GET,
			produces="application/json; charset=UTF-8")
	public @ResponseBody TopInfos selectTopInfo(String where, HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		return topDAO.selectOfTopInfo(where, req);

	}
	
	@RequestMapping(value="/select.city", method=RequestMethod.GET)
	public String selectCity(String where, String whereVal, HttpServletRequest req) {
		req.setAttribute("where", where);
		req.setAttribute("cp", "koreaMap/city/" + whereVal + ".jsp");
		
		return "index";
	}
	
	@RequestMapping(value="/selectList.map", method=RequestMethod.GET)
	public String selectList(String address, HttpServletRequest req) throws Exception {
		topDAO.selectListMap(address, req);
		req.setAttribute("cp", "naverMap/selectList.jsp");
		
		return "index";
	}
	
	@RequestMapping(value="/cityMap.go", method=RequestMethod.GET)
	public String cityMap(String city, HttpServletRequest req) throws Exception {
		req.setAttribute("where", city);
		req.setAttribute("cp", "naverMap/cityMap.jsp");
		
		return "index";
	}
}
