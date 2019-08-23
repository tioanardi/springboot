package com.sekolahan.sekolah.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sekolahan.sekolah.exception.ResourceNotFoundException;
import com.sekolahan.sekolah.model.Guru;
import com.sekolahan.sekolah.repository.GuruRepository;

@RestController
@RequestMapping("/api/v3")
public class GuruController {
	@Autowired
	private GuruRepository guruRepository;

	@GetMapping("/guru")
	public List<Guru> getAllGuru() {
		return guruRepository.findAll();
	}

	@GetMapping("/guru/{id}")
	public ResponseEntity<Guru> getGuruById(@PathVariable(value = "id") Long guruId)
			throws ResourceNotFoundException {
		Guru guru= guruRepository.findById(guruId)
				.orElseThrow(() -> new ResourceNotFoundException("Guru not found for this id :: " + guruId));
		return ResponseEntity.ok().body(guru);
	}

	@PostMapping("/guru")
	public Guru createGuru(@Valid @RequestBody Guru guru) {
		return guruRepository.save(guru);
	}

	@PutMapping("/guru/{id}")
	public ResponseEntity<Guru> updateGuru(@PathVariable(value = "id") Long guruId,
			@Valid @RequestBody Guru guruDetails) throws ResourceNotFoundException {
		Guru guru = guruRepository.findById(guruId)
				.orElseThrow(() -> new ResourceNotFoundException("Guru not found for this id :: " + guruId));

		guru.setNamaGuru(guruDetails.getNamaGuru());
		guru.setPelajaranGuru(guruDetails.getPelajaranGuru());
        guru.setKelasGuru(guruDetails.getKelasGuru());
		final Guru updatedGuru = guruRepository.save(guru);
		return ResponseEntity.ok(updatedGuru);
	}

	@DeleteMapping("/guru/{id}")
	public Map<String, Boolean> deleteGuru(@PathVariable(value = "id") Long guruId)
			throws ResourceNotFoundException {
		Guru guru = guruRepository.findById(guruId)
				.orElseThrow(() -> new ResourceNotFoundException("Guru not found for this id :: " + guruId));

		guruRepository.delete(guru);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
