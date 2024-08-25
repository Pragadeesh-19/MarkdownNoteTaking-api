package org.pragadeesh.markdownapp.model;

import lombok.Data;

@Data
public class NoteResponse {

    private Long id;
    private String title;
    private String markdownContent;
    private String htmlContent;
    private Object grammerCheckReport;
}
