package com.example.library.app;

import java.util.List;

public class LibraryService {
	
	private final Repository<Book> bookRepo;
	private final Repository<Member> memberRepo;
	
	public LibraryService(Repository<Book> bookRepo, Repository<Member> memberRepo) {
		this.bookRepo = bookRepo;
		this.memberRepo = memberRepo;
	}
	
	//Book Operations
	public void addBook(Book book) {
		bookRepo.save(book);
	}
	
	public Book getBook(String Id) {
		return bookRepo.findById(Id);
	}
	public List<Book> getAllBooks(){
		return bookRepo.findAll();
	}
	
	// MEMBER OPERATIONS
	public void addMember(Member member) {
		memberRepo.save(member);;
	}
	public Member getMember(String id) {
		return memberRepo.findById(id);
	}
	public List<Member> getAllMembers(){
		return memberRepo.findAll();
	}

}
