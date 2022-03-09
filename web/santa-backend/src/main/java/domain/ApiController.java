package domain;

import domain.entity.Child;
import domain.repository.ChildRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ApiController {
    private ChildRepository childRepository;

    @Autowired
    public ApiController(ChildRepository childRepository) {
        this.childRepository = childRepository;
    }

    @GetMapping(
            value = "/children"
    )
    public List<Child> getAllChildren() {
        return childRepository.findAll();
    }

    @GetMapping(
            value = "/children/{id}"
    )
    public Child getChild(@PathVariable("id") Long id) {
        return childRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException(Child.class, id)
        );
    }

    @GetMapping(
            value = "/notget"
    )
    public List<Child> getChildByState() {
        return childRepository.findNotGetPresent();
    }

    @GetMapping(
            value = "/cities/{city}/children"
    )
    public List<Child> getChildByCity(@PathVariable("city") String city) {
        return childRepository.findByCity(city);
    }


    @PutMapping(
            value = "children/{id}"
    )
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateChild(@PathVariable("id") Long id, @RequestBody Child child) {
        Child childFromDb = childRepository.findById(id).orElseThrow(
                ()->new EntityNotFoundException(Child.class, id)
        );
        if (!childFromDb.getId().equals(child.getId())) {
            throw new BadRequestException("Request and data ID mismatch!");
        }

        childRepository.save(child);
    }
}
