package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.persistence.GenerationType;

@RestController
public class AddressController {
			@Autowired
			MyRepo repo;
			@GetMapping("/address")
			public ResponseEntity<List<Address>> show()
			{
				return ResponseEntity.ok(repo.findAll());
			}
			@PostMapping("/address")
			public ResponseEntity<Address> save(@RequestBody Address a)
			{
				 Address o=repo.save(a);
				 if (o==null) {
					return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
				} else {
                     return ResponseEntity.status(HttpStatus.CREATED).build();
				}
			}
			@DeleteMapping("/address/{hno}")
			public ResponseEntity<String> delete(@PathVariable("hno") int id)
			{
			 Optional<Address> a=repo.findById(id);
			 if(a.isPresent())
			 {
				 repo.deleteById(id);
				 return ResponseEntity.status(HttpStatus.NO_CONTENT).body("No Content");
			 }else {
				 return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			 }
				
			}
			@PutMapping("/address/{hno}")
			public ResponseEntity<Address> update(@RequestBody Address a,@PathVariable("hno") int id)
			{
				Optional<Address> o=repo.findById(id);
				if(o.isPresent())
				{
					a.setHno(id);
					Address ad= repo.save(a);
					return ResponseEntity.ok(ad);
				}else {
					return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
				}
			}
			@GetMapping("/address/{hno}")
			public ResponseEntity<List<Address>> search(@PathVariable("hno") int id)
			{
				Optional<Address> o=repo.findById(id);
				if(o.isPresent())
				{
					
					return ResponseEntity.ok(repo.findAll());
				}else
				{
					return ResponseEntity.status(HttpStatus.valueOf(404)).build();
				}
			}
}
