package stock.mark.service;

import java.util.List;
import stock.mark.modal.Mark;

public interface MarkService {
	
	public Mark save(Mark mark);
	
	public Mark update(Mark mark);

	public void delete(Mark mark);
	
	public Mark merge (Mark mark);
	
	public List<Mark> listAll();
	
	public Mark getById(Long id);
}
