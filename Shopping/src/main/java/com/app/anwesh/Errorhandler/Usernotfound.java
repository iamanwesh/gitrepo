package com.app.anwesh.Errorhandler;

@SuppressWarnings("serial")
public class Usernotfound extends RuntimeException {
	public Usernotfound() {
		super();
	}

	public Usernotfound(String message) {
		super(message);
	}
}
