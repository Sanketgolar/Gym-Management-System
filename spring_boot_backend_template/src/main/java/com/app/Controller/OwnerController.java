package com.app.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.DTO.Gymdto;
import com.app.Entities.GymClass;
import com.app.Entities.Owner;
import com.app.Entities.Trainer;
import com.app.Services.OwnerService;

@RestController
@RequestMapping("/owner")
public class OwnerController {

	@Autowired
	private OwnerService ownerService;

	
	@PostMapping("/signup")
	public ResponseEntity<?> addNewOwner(@RequestBody Owner owner){
		return new ResponseEntity<>(ownerService.addNewOwner(owner),HttpStatus.ACCEPTED);
	}
	
	
	@PostMapping("/creategym/{ownerId}")
	public ResponseEntity<?> addGym(@RequestBody Gymdto g,@PathVariable Integer ownerId){
		return new ResponseEntity<>(ownerService.addGym(g, ownerId),HttpStatus.ACCEPTED);
	}
	
	@PostMapping("/creategymclass/{ownerId}")
	public ResponseEntity<?> addClassWithinGym(@RequestBody GymClass gc,@PathVariable Integer ownerId)
	{
	 return new ResponseEntity<>( ownerService.addGymClass(gc, ownerId),HttpStatus.ACCEPTED);
	}
	
	@PostMapping("/trainer/add/{gymclassId}")
	public ResponseEntity<?> addTrainerWithinGymClass(@RequestBody Trainer t,@PathVariable Integer gymclassId)
	{
	 return new ResponseEntity<>( ownerService.addNewTrainer(t, gymclassId),HttpStatus.ACCEPTED);
	}
}
