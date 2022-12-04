package com.dinhnguyen.controller.admin.api;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dinhnguyen.model.NhomChat;
import com.dinhnguyen.model.UserModel;
import com.dinhnguyen.service.IGroupchatService;
import com.dinhnguyen.util.httpUtil;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet(urlPatterns = { "/api-admin-listgroup"})
public class ListGroupAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Inject
	private IGroupchatService iGroupchatService;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		req.setCharacterEncoding("UTF-8");
		res.setContentType("application/json");
		UserModel user = httpUtil.of(req.getReader()).toUsers(UserModel.class);
		List<NhomChat> list = iGroupchatService.findAllnhomchatbyiduser(user.getId());
		mapper.writeValue(res.getOutputStream(), list);

	}
}
