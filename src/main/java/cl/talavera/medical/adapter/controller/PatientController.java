package cl.talavera.medical.adapter.controller;

import cl.talavera.medical.adapter.controller.dto.PatientDto;
import cl.talavera.medical.adapter.repository.dao.PatientDao;
import cl.talavera.medical.adapter.repository.PatientDaoRepository;
import cl.talavera.medical.core.port.PatientServicePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pacientes")
public class PatientController {

    private final PatientServicePort patientService;

    public PatientController(PatientServicePort patientService) {
        this.patientService = patientService;
    }

    @GetMapping
    public List<PatientDto> getAllPatients() {
        return patientService.getAllPatients();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PatientDto> getPatientById(@PathVariable Long id) {
        PatientDto patient = patientService.getPatientById(id);
        if (patient != null) {
            return ResponseEntity.ok(patient);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public PatientDto createPatient(@RequestBody PatientDto patientDto) {
        return patientService.createPatient(patientDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PatientDto> updatePatient(@PathVariable Long id, @RequestBody PatientDto patientDetails) {
        PatientDto updatedPatient = patientService.updatePatient(id, patientDetails);
        if (updatedPatient != null) {
            return ResponseEntity.ok(updatedPatient);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePatient(@PathVariable Long id) {
        boolean deleted = patientService.deletePatient(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
