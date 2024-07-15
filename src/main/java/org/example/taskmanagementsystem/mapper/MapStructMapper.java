package org.example.taskmanagementsystem.mapper;

import org.example.taskmanagementsystem.dto.AppUserGetDto;
import org.example.taskmanagementsystem.dto.AppUserPostDto;
import org.example.taskmanagementsystem.model.AppUser;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface MapStructMapper {
    AppUserPostDto appUserPostDto(AppUser user);

    AppUserGetDto appUserGetDto(AppUser user);

    AppUser userPostDtoToAppUser(AppUserPostDto userDto);
}
