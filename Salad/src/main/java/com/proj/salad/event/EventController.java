package com.proj.salad.event;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class EventController {
	
	@RequestMapping(value="/event", method=RequestMethod.GET)
	public String eventPage() {
		return "/event/eventPage";
	}
	
}
