package com.Nakka.DMS.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.Nakka.DMS.Models.Dog;
import com.Nakka.DMS.Models.Trainer;
import com.Nakka.DMS.repository.DogRepository;
import com.Nakka.DMS.repository.TrainerRepository;

@Controller
public class DogController {

	ModelAndView mv = new ModelAndView();
	@Autowired
	DogRepository dogrepo;
	@Autowired
	TrainerRepository trainerrepo;
//	@RequestMapping("dogHome")
//	public String home() {
//		return "home";
//	}

	@RequestMapping("dogHome")
	public ModelAndView home() {
		mv.setViewName("home");
		return mv;
	}

	@RequestMapping("add")
	public ModelAndView add() {
		mv.setViewName("addNewDog.html");
		Iterable<Trainer> trainerlist = trainerrepo.findAll();
		mv.addObject("trainers", trainerrepo.findAll());
		return mv;
	}

	@RequestMapping("addNewDog")
	public ModelAndView add(Dog dog, @RequestParam("trainerId") int id) {
		Trainer trainer = trainerrepo.findById(id).orElse(new Trainer());
		dog.setTrainer(trainer);
		dogrepo.save(dog);
		mv.setViewName("home");
		return mv;
	}

	@RequestMapping("addTrainer")
	public ModelAndView addTrainer() {
		mv.setViewName("addNewTrainer");
		return mv;
	}

	@RequestMapping("trainerAdded")
	public ModelAndView addNewTrainer(Trainer trainer) {
		trainerrepo.save(trainer);
		mv.setViewName("home");
		return mv;
	}

	@RequestMapping("viewModifyDelete")
	public ModelAndView viewDogs() {
		mv.setViewName("viewDogs");
		Iterable<Dog> dogList = dogrepo.findAll();
		mv.addObject("dogs", dogList);
		return mv;
	}

	@RequestMapping("editDog")
	public ModelAndView editDog(Dog dog) {
		dogrepo.save(dog);
		mv.setViewName("editDog");
		return mv;
	}

	@RequestMapping("deleteDog")
	public ModelAndView deleteDog(Dog dog) {
		// based in id
//		Optional<Dog> dogFound = dogrepo.findById(dog.getId());
//		if (dogFound.isPresent()) {
//			dogrepo.delete(dog);
//		}
		// return home();
		// based on the name
//		List<Dog> dogsFound = dogrepo.findByName(dog.getName());
//		for (Dog d : dogsFound) {
//			dogrepo.delete(d);
//		}
//		return home();

		Dog d = dogrepo.findById(dog.getId()).orElse(new Dog());
		dogrepo.delete(d);
		return home();
	}

	@RequestMapping("search")
	public ModelAndView SearchById(int id) {
		Dog dogFound = dogrepo.findById(id).orElse(new Dog());
		mv.addObject(dogFound);
		mv.setViewName("searchResults");
		return mv;
	}

}
