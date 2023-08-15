package pe.edu.cibertec.CL3_CHARLY_CANALES.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.cibertec.CL3_CHARLY_CANALES.dtos.EmpleadoDto;
import pe.edu.cibertec.CL3_CHARLY_CANALES.entities.Empleado;
import pe.edu.cibertec.CL3_CHARLY_CANALES.repositories.EmpleadoRepository;

@Controller
@RequestMapping("empleados")
public class EmpleadoController {

    EmpleadoRepository empleadoRepository;

    public EmpleadoController(EmpleadoRepository empleadoRepository) {
        this.empleadoRepository = empleadoRepository;
    }
    
    @GetMapping
    public String list(Model model) {
        List<Empleado> empleados = empleadoRepository.findAll();
        model.addAttribute("listaEmpleados", empleados);

        return "empleados/list";
    }

    //create
    @GetMapping("/create")
    public String showCreateForm(Model model) {
        EmpleadoDto empleadoDto = new EmpleadoDto();
        model.addAttribute("empleadoForm", empleadoDto);
        return "empleados/create";
    }

    @PostMapping
    public String create(EmpleadoDto empleadoDto) {
        Empleado empleado = new Empleado(
            empleadoDto.getNombre(),
            empleadoDto.getApellido(),
            empleadoDto.getSalario(),
            empleadoDto.getPuesto()
        );
        empleadoRepository.save(empleado);
        return "redirect:/empleados";
    }

    @GetMapping("/{id}")
    public String detail(@PathVariable Integer id, Model model) {
        Optional<Empleado> empleadoOptional = empleadoRepository.findById(id);
        if (empleadoOptional.isEmpty()) {
            return "404";
        }

        Empleado empleado = empleadoOptional.get();
        model.addAttribute("empleado", empleado);
        return "empleados/detail";
    }
    // Editar
    @GetMapping("/{id}/edit")
    public String showEditForm(@PathVariable Integer id, Model model) {
            Optional<Empleado> empleadoOptional = empleadoRepository.findById(id);
            if (empleadoOptional.isEmpty()) {
                return "404"; 
            }

            Empleado empleado = empleadoOptional.get();
            model.addAttribute("empleado", empleado);
            return "empleados/edit"; 
    }

    @PostMapping("/{id}")
    public String edit(@PathVariable Integer id, Empleado empleadoDataForm) {
            Optional<Empleado> empleadoOptional = empleadoRepository.findById(id);
            if (empleadoOptional.isEmpty()) {
                return "404"; 
            }

            Empleado empleado = empleadoOptional.get();
            empleado.setNombre(empleadoDataForm.getNombre());
            empleado.setApellido(empleadoDataForm.getApellido());
            empleado.setSalario(empleadoDataForm.getSalario());
            empleado.setPuesto(empleadoDataForm.getPuesto());
   

            empleadoRepository.save(empleado);

        return "redirect:/empleados";
    }

    // Eliminar
    @PostMapping("/{id}/delete")
    public String delete(@PathVariable Integer id) {
        empleadoRepository.deleteById(id);
        return "redirect:/empleados";
}


}
