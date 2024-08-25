package org.pragadeesh.markdownapp.service;

import org.commonmark.node.Node;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;
import org.springframework.stereotype.Service;

@Service
public class MarkdownService {

    private final Parser parser; // Initializes a new Markdown parser
    private final HtmlRenderer htmlRenderer; // Initializes a new HTML renderer

    public MarkdownService() {
        this.parser = Parser.builder().build();
        this.htmlRenderer = HtmlRenderer.builder().build();
    }

    public String convertToHtml(String markdown) {
        if(markdown == null) {
            System.out.println("Markdown input is null");
            return "Error: Markdown input is null";
        }

        try {
            Node document = parser.parse(markdown);
            return htmlRenderer.render(document);
        } catch (Exception e) {
            e.printStackTrace();
            return "Error processing markdown";
        }
    }
}
