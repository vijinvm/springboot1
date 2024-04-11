package com.example.demoI;
import java.util.List;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api/bankers")
public class BankController {
	
	@Autowired
	private BankService b;
	
	@GetMapping
	public List<Bank>getAllBankers(){
		return b.getAllBankers();
	}
	@GetMapping("/{id}")
	public Bank getBankerById(@PathVariable int id) {
		return b.getBankerById(id).orElse(null);
	}
	@PostMapping
	public Bank createBanker(@RequestBody Bank bank) {
		return b.createBanker(bank);
	}
	@PutMapping("/{id}")
	public Bank updateBanker(@PathVariable int id,@RequestBody Bank bank) {
		return b.updateBanker(id,bank);

	}
	@DeleteMapping("/{id}")
	public void deleteBanker(@PathVariable int id) {
		b.deleteBanker(id);
	}
}
