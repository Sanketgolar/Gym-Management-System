package com.app.Controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.Entities.Feedback;
import com.app.Entities.Gym;
import com.app.Entities.GymClass;
import com.app.Entities.Member;
import com.app.Entities.SubscriptionData;
import com.app.Services.MemberService;

@RestController
@RequestMapping("/member")
public class MemberController {

	@Autowired
	private MemberService memberService;
		
	@PostMapping("/signup")
	public ResponseEntity<?> addNewMember(@RequestBody Member member){
		return new ResponseEntity<>(memberService.addNewMember(member),HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/selectgym")
	public ResponseEntity<?> selectGym()
	{
		return new ResponseEntity<>(memberService.selectGym(),HttpStatus.OK);
	}
	
	@PostMapping("/selectgym/{memberId}")
	public ResponseEntity<?> addGym(@RequestBody Gym g,@PathVariable Integer memberId){
		return new ResponseEntity<>(memberService.addGym(g, memberId),HttpStatus.ACCEPTED);
	}
	
	@PostMapping("/feedback/{memberId}")
	public ResponseEntity<?> givefeedback(@RequestBody Feedback f,@PathVariable Integer memberId){
		return new ResponseEntity<>(memberService.givefeedback(f, memberId),HttpStatus.CREATED);
	}
	
	@GetMapping("/feedback")
	public ResponseEntity<?> givefeedback(){
		return new ResponseEntity<>(new Feedback(),HttpStatus.OK);
	}
	
	@PostMapping("/pay/{memberId}")
	public ResponseEntity<?> payAndSubscribe(@RequestBody SubscriptionData data,@PathVariable  Integer memberId)
	{
		return new ResponseEntity<>(memberService.payAndSubscribe(data, memberId),HttpStatus.PAYMENT_REQUIRED);
	}
	
	@GetMapping("/selectgymclass/{memberId}")
	public ResponseEntity<?> selectGymClass(@PathVariable Integer memberId){
		return new ResponseEntity<>(memberService.selectGymClass(memberId),HttpStatus.OK);
	}
	@PostMapping("/selectgymclass/{memberId}")
	public ResponseEntity<?> setGymClass(@RequestBody GymClass g,@PathVariable Integer memberId){
		return new ResponseEntity<>(memberService.setGymClass(g, memberId),HttpStatus.ACCEPTED);
	}
	
	
}
