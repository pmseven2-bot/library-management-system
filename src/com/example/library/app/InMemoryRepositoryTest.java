package com.example.library.app;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class InMemoryRepositoryTest {

	@Test
	void saveStoresEntity() {
		InMemoryRepository<Book> repo = new InMemoryRepository<>();
		Book book = new Book("B1", "Title", "Author", Genre.FICTION);

		repo.save(book);

		assertEquals(1, repo.findAll().size());
	}

	@Test
	void findByIdReturnsCorrectEntity() {
		InMemoryRepository<Book> repo = new InMemoryRepository<>();
		Book book = new Book("B1", "Title", "Author", Genre.FICTION);

		repo.save(book);

		assertThrows(ItemNotFoundException.class, () -> repo.findById("missing"));

	}

	@Test
	void findByIdThrowsWhenMissing() {
		InMemoryRepository<Book> repo = new InMemoryRepository<>();
		assertThrows(ItemNotFoundException.class, () -> repo.findById("missing"));
	}
}
