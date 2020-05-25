package com.taskmanager.taskmanager.controller;

import com.taskmanager.taskmanager.dto.SubTaakDTO;
import com.taskmanager.taskmanager.dto.TaakDTO;
import com.taskmanager.taskmanager.service.TaakService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class TaakController {

    @Autowired
    private TaakService taakService;


    @RequestMapping
    public String getIndex(){
        return "index";
    }

    @GetMapping("/tasks")
    public String getTasks(Model model){
            model.addAttribute("tasks", taakService.getTaken());
            return "tasks";
    }

    @GetMapping("tasks/{id}")
    public String getTaskDetail(@PathVariable String id, Model model){
        model.addAttribute("taskdetails",taakService.geefTaak(id));
        model.addAttribute("subTaskdetails",taakService.geefSubTaak(id));
        return "taskdetails" ;
    }

    @GetMapping("tasks/new")
    public String toonforum(){
        return "tasknew";
    }

    @PostMapping("tasks/new")
    public String getTaskToevoegen(@ModelAttribute TaakDTO taakDTO){
        taakService.addTaak(taakDTO);
        return "redirect:/tasks";
    }

    @GetMapping("tasks/update/{id}")
    public String toonUpdateForm(@PathVariable String id, Model model){
        model.addAttribute("updateTaak",taakService.geefTaak(id));
        return "taskupdate";
    }

    @PostMapping("tasks/update")
    public String updateForm(@ModelAttribute TaakDTO taakDTO){
        taakService.updateTaak(taakDTO);
        return "redirect:/tasks/" + taakDTO.getId();
    }

    @GetMapping("/tasks/{id}/sub/create")
    public String subTaskForm(@PathVariable String id,Model model){
        model.addAttribute("subTaak",taakService.geefTaak(id));
        return "tasksub";
    }

    @PostMapping("tasks/subtaak")
    public String subTask(@ModelAttribute SubTaakDTO subTaakDTO){
        taakService.addSubTaak(subTaakDTO);
        return "redirect:/tasks/" + subTaakDTO.getId();
    }

}
