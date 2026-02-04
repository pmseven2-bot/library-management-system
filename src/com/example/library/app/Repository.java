package com.example.library.app;

import java.util.List;
//Repository is an interface — a contract that defines what 
//operations a repository must support.
//<T extends Identifiable<String>> is a generic type parameter with a constraint.
//Why the constraint? T must be a type that implements:Identifiable<String>
////This guarantees:Every object stored in the repository has an ID,
//The ID is a String, You can safely call item.getId() inside the repository

public interface Repository<T extends Identifiable<String>>{
	//This method stores an item in the repository.
	//What happens in the in‑memory implementation class:storage.put(item.getId(),
	// item);
   //Why it returns T: Because the repository stores objects of type T.
	void save(T item);
	//What it means: Retrieve a single object by its ID.
	//Why the parameter is a String:Because your Identifiable<String> guarantees
	//IDs are strings. 
	T findById(String id);
	//Return all items stored in the repository.
	//Lists preserve order
	//Lists are easy to iterate
	//Lists are the most common return type for collections
	//What the implementation does: It will return:
	//new ArrayList<>(storage.values());
    //This prevents callers from modifying the internal map.
	List<T> findAll();
	
	//Remove an item from the repository by its ID.
	void deleteById(String id);
	

}
