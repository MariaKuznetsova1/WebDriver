package ru.business;

public class Message {
	private String to;
	private String theme;
	private String body;

	public Message(String to, String theme, String body) {
		super();
		this.to = to;
		this.theme = theme;
		this.body = body;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getTheme() {
		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	@Override
	public String toString() {
		return "Message [to=" + to + ", theme=" + theme + ", body=" + body + "]";
	}

}
