package com.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    RestTemplate restTemplate;

   // String basicURL = "https://jsonplaceholder.typicode.com/";
   // StringBuilder builder = new StringBuilder(basicURL);

   // String POST = "/post";
    @Override
    public List<Map<String, Object>> getPost() {
        HttpEntity<Void> httpEntity = new HttpEntity<>(httpHeaders());
        String url = "https://jsonplaceholder.typicode.com/posts";
        return restTemplate.exchange(url, HttpMethod.GET, httpEntity, List.class ).getBody();
    }

    public Map<String, Object> getPostById(int id){
        HttpEntity<Void> httpEntity = new HttpEntity<>(httpHeaders());
        String url2 = "https://jsonplaceholder.typicode.com";
        StringBuilder stringBuilder = new StringBuilder(url2);
        String url = stringBuilder.append("/posts/").append(id).toString();
        return restTemplate.exchange(url,HttpMethod.GET, httpEntity, Map.class).getBody();
    }

    private HttpHeaders httpHeaders(){
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        return httpHeaders;
    }
}
