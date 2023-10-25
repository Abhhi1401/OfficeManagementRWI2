package in.railworld.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.railworld.app.Services.Implemetation.NoticeDisplayService;
import in.railworld.app.controller.dto.NoticeDto;
import in.railworld.app.model.NoticeDisplay;

@RestController
@RequestMapping("/notices")
public class NoticeDisplayController {

    private final NoticeDisplayService noticeDisplayService;

    @Autowired
    public NoticeDisplayController(NoticeDisplayService noticeDisplayService) {
        this.noticeDisplayService = noticeDisplayService;
    }

    @PostMapping("/postnotice")
    public ResponseEntity<NoticeDto> postNoticeDto(@RequestBody NoticeDto noticeDto) {
        NoticeDto savedNoticeDto = noticeDisplayService.postNoticeDto(noticeDto);
        return ResponseEntity.ok(savedNoticeDto);
    }

    @GetMapping("/getnotice")
    public List<NoticeDto> getAllNotices() {
        return noticeDisplayService.getAllNotices();
    }
}
