package com.gsitm.career.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/career")
public class SearchController {

	@GetMapping("/search")
	public ModelAndView viewSearch(ModelAndView modelAndView) {
		modelAndView.setViewName("career/search");
		return modelAndView;
	}
}
