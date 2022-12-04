package com.dinhnguyen.service;

import java.util.List;

import com.dinhnguyen.model.HopChat;

public interface IBoxMessageService {
	HopChat fineone(Long id_sender , Long id_receider);
	HopChat save(HopChat hopChat);
	HopChat Update(HopChat hopChat);
	List<HopChat> findall(Long id_sender , Long id_receider);
}
