package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.Dog;
import com.db.grad.javaapi.repository.DogsRepository;
import com.db.grad.javaapi.repository.DogsRepositoryStub;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DogHandlerTest {

    private DogsRepository itsDogRepo = new DogsRepositoryStub();

    @BeforeEach
    public void makeSureRepoIsEmpty()
    {
        itsDogRepo.deleteAll();
    }
    @Test
    public void add_a_dog_return_number_of_dogs_in_repo_is_one()
    {
        DogHandler cut = new DogHandler(itsDogRepo);
        Dog theDog = new Dog();
        theDog.setName("Bruno");
        cut.addDog( theDog );
        int expectedResult = 1;

        long actualResult = cut.getNoOfDogs();
        assertEquals( expectedResult, actualResult );
    }

    @Test
    public void unique_dog_name()
    {
        DogHandler cut = new DogHandler(itsDogRepo);
        Dog d1 = new Dog();
        d1.setName("Marcel");
        Dog d2 = new Dog();
        d2.setName("Pluto");
        Dog d3 = new Dog();
        d3.setName("Marcel");
        cut.addDog(d1);
        cut.addDog(d2);
        cut.addDog(d3);
        Dog result = cut.getDogByName("Pluto");
        assertEquals("Pluto",result.getName());
        Dog result1 = cut.getDogByName("Marcel");
        assertNull(result1);
        Dog result3 = cut.getDogByName("Alex");
        assertNull(result3);
    }
    @Test
    public void unique_id()
    {
        DogHandler cut = new DogHandler(itsDogRepo);
        Dog d1 = new Dog();
        d1.setId(1);
        cut.addDog(d1);
        assertNull(cut.getDogById(2));
    }

    @Test
    public void update_works()
    {
        DogHandler cut = new DogHandler(itsDogRepo);
        Dog d1 = new Dog();
        d1.setId(1);
        d1.setName("Vlad");
        cut.addDog(d1);
        assertEquals(1,cut.getDogDetails(d1));
    }
}
