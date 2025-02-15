package com.taskmanager.taskmanager.department;

import com.taskmanager.taskmanager.department.dto.DepartmentCreationDTO;
import com.taskmanager.taskmanager.department.dto.DepartmentDTO;
import com.taskmanager.taskmanager.department.jpa.Department;
import com.taskmanager.taskmanager.department.jpa.DepartmentRepository;
import com.taskmanager.taskmanager.department.service.CreateDepartmentServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class CreateDepartmentServiceImplTest {

    @Mock
    private DepartmentRepository departmentRepository;

    @InjectMocks
    private CreateDepartmentServiceImpl createDepartmentService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateDepartmentSuccess() {
        // Given
        DepartmentCreationDTO departmentCreationDTO = new DepartmentCreationDTO();
        departmentCreationDTO.setName("Finance");

        Department department = new Department();
        department.setId(1L);
        department.setName("Finance");

        DepartmentDTO departmentDTO = new DepartmentDTO(1L, "Finance");

        when(departmentRepository.save(any(Department.class))).thenReturn(department);

        // When
        DepartmentDTO result = createDepartmentService.create(departmentCreationDTO);

        // Then
        assertNotNull(result);
        assertEquals("Finance", result.getName());
        assertEquals(1L, result.getId());
        verify(departmentRepository, times(1)).save(any(Department.class));
    }

    @Test
    void testCreateDepartment_SaveFails() {
        // Given
        DepartmentCreationDTO departmentCreationDTO = new DepartmentCreationDTO();
        departmentCreationDTO.setName("Finance");

        when(departmentRepository.save(any(Department.class))).thenThrow(new RuntimeException("Save failed"));

        // When & Then
        Exception exception = assertThrows(RuntimeException.class, () -> {
            createDepartmentService.create(departmentCreationDTO);
        });

        assertEquals("Save failed", exception.getMessage());
        verify(departmentRepository, times(1)).save(any(Department.class));
    }
}

