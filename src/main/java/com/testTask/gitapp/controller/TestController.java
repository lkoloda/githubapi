package com.testTask.gitapp.controller;

import com.testTask.gitapp.domain.Message;
import com.testTask.gitapp.repository.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
public class TestController {
    @Autowired
    private MessageRepo messageRepo;

    @GetMapping ("/map")
    public String map (
            @RequestParam (name = "name", required = false,defaultValue = "map")String name, Map<String, Object> model)
    {
        model.put("name",name);
        return "map";
    }
    @GetMapping
    public String main(Map<String,Object> model)
    {
        Iterable<Message> messages = messageRepo.findAll();
        model.put("messages", messages);
        //model.put("some","Let's Code!");
        return "main";
    }

    @PostMapping
    public String add(@RequestParam String text,@RequestParam String tag, Map<String,Object> model)
    {
        Message message = new Message(text, tag);
        messageRepo.save(message);

        Iterable<Message> messages = messageRepo.findAll();
        model.put("messages", messages);

        return "main";
    }

    @PostMapping ("filter")
    public String filter(@RequestParam String filter,Map<String,Object> model)
    {
        List<Message> messages = messageRepo.findByText(filter);
        model.put("messages",messages);
        return "main";
    }
}
