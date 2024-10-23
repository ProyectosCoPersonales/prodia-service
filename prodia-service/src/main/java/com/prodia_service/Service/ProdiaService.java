package com.prodia_service.Service;

import com.prodia_service.Model.http.request.RequestGenerate;
import com.prodia_service.Model.http.response.GeneratingImage;
import com.prodia_service.Model.http.response.ResponseImage;

public interface ProdiaService {
    GeneratingImage generateImageSDXL(RequestGenerate request) throws Exception;
    ResponseImage getJobResult(GeneratingImage request) throws Exception;
}
