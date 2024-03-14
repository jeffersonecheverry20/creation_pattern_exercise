package com.jefferson.university.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.jefferson.university.DTO.AdminDTO;
import com.jefferson.university.model.Admin;
import com.jefferson.university.respository.AdminRepository;

@Service
public class AdminService {

    private final AdminRepository adminRepository;

    public AdminService(final AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    public List<AdminDTO> getAllStudents() {
         List<Admin> admins = this.adminRepository.findAll();
         if (CollectionUtils.isEmpty(admins)) {
             throw new RuntimeException("There are not students yet.");
         }

        return admins.stream().map(student -> new AdminDTO(student.getID(),
                        student.getName(),
                        student.getLastName()
                        ))
                .collect(Collectors.toList());
    }

    public AdminDTO getStudentByID(final String ID) {
        Admin admin = this.adminRepository.getReferenceById(ID);
        if (admin == null) {
            throw new RuntimeException(String.format("Student %s not found", ID));
        }
        return new AdminDTO(admin.getID(),
        		admin.getName(),
        		admin.getLastName()
               );
    }

    public AdminDTO createStudent(final AdminDTO adminToCreate) {
        Admin admin = Admin.getInstance();
        
        int hashCode = Admin.getInstance().hashCode();
        System.out.println(hashCode);
        
        String name = adminToCreate.getName();
        admin.setName(name);
        admin.setLastName(adminToCreate.getLastName());
  
        this.adminRepository.save(admin);

        return adminToCreate;
    }

    public AdminDTO updateStudent(final AdminDTO adminToUpdate) {
    	Admin admin = Admin.getInstance();
        String name = adminToUpdate.getName();
        admin.setName(name);
        admin.setLastName(adminToUpdate.getLastName());
        
        this.adminRepository.save(admin);

        return adminToUpdate;
    }

	public AdminDTO deleteStudent(String ID) {
		 Admin admin = this.adminRepository.getReferenceById(ID);
	        if (admin == null) {
	            throw new RuntimeException(String.format("Does not find the student %s.", ID));
	        }
	        this.adminRepository.delete(admin);

	        return new AdminDTO(admin.getID(),
	        		admin.getName(),
	        		admin.getLastName());
	}

    
}
