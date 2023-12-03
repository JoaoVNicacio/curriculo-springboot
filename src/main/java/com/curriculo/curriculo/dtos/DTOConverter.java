package com.curriculo.curriculo.dtos;

import com.curriculo.curriculo.entities.Experience;
import com.curriculo.curriculo.entities.Language;
import com.curriculo.curriculo.entities.Resume;

import java.util.ArrayList;
import java.util.List;

public class DTOConverter {
    public static Resume convertToResume(ResumeDTO resumeDTO) {
        var resume = new Resume();

        resume.setName(resumeDTO.name());
        resume.setShortDescription(resumeDTO.shortDescription());
        resume.setCity(resumeDTO.city());
        resume.setPhoneNumber(resumeDTO.phoneNumber());
        resume.setSkills(resumeDTO.skills());

        if (resumeDTO.experiences() != null) {
            List<Experience> experiences = new ArrayList<>();

            resumeDTO.experiences().forEach(experienceDTO -> {
                Experience experience = convertToExperience(experienceDTO);
                experience.setResume(resume);

                experiences.add(experience);
            });
            resume.setExperiences(experiences);
        }

        if (resumeDTO.languages() != null) {
            List<Language> languages = new ArrayList<>();

            resumeDTO.languages().forEach(languageDTO -> {
                Language language = convertToLanguage(languageDTO);
                language.setResume(resume);

                languages.add(language);
            });
            resume.setLanguages(languages);
        }

        return resume;
    }

    private static Experience convertToExperience(ExperienceDTO experienceDTO) {
        var experience = new Experience();

        experience.setTitle(experienceDTO.title());
        experience.setInstitution(experienceDTO.institution());
        experience.setExperienceType(experienceDTO.experienceType());
        experience.setExtraInfo(experienceDTO.extraInfo());
        experience.setCurrent(experienceDTO.isCurrent());
        experience.setStartedIn(experienceDTO.startedIn());
        experience.setEndedIn(experienceDTO.endedIn());

        return experience;
    }

    private static Language convertToLanguage(LanguageDTO languageDTO) {
        var language = new Language();

        language.setTitle(languageDTO.title());
        language.setAbilityLevel(languageDTO.abilityLevel());

        return language;
    }
}

