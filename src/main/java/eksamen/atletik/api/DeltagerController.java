package eksamen.atletik.api;

import eksamen.atletik.dto.DeltagerDto;
import eksamen.atletik.entity.DeltagerEntity;
import eksamen.atletik.service.DeltagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/deltagere")
public class DeltagerController {
    private final DeltagerService deltagerService;

    public DeltagerController(DeltagerService deltagerService) {
        this.deltagerService = deltagerService;
    }

    @GetMapping
    public List<DeltagerEntity> getDeltager(){
        return deltagerService.findAll();
    }
    @GetMapping("/{id}")
    public DeltagerEntity getDeltagerById(@PathVariable int id) {
        return deltagerService.findById(id);
    }
    @PostMapping
    public DeltagerEntity addDeltagerEntity(@RequestBody DeltagerDto deltagerDto) {
        return deltagerService.addDeltagerEntity(deltagerDto);
    }
    @DeleteMapping("/{id}")
    public void deleteDeltagerEntity(@PathVariable int id) {
        deltagerService.deleteDeltagerEntity(id);
    }
    @PutMapping("/{id}")
    public DeltagerEntity updateDeltagerEntity(@PathVariable int id, @RequestBody DeltagerDto deltagerDto) {
        return deltagerService.updateDeltagerEntity(id, deltagerDto);
    }


}
