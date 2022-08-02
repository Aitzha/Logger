package com.example.logger.controllers;

import com.example.logger.models.Log;
import com.example.logger.models.Request;
import com.example.logger.repositories.LogRepository;
import com.example.logger.repositories.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/")
public class LoggerController {
    private final LogRepository logRepository;
    private final RequestRepository requestRepository;

    @Autowired
    public LoggerController(LogRepository logRepository, RequestRepository requestRepository) {
        this.logRepository = logRepository;
        this.requestRepository = requestRepository;
    }

    @PostMapping
    @ResponseBody
    public String post(@RequestBody Request body) throws IOException {
        List<Request> requestsList = new ArrayList<>();
        requestRepository.findAll().forEach(requestsList::add);

        Request request = new Request(requestsList.size() + 1, body.command, body.content);
        requestRepository.save(request);

        if(!request.command.equals("addLog")) {
            return "unknown command";
        }

        List<Log> logsList = new ArrayList<>();
        logRepository.findAll().forEach(logsList::add);

        Log log = new Log(logsList.size() + 1, request.content);
        logRepository.save(log);

        return "Saved";
    }

    @GetMapping
    public Iterable<Request> getAll(@RequestBody Request body) {

        List<Request> requestsList = new ArrayList<>();
        requestRepository.findAll().forEach(requestsList::add);

        Request request = new Request(requestsList.size() + 1, body.command, null);
        requestRepository.save(request);

        if(!body.command.equals("logs")) {
            return Collections.emptyList();
        }

        return requestRepository.findAll();
    }
}
