package stock.mark.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import stock.mark.modal.Mark;
import stock.mark.service.MarkService;

@RestController
@RequestMapping(value = "/rest/marks")
public class MarkController {

	@Autowired
	private MarkService markService;

	public MarkController() {
	}

	public MarkController(Mark m) {

	}

	public void setMarkService(MarkService markService) {
		this.markService = markService;
	}

	@RequestMapping("/all")
	public ResponseEntity<List<Mark>> getMarks(){
		List<Mark> marks = new ArrayList<Mark>();

		marks = markService.listAll();
		if(marks.isEmpty()){
			return new ResponseEntity<List<Mark>>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<List<Mark>>(marks, HttpStatus.OK);
	}

	@RequestMapping(
			value= "/{id}", 
			method=RequestMethod.GET)
	public ResponseEntity<Mark> getMarkById(@PathVariable("id") Long id){
		Mark mark = null;
		if(id.intValue()>0){
			mark = markService.getById(id);

			if(mark == null){
				return new ResponseEntity<Mark>(HttpStatus.NOT_FOUND);
			}
		}		
		return new ResponseEntity<Mark>(mark, HttpStatus.OK);
	}

	@RequestMapping(
			value="/save", 
			method=RequestMethod.POST,
			headers ="content-type=application/x-www-form-urlencoded")
	public ResponseEntity<Mark> salvar(@ModelAttribute Mark mark){
		Mark markNew = null;
		try {
			markNew = markService.save(mark);
		} catch (Exception e) {
			return new ResponseEntity<Mark>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<Mark>(markNew, HttpStatus.OK);
	}
	
	@RequestMapping(
			value="/updade", 
			method=RequestMethod.PUT,
			headers ="content-type=application/x-www-form-urlencoded")
	public ResponseEntity<Mark> alterar(@ModelAttribute Mark mark){
		Mark markUpdate = null;
		try {
			markUpdate = markService.update(mark);
		} catch (Exception e) {
			return new ResponseEntity<Mark>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<Mark>(markUpdate, HttpStatus.OK);
	}
	
	@RequestMapping(
			value="/delete/{id}", 
			method=RequestMethod.DELETE)
	public ResponseEntity<Mark> excluir(@ModelAttribute Mark mark){
		
		try {
			markService.delete(mark);
		} catch (Exception e) {
			return new ResponseEntity<Mark>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Mark>(HttpStatus.OK);
	}
	
	//test using modelAndView for list
	public ModelAndView listarMarks(){	
		List<Mark> marks = markService.listAll();
		ModelAndView mav = new ModelAndView("mark/form-listar-customer");
		if(!marks.isEmpty()){
			return mav.addObject("mark", marks);
		}
		return mav;
	}
}
