package jpn.jalin.controller;

import jpn.jalin.service.ReadFileService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ConstantController {
    @Autowired
    private ReadFileService readFileService;

    @GetMapping("/{req}")
    public String home(@PathVariable String req) {
        return readFileService.readData(req);
    }
}