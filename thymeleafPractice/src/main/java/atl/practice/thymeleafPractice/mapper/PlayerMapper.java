package atl.practice.thymeleafPractice.mapper;

import atl.practice.thymeleafPractice.model.Players;
import atl.practice.thymeleafPractice.request.PlayersRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;


@Mapper
public interface PlayerMapper {
    PlayerMapper INSTANCE = Mappers.getMapper(PlayerMapper.class);

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "number", target = "number"),
            @Mapping(source = "team", target = "team"),
            @Mapping(target = "image", ignore = true)})
    PlayersRequest modelToDto(Players players);

    @Mapping(target = "image", ignore = true)
    Players dtoToModel(PlayersRequest commerceDto);
}
