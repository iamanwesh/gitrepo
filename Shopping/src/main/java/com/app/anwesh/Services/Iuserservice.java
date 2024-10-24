package com.app.anwesh.Services;

import java.util.List;

import com.app.anwesh.Entity.UserRegistration;

public interface Iuserservice {
	Long registeruser(UserRegistration reg);

	List<UserRegistration> showuser();

	UserRegistration getOneuser(Long id);

	void updateuserdata(UserRegistration reg);

	void deleteuserdata(Long id);
}
