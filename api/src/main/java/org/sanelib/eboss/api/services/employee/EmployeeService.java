package org.sanelib.eboss.api.services.employee;

import org.sanelib.eboss.api.dto.employee.EmployeeDTO;
import org.sanelib.eboss.api.services.ApiEndPointConstants;
import org.sanelib.eboss.api.services.ApiServiceBase;
import org.sanelib.eboss.core.activities.ActivitiProcessConstants;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Component
@Path(ApiEndPointConstants.Admin.EMPLOYEE_END_POINT)
@Produces(MediaType.APPLICATION_JSON)
public class EmployeeService extends ApiServiceBase {

    @GET
    public List<EmployeeDTO> getAllEmployees() throws Exception {
        List<EmployeeDTO> dtos = new ArrayList<>();
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setCode("EMP001");
        employeeDTO.setFirstName("first name");
        employeeDTO.setLastName("last name");
        employeeDTO.setDateOfBirth("1990/1/1");
        employeeDTO.setAddressLine1("7,Shakti Park Soc");
        employeeDTO.setAddressLine2("College Road");
        employeeDTO.setCity("Nadiad");
        employeeDTO.setState("Gujarat");
        employeeDTO.setCountry("India");
        employeeDTO.setZipCode("387001");
        employeeDTO.setPhone("9876543210");
        employeeDTO.setEmail("fname@gmail.com");
        employeeDTO.setGender("Male");
        employeeDTO.setDateOfJoining("2015/7/1");
        employeeDTO.setIsActive(true);
        dtos.add(employeeDTO);
        return dtos;
    }

    @POST
    public String addEmployee(EmployeeDTO employeeDTO) throws Throwable {
        return execute(employeeDTO, ActivitiProcessConstants.Admin.ADD_EMPLOYEE);
    }

    @PUT
    public String updateEmployee(EmployeeDTO employeeDTO) throws Throwable {
        return execute(employeeDTO, ActivitiProcessConstants.Admin.UPDATE_EMPLOYEE);
    }

    @DELETE
    @Path("/{id}")
    public String deleteEmployee(@PathParam("id") String id) throws Throwable {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setId(id);
        return execute(employeeDTO, ActivitiProcessConstants.Admin.DELETE_EMPLOYEE);
    }
}
