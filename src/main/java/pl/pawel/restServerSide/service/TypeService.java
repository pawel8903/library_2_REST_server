package pl.pawel.restServerSide.service;

import java.util.List;

import pl.pawel.restServerSide.entity.Type;

public interface TypeService {

	List<Type> getTypes();

	Type getType(int typeId);

	void addType(Type type);

	void deleteType(int typeId);

}
