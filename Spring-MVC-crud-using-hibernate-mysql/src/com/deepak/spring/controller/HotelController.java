package com.deepak.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.deepak.spring.entity.Hotel;
import com.deepak.spring.service.HotelService;

@Controller
@RequestMapping("/hotels")
public class HotelController {
	
	@Autowired
	private HotelService hotelSevice;
	
	public void setHotelSevice(HotelService hotelSevice) {
		this.hotelSevice = hotelSevice;
	}

	@RequestMapping("/view")
	public String homePage(Model model){
		model.addAttribute("hotel", new Hotel());
		model.addAttribute("hotels", hotelSevice.getAllHotels());
		return "hotels";
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String saveOrUpdateHotel(@ModelAttribute Hotel hotel) {
		if(hotel.getHotelId() == null)
			hotelSevice.saveHotel(hotel);
		else
			hotelSevice.updateHotel(hotel);
		return "redirect:/hotels/view";
	}
	
	@RequestMapping("/update/{hotelId}")
	public String updateHotel(@PathVariable Long hotelId, Model model) {
		model.addAttribute("hotel", hotelSevice.getHotel(hotelId));
		model.addAttribute("hotels", hotelSevice.getAllHotels());
		return "hotels";
	}
	
	@RequestMapping("/delete/{hotelId}")
	public String deleteHotel(@PathVariable Long hotelId){
		hotelSevice.deleteHotel(hotelId);
		return "redirect:/hotels/view";
	}
}
