package com.jpa;

import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name="Z_University")
public class Z_University {
	@Id
	@GeneratedValue
	String uni_id;
	
	String name;
	String city;
	String state;
	
	
	@ElementCollection(fetch=FetchType.EAGER)
	@Column(name="studentName", length=250)
	@CollectionTable(
			name = "Z_Student", 
			joinColumns = @JoinColumn(name = "uni_id", referencedColumnName = "uni_id"))
	private Set<String> students;
	
	@ElementCollection(fetch=FetchType.EAGER)
	@Column(name="profName", length=250)
	@CollectionTable(
			name = "Z_prof", 
			joinColumns = @JoinColumn(name = "uni_id", referencedColumnName = "uni_id"))
	private Set<String> professors;
	
	@Version
	@Column(precision=38)
	private long version;

	public String getUni_id() {
		return uni_id;
	}

	public void setUni_id(String uni_id) {
		this.uni_id = uni_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}


	public Set<String> getStudents() {
		return students;
	}

	public void setStudents(Set<String> students) {
		this.students = students;
	}
	
	

	public Set<String> getProfessors() {
		return professors;
	}

	public void setProfessors(Set<String> professors) {
		this.professors = professors;
	}

	public long getVersion() {
		return version;
	}

	public void setVersion(long version) {
		this.version = version;
	}
	
	@Override
	public boolean equals(Object obj) {
		System.out.println("equals University");
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Z_University other = (Z_University) obj;
		if (uni_id == null) {
			if (other.uni_id != null) {
				return false;
			}
		} else if (uni_id!=other.uni_id) {
			return false;
		}
		return true;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((uni_id == null) ? 0 : uni_id.hashCode());
		return result;
	}
	
	
	
	
	
}
