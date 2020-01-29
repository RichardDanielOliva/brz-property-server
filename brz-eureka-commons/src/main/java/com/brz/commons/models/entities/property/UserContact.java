package com.brz.commons.models.entities.property;

import java.util.List;

public class UserContact {
	private List<String> phones;
	private List<String> emails;

	public UserContact() {}

	public List<String> getPhones() {
		return phones;
	}
	public void setPhones(List<String> phones) {
		this.phones = phones;
	}

	public List<String> getEmails() {
		return emails;
	}

	public void setEmails(List<String> emails) {
		this.emails = emails;
	}
}
