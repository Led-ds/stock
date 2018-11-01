package stock.mark.dao;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import stock.dao.generic.FaceGenericDao;
import stock.dao.generic.FaceGenericDaoImpl;
import stock.mark.modal.Mark;

@Repository("markDao")
public class MarkDaoImpl extends FaceGenericDaoImpl<Mark> implements FaceGenericDao<Mark> {

	@Autowired
	private SessionFactory sessionFactory;

	public MarkDaoImpl(Class<Mark> prPersistenceClass) {
		super(prPersistenceClass);
		// TODO Auto-generated constructor stub
	}

	public Mark getById(Long id){
		try{
			Session session = sessionFactory.getCurrentSession();
			Transaction tx = session.beginTransaction();
			String hql = "from " + Mark.class.getName() + " where id=" + id;
			Query query = session.createQuery(hql);        
			Mark mark = (Mark) query.uniqueResult();        
			tx.commit();

			if (mark != null) {
				return mark;
			}            

			return null;
		}catch(HibernateException he){
			throw he;    		
		}
	}


}
