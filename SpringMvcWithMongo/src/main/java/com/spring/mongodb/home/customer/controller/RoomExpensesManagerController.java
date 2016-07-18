package com.spring.mongodb.home.customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.spring.mongodb.home.customer.constants.RoomExpenseManagerConstants;
import com.spring.mongodb.home.customer.exception.BackEndException;
import com.spring.mongodb.home.customer.exception.RoomMemberException;
import com.spring.mongodb.home.customer.model.RoomMember;
import com.spring.mongodb.home.customer.service.RoomMemberDAO;

@Controller
public class RoomExpensesManagerController {

	@Autowired
	private RoomMemberDAO dao;

	@RequestMapping(value = { "/", "/member", "/home" }, method = RequestMethod.GET)
	@ExceptionHandler(BackEndException.class)
	public ModelAndView home(Model model,
			@ModelAttribute("roomMember") RoomMember roomMember,
			final RedirectAttributes flashAttributes) throws BackEndException {

		ModelAndView modelAndView = new ModelAndView();
		if (!model.containsAttribute("memberList")) {
			modelAndView.addObject("memberList", dao.listOfMembers());
		} else {
		}
		if (!model.containsAttribute("roomMember")) {
			modelAndView.addObject("roomMember", new RoomMember());
		} else {
		}
		modelAndView.setViewName(RoomExpenseManagerConstants.HOME_PAGE);
		return modelAndView;
	}

	@RequestMapping(value = { "/member/save" }, method = RequestMethod.POST)
	public View registerAmountSpentDetails(
			@ModelAttribute RoomMember roomMember, ModelMap model)
			throws RoomMemberException {
		if (roomMember.getId() != null && roomMember.getId() != "") {
			dao.updateMember(roomMember);
		} else {
			dao.registerAmountSpentDetails(roomMember);
		}
		return new RedirectView("/mongodb/");
	}

	@RequestMapping(value = "/member/delete", method = RequestMethod.GET)
	public View deleteMember(@RequestParam final String id)
			throws RoomMemberException {
		dao.deleteMember(id);
		return new RedirectView("/mongodb/");
	}

	@RequestMapping(value = "/member/update", method = RequestMethod.POST)
	public View updateMember(@ModelAttribute RoomMember roomMember,
			ModelMap model) throws RoomMemberException {
		dao.updateMember(roomMember);
		return new RedirectView("/mongodb/");
	}

	@RequestMapping(value = "/member/edit", method = RequestMethod.GET)
	public String editMember(@RequestParam final String id,
			final RedirectAttributes model) throws RoomMemberException {
		model.addFlashAttribute("memberList", dao.listOfMembers());
		model.addFlashAttribute("roomMember", dao.editMember(id));
		return "redirect:/";
	}

}
