package pl.pawel.restServerSide.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pl.pawel.restServerSide.entity.Type;
import pl.pawel.restServerSide.exception.NotFoundException;
import pl.pawel.restServerSide.service.TypeService;

@RestController
@RequestMapping("/type")
public class TypeController {
	
	@Autowired
	private TypeService typeService;
	
	@GetMapping("/typeList")
	public List<Type> getTypes(){
		return typeService.getTypes();
	}
	
	@GetMapping("/{typeId}")
	public Type getType(@PathVariable int typeId) {
		Type type = typeService.getType(typeId);
		
		if(type == null) {
			throw new NotFoundException("Type not found by id:"+ typeId);
		}
		return type;
	}
	
	@PostMapping()
	public Type addType(@RequestBody Type type) {
		type.setId(0);
		typeService.addType(type);
		return type;
	}
	
	@PutMapping()
	public Type updateType(@RequestBody Type type) {
		typeService.addType(type);
		return type;
	}
	
	@DeleteMapping("/{typeId}")
	public String deleteType(@PathVariable int typeId) {
		Type type = typeService.getType(typeId);
		if(type == null) {
			throw new NotFoundException("Type not found by id:" +typeId);
		}
		typeService.deleteType(typeId);
		return "Delete book id: " + typeId;
	}
}
