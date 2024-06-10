package citas_medicas.citas_medicas;


import com.example.demo.model.CitaMedica;
import com.example.demo.repository.CitaMedicaRepository;

@Controller
public class CitaMedicaController {

    @Autowired
    private CitaMedicaRepository citaMedicaRepository;

    @GetMapping("/cita")
    public String showForm() {
        return "cita";
    }

    @PostMapping("/submitCita")
    public String submitForm(@RequestParam("paciente") String paciente,
                             @RequestParam("doctor") String doctor,
                             @RequestParam("fecha") String fecha,
                             @RequestParam("hora") String hora,
                             Model model) {
        // Crear y guardar la nueva cita médica
        CitaMedica cita = new CitaMedica();
        cita.setPaciente(paciente);
        cita.setDoctor(doctor);
        cita.setFecha(fecha);
        cita.setHora(hora);
        citaMedicaRepository.save(cita);

        // Agregar datos al modelo para mostrarlos en la vista
        model.addAttribute("paciente", paciente);
        model.addAttribute("doctor", doctor);
        model.addAttribute("fecha", fecha);
        model.addAttribute("hora", hora);

        return "resultadoCita";
    }
}

