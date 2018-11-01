package stock.dao.generic;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional(noRollbackFor= Exception.class)
@Service
public abstract class FaceGenericDaoImpl<T> implements FaceGenericDao<T> {
	
	private Class<T> persistenceClass;
	private Session session;
	
	@Autowired
	private SessionFactory sessionFactory;

	
	public FaceGenericDaoImpl(Class<T> prPersistenceClass){
		super();
		this.persistenceClass = prPersistenceClass;
	}
	
	@Override
	public void save(T obj) throws Exception {
		// TODO Auto-generated method stub
		session = sessionFactory.getCurrentSession();
		session.save(obj);
		session.flush();
	}
	
	@Override
	public void delete(T obj) throws Exception {
		// TODO Auto-generated method stub
		session = sessionFactory.getCurrentSession();
		session.delete(obj);
		session.flush();
	}
	
	@Override
	public void update(T obj) throws Exception {
		// TODO Auto-generated method stub
		session = sessionFactory.getCurrentSession();
		session.update(obj);
		session.flush();
	}
	
	@Override
	public T merge(T obj) throws Exception {
		// TODO Auto-generated method stub
		session = sessionFactory.getCurrentSession();
		T t = (T) session.merge(obj);
		session.flush();
		
		return t;
	}
	
	@Override
	public List<T> list() throws Exception {
		// TODO Auto-generated method stub
		session = sessionFactory.getCurrentSession();
		return session.createCriteria(persistenceClass).list();
	}
}
