package com.sekolahan.sekolah.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "guru")
public class Guru {

	private long id;
	private String namaGuru;
	private String pelajaranGuru;
	private String kelasGuru;
	
	
	public Guru() {
		
	}
	
	public Guru(String namaGuru, String pelajaranGuru, String kelasGuru) {
		this.namaGuru = namaGuru;
		this.pelajaranGuru = pelajaranGuru;
		this.kelasGuru = kelasGuru;
	
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	@Column(name = "nama_guru", nullable = false)
	public String getNamaGuru() {
		return namaGuru;
	}
	public void setNamaGuru(String namaGuru) {
		this.namaGuru = namaGuru;
	}
	
	@Column(name = "pelajaran_guru", nullable = false)
	public String getPelajaranGuru() {
		return pelajaranGuru;
	}
	public void setPelajaranGuru(String pelajaranGuru) {
		this.pelajaranGuru = pelajaranGuru;
	}
	
	@Column(name = "kelas_guru", nullable = false)
	public String getKelasGuru() {
		return kelasGuru;
	}
	public void setKelasGuru(String kelasGuru) {
		this.kelasGuru = kelasGuru;

	}

	@Override
	public String toString() {
		return "Guru [id=" + id + ", namaGuru=" + namaGuru + ", pelajaranGuru=" + pelajaranGuru + ", kelasGuru=" + kelasGuru
				+ "]";
	}
	
}
