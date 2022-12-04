package com.dinhnguyen.Dao.Impl;

import java.util.List;

import com.dinhnguyen.Dao.IMessageDAO;
import com.dinhnguyen.mapper.MessageMapper;
import com.dinhnguyen.model.TinNhan;

public class MessageDAO extends AbstractDAO<TinNhan> implements IMessageDAO{

	@Override
	public List<TinNhan> findAll() {
		String sql = "SELECT * FROM tinnhan" ;
		return query(sql, new MessageMapper());
	}

	@Override
	public Long save(TinNhan mes) {
		String sql = "insert into tinnhan (id_nguoigui , id_nguoinhan , noidung ,thoigiantao, id_nhomchat) values"
				+ " (?,?,?,?,0)";
		return insert(sql, mes.getId_nguoigui() , mes.getId_nguoinhan() , mes.getNoidung() ,mes.getThoigiantao());
	}
	@Override
	public void Delete(Long id_tinnhan) {
		String sql = "Delete from tinhan where id_tinnhan = ?";
		update(sql, id_tinnhan);
	}

	@Override
	public TinNhan findone(Long Id_tinnhan) {
		String sql = "Select * from tinnhan where id_tinnhan = ?";
		try {
			List<TinNhan> mes = query(sql, new MessageMapper(),Id_tinnhan);
			return mes.isEmpty() ? null : mes.get(0); 
		} catch (Exception e) {
			System.out.print(e.getMessage());
			return null;
		}
	}

	@Override
	public List<TinNhan> findAllbyid_nguoiguiandid_nguoinhan(Long id_nguoigui, Long id_nguoinhan) {
		StringBuilder sql = new StringBuilder("Select * from tinnhan where id_nguoigui =  " + id_nguoigui);
		sql.append(" and id_nguoinhan = " + id_nguoinhan);
		return query(sql.toString(), new MessageMapper());
	}

}
