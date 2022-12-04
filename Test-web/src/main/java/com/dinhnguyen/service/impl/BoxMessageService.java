package com.dinhnguyen.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.dinhnguyen.Dao.IBoxMessageDAO;
import com.dinhnguyen.model.HopChat;
import com.dinhnguyen.service.IBoxMessageService;

public class BoxMessageService implements IBoxMessageService {

	@Inject
	private IBoxMessageDAO iBoxMessageDAO ;
	@Override
	public HopChat fineone(Long id_sender, Long id_receider) {
		HopChat a = iBoxMessageDAO.fineone(id_sender, id_receider);
		return a;
	}
	

	@Override
	public HopChat Update(HopChat hopChat) {
		 iBoxMessageDAO.Update(hopChat);
		 return iBoxMessageDAO.fioneone(hopChat.getId_hopchat());
	}


	@Override
	public HopChat save(HopChat hopChat) {
		Long id_hopchat = iBoxMessageDAO.save(hopChat);
		return iBoxMessageDAO.fioneone(id_hopchat);
	}


	@Override
	public List<HopChat> findall(Long id_sender, Long id_receider) {
		return iBoxMessageDAO.findall(id_sender, id_receider);
	}



}
