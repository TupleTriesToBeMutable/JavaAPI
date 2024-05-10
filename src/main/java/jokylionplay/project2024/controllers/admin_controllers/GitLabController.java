package jokylionplay.project2024.controllers.admin_controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Tag(name = "Admin Gitlab Test", description = "test")
@RestController
@RequestMapping("/admin/{adminId}/gitlab/{userId}")
@AllArgsConstructor
public class GitLabController {

    @GetMapping("/get")
    public ResponseEntity<?> userRegistration(
            @PathVariable
            Long userId){

        String gitlabUrl = "http://localhost:8929";
        String accessToken = "glpat-iGZx_zbfkuzpPyV1CpB8";


        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(gitlabUrl + "/users/" + userId))
                .header("Authorization", "Bearer " + accessToken)
                .header("Content-Type", "application/json")
                .GET()
                .build();
        try{
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response);
        }
        catch (IOException | InterruptedException e) {
            System.out.println(e.getMessage());
        }

        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
