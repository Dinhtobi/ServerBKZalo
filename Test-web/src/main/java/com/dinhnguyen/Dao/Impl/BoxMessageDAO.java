package com.dinhnguyen.Dao.Impl;

import java.util.List;

import com.dinhnguyen.Dao.IBoxMessageDAO;
import com.dinhnguyen.mapper.BoxMessageMapper;
import com.dinhnguyen.model.HopChat;

public class BoxMessageDAO extends AbstractDAO<HopChat> implements IBoxMessageDAO{

	@Override
	public HopChat fineone(Long id_sender, Long id_receider) {
		StringBuilder sql = new StringBuilder("select hc.id_hopchat, nd1.ten as tensender , nd2.ten as tenreceider , nd1.id_users as id_nguoigui , nd2.id_users as id_nguoinhan ,") ;
		sql.append(" hc.tinnhancuoi , hc.thoigiantao, nd1.avatar as urlsender , nd2.avatar as urlreceider ");
		sql.append(" from nguoidung as nd1,nguoidung as nd2, hopchat as hc");
		sql.append(" where nd1.id_users = "+ id_sender +" and nd2.id_users = "+id_receider+" and nd1.id_users = hc.id_nguoigui and nd2.id_users = hc.id_nguoinhan");
		try {
			List<HopChat> list = query(sql.toString(), new BoxMessageMapper());
			return list.isEmpty()? null : list.get(0);
		} catch (Exception e) {
			System.out.print(e.getMessage());
			return null;
		}
	}

	@Override
	public Long save(HopChat hopChat) {
		String sql ="insert into hopchat(id_nguoigui , id_nguoinhan , tinnhancuoi , thoigiantao) values(?,?,?,?)";
		
		return insert(sql, hopChat.getId_nguoigui(), hopChat.getId_nguoinhan() , hopChat.getTinnhancuoi() , hopChat.getThoigiantao());
	}

	@Override
	public void Update(HopChat hopChat) {
		StringBuilder sql = new StringBuilder("Update hopchat set tinnhancuoi = ? ,");
		sql.append(" thoigiantao = ? where id_hopchat = ?");
		update(sql.toString(),hopChat.getTinnhancuoi() , hopChat.getThoigiantao() , hopChat.getId_hopchat());
	
	}

	@Override
	public HopChat fioneone(Long id_hopchat) {
		StringBuilder sql = new StringBuilder("select hc.id_hopchat, nd1.ten as tensender , nd2.ten as tenreceider , nd1.id_users as id_nguoigui , nd2.id_users as id_nguoinhan ,") ;
		sql.append(" hc.tinnhancuoi , hc.thoigiantao, nd1.avatar as urlsender , nd2.avatar as urlreceider ");
		sql.append(" from nguoidung as nd1,nguoidung as nd2, hopchat as hc");
		sql.append(" where hc.id_hopchat = "+ id_hopchat +"  and nd1.id_users = hc.id_nguoigui and nd2.id_users = hc.id_nguoinhan");
		try {
			List<HopChat> list = query(sql.toString(), new BoxMessageMapper());
			return list.isEmpty()? null : list.get(0);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<HopChat> findall(Long id_sender , Long id_receider) {
		StringBuilder sql = new StringBuilder("select hc.id_hopchat, nd1.ten as tensender , nd2.ten as tenreceider , nd1.id_users as id_nguoigui , nd2.id_users as id_nguoinhan ,") ;
		sql.append(" hc.tinnhancuoi , hc.thoigiantao, nd1.avatar as urlsender , nd2.avatar as urlreceider ");
		sql.append(" from nguoidung as nd1,nguoidung as nd2, hopchat as hc");
		if(id_sender != null && id_receider == null)
		sql.append(" where nd1.id_users = "+id_sender+" and nd1.id_users = hc.id_nguoigui and nd2.id_users = hc.id_nguoinhan");
		else if(id_sender == null && id_receider != null) {
			sql.append(" where nd2.id_users = "+id_receider+" and nd1.id_users = hc.id_nguoigui and nd2.id_users = hc.id_nguoinhan");
		}
		try {
			List<HopChat> list = query(sql.toString(), new BoxMessageMapper());
			return list;
		} catch (Exception e) {
			System.out.print(e.getMessage());
			return null;
		}
	}

}
