package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserRepository userRepo;

    @GetMapping("/all")
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    @GetMapping("/page/{pageNo}/{pageSize}")
    public List<User> getPaginatedUsers(@PathVariable int pageNo, @PathVariable int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<User> pagedResult = userRepo.findAll(pageable);

        return pagedResult.hasContent() ? pagedResult.getContent() : new ArrayList<>();
    }

    @GetMapping("/sort")
    public List<User> getAllSorted(@RequestParam String field, @RequestParam String direction) {
        Sort.Direction sortDirection = direction.equalsIgnoreCase("desc") ? Sort.Direction.DESC : Sort.Direction.ASC;
        return userRepo.findAll(Sort.by(sortDirection, field));
    }

    @GetMapping("/page/{pageNo}/{pageSize}/sort")
    public List<User> getPaginatedAndSortedUsers(@PathVariable int pageNo, @PathVariable int pageSize,
                                                 @RequestParam String sortField, @RequestParam String sortDir) {
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
                    Sort.by(sortField).descending();
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
        Page<User> pagedResult = userRepo.findAll(pageable);

        return pagedResult.hasContent() ? pagedResult.getContent() : new ArrayList<>();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userRepo.findById(id).orElse(null);
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userRepo.save(user);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User userDetails) {
        User existingUser = userRepo.findById(id).orElseThrow();
        existingUser.setFirstName(userDetails.getFirstName());
        existingUser.setLastName(userDetails.getLastName());
        existingUser.setVehicles(userDetails.getVehicles());

        return userRepo.save(existingUser);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userRepo.deleteById(id);
    }
}
