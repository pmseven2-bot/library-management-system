package com.example.library.app;

import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;


//<T extends Identifiable<String>> means:
//You can only store objects that implement Identifiable<String>.
//This guarantees every object has a getId() method returning a String. 
// from the interface
public class InMemoryRepository<T extends Identifiable<String>> implements Repository<T> {

	
	//2️⃣ Internal Storage What this means
	//You store items in a HashMap.
	//The key is the item’s ID (String).
	//The value is the item itself (T).
	//Why HashMap?Fast lookups (O(1) average), Perfect for ID‑based access
	//Simple and reliable
	private final Map<String, T> storage = new HashMap<>();

	@Override
	public void save(T item) {
		storage.put(item.getId(), item);

	}

	@Override
	public T findById(String id) {
		T item = storage.get(id);
		if (item == null) {
			throw new ItemNotFoundException("Item not found: " + id);
		}
		return item;
	}

	@Override
	public List<T> findAll() {
		
		return new ArrayList<>(storage.values());
	}

	@Override
	public void deleteById(String id) {
		if(!storage.containsKey(id)) {
			throw new ItemNotFoundException("Cannot delete. Item not found: " + id);
		}
       storage.remove(id);
	}

}
