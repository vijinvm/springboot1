package com.example.demoI;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.*;

@Service
public class BankService {

	@Autowired
	private BankRepository r;
	
	public List<Bank>getAllBankers(){
		return r.findAll();
	}
	public Optional<Bank>getBankerById(int id){
		return r.findById(id);
	}
	public Bank createBanker(Bank bank) {
		return r.save(bank);
	}
	public Bank updateBanker(int id, Bank bank) {
		Optional<Bank>e=r.findById(id);
		if(e.isPresent()) {
			Bank e1=e.get();
			e1.setName(bank.getName());
			e1.setAddress(bank.getAddress());
			e1.setPhonenumber(bank.getPhonenumber());
			return r.save(e1);


		}
		else {
			return null;
		}
	}
		public void deleteBanker(int id) {
			r.deleteById(id);
		}
	}

