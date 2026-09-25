package com.filazero.ubs.dto;
import java.util.Set;
public record ProjectResponse(Long id, String title, String description, String repositoryUrl, Long profileId, Set<TechnologyResponse> technologies) {}
