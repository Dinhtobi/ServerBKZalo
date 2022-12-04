package com.dinhnguyen.service.impl;

import java.sql.Timestamp;
import java.util.List;

import javax.inject.Inject;

import com.dinhnguyen.Dao.IMessageDAO;
import com.dinhnguyen.model.TinNhan;
import com.dinhnguyen.service.IMessageService;

public class MessageService implements IMessageService{
	@Inject
	private IMessageDAO messageDAO;
	@Override
	public List<TinNhan> findAll() {
		return messageDAO.findAll();
	}

	@Override
	public TinNhan save(TinNhan message) {
		//message.setThoigiantao(new Timestamp(System.currentTimeMillis()));
		Long id_mes = messageDAO.save(message);
		System.out.println(id_mes);
		return messageDAO.findone(id_mes);
	}

	@Override
	public void Delete(Long id_tinnhan) {
		messageDAO.Delete(id_tinnhan);
	}

	@Override
	public List<TinNhan> findAllbyid_nguoiguiandid_nguoinhan(Long id_nguoigui, Long id_nguoinhan) {
		return messageDAO.findAllbyid_nguoiguiandid_nguoinhan(id_nguoigui, id_nguoinhan);
	}


}
