package org.pragadeesh.markdownapp;

import org.junit.jupiter.api.Test;
import org.pragadeesh.markdownapp.service.MarkdownService;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MarkdownAppApplicationTests {

    @Test
    void contextLoads() {
    }

    public static void main(String[] args) {
        MarkdownService markdownService = new MarkdownService();

        String markdown = "# Hello World\nThis is a sample note written in Markdown.";
        String html = markdownService.convertToHtml(markdown);
        System.out.println("Generated Html: " + html);

        String nullHtml = markdownService.convertToHtml(null);
        System.out.println("Generated html for null input: " + nullHtml);
    }
}
