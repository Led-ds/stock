package stock.dao.generic;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional(noRollbackFor= Exception.class)
@Service
public interface FaceGenericDao<T> {

	void save(T obj) throws Exception;
	void delete(T obj) throws Exception;
	void update(T obj) throws Exception;
	T merge (T obj) throws Exception;
	List<T> list() throws Exception;
	
}
