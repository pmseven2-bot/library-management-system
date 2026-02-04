
package com.example.library.app;

import java.time.LocalDate;

public class Member implements Identifiable<String> {

	private final String id;
	private final String name;
	private final LocalDate joined;
	private final MembershipLevel level;

	public Member(String id, String name, LocalDate joined, MembershipLevel level) {
		this.id = id;
		this.name = name;
		this.joined = joined;
		this.level = level;
	}

	@Override
	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public LocalDate getJoined() {
		return joined;
	}

	public MembershipLevel getLevel() {
		return level;
	}
}
