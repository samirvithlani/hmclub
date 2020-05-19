package com.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bean.UserBean;

@RestController
@CrossOrigin
public class UserController {

	ArrayList<UserBean> users = new ArrayList<>();

	@RequestMapping(value = "/adduser", method = RequestMethod.POST)
	public String addUser(UserBean userBean) {

		System.out.println("api called...");
		users.add(userBean);

		return "data Added";
	}

	@RequestMapping(value = "/viewuser", method = RequestMethod.GET)
	public List<UserBean> userData() {

		return users;

	}

	@RequestMapping(value = "/deleteuser/{id}", method = RequestMethod.DELETE)
	public String deleteUser(@PathVariable int id) {

		users.remove(id);

		return "data deleted";

	}

	@RequestMapping(value = "/deleteuser", method = RequestMethod.DELETE)
	public String deleteUser1(@RequestParam("id") int id) {

		users.remove(id);

		return "data deleted";

	}

	@RequestMapping(value = "/deleteuser1", method = RequestMethod.DELETE)
	public String deleteUser3(@RequestHeader("id") int id) {

		users.remove(id);

		return "data deleted";

	}

	@RequestMapping(value = "/updateuser/{id}")
	public List<UserBean> updateUser(@PathVariable int id, UserBean userBean) {

		users.set(id, userBean);

		return users;
	}

}
