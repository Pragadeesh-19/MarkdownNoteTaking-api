package org.pragadeesh.markdownapp.model;

import lombok.Data;

@Data
public class NoteRequest {

    private String title;
    private String markdownContent;
}
