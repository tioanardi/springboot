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
import com.sekolahan.sekolah.model.Siswa;
import com.sekolahan.sekolah.repository.SiswaRepository;

@RestController
@RequestMapping("/api/v3")
public class SiswaController {
	@Autowired
	private SiswaRepository siswaRepository;

	@GetMapping("/siswa")
	public List<Siswa> getAllSiswa() {
		return siswaRepository.findAll();
	}

	@GetMapping("/siswa/{id}")
	public ResponseEntity<Siswa> getSiswaById(@PathVariable(value = "id") Long siswaId)
			throws ResourceNotFoundException {
		Siswa siswa = siswaRepository.findById(siswaId)
				.orElseThrow(() -> new ResourceNotFoundException("Siswa not found for this id :: " + siswaId));
		return ResponseEntity.ok().body(siswa);
	}

	@PostMapping("/siswa")
	public Siswa createSiswa(@Valid @RequestBody Siswa siswa) {
		return siswaRepository.save(siswa);
	}

	@PutMapping("/siswa/{id}")
	public ResponseEntity<Siswa> updateSiswa(@PathVariable(value = "id") Long siswaId,
			@Valid @RequestBody Siswa siswaDetails) throws ResourceNotFoundException {
		Siswa siswa = siswaRepository.findById(siswaId)
				.orElseThrow(() -> new ResourceNotFoundException("Siswa not found for this id :: " + siswaId));

		siswa.setNamaSiswa(siswaDetails.getNamaSiswa());
		siswa.setJurusanSiswa(siswaDetails.getJurusanSiswa());
        siswa.setKelasSiswa(siswaDetails.getKelasSiswa());
        siswa.setNilaiSiswa(siswaDetails.getNilaiSiswa());
		final Siswa updatedSiswa = siswaRepository.save(siswa);
		return ResponseEntity.ok(updatedSiswa);
	}

	@DeleteMapping("/siswa/{id}")
	public Map<String, Boolean> deleteSiswa(@PathVariable(value = "id") Long siswaId)
			throws ResourceNotFoundException {
		Siswa siswa = siswaRepository.findById(siswaId)
				.orElseThrow(() -> new ResourceNotFoundException("Siswa not found for this id :: " + siswaId));

		siswaRepository.delete(siswa);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
