package com.code2000.makeamiracle.utils;

import com.code2000.makeamiracle.model.Career;
import com.code2000.makeamiracle.model.Institute;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class InstituteDto {

    Institute institute;
    List<Career> career;
}
