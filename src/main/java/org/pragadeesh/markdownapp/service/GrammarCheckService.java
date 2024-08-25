package org.pragadeesh.markdownapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GrammarCheckService {

    private final RestTemplate restTemplate;
    @Autowired
    public GrammarCheckService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String checkGrammar(String text) {
        String url = "https://api.languagetool.org/v2/check";
        String requestBody = "text=" + text + "&language=en-us";
        return restTemplate.postForObject(url, requestBody, String.class);
    }
}
