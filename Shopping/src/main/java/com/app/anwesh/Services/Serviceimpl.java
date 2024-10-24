package com.app.anwesh.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.anwesh.Entity.UserRegistration;
import com.app.anwesh.Errorhandler.Usernotfound;
import com.app.anwesh.UserRepo.Userrepository;

@Service
public class Serviceimpl implements Iuserservice {

	@Autowired 
	private Userrepository urepo;
	@Override
	public Long registeruser(UserRegistration reg) {
		Long id=urepo.save(reg).getUserid();
		return id;
	}

	@Override
	public List<UserRegistration> showuser() {
		List<UserRegistration> userlist=urepo.findAll();
		return userlist;
	}

	@Override
	public UserRegistration getOneuser(Long id) {
		return urepo.findById(id).orElseThrow(()->new Usernotfound("User '"+id+"' Not Found"));
	}

	@Override
	public void updateuserdata(UserRegistration reg) {
		
		if(reg.getUserid() != null &&  urepo.existsById(reg.getUserid()))
			urepo.save(reg);
		else
			throw  new Usernotfound("User '"+reg.getUserid()+"' Not Found");
	}

	@Override
	public void deleteuserdata(Long id) {
		urepo.deleteById(id);
		
	}

}
