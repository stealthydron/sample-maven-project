package com.github.stealthydron.example.testit.client.api;

import com.github.stealthydron.example.testit.client.dto.AutotestDto;
import com.github.stealthydron.example.testit.client.dto.AutotestPostRequestDto;
import com.github.stealthydron.example.testit.client.dto.AutotestPutRequestDto;
import com.github.stealthydron.example.testit.client.dto.ItemId;
import feign.Headers;
import feign.Param;
import feign.RequestLine;

import java.util.List;

public interface Autotests {

    @RequestLine("GET /api/v2/autoTests/{autoTestId}")
    AutotestDto getAutoTest(@Param("autoTestId") String autoTestId);

    @Headers("Content-Type: application/json")
    @RequestLine("POST /api/v2/autoTests")
    AutotestDto createAutotest(AutotestPostRequestDto autotest);

    @Headers("Content-Type: application/json")
    @RequestLine("PUT /api/v2/autoTests")
    AutotestDto updateAutotest(AutotestPutRequestDto autotest);

    @RequestLine("DELETE /api/v2/autoTests/{autotestId}")
    void deleteAutotest(@Param("autotestId") String autotestId);

    @RequestLine("GET /api/v2/autoTests/{autotestId}/workItems?isWorkItemDeleted={isWorkItemDeleted}")
    List<ItemId> getLinkedWorkItems(@Param("autotestId") String autotestId,
                                    @Param("isWorkItemDeleted") boolean isWorkItemDeleted);


}