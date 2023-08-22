package com.app.Services;



import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.CustomExceptions.ResourceNotFoundException;
import com.app.DTO.Gymdto;
import com.app.Entities.Gym;
import com.app.Entities.GymClass;
import com.app.Entities.Owner;
import com.app.Entities.Trainer;
import com.app.Repository.GymClassRepository;
import com.app.Repository.GymRepository;
import com.app.Repository.OwnerRepository;
import com.app.Repository.TrainerRepository;

@Service
@Transactional
public class OwnerService {

@Autowired
private OwnerRepository ownerRepository;
@Autowired
private ModelMapper mapper;
@Autowired
private GymRepository gymRepository;
@Autowired
private GymClassRepository gymClassRepository;

@Autowired
private TrainerRepository trainerRepository;


	public Owner addNewOwner( Owner owner){
		return ownerRepository.save(owner);
	}

	
	public Gym addGym(Gymdto g,Integer id)
	{
		Owner o=ownerRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Owner does not exist!!!"));
		Gym temp=mapper.map(g, Gym.class);
		o.addGym(temp);
		return gymRepository.save(temp);
	}
	
	public GymClass addGymClass(GymClass gc,Integer id)
	{
		Owner o=ownerRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Owner does not exist!!!"));
		GymClass gcc=gymClassRepository.save(o.addGymClass(gc));
		ownerRepository.save(o);
		return gcc;
	}
	
	public Trainer addNewTrainer(Trainer t,Integer gymclassId)
	{
		GymClass gc=gymClassRepository.findById(gymclassId).orElseThrow(()->new ResourceNotFoundException("GYM CLASS does not exist!!!"));
		t.addGymClass(gc);
		gymClassRepository.save(gc);
		t.setId(null);
		return trainerRepository.save(t);
	}
}