package stock.mark.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import stock.mark.dao.MarkDao;
import stock.mark.dao.MarkDaoImpl;
import stock.mark.modal.Mark;

@Service("markService")
public abstract class MarkServiceImpl implements MarkService {

	@Autowired
	MarkDao markDao;
	
	@Override
	public Mark save(Mark mark) {
		// TODO Auto-generated method stub
		Mark markNew = null;
		try {
			markNew = markDao.merge(mark);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return markNew;
	}

	@Override
	public Mark update(Mark mark){
		// TODO Auto-generated method stub
		Mark markUp = null;
		try {
			markUp = markDao.merge(mark);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return markUp;
	}

	@Override
	public void delete(Mark mark) {
		// TODO Auto-generated method stub
		try {
			markDao.delete(mark);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<Mark> listAll() {
		// TODO Auto-generated method stub
		List<Mark> listMarks = new ArrayList<Mark>();
		try {
			listMarks = markDao.list();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listMarks;
 	}

	@Override
	public Mark getById(Long id) {
		MarkDaoImpl markDaoImpl = new MarkDaoImpl(null);
		Mark mark = markDaoImpl.getById(id);
		
		return mark;
	}

}
