package pl.pawel.restServerSide.repository;

import java.util.List;

import org.springframework.data.repository.Repository;

import pl.pawel.restServerSide.entity.Type;

public interface TypeRepository extends Repository<Type, Integer> {

	List<Type> findAll();

	Type findById(int typeId);

	void save(Type type);

	void deleteById(int typeId);
	
}
