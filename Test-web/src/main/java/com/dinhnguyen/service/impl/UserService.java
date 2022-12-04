package com.dinhnguyen.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.dinhnguyen.Dao.IUserDAO;
import com.dinhnguyen.model.UserModel;
import com.dinhnguyen.paging.Pageble;
import com.dinhnguyen.service.IUserService;

public class UserService implements IUserService{
	@Inject
	private IUserDAO usDAO;
	
	@Override
	public List<UserModel> findAll(Pageble pageble) {
		return usDAO.findAll( pageble);
	}

	@Override
	public UserModel save(UserModel us) {
		Long newID = usDAO.save(us);
		System.out.print(newID);
		return usDAO.FindOne(newID);
	}

	@Override
	public UserModel Update(UserModel updateUS) {
		//UserModel oldUserModel = usDAO.FindOne(updateUS.getId_users());
		usDAO.Update(updateUS);
		return usDAO.FindOne(updateUS.getId());
	}

	@Override
	public void Delete(long[] ids) {
		for(long id :ids) {
			usDAO.Delete(id);
		}
	}

	@Override
	public int getTotalItem() {
		return usDAO.GetTotalItem();
	}

	@Override
	public UserModel findone(Long id) {
		
		return usDAO.FindOne(id);
	}

	@Override
	public UserModel FindonebyEmailandPassWord(String Email, String Password) {
		return usDAO.FindonebyEmailandPassWord(Email, Password);
	}

	@Override
	public void SetStatusOnl(Long id) {
		usDAO.SetStatusOnl(id);
	}

	@Override
	public void SetStatusOff(Long id) {
		usDAO.SetStatusOff(id);
	}

	@Override
	public List<UserModel> findAll() {
		return usDAO.findAll();
	}


}
