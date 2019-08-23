package com.sekolahan.sekolah.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "siswa")
public class Siswa {

	private long id;
	private String namaSiswa;
	private String jurusanSiswa;
	private String kelasSiswa;
	private String nilaiSiswa;
	
	public Siswa() {
		
	}
	
	public Siswa(String namaSiswa, String jurusanSiswa, String kelasSiswa, String nilaiSiswa) {
		this.namaSiswa = namaSiswa;
		this.jurusanSiswa = jurusanSiswa;
		this.kelasSiswa = kelasSiswa;
		this.nilaiSiswa = nilaiSiswa;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	@Column(name = "nama_siswa", nullable = false)
	public String getNamaSiswa() {
		return namaSiswa;
	}
	public void setNamaSiswa(String namaSiswa) {
		this.namaSiswa = namaSiswa;
	}
	
	@Column(name = "jurusan_siswa", nullable = false)
	public String getJurusanSiswa() {
		return jurusanSiswa;
	}
	public void setJurusanSiswa(String jurusanSiswa) {
		this.jurusanSiswa = jurusanSiswa;
	}
	
	@Column(name = "kelas_siswa", nullable = false)
	public String getKelasSiswa() {
		return kelasSiswa;
	}
	public void setKelasSiswa(String kelasSiswa) {
		this.kelasSiswa = kelasSiswa;
	}
	@Column(name = "nilai_siswa", nullable = false)
	public String getNilaiSiswa() {
		return nilaiSiswa;
	}
	public void setNilaiSiswa(String nilaiSiswa) {
		this.nilaiSiswa = nilaiSiswa;
	}

	@Override
	public String toString() {
		return "Siswa [id=" + id + ", namaSiswa=" + namaSiswa + ", jurusanSiswa=" + jurusanSiswa + ", kelasSiswa=" + kelasSiswa
				+ "nilaiSiswa" + nilaiSiswa +"]";
	}
	
}
