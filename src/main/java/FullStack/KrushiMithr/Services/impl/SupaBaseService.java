package FullStack.KrushiMithr.Services.impl;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class SupaBaseService {

    @Value("${supabase.url}")
    private String url;

    @Value("${supabase.key}")
    private String apiKey;

    @Value("${supabase.bucket}")
    private String bucketName;

    private WebClient webClient = WebClient.builder().build();

    public String uploadFile(MultipartFile file) throws Exception {
        String path = file.getOriginalFilename();

        String uploadUrl = url + "/storage/v1/object/" + bucketName + "/" + path;

        webClient.post()
                .uri(url + "/storage/v1/object/" + bucketName + "/" + path)
                .header(HttpHeaders.AUTHORIZATION, "Bearer " + apiKey)
                .header(HttpHeaders.CONTENT_TYPE, file.getContentType())
                .body(BodyInserters.fromValue(file.getBytes()))
                .retrieve()
                .bodyToMono(String.class)
                .block();

        return url + "/storage/v1/object/public/" + bucketName + "/" + path;



    }
}

