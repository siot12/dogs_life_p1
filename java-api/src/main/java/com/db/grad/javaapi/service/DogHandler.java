package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.Dog;
import com.db.grad.javaapi.repository.DogsRepository;

import java.util.List;

public class DogHandler {
    private DogsRepository itsDogRepo;

    public DogHandler(DogsRepository itsDogRepo) {
        this.itsDogRepo = itsDogRepo;
    }

    public long addDog(Dog theDog) {
        return itsDogRepo.save(theDog);
    }

    public long getNoOfDogs() {
        return itsDogRepo.count();

    }

    public Dog getDogByName(String name)
    {
        Dog find = new Dog();
        find.setName(name);
        List<Dog> dogsReturned =  itsDogRepo.findByName(find);
        if(dogsReturned.size() != 1)
        {
            return null;
        }
        else {
            return dogsReturned.get(0);
        }
    }

    public Dog getDogById(long id)
    {
        return itsDogRepo.findById(id);
    }
    public long getDogDetails(Dog dog)
    {
        return itsDogRepo.save(dog);
    }

}
