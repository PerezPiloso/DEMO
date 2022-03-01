package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dominio.Poll;
import com.example.demo.repository.PollRepository;

@RestController
public class PollController {
	
	@Autowired
	private PollRepository pollRepository;

	@GetMapping("/Welcome")
	public List<Poll>Welcome() {
		List<Poll> polls = new ArrayList<>();
		Poll p1 = new Poll();
		p1.setId(1);
		p1.setQuestion("Pregunta 2");
		
		Poll p2 = new Poll();
		p1.setId(2);
		p1.setQuestion("Pregunta 2");
		
		polls.add(p1);
		polls.add(p2);
		return polls;
		
		
		
	}
	@RequestMapping(value = "/polls",method = RequestMethod.GET)
	public ResponseEntity<Iterable<Poll>> getAllPoll() {
		Iterable<Poll>result = pollRepository.findAll();
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/polls", method=RequestMethod.POST)
	public ResponseEntity<?>createPoll(@RequestBody Poll poll){
		poll = pollRepository.save(poll);
		return new ResponseEntity<>(poll, HttpStatus.CREATED);
		
	}
	
}
