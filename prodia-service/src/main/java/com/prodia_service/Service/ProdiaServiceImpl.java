package com.prodia_service.Service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import java.util.Map;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.prodia_service.Model.http.request.RequestGenerate;
import com.prodia_service.Model.http.request.RequestProdia;
import com.prodia_service.Model.http.response.GeneratingImage;
import com.prodia_service.Model.http.response.ResponseImage;

@Service
public class ProdiaServiceImpl implements ProdiaService {
        private String prodiaToken = "eb0276c7-47c3-4b5e-b242-5cf330b86ec7";
        private final PromptService promptService;

        public ProdiaServiceImpl(PromptService promptService) {
                this.promptService = promptService;
        }

        @Override
        public GeneratingImage generateImageSDXL(RequestGenerate request) throws Exception {
                ObjectMapper objectMapper = new ObjectMapper();
                String prompt = promptService.getRandomPromptByEffect(request.getEffect()).getDescription();
                String model = "realvisxlV40.safetensors [f7fdcb51]";
                String sampler = "DPM++ 2M Karras";
                String imageUrl = request.getImageUrl();
                String style_preset = "cinematic";
                int steps = 40;
                int cfg_scale = 25;
                int seed = -1;
                boolean upscale = true;
                Double denoising_strength = 0.44;
                int width = request.getWidth();
                int height = request.getHeight();

                String requestBody = objectMapper
                                .writeValueAsString(new RequestProdia(imageUrl, model, prompt, denoising_strength, style_preset,
                                steps, cfg_scale, seed, upscale, sampler, width, height));

                HttpRequest httpRequest = HttpRequest.newBuilder()
                                .uri(URI.create("https://api.prodia.com/v1/sdxl/transform"))
                                .header("accept", "application/json")
                                .header("content-type", "application/json")
                                .header("X-Prodia-Key", prodiaToken)
                                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                                .build();

                HttpResponse<String> httpResponse = HttpClient.newHttpClient().send(httpRequest,
                                HttpResponse.BodyHandlers.ofString());

                Map<String, Object> responseMap = objectMapper.readValue(httpResponse.body(),
                                new TypeReference<Map<String, Object>>() {
                                });

                String jobId = (String) responseMap.get("job");
                String status = (String) responseMap.get("status");

                GeneratingImage generatingImage = new GeneratingImage();
                generatingImage.setJob(jobId);
                generatingImage.setStatus(status);

                return generatingImage;
        }

        @Override
        public ResponseImage getJobResult(GeneratingImage request) throws Exception {
                HttpRequest result = HttpRequest.newBuilder()
                                .uri(URI.create("https://api.prodia.com/v1/job/" + request.getJob()))
                                .header("accept", "application/json")
                                .header("X-Prodia-Key", prodiaToken)
                                .method("GET", HttpRequest.BodyPublishers.noBody())
                                .build();

                HttpResponse<String> httpResponse = HttpClient.newHttpClient().send(result,
                                HttpResponse.BodyHandlers.ofString());

                ObjectMapper objectMapper = new ObjectMapper();
                Map<String, Object> responseMap = objectMapper.readValue(httpResponse.body(),
                                new TypeReference<Map<String, Object>>() {
                                });

                String jobId = (String) responseMap.get("job");
                String status = (String) responseMap.get("status");
                String imageUrl = (String) responseMap.get("imageUrl");

                ResponseImage responseImage = new ResponseImage();
                responseImage.setJob(jobId);
                responseImage.setStatus(status);
                responseImage.setImageUrl(imageUrl);

                return responseImage;
        }

}
