package com.dqi.jira.consumer;

public class Assignee {
String name;
String emailAddress;
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getEmailAddress() {
	return emailAddress;
}
public void setEmailAddress(String emailAddress) {
	this.emailAddress = emailAddress;
}
@Override
public String toString() {
	return "Assignee [name=" + name + ", emailAddress=" + emailAddress + "]";
}
}
