package com.example.demo.proxies.advertisement;

import com.example.demo.bean.sp09.SP09ResponseBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;
import java.util.List;

@FeignClient(name = "my-adv-api", url = "https://ltct-api.2soft.top")
public interface SP09AdvertisementWebServiceProxy {

    @GetMapping("/advertisements")
    SP09ResponseBean<List<HashMap<String, Object>>> getAllAdvertisements();
}
