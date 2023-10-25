package in.railworld.app.Services.Implemetation;


import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import in.railworld.app.controller.dto.NoticeDto;

@Service
public class NoticeDisplayService {

    // Simulated storage for notices. Replace this with your actual data storage mechanism (e.g., a database).
    private List<NoticeDto> noticeList = new ArrayList<>();
    private Long nextId = 1L;

    public NoticeDto postNoticeDto(NoticeDto npoticeDto) {
        // Assign a unique ID and save the notice.
        npoticeDto.setId(nextId);
        noticeList.add(npoticeDto);
        nextId++;
        return npoticeDto;
    }

    public List<NoticeDto> getAllNotices() {
        return noticeList;
    }

    public NoticeDto getNoticeById(Long id) {
        // Find and return the notice with the given ID, or return null if not found.
        for (NoticeDto npoticeDto : noticeList) {
            if (npoticeDto.getId().equals(id)) {
                return npoticeDto;
            }
        }
        return null;
    }

    // You can add more methods for updating and managing notices as needed.

    // For instance, an update method might look like this:
    public NoticeDto updateNoticeDto(Long id, NoticeDto updatedNotice) {
        for (NoticeDto existingNotice : noticeList) {
            if (existingNotice.getId().equals(id)) {
                // Update the existing notice with the new data
                existingNotice.setTitle(updatedNotice.getTitle());
                existingNotice.setContent(updatedNotice.getContent());
                return existingNotice;
            }
        }
        return null; // Notice with the given ID was not found.
    }
}


