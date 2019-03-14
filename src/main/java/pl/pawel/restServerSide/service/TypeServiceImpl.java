package pl.pawel.restServerSide.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.pawel.restServerSide.entity.Type;
import pl.pawel.restServerSide.repository.TypeRepository;

@Service
public class TypeServiceImpl implements TypeService{
	
	@Autowired
	private TypeRepository typeRepository;
	
	@Override
	public List<Type> getTypes() {
		return typeRepository.findAll();
	}

	@Override
	public Type getType(int typeId) {
		return typeRepository.findById(typeId);
	}

	@Override
	public void addType(Type type) {
		typeRepository.save(type);
	}

	@Override
	public void deleteType(int typeId) {
		typeRepository.deleteById(typeId);
	}

}
