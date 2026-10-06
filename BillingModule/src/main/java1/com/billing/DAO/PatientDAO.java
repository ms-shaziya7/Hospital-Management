package com.billing.DAO;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.billing.java.Patient;

@Repository
public class PatientDAO {

	
	public void save(Patient patient) {
		
		private JdbcTemplate jdbcTemplate;
		
		public PatientDAO(JdbcTemplate jdbcTemplate)
		{
			
		this.jdbcTemplate=jdbcTemplate;
		}
		
	public void save1(Patient patient) {
		String sql="insert into patient values(?,?,?,?,?,?,?,?,?,?)";
		jdbcTemplate.update(sql,
				patient.getPatientId(),
				patient.getName(),
				patient.getDateOfBirth(),
				patient.getAge(),
				patient.getGender(),
				patient.getMobileno(),
				patient.getEmail(),
				patient.getAddress(),
				patient.getEmergencyContact());
				
	}
	

	public List<Patient> getAllPatients() {
		String sql="select * from patient";
		return jdbcTemplate.query(sql, (rs, rowNum) ->{Patient patient = new Patient();
		patient.setPatientId(rs.getLong("patientId"));
		patient.setName(rs.getString("name"));
		patient.setDateOfBirth(rs.getString("dateOdBirth"));
		patient.setAge(rs.getInt("age"));
		patient.setGender(rs.getString("gender"));
		patient.setEmail(rs.getString("email"));
		patient.setMobileno(rs.getString("mobileno"));
		patient.setAddress(rs.getString("address"));
		patient.setEmergencyContact(rs.getString("emergencyContact"));
		     
		return patient;
		});
	}

	public Patient getPatientById(int iD) {
		// TODO Auto-generated method stub
		return null;
	}

	public void update(Patient patient) {
		// TODO Auto-generated method stub
		
	}

	 void delete(int id) {
		// TODO Auto-generated method stub
		
	

}
}
