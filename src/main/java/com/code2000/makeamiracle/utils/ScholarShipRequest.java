package com.code2000.makeamiracle.utils;

import lombok.Data;

@Data
public class ScholarShipRequest {

    public Long sponsorId;
    public Long studentId;
    public Long instituteId;
    public Long careerId;
    public String studentCode;

}
