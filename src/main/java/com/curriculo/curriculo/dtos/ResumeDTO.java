package com.curriculo.curriculo.dtos;

import java.util.List;

public record ResumeDTO(
        String name,
        String shortDescription,
        String city,
        String phoneNumber,
        List<String> skills,
        List<ExperienceDTO> experiences,
        List<LanguageDTO> languages
) { }
