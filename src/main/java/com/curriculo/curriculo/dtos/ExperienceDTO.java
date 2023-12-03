package com.curriculo.curriculo.dtos;

import java.util.Date;

public record ExperienceDTO(
        String title,
        String institution,
        String experienceType,
        String extraInfo,
        boolean isCurrent,
        Date startedIn,
        Date endedIn,
        Long resumeId
) { }
